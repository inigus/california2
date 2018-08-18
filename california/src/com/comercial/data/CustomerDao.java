package com.comercial.data;

import java.util.List;

import com.comercial.model.Customer;

public interface CustomerDao {


	public Customer get(Customer customer);

	public Customer insert(Customer customer);
	
	public boolean update(Customer customer);

	public boolean delete(Customer customer);
	
	public List<Customer> getAll();

}
