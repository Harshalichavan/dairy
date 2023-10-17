package com.milk.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milk.Model.ConstantValues;
import com.milk.Repository.ConstantValuesRepository;

@Service 
public class ConstantValuesServiceImpl implements ConstantValuesServiceInterface {
 
	@Autowired
	public ConstantValuesRepository repo;
	
	
	@Override
	public ConstantValues updateallinservice(ConstantValues update) {
		// TODO Auto-generated method stub
		
		return repo.save(update);
	}
	
	@Override
	public ConstantValues getLatestValue() {
		return repo.findFirstByOrderByUidDesc();
	}

}
