package com.cg.capsstore.merchantinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capsstore.merchantinventory.enities.Product;
import com.cg.capsstore.merchantinventory.service.IMerchantInventoryProductService;


@RestController
public class MerchantInventoryRest {
	@Autowired
	IMerchantInventoryProductService  merchantproductservice;

	public IMerchantInventoryProductService getMerchantproductservice() {
		return merchantproductservice;
	}

	public void setMerchantproductservice(IMerchantInventoryProductService merchantproductservice) {
		this.merchantproductservice = merchantproductservice;
	}
	
	@PostMapping("/product/{mId}")
	public int addProduct(@PathVariable("mId") int mId, @RequestBody Product product)
	{
		return merchantproductservice.addProduct(product, mId);
	
	}

	@GetMapping("/{mId}")
	public String showMerchant(@PathVariable("mId") int mId)
	{
		List<Product> pList = merchantproductservice.getMerchant(mId).getProductsAvailable();
		System.err.println(pList);
		return pList.toString();
	
	}
}
