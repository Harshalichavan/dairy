package com.milk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.milk.Model.AccountDatails;
import com.milk.Service.AccountDetailsInterface;

@RestController
public class AccountDetailsController {

	@Autowired
	public AccountDetailsInterface adi;
	
	@PostMapping("accountDetails")
	public AccountDatails saveDetails (@RequestBody AccountDatails account) {
		return adi.saveAccountDetails(account);
	}
	
	
	
}
