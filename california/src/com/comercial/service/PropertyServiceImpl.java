package com.comercial.service;

import java.util.List;

import com.comercial.data.PropertyDao;
import com.comercial.data.PropertyDaoImpl;
import com.comercial.model.Property;


public class PropertyServiceImpl  extends BaseService implements PropertyService {

		
	private PropertyDao visitDao = new PropertyDaoImpl(this.em);
	
	
	
	@Override
	public List<Property> getPropertysFiltered(Property propiedad) {

		return visitDao.getProperties(propiedad);
	}
	

	@Override
	public Property get(Property propiedad) {

		return (Property) em.find( Property.class, propiedad.getIdPropiedad() );
	}

	@Override
	public Property insert(Property propiedad) {

		try {
			this.initTransaction();
			
			em.persist(propiedad);
			
			this.finishTransaction();
		} catch (Throwable t) {
			this.finishTransaction(t);
			throw t;
		}
		return propiedad;
	}

	@Override
	public boolean update(Property propiedad) {

		boolean resul = false;
		try {
			this.initTransaction();
			
			
			em.merge(propiedad);
			
			this.finishTransaction();
		} catch (Throwable t) {
		    this.finishTransaction(t);
		    throw t;
		}
		return resul;
	}

	@Override
	public boolean delete(Property propiedad) {

		return false;
	}


	
	


	
	
}
