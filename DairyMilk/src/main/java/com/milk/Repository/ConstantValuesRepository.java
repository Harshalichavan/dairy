package com.milk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milk.Model.ConstantValues;

public interface ConstantValuesRepository extends JpaRepository<ConstantValues, Integer>{

	ConstantValues findFirstByOrderByUidDesc();
	
}
