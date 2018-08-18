package com.comercial.data;

import java.util.List;

import com.comercial.model.Visit;

public interface VisitDao {


	public List<Visit> getVisits(Visit visita);
	

	public void removeProperties(Visit visita);
}
