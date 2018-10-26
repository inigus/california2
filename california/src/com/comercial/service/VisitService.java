package com.comercial.service;

import java.util.List;

import com.comercial.model.Visit;

public interface VisitService {
	
	
	/**
	 * 
	 * @param visita
	 * @param orderBy nombre del atributo por el que se ordena
	 * @return
	 */
	public List<Visit> getVisitsFiltered(Visit visita, String orderBy);
	
	public Visit get(Integer idVisita);
	
	public Visit insert(Visit visita);
	
	public boolean update(Visit visita);
	
	public boolean delete(Visit visita);

}
