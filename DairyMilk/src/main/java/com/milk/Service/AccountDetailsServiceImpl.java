package com.milk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milk.Model.AccountDatails;
import com.milk.Repository.AccountDetailsRepo;

@Service
public class AccountDetailsServiceImpl  implements AccountDetailsInterface{

	@Autowired
	public AccountDetailsRepo repo;
	
	@Override
	public AccountDatails saveAccountDetails(AccountDatails account) {
		// TODO Auto-generated method stub
		return repo.save(account);
	}

}
