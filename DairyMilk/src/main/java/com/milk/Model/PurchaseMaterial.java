package com.milk.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PurchaseMaterial {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int pid;
	private String pname;
	private double price;
	private Date date = new Date(System.currentTimeMillis());
	
	
}
