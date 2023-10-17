package com.milk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milk.Model.PurchaseMaterial;

public interface PurchaseMaterialRepository extends JpaRepository<PurchaseMaterial, Integer> {

}
