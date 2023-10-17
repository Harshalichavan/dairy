package com.milk.Model;

import java.sql.Date;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class RateDTO {

	@Id
	private int rid;
	
	private double fat;
	private double degree;
	private double snf;
	private String milkType;
	private double milkPurchaseQuantity;
	private double purchasePricePerLitre;
	private Date date;
	
}
