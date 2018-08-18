package com.comercial.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.comercial.model.Customer;
import com.comercial.service.CustomerService;
import com.comercial.service.CustomerServiceImpl;


@ManagedBean(name = "customerController")
@ViewScoped
public class CustomerController {
	
	private Customer selected;

	private List<Customer> customers;

	private CustomerService customerService = new CustomerServiceImpl();

	public void CustomersControl() {
		// TODO Auto-generated method stub

		
		this.customers = this.customerService.getAll();
	}

    public void create() {
    	this.customers = this.customerService.getAll();
    }
	
	
	public void onCellEdit(){
		
		System.out.println("EDITANDO LA CELDA");
		
	}
	
	
	
    public Customer prepareCreate(ActionEvent event) {
        selected = new Customer();
        return selected;
        
    }
	
    
    public void save(ActionEvent event) {
    	
    	if (selected.getIdCliente()!= null) {
    		System.out.println( "CUSTOMER SELECTED(update):" + selected.toString() );
    		customerService.update(selected);
    	} else {
    		System.out.println( "CUSTOMER SELECTED(save_new):" + selected.toString() );
    		customerService.insert(selected);
    	}
    	
    }
    
    
    public void closeListDialog() {
        //pass back to level 2
        RequestContext.getCurrentInstance().closeDialog(this.selected );
    }
    
    public void cancel(ActionEvent event) {
    	System.out.println( "CUSTOMER CANCEL:" + selected.toString() );
    	selected = null;
    }
	
    public void delete(ActionEvent event) {
    	System.out.println( "CUSTOMER SELECTED(DELETE):" + selected.toString() );
    }
	

	public List<Customer> getCustomers() {
		
		if (customers==null) {
			this.customers = this.customerService.getAll();
		}
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public Customer getSelected() {
		return selected;
	}

	public void setSelected(Customer selected) {
		this.selected = selected;
	}


}
