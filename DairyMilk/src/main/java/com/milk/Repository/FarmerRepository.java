package com.milk.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.milk.Model.Farmer;
import com.milk.Model.Rate;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {

	Farmer findByFid(int fid);
	

	
	
}
