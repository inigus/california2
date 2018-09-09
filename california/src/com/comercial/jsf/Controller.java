package com.comercial.jsf;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.comercial.model.User;

public abstract class Controller {

	
	private User user;
	
	
	
	public Controller() {
		
		
		
	}
	
	public void validateSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		
		if (session.getAttribute("user") == null) {
			System.out.println("tienes que Reiniciar session");
		}
		
	}
}
