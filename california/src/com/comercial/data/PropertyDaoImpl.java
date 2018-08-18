package com.comercial.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.comercial.model.Property;

public class PropertyDaoImpl extends BaseDao implements PropertyDao {

	public PropertyDaoImpl(EntityManager em) {
		super(em);
	}
	
	
	@Override
	public List<Property> getProperties(Property propiedad) {
		// TODO Auto-generated method stub
		try {
			List<Property> propiedades = (List<Property>) em
					.createQuery("SELECT p from Property p where p.entidad = :entidad")
					.setParameter("entidad", propiedad.getEntidad() )
					.getResultList();

			return propiedades;
		} catch (NoResultException e) {
			return null;
		}
	}





	
	
	
	


}
