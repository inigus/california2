package com.comercial.jsf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import com.comercial.model.Customer;
import com.comercial.model.Property;
import com.comercial.model.Visit;
import com.comercial.model.VisitProperty;
import com.comercial.service.CustomerServiceImpl;
import com.comercial.service.PropertyService;
import com.comercial.service.PropertyServiceImpl;
import com.comercial.service.VisitService;
import com.comercial.service.VisitServiceImpl;
import com.comercial.utils.K;
import com.comercial.utils.Util;


@ManagedBean(name = "visitEdit")
@ViewScoped
public class VisitEditController extends Controller {
	
	
	@ManagedProperty(value="#{customerController}")
	private CustomerController customerController;
	
	@ManagedProperty("#{customerService}")
    private CustomerServiceImpl customerService;
	
	private VisitService visitService = new VisitServiceImpl();
	
	private PropertyService proService = new PropertyServiceImpl();
	
	private Visit selected;
	
	private List<Property> properties;
	
	private VisitProperty selectedProperty;
	
	private String[] propertyValue;
	
	private Map<String, Integer> mPropertyIndex = new HashMap<String, Integer>();

	private boolean bEditCustomer= true;
	private boolean bNewCustomer = false;
	
	private List<Customer> customers;

	private List<VisitProperty> listPropertiesSelected = new ArrayList<>();

	private Customer selCustomer = new Customer();

	public VisitEditController() {
		// TODO Auto-generated method stub
	}
	
	@PostConstruct
    public void init() {       
        // Remember already saved result from view scoped bean
		// validateSession();
        
        this.customers = customerService.getCustomers();
        
        selected = new Visit();
        selected.setCliente(new Customer());
       
		Property pro = new Property();
		pro.setEntidad("visita");
		this.properties = this.proService.getPropertysFiltered(pro);
		propertyValue = new String[this.properties.size()];
		
		int i=0;
		for (Property prop : properties) {
			mPropertyIndex.put(prop.getPropiedad(), i++);
		}

    }

    
    public List<VisitProperty> getVisitPropertyValues(String propiedad) {
    	
    	List<VisitProperty> properties = new ArrayList<VisitProperty>();
    	for (VisitProperty vpro : selected.getPropiedadesVisita() ) {
    		if ( vpro.getPropiedad().getPropiedad().equalsIgnoreCase(propiedad)) {
    			properties.add(vpro);
    		}
		}
    	return properties;
    }
     
    public void clickVisitSave(ActionEvent event) {
    	
    	try {
	    	
    		if (selected.getIdVisita() != null) {
	    		System.out.println( "CUSTOMER SELECTED(update):" + selected.toString() );
	    		visitService.update(selected);
	    	} else {
	    		System.out.println( "CUSTOMER SELECTED(save_new):" + selected.toString() );
	    		visitService.insert(selected);
	    	}
	    	Util.showMessage("Visita guardada correctamente");
	    	
    	} catch (Exception e) {
    		Util.showMessage("ERROR guardando la visita:" + e.toString());
    	}
    }
    
    public void clickVisitCancel(ActionEvent event) {
    	this.selected = null;
    }
	
    public void remove(ActionEvent event) {
    	System.out.println( "CUSTOMER SELECTED(DELETE):" + selected.toString() );
    }
    
    public void clickAddProperty(String property) {
    	
    	int index = this.mPropertyIndex.get(property);
    	String value = this.propertyValue[index];
    	
    	Property prop = Property.getPropertyByName(properties, property);
    	this.selected.addVisitProperty(prop, value);
    	this.propertyValue[index] = "";
    }
    
    public void selectProperty(ValueChangeEvent event){
    	System.out.println("aaaaaaaaaaaaa");
    }
    
    public void clickDeleteProperty(String property) {
	
    	Property prop = Property.getPropertyByName(properties, property);
    
    	for (int i = this.selected.getPropiedadesVisita().size()-1; i>=0; i-- ) {
    		VisitProperty vProp = this.selected.getPropiedadesVisita().get(i);
    		if (vProp.getPropiedad().equals(prop) && vProp.isSelected() ) {
    			this.selected.getPropiedadesVisita().remove(vProp);
    		}
		}
    }
    
    public void selectCustomerOnFilter(){
    	this.bEditCustomer = false;
    	this.selCustomer = this.selected.getCliente();
    }
    
    public void clickCustomerNew( ActionEvent event ) {
    	this.bNewCustomer = true;
    	selected.setCliente(new Customer());
    }
    
    public void clickCustomerSave(ActionEvent event) {
    	
    	try {
	    	if (bNewCustomer) {
	    		customerService.insert( selCustomer );
	    		this.selected.setCliente(selCustomer);
	    		bNewCustomer = false;
	    	} else {
	    		customerService.update( selected.getCliente() );
	    	}
	    	Util.showMessage("Cliente guardado correctamente");
    	} catch (Exception e) {
    		Util.showError("Error guardadndo cliente:" + e.toString());
    	}
    	
    }
	
	public Visit getSelected() {
		return selected;
	}

	public void setSelected(Visit selected) {
		this.selected = selected;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public VisitProperty getSelectedProperty() {
		return selectedProperty;
	}

	public void setSelectedProperty(VisitProperty selectedProperty) {
		this.selectedProperty = selectedProperty;
	}
	
	public String[] getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String[] propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getPropertyValue(int index) {
		return this.propertyValue[index];
	}

	public void setPropertyValues(int index, String value) {
		this.propertyValue[index] = value;
	}
	
	public void setPropertyValues(int index) {
		this.propertyValue[index] = "XXXXXXXXXXXXXXX";
	}

	public CustomerController getCustomerController() {
		return customerController;
	}

	public void setCustomerController(CustomerController customerController) {
		this.customerController = customerController;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public CustomerServiceImpl getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerServiceImpl customerService) {
		this.customerService = customerService;
	}

	public List<VisitProperty> getListPropertiesSelected() {
		return listPropertiesSelected;
	}

	public void setListPropertiesSelected(List<VisitProperty> listPropertiesSelected) {
		this.listPropertiesSelected = listPropertiesSelected;
	}

	public boolean isbEditCustomer() {
		return bEditCustomer;
	}

	public void setbEditCustomer(boolean bEditCustomer) {
		this.bEditCustomer = bEditCustomer;
	}

	public Customer getSelCustomer() {
		return selCustomer;
	}

	public void setSelCustomer(Customer selCustomer) {
		this.selCustomer = selCustomer;
	}

	
}
