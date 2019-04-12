package com.cg.capsstore.merchantinventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capsstore.merchantinventory.enities.Merchant;


public interface IMerchantInventoryMerchantRepo extends JpaRepository<Merchant, Integer>  {

}
