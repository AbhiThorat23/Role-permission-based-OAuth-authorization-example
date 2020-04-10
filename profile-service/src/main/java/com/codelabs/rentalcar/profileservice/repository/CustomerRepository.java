package com.codelabs.rentalcar.profileservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codelabs.rentalcar.commons.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
