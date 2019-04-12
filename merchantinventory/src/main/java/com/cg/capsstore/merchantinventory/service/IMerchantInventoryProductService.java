package com.cg.capsstore.merchantinventory.service;

import com.cg.capsstore.merchantinventory.enities.Merchant;
import com.cg.capsstore.merchantinventory.enities.Product;

public interface IMerchantInventoryProductService {

	public int addProduct(Product product, int merchantId);

	public Merchant getMerchant(int mId);

}
