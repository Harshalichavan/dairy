package com.milk.Service;

import java.util.Date;
import java.util.List;
import com.milk.Model.Rate;
import com.milk.Model.RateDTO;

public interface RateServiceInterface {

	Rate addrateinservice(Rate acc);

	Rate updaterateinservice(Rate acc);

	void deleterateinservice(int id);

	List<Rate> getallrate();

	Rate getrate(int fid);

	Rate calculateRate(Rate rate);

	List<Rate> getBetweenDatesByID(int id, Date startDate, Date endDate);

	List<Rate> getDatesBetween(Date startDate, Date endDate);
	
	
	

	
	

}

