package com.milk.Controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.milk.Model.Rate;
import com.milk.Model.RateDTO;
import com.milk.Service.RateServiceInterface;

@RestController
public class RateController {

	@Autowired
	public RateServiceInterface asi;

	@Autowired
	public ModelMapper modelMapper;

	@GetMapping("account")
	public List<RateDTO> getAllRate() {
		return asi.getallrate().stream().map(Rate -> modelMapper.map(Rate, RateDTO.class)).collect(Collectors.toList());

	}

	@GetMapping("account/{fid}")
	public Rate getrate(@PathVariable int fid) {
		return asi.getrate(fid);
	}

	@GetMapping("account/{id}/{startDate}/{endDate}")
	public List<Rate> getDatesBetween(@PathVariable int id,
			@PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-mm-dd") Date startDate,
			@PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-mm-dd") Date endDate) {
		return asi.getBetweenDatesByID(id, startDate, endDate);

	}

	@GetMapping("account/{startDate}/{endDate}")
	public List<Rate> getDates(
			@PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-mm-dd") Date startDate,
			@PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-mm-dd") Date endDate) {
		return asi.getDatesBetween(startDate, endDate);

	}

	@PostMapping("account")
	public Rate addaccountrate(@RequestBody Rate acc) {
		return asi.addrateinservice(acc);

	}

	@PutMapping("account")
	public Rate updateaccountrate(@RequestBody Rate acc) {
		return asi.updaterateinservice(acc);

	}

	@DeleteMapping("account/{id}")
	public void deleteaccountrate(@PathVariable int id) {
		asi.deleterateinservice(id);

	}

}
