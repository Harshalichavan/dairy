package com.milk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milk.Model.PurchaseMaterial;
import com.milk.Repository.PurchaseMaterialRepository;

@Service
public class PurchaseMaterialServiceImpl implements PurchaseMaterialServiceInterface
{

	@Autowired
	public PurchaseMaterialRepository prepo;
	
	@Override
	public PurchaseMaterial addpurchasematerialinservice(PurchaseMaterial pm) {
		// TODO Auto-generated method stub
		return prepo.save(pm);
	}

	@Override
	public PurchaseMaterial updatepurchasematerialinservice(PurchaseMaterial pm) {
		// TODO Auto-generated method stub
		return prepo.save(pm);
	}

	@Override
	public void deletepurchasematerialinservice(int id) {

		prepo.delete(prepo.getById(id));
		
	}

}
