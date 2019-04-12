package com.cg.capsstore.managingmerchant.service;
import com.cg.capsstore.managingmerchant.entities.Merchant;

public interface IMerchantService {
	public String removeMerchantById(int merchantId);
	public String addMerchant(Merchant merchant);
	public boolean updateMerchant(int merchantId, Merchant merchant);
	public String showMerchant(int merchantId);
}
