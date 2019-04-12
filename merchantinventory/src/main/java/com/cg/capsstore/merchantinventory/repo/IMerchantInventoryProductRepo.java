package com.cg.capsstore.merchantinventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.capsstore.merchantinventory.enities.Product;



public interface IMerchantInventoryProductRepo extends JpaRepository<Product, Integer> {

}
