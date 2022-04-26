package com.example.PBGS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.PBGS.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
