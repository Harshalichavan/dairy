package com.milk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.milk.Model.PurchaseMaterial;
import com.milk.Service.PurchaseMaterialServiceInterface;

@RestController
public class PurchaseMaterialController {

	@Autowired
	public PurchaseMaterialServiceInterface psi;
	
	@PostMapping("purchase")
	public PurchaseMaterial addpurchasematerial(@RequestBody PurchaseMaterial pm)
	{
		return psi.addpurchasematerialinservice(pm);
	}
	
	@PutMapping("purchase")
	public PurchaseMaterial updatepurchasematerial(@RequestBody PurchaseMaterial pm)
	{
		return psi.updatepurchasematerialinservice(pm);
	}
	
	@DeleteMapping("purchase/{id}")
	public void deletepurchasematerial(@PathVariable int id)
	{
		 psi.deletepurchasematerialinservice(id);
		
	}
	
}
