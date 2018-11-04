package com.comercial.service;

import java.util.List;

import com.comercial.data.PropertyDao;
import com.comercial.data.PropertyDaoImpl;
import com.comercial.data.VisitDao;
import com.comercial.data.VisitDaoImpl;
import com.comercial.model.Property;
import com.comercial.model.Visit;
import com.comercial.model.VisitProperty;

public class VisitServiceImpl  extends BaseService implements VisitService {

	
	
	private VisitDao visitDao = new VisitDaoImpl(this.em);
	
	
	@Override
	public List<Visit> getVisitsFiltered(Visit visita, String orderBy) {

		return visitDao.getVisits(visita, orderBy);
	}
	

	@Override
	public Visit get(Integer idVisita) {

		return (Visit) em.find( Visit.class, idVisita);
	}

	@Override
	public Visit insert(Visit visita) {

		try {
			this.initTransaction();
			
			em.persist(visita);
			
			this.finishTransaction();
		} catch (Throwable t) {
			this.finishTransaction(t);
			throw t;
		}
		return visita;
	}

	@Override
	public boolean update(Visit visita) {

		boolean resul = false;
		try {
			this.initTransaction();
			em.persist(visita);
			
//			visitDao.removeProperties(visita);
//			for (VisitProperty vProp : visita.getPropiedadesVisita()) {
//				em.persist(vProp);
//			}
			
			this.finishTransaction();
		} catch (Throwable t) {
			t.printStackTrace();
		    this.finishTransaction(t);
		    throw t;
		}
			
		return resul;
	}

	@Override
	public boolean delete(Visit visita) {

		return false;
	}


	
	


	
	
}
