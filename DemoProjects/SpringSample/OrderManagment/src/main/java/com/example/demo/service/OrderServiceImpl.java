package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.client.DeliveryClient;
import com.example.demo.client.InventoryClient;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Products;
import com.example.demo.exception.NoDataFoundException;
import com.example.demo.model.OrderModel;
import com.example.demo.model.ProductModel;
import com.example.demo.model.UserModel;
import com.example.demo.repo.OrderRepository;
import com.example.demo.util.ModelMapperUtils;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	InventoryClient inventoryClient;

	@Autowired
	DeliveryClient deliveryClient;

	@Autowired
	OrderRepository orderRepo;

	@Autowired
	ModelMapperUtils modelMapperUtils;

	@Override
	public OrderModel placeOrder(OrderModel orderModel, UserModel user) throws NoDataFoundException {
		double totalAmt = 0.0;

		if ((!orderModel.getIsPickup()) || orderModel.getPickupAddress() == null || orderModel.getIsPickup()==null) {
			orderModel.setPickupAddress(user.getAddress());
		}

		Orders orders = modelMapperUtils.ordersModelToEntity(orderModel);

		orderModel = modelMapperUtils.orderToModel(orders);
		// to call inventory service and update quantity
		if(orderModel.getProducts().size()>0 || orderModel.getProducts()!=null) {
			List<Products> products = inventoryClient.updateQuantityProduct(orderModel.getProducts());
			if (products.size() == 0) {
				throw new NoDataFoundException();
			}
			for (ProductModel prod : orderModel.getProducts()) {
				for (Products prodDB : products) {
					if (prod.getProdId() == prodDB.getProdId()) {
						prodDB.setStockLevel(prod.getStockLevel());
						break;
					}
				}
			}
			List<ProductModel> prodModel = products.stream().map(modelMapperUtils::productToModel)
					.collect(Collectors.toList());
			// ProductModel prodModel = modelMapperUtils.productToModel(products);
			orderModel.setProducts(prodModel);
			for (ProductModel prodMod : prodModel) {
				totalAmt = totalAmt + (prodMod.getPrice() * prodMod.getStockLevel());
			}
			orderModel.setTotalAmount(totalAmt);	
			// to save order details.
	orders = orderRepo.save(modelMapperUtils.ordersModelToEntity(orderModel));	
		}else {
			throw new NoDataFoundException();
		}

		return orderModel;
	}

	@Override
	public ResponseEntity<UserModel> getUserDetails(Long mob) {
		return inventoryClient.getUser(mob);

	}

}
