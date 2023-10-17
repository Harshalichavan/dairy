package com.milk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.milk.Model.ConstantValues;
import com.milk.Service.ConstantValuesServiceInterface;

@RestController
public class ConstantValuesController {

	@Autowired
	public ConstantValuesServiceInterface vsi;
	
	@PostMapping("update")
	public ConstantValues updateall(@RequestBody ConstantValues update)
	{
		return vsi.updateallinservice(update);
	}
	
	
}
