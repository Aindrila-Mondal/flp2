package com.cg.capsstore.managingmerchant.service;

import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import com.cg.capsstore.managingmerchant.entities.Merchant;
import com.cg.capsstore.managingmerchant.repo.IMerchantRepo;

@Service
@Transactional
public class MerchantServiceImpl implements IMerchantService {

	@Autowired
	IMerchantRepo merchantRepo;
	
	public IMerchantRepo getMerchantRepo() {
		return merchantRepo;
	}

	public void setMerchantRepo(IMerchantRepo merchantRepo) {
		this.merchantRepo = merchantRepo;
	}

	@Override
	/*TO ADD A NEW MERCHANT*/
	public String addMerchant(Merchant merchant) {
		merchantRepo.save(merchant);
		return "Merchant Successfully Added With ID "+merchant.getMerchantId()+"!";
	}
	
	@Override
	/*TO REMOVE A MERCHANT*/
	public String removeMerchantById(int merchantId) {
		String msg="";
		try {
			if(merchantRepo.getOne(merchantId)!=null) {
				merchantRepo.deleteById(merchantId);
				msg="Success! ID "+merchantId+" Found And Merchant Removed!";
			}
			else {
				msg="Error! Merchant Not Found: Cannot Be Deleted";
			}
		} catch (EmptyResultDataAccessException e) {
			msg="Error! Merchant Not Found: Cannot Be Deleted"+e;
			return msg;
		} catch (ConstraintViolationException e) {
			msg="Merchant Found But Cannot Be Removed: Foreign Key Constraint!";
			return msg;
		} catch (UnexpectedRollbackException e) {
			msg="Error! Merchant Not Found: Cannot Be Deleted"+e;
			return msg;
		}
		catch (Exception e) {
			msg="Error! Merchant Not Found: Cannot Be Deleted"+e;
			return msg;
		}
		return msg;
	}

	@Override
    /*TO UPDATE MERCHANT DETAILS*/
	public boolean updateMerchant(int merchantId, Merchant merchant)
	{
    	boolean flag=false;
    	Merchant mer=merchantRepo.getOne(merchantId);
    	if(mer!=null)
    	{
    		mer.setMerchantName(merchant.getMerchantName());
    		mer.setMerchantEmail(merchant.getMerchantEmail());
    		mer.setMerchantMobile(merchant.getMerchantMobile());
    		mer.setMerchantPassword(merchant.getMerchantPassword());
    		mer.setShopName(merchant.getShopName());
    		mer.setShopAddress(merchant.getShopAddress());
    		merchantRepo.save(mer);
    		flag=true;
    	}
		return flag;
	}

	@Override
	/*TO SHOW MERCHANT DETAILS BY ID*/
	public String showMerchant(int merchantId) {
		Merchant mer=merchantRepo.getOne(merchantId);
		return mer.toString();
	}
}
