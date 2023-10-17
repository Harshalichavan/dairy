package com.milk.Model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Rate {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rid;
	private double fat;
	private double degree;
	private double snf;
	private double rateofmilk ;

	private String milkType;
	private double milkPurchaseQuantity;
	private double purchasePricePerLitre;
	private String shift;
	private int updateId;
	private Date date = new Date(System.currentTimeMillis());
	
	@ManyToOne
    @JoinColumn(name = "fid")
	@JsonIgnore
    private Farmer farmer;
	
}
