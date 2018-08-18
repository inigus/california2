package com.comercial.service;

import java.util.List;

import com.comercial.model.Customer;

public interface CustomerService {
	
	
	public List<Customer> getAll();
	
	public Customer get(Customer customer);
	
	public Customer insert(Customer customer);
	
	public boolean update(Customer customer);
	
	public boolean delete(Customer customer);

}
