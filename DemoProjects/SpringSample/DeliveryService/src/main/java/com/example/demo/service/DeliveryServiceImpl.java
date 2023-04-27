package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Delivery;
import com.example.demo.entity.Orders;
import com.example.demo.model.DeliveryModel;
import com.example.demo.repo.DeliveryRepository;
import com.example.demo.util.ModelMapperUtils;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	DeliveryRepository deliveryRepo;
	@Autowired
	ModelMapperUtils modelMapperUtils;

	@Override
	public DeliveryModel saveDelivery(DeliveryModel deliveryModel) {
		Delivery delivery = modelMapperUtils.deliveryModelToEntity(deliveryModel);

		delivery.setOrders(modelMapperUtils.orderModelToEntity(deliveryModel.getOrderDetails()));
		delivery = deliveryRepo.save(delivery);
		deliveryModel = modelMapperUtils.dliveryToModel(delivery);
		deliveryModel.setOrderDetails(modelMapperUtils.orderToModel(delivery.getOrders()));
		return deliveryModel;
	}

	@Override
	public List<DeliveryModel> getAllDeliveries() {
		List<Delivery> delveries = deliveryRepo.findAll();
		List<DeliveryModel> delModel = delveries.stream().map(modelMapperUtils::dliveryToModel)
				.collect(Collectors.toList());
		return delModel;
	}

	@Override
	public DeliveryModel changeStatus(int id, String status) {
		Optional<Delivery> optDel = deliveryRepo.findById(id);
		if (optDel.isPresent()) {
			Delivery del = optDel.get();
			del.setStatus(status);
			del = deliveryRepo.save(del);
			return modelMapperUtils.dliveryToModel(del);
		}
		return null;
	}

}
