package com.cg.capsstore.managingmerchant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capsstore.managingmerchant.entities.Merchant;

public interface IMerchantRepo extends JpaRepository<Merchant, Integer> {

}
