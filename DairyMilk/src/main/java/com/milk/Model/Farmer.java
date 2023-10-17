package com.milk.Model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
@Entity
public class Farmer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private  int fid;
	private  String fname;
	private  long contact;
	private  String address;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="farmer",cascade = CascadeType.ALL)
    private List<Rate> rates;

	
}
