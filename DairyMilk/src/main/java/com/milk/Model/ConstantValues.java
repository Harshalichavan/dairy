package com.milk.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ConstantValues {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uid;
	private  double fatInc = 0.20; 
	private  double fatDec = 0.10;
	private  double snfInc = 0.20;
	private  double snfDec = 0.10;
	private double rateOfMilk = 36;
	private double rateOfMilkB = 48;
	private  double fatB = 0.70; 
	private  double snfB = 0.70;
	
	private Date date = new Date(System.currentTimeMillis());
}
