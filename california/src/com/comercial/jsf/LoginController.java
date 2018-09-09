package com.comercial.jsf;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.comercial.model.User;
import com.comercial.service.UserService;
import com.comercial.service.UserServiceImpl;
import com.comercial.utils.K;
   
  @ManagedBean(name = "login")
  @ViewScoped
  public class LoginController {
   
        private UserService userService = new UserServiceImpl();
        
        private User user = new User();
        
    	@PostConstruct
        public void init() {    
    		
    		System.out.println("A ver si entro por lo menos");
    		
    		this.user.setMail("fernandezarce@gmail.com");
    		this.user.setPassword("inigo");
    		
    	}
        
        public String loginUser() {
        	
        	this.user.setPassword("inigo");
        	user = userService.loginUser(user);
              
        	if (user==null) {
        		user = new User();
                FacesContext.getCurrentInstance().addMessage(
                           null,
                           new FacesMessage(FacesMessage.SEVERITY_ERROR, "User not found!",
                                       " Login Error!"));
                return null;
        	} else {
        		 return K.page_visit_new;
        	}  
        }
   
        public User getUser() {
              return user;
        }
   
        public void setUser(User user) {
              this.user = user;
        }
  }
