package com.comercial.jsf;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comercial.model.User;
import com.comercial.utils.K;

public class ComercialFilter implements Filter {
	
	User user = null;

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        
        user = (User)session.getAttribute(K.session_user);
		String urlLogin = request.getContextPath() + "/faces/" + K.page_login;
		
		if (request.getRequestURI().indexOf(urlLogin)!=-1 || user!=null || request.getRequestURI().indexOf(".xhtml")==-1) {
			chain.doFilter(req, resp);
        } else {
        	response.sendRedirect(request.getContextPath() + "/faces/" + K.page_login );
        }
	
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println(" PASANDO POR EL INIT DE SERVLET-FILTER DE CALIFORNIA");
	}
	
	public void destroy() {
		System.out.println(" PASANDO POR EL DESTROY DE SERVLET-FILTER DE CALIFORNIA");
	}


}
