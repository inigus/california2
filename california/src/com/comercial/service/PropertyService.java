package com.comercial.service;

import java.util.List;

import com.comercial.model.Property;

public interface PropertyService {
	
	
	public List<Property> getPropertysFiltered(Property propiedad);
	
	public Property get(Property propiedad);
	
	public Property insert(Property propiedad);
	
	public boolean update(Property propiedad);
	
	public boolean delete(Property propiedad);

}
