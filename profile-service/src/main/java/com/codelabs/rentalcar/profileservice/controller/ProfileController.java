package com.codelabs.rentalcar.profileservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelabs.rentalcar.commons.models.Customer;
import com.codelabs.rentalcar.profileservice.services.CustomerService;

@RestController
@RequestMapping("/service")
public class ProfileController {

	@Autowired
	private CustomerService customerService;

	/**
	 * Here we have done role based Authorization. If user has a role of
	 * "ROLE_admin" then only he can create records. So even if any other user has
	 * create permission/authority, he will not be ale to create record here,
	 * because here we are giving access to only "ROLE_adminr" role.
	 * 
	 * Here only user "abhi" can create profile, because he is having Admin role
	 * 
	 * @param customer
	 * @return Customer
	 */
	@PostMapping("/customer")
	@PreAuthorize("hasRole('ROLE_admin')")
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@GetMapping(value = "/profile")
	public Customer fetch(@RequestParam int profileId) {
		return customerService.fetchById(profileId);
	}

	/**
	 * Here we have done permission/Authority based Authorization. Here all the
	 * users with "read permission" can able to fetch the data irrespective of there
	 * role. Role will not be considered here only permission/authority of user will
	 * be considered.
	 * 
	 * Here All 3 users-> abhi, kiran, dipak can fetch the data, as all the 3 users
	 * have "read_profile" permission.
	 * 
	 * @return List<Customer>
	 */
	@GetMapping(value = "/profiles")
	@PreAuthorize("hasAuthority('read_profile')")
	public List<Customer> fetchAll() {
		return customerService.fetchAllProfiles();
	}
}
