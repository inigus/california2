package com.comercial.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.comercial.data.CustomerDao;
import com.comercial.data.CustomerDaoImpl;
import com.comercial.model.Customer;



@ManagedBean(name="customerService", eager = true)
@ApplicationScoped
public class CustomerServiceImpl  extends BaseService implements CustomerService {
	
	
	private CustomerDao customerDao = new CustomerDaoImpl(this.em);
	
	private List<Customer> customers;
	
	@PostConstruct
    public void init() {
		
		this.customers = customerDao.getAll();
	}
	
	
	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerDao.getAll();
	}

	@Override
	public Customer get(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.get(customer);
	}

	@Override
	public Customer insert(Customer customer) {
		// TODO Auto-generated method stub
		
		Customer cus = new Customer();
		try {
		this.initTransaction();
		
		cus = customerDao.insert(customer);
		
		this.finishTransaction();
		} catch (Throwable t) {
			this.finishTransaction(t);
		}
		return cus;
	}

	@Override
	public boolean update(Customer customer) {

		boolean resul = false;
		try {
			this.initTransaction();
			resul = customerDao.update(customer);
			this.finishTransaction();
		} catch (Throwable t) {
		    this.finishTransaction(t);
		}
			
		return resul;
	}

	@Override
	public boolean delete(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	


	
	
}
