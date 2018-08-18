package com.comercial.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.comercial.model.Customer;

public class CustomerDaoImpl extends BaseDao implements CustomerDao {

	public CustomerDaoImpl(EntityManager em) {
		super(em);
	}
	
	@Override
	public Customer get(Customer customer) {

		try {
			Customer newCustomer = (Customer) em
					.createQuery(
							"SELECT c from Customer c where c.idCliente = :idCliente")
					.setParameter("idCliente", customer.getIdCliente()).getSingleResult();

			return newCustomer;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Customer insert(Customer customer) {
		
			em.persist(customer);
			return customer;

		
	}
	
	@Override
	public boolean update(Customer customer) {		
			em.merge(customer);
			return true;
		
	}

	@Override
	public boolean delete (Customer customer) {
		try {
			em.remove(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Customer> getAll() {

		try {
			List<Customer> customers = (List<Customer>) em
					.createQuery("SELECT c from Customer c")
					.getResultList();
			return customers;
		} catch (NoResultException e) {
			return new ArrayList<Customer>();
		}
	}

}
