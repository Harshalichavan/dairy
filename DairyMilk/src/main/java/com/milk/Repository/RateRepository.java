package com.milk.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.milk.Model.Farmer;
import com.milk.Model.Rate;

public interface RateRepository extends JpaRepository<Rate, Integer> {
	
	List<Rate> findByFarmer(int fid);
	
	@Query(value = "SELECT * FROM rate WHERE fid =:fid and  date between  :startDate AND :endDate", nativeQuery = true)
	List<Rate> findByDateBetween(@Param("fid") int fid,@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	@Query(value = "SELECT * FROM rate WHERE date between  :startDate AND :endDate", nativeQuery = true)
	List<Rate> findByDateAllID(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	
}
