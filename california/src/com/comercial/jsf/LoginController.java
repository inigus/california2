package com.comercial.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.comercial.model.User;
import com.comercial.service.UserService;
import com.comercial.service.UserServiceImpl;
   
  @ManagedBean(name = "login")
  @ViewScoped
  public class LoginController {
   
        private UserService userService = new UserServiceImpl();
        
        private User user = new User();
        
        public String send() {
        	
        	
        	user = userService.loginUser(user);
              
        	if (user==null) {
        		user = new User();
                FacesContext.getCurrentInstance().addMessage(
                           null,
                           new FacesMessage(FacesMessage.SEVERITY_ERROR, "User not found!",
                                       " Login Error!"));
                return null;
        	} else {
        		 return "/main.xhtml";
        	}  
        }
   
        public User getUser() {
              return user;
        }
   
        public void setUser(User user) {
              this.user = user;
        }
  }
