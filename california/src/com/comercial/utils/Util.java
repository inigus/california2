package com.comercial.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {
	
	public static boolean isNotBlank(String val) {
		
		if (val!=null &&  !val.trim().equalsIgnoreCase("")) {
			return true;
		} 
		return false;
	}
	
	
	public static void showMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", message ));
	}
	
	
	public static void showError(String message) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message ));

	}

}
