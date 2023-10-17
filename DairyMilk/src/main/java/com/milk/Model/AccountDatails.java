package com.milk.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AccountDatails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private  int aid;
	private  String name;
	private  long contact;
	private String bankName;
	private long accNumber;
	private String ifscCode;
	private String branch;
	

}
