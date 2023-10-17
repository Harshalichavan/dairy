package com.milk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.milk.Model.Farmer;
import com.milk.Model.Rate;
import com.milk.Service.FarmerServiceInterface;
import com.milk.Service.RateServiceInterface;

@RestController
public class FarmerController {

	@Autowired
	public FarmerServiceInterface fsi;

	@Autowired 
	public RateServiceInterface rsi;

	@GetMapping("farmer/{id}")
	public Farmer getfarmer(@PathVariable int id) {
		return fsi.getFarmer(id);
	}

	@PostMapping("farmer")
	public Farmer addfarmer(@RequestBody Farmer farmer) {
		return fsi.addfarmerinservice(farmer);

	}

	@PostMapping("farmer/milk/purchase/{farmerId}")
	public Farmer purchaseMilk(@PathVariable int farmerId, @RequestBody Rate rate) {

		Farmer resp = fsi.purchaseMilk(farmerId, rate);
		Rate r = resp.getRates().get(resp.getRates().size() - 1); // get last element
		resp.getRates().clear(); // remove all rates
		resp.getRates().add(r);
		return resp;
	}

	@PutMapping("farmer")
	public Farmer updatefarmer(@RequestBody Farmer farmer) {
		return fsi.updatefarmerinservice(farmer);
	}

	@DeleteMapping("farmer/{id}")
	public void deletefarmer(@PathVariable int id) {
		fsi.deletefarmerinservice(id);
	}

}
