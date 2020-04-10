package com.codelabs.rentalcar.profileservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelabs.rentalcar.commons.models.Customer;
import com.codelabs.rentalcar.profileservice.repository.CustomerRepository;
import com.codelabs.rentalcar.profileservice.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer save(Customer cust) {
		return customerRepo.save(cust);
	}

	@Override
	public Customer fetchById(int profileId) {
		Optional<Customer> customer = customerRepo.findById(profileId);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            return null;
        }
	}

	@Override
	public List<Customer> fetchAllProfiles() {
		return customerRepo.findAll();
	}

}
