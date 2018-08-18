package com.comercial.service;

import java.util.List;

import com.comercial.model.Visit;

public interface VisitService {
	
	
	public List<Visit> getVisitsFiltered(Visit visita);
	
	public Visit get(Integer idVisita);
	
	public Visit insert(Visit visita);
	
	public boolean update(Visit visita);
	
	public boolean delete(Visit visita);

}
