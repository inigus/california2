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


@ManagedBean(name = "visitController")
@ViewScoped
public class VisitController {
	
	
	@ManagedProperty(value="#{customerController}")
	private CustomerController customerController;
	
	@ManagedProperty("#{customerService}")
    private CustomerServiceImpl customerService;
	
	private Visit selected;
	
	private Visit edited;
	
	private Visit filter = new Visit();

	private List<Visit> visits;
	
	private List<Property> properties;
	
	private VisitProperty selectedProperty;
	
	private String[] propertyValue;
	
	private Map<String, Integer> mPropiedadIndex = new HashMap<String, Integer>();

	private VisitService visitService = new VisitServiceImpl();
	
	private PropertyService proService = new PropertyServiceImpl();
	
	private boolean showCustomerListForm = false;
	
	private boolean showFilerVisitForm = false;
	
	
	private boolean disabledFilterButton = false;
	private boolean disabledOrderButton = true;
	private boolean disabledNewButton = false;
	private boolean disabledSaveButton = true;
	private boolean disabledDeleteButton = true;
	private boolean disabledCancelButton = true;
	
	private List<Customer> customers;

	private List<VisitProperty> listaVisitas = new ArrayList<>();
	private List<VisitProperty> listaVisitasSeleccionadas;
	
	public void removeXXX(ActionEvent event) {
		
		System.out.println("aqui entro");

		for (VisitProperty v : listaVisitasSeleccionadas) {
			System.out.println("POR FIN PASOOOOOOO: " + v.toString());
		}
	}

	public List<VisitProperty> getListaVisitas() {
		return listaVisitas;
	}
	public void setListaVisitas(List<VisitProperty> listaVisitas) {
		this.listaVisitas = listaVisitas;
	}

	public List<VisitProperty> getListaVisitasSeleccionadas() {
		return listaVisitasSeleccionadas;
	}
	public void setListaVisitasSeleccionadas(List<VisitProperty> listaVisitasSeleccionadas) {
		this.listaVisitasSeleccionadas = listaVisitasSeleccionadas;
	}



@PostConstruct
    public void init() {       
        // Remember already saved result from view scoped bean
        System.out.println(" supongo sera como un constructor....");
        
        this.customers = customerService.getCustomers();
        
        //themes = service.getThemes();
    }
	
	public VisitController() {
		// TODO Auto-generated method stub

		this.visits = this.visitService.getVisitsFiltered(filter, "cliente.nombre" );
		
		Property pro = new Property();
		pro.setEntidad("visita");
		this.properties = this.proService.getPropertysFiltered(pro);
		propertyValue = new String[this.properties.size()];
		
		int i = 0;
		for (Property property : properties) {
			mPropiedadIndex.put(property.getPropiedad(), i++ );
		}
		
		for (Visit v : this.visits ) {
			for (VisitProperty vp : v.getPropiedadesVisita()) {
				this.listaVisitas.add(vp);
			}
			break;
		}
		
	}
	
	
	/*
	 *  METODOS PARA EL LISTADO
	 */
	
	public void filterVisits(ActionEvent event) {
		this.visits = this.visitService.getVisitsFiltered(filter, null);
    	System.out.println("FILTRADO VISITAS");
    }
	
	public void filterVisitsCancel(ActionEvent event) {
    	this.filter = new Visit();
		this.visits = this.visitService.getVisitsFiltered(filter,null);
    	System.out.println("FILTRADO VISITAS");
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
    
    
    public void edit(ActionEvent event) {
    	Map<String,Object> req = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
    	Visit aux = (Visit)req.get("item");
    	this.selected = visitService.get( aux.getIdVisita() );  
    	this.controlToolbarButtons(K.action_edit);
    }
    
    
    public void view(ActionEvent event) {
    	Map<String,Object> req = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
    	Visit aux = (Visit)req.get("item");
    	this.selected = visitService.get(aux.getIdVisita());  
    	this.controlToolbarButtons(K.action_view);
    }
    
    /*
     * FIN METODOS DEL LISTADO
     */


   /*
    *  METODOS PARA EL FORMULARIO DE EDICION
    */
    
    public void create (ActionEvent event) {
    	this.selected = new Visit();
    	this.controlToolbarButtons(K.action_new);
    }
    
    public void save(ActionEvent event) {
    	
    	if (selected.getIdVisita() != null) {
    		System.out.println( "CUSTOMER SELECTED(update):" + selected.toString() );
    		visitService.update(selected);
    	} else {
    		System.out.println( "CUSTOMER SELECTED(save_new):" + selected.toString() );
    		visitService.insert(selected);
    	}
    	FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Se ha guardado correctamente la visita "));
    }
    
    public void cancel(ActionEvent event) {
    	this.selected = null;
    	this.controlToolbarButtons(K.action_cancel);
    }
	
    public void remove(ActionEvent event) {
    	System.out.println( "CUSTOMER SELECTED(DELETE):" + selected.toString() );
    }
    
    public void addProperty(String property) {
    	
    	int index = this.mPropiedadIndex.get(property);
    	String value = this.propertyValue[index];
    	
    	Property prop = Property.getPropertyByName(properties, property);
    	this.selected.addVisitProperty(prop, value);
    	this.propertyValue[index] = "";
    }
    
    public void deleteProperty(String property) {
    	
    	Property prop = Property.getPropertyByName(properties, property);
    	
    	for (int i = this.selected.getPropiedadesVisita().size()-1; i>=0; i-- ) {
    		VisitProperty vProp = this.selected.getPropiedadesVisita().get(i);
    		if (vProp.getPropiedad().equals(prop) && vProp.isSelected() ) {
    			this.selected.getPropiedadesVisita().remove(vProp);
    		}
		}
    }
    
    private void controlToolbarButtons(String accion) {
    	
    	if (accion.equals(K.action_edit)) {
    		this.disabledFilterButton = true;
    		this.disabledOrderButton = true;
    		this.disabledNewButton = true;
    		this.disabledSaveButton = false;
    		this.disabledDeleteButton = false;
    		this.disabledCancelButton = false;
    	} else if (accion.equalsIgnoreCase(K.action_new)) {
    		this.disabledFilterButton = true;
    		this.disabledOrderButton = true;
    		this.disabledNewButton = true;
    		this.disabledSaveButton = false;
    		this.disabledDeleteButton = true;
    		this.disabledCancelButton = false;
    	} else if (accion.equals(K.action_cancel)) {
    		this.disabledFilterButton = false;
    		this.disabledOrderButton = true;
    		this.disabledNewButton = false;
    		this.disabledSaveButton = true;
    		this.disabledDeleteButton = true;
    		this.disabledCancelButton = true;
    	}else if (accion.equals(K.action_view)) {
    		this.disabledFilterButton = false;
    		this.disabledOrderButton = true;
    		this.disabledNewButton = false;
    		this.disabledSaveButton = true;
    		this.disabledDeleteButton = true;
    		this.disabledCancelButton = false;
    	}
    }
    
	
    public void selectCustomerOnEdit(){
    	
    	System.out.println("CLIENTE SELECCIONADO:" + this.selected.getCliente());
    }
    
    public void selectCustomerOnFilter(){
    	
    	System.out.println("CLIENTE SELECCIONADO:" + this.filter.getCliente());
    }

    
    public void clickFilterBtn(ActionEvent event) {
    	if (this.showCustomerListForm) {
    		this.showFilerVisitForm = false;
    	} else {
    		this.showFilerVisitForm = true;
    	}
    }
    

	

	public List<Visit> getVisits() {
		
		if (visits==null) {
			this.visits = this.visitService.getVisitsFiltered(filter,null);
		}
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
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

	public boolean isShowCustomerListForm() {
		return showCustomerListForm;
	}

	public void setShowCustomerListForm(boolean showCustomerListForm) {
		this.showCustomerListForm = showCustomerListForm;
	}

	public Visit getFilter() {
		return filter;
	}

	public void setFilter(Visit filter) {
		this.filter = filter;
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

	public boolean isShowFilerVisitForm() {
		return showFilerVisitForm;
	}

	public void setShowFilerVisitForm(boolean showFilerVisitForm) {
		this.showFilerVisitForm = showFilerVisitForm;
	}

	public boolean isDisabledNewButton() {
		return disabledNewButton;
	}

	public void setDisabledNewButton(boolean disabledNewButton) {
		this.disabledNewButton = disabledNewButton;
	}

	public boolean isDisabledSaveButton() {
		return disabledSaveButton;
	}

	public void setDisabledSaveButton(boolean disabledSaveButton) {
		this.disabledSaveButton = disabledSaveButton;
	}

	public boolean isDisabledDeleteButton() {
		return disabledDeleteButton;
	}

	public void setDisabledDeleteButton(boolean disabledDeleteButton) {
		this.disabledDeleteButton = disabledDeleteButton;
	}

	public boolean isDisabledCancelButton() {
		return disabledCancelButton;
	}

	public void setDisabledCancelButton(boolean disabledCancelButton) {
		this.disabledCancelButton = disabledCancelButton;
	}

	public boolean isDisabledFilterButton() {
		return disabledFilterButton;
	}

	public void setDisabledFilterButton(boolean disabledFilterButton) {
		this.disabledFilterButton = disabledFilterButton;
	}

	public boolean isDisabledOrderButton() {
		return disabledOrderButton;
	}

	public void setDisabledOrderButton(boolean disabledorderButton) {
		this.disabledOrderButton = disabledorderButton;
	}

	public Visit getEdited() {
		return edited;
	}

	public void setEdited(Visit edited) {
		this.edited = edited;
	}

	
	
    private List<String> selectedOptions;
 
//    public void setService(ThemeService service) {
//        this.service = service;
//    }
 
    public List<String> getSelectedOptions() {
        return selectedOptions;
    }
 
    public void setSelectedOptions(List<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }
 
	
	
}
