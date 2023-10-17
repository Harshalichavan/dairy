package com.milk.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milk.Model.Farmer;
import com.milk.Model.Rate;
import com.milk.Repository.FarmerRepository;
import com.milk.Repository.RateRepository;

@Service
public class FarmerServiceImpl implements FarmerServiceInterface {

	@Autowired
	public FarmerRepository repo;
	
//	@Autowired
//	public RateRepository rateRepo;
	
	@Autowired RateServiceInterface rateService;
	
	@Override
	public Farmer addfarmerinservice(Farmer farmer) {
		return repo.save(farmer);
	}

	@Override
	public Farmer updatefarmerinservice(Farmer farmer) {
		// TODO Auto-generated method stub
		return repo.save(farmer);
	}

	@Override
	public void deletefarmerinservice(int id) {
		// TODO Auto-generated method stub
		 repo.delete(repo.getById(id));	
	}

	@Override
	public Farmer getFarmer(int id) {
		
		return repo.findById(id).get();
	}

	@Override
	public Farmer purchaseMilk(int farmerId, Rate rate) {
		List<Rate> rateList;
		Farmer farmer = repo.findById(farmerId).get();
		if (null != farmer) {
			Rate calculatedRate = rateService.calculateRate(rate);
			calculatedRate.setFarmer(farmer);
			farmer.getRates().add(calculatedRate);
			return repo.save(farmer);
		} else {
			return null;
		}
	}

}