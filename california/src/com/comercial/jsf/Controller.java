package com.comercial.jsf;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.comercial.model.User;
import com.comercial.utils.K;

public abstract class Controller {

	
	private User user;
	
	
	
	public Controller() {
		
		
		
	}
	
	public void validateSession() {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		
		this.user = (User)session.getAttribute(K.session_user); 
		
	}
}
