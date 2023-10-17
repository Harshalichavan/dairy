package com.milk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milk.Model.AccountDatails;

public interface AccountDetailsRepo extends JpaRepository<AccountDatails, Integer> {

}
