package com.cg.capsstore.managingmerchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capsstore.managingmerchant.entities.Merchant;
import com.cg.capsstore.managingmerchant.service.IMerchantService;

@RestController
public class ManagingMerchantRest {

	@Autowired
	IMerchantService merchantService;

	public IMerchantService getMerchantService() {
		return merchantService;
	}

	public void setMerchantService(IMerchantService merchantService) {
		this.merchantService = merchantService;
	}
	
	@PostMapping("/add")
	public String addMerchant(@RequestBody Merchant merchant) {
		return merchantService.addMerchant(merchant);
	}
	
	@DeleteMapping("/remove/{id}")
	public String deleteMerchant(@PathVariable("id") int id) {
		String message=merchantService.removeMerchantById(id).toString();
		return message;
	}
	
	@PostMapping("/update/{mId}")
	public boolean updateMerchant(@PathVariable("mId") int merchantId,@RequestBody Merchant merchant) {
		return merchantService.updateMerchant(merchantId, merchant);
		
	}
	
	@GetMapping("/show/{mId}")
	public String showMerchant(@PathVariable("mId") int merchantId) {
		return merchantService.showMerchant(merchantId);
	}
}
