package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.URIConstants;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.model.CartModel;
import com.example.demo.repository.CartRepo;
import com.example.demo.repository.ProductRepository;
import com.example.demo.util.CartModelMapperUtil;

@RestController
@RequestMapping(path = URIConstants.BASE_URL)
public class CartController {

	@Autowired
	CartRepo cartRepo;

	@Autowired
	ProductRepository prodRepo;

	@Autowired
	CartModelMapperUtil cartModelMapper;

	Cart cart = new Cart();

//get product by id
	@GetMapping(path = "/cart/{id}")
	public Cart getCartById(@PathVariable int id) {
		Optional<Cart> optCart = cartRepo.findById(id);
		Cart cart = optCart.orElse(null);
		System.out.println(cart.getUser().getName());
		return cart;

	}

	@PostMapping("/addProdsToCart/{cartId}")
	public Cart addProductsToCart(@RequestBody CartModel cartModel, @PathVariable int cartId) throws Exception {

		Cart cart = cartModelMapper.CartModelToCart(cartModel);

		Set<Product> prods = new HashSet<>();
		Optional<Cart> optCart = cartRepo.findById(cartId);
		List<Integer> prodidList = cart.getProducts().stream().map(x -> x.getProdId()).collect(Collectors.toList());

		if (optCart.isPresent()) {
			Cart cart1 = optCart.get();
			prods = cart1.getProducts();
			Set<Product> productsSet = prodidList.stream().map(x -> prodRepo.findById(x).get())
					.collect(Collectors.toSet());
			for (Product p : productsSet) {
				prods.add(p);
			}

			cart1.setProducts(prods);
			return cartRepo.save(cart1);
		} else {
			throw new Exception("no such Cart or USer Exist");
		}
	}

}
