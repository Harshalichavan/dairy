package com.milk.Service;

import java.util.Date;
import java.util.List;

import com.milk.Model.Farmer;
import com.milk.Model.Rate;


public interface FarmerServiceInterface {

	Farmer addfarmerinservice(Farmer farmer);

	Farmer updatefarmerinservice(Farmer farmer);

	void deletefarmerinservice(int id);

	Farmer getFarmer(int id);

	Farmer purchaseMilk(int farmerId, Rate rate);
	
	
	


}
