package com.cg.capsstore.merchantinventory.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capsstore.merchantinventory.enities.Merchant;
import com.cg.capsstore.merchantinventory.enities.Product;
import com.cg.capsstore.merchantinventory.repo.IMerchantInventoryMerchantRepo;
import com.cg.capsstore.merchantinventory.repo.IMerchantInventoryProductRepo;

@Service
@Transactional
public class MerchantInventoryProductServiceImpl implements IMerchantInventoryProductService {

	@Autowired
	IMerchantInventoryProductRepo merchantproductrepo;
	
	@Autowired
	IMerchantInventoryMerchantRepo merchantRepo;
	
	public IMerchantInventoryMerchantRepo getMerchantRepo() {
		return merchantRepo;
	}

	public void setMerchantRepo(IMerchantInventoryMerchantRepo merchantRepo) {
		this.merchantRepo = merchantRepo;
	}

	public IMerchantInventoryProductRepo getMerchantproductrepo() {
		return merchantproductrepo;
	}
	
	public void setMerchantproductrepo(IMerchantInventoryProductRepo merchantproductrepo) {
		this.merchantproductrepo = merchantproductrepo;
	}
	

	@Override
	public int addProduct(Product product , int merchantId) {
		// TODO Auto-generated method stub
		product.setMerchant(merchantRepo.getOne(merchantId));
		merchantproductrepo.save(product);
		return product.getProductId();
		
	}

	@Override
	public Merchant getMerchant(int mId) {
		// TODO Auto-generated method stub
		return merchantRepo.getOne(mId);
	}

}
