package com.comercial.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.comercial.model.Customer;
import com.comercial.model.Visit;

public class VisitDaoImpl extends BaseDao implements VisitDao {

	public VisitDaoImpl(EntityManager em) {
		super(em);
	}
	
	
	@Override
	public List<Visit> getVisits(Visit visita) {
		// TODO Auto-generated method stub
		try {
			
			String sql = "select v from Visit v where 1=1 ";

			Map<String,Object> mParams = new HashMap<String, Object>();
			if ( visita.getFechaDesde()!=null ) {
				sql += " and v.fecha >= :fechaDesde ";
				mParams.put("fechaDesde", visita.getFechaDesde());
			}
			if ( visita.getFechaHasta()!=null ) {
				sql += " and v.fecha <= :fechaHasta ";
				mParams.put("fechaHasta", visita.getFechaHasta());
			} 
			
			Query query = em.createQuery(sql);
			for (String param : mParams.keySet() ) {
				query.setParameter(param, mParams.get(param));
			}
			
			List<Visit> visitas = (List<Visit>) query.getResultList();
			

			return visitas;
		} catch (NoResultException e) {
			return null;
		}
	}

	

	@Override
	public void removeProperties(Visit visita) {
		
		  int num = em.createQuery("DELETE FROM VisitProperty vp WHERE vp.visita = :visita" )
				  			.setParameter("visita", visita)
				  			.executeUpdate();
	}
	
	
	
	


}
