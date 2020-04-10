package com.codelabs.rentalcar.profileservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codelabs.rentalcar.commons.models.Customer;

@Service
public interface CustomerService {

	public Customer save(Customer cust);

	public Customer fetchById(int profileId);

	public List<Customer> fetchAllProfiles();
}
