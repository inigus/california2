package com.comercial.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;

@Entity
@Table(name = "visitas_propiedades")
public class VisitProperty implements Serializable {


	private static final long serialVersionUID = -3847933150212471547L;


	@Id
	@ManyToOne
	@JoinColumn(name = "idVisita")
	private Visit visita;

	
	@Id
	@ManyToOne
	@JoinColumn(name = "idPropiedad")
	private Property propiedad;
	
	
	@Id
	@Column(name="orden")
	private int orden;

	
	@Column(name="valor")
	private String valor;
	
	@Transient
	private boolean selected = false;
	
	
	public VisitProperty() {
		// TODO Auto-generated constructor stub
	}
	
	public VisitProperty(Visit visita, Property propiedad, String valor, int orden ) {
		this.visita = visita;
		this.propiedad = propiedad;
		this.orden = orden;
		this.valor = valor;
	}
	

	public String getConcatID() {
		
		return this.propiedad.getIdPropiedad() + "_" + orden;
		
	}

	public Visit getVisita() {
		return visita;
	}

	public void setVisita(Visit visita) {
		this.visita = visita;
	}

	public Property getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Property propiedad) {
		this.propiedad = propiedad;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}


	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	private static final String sep = "#@#@";
	public static String toConvertString(VisitProperty obj) {
		
		return obj.valor + sep + obj.orden + sep + obj.selected + sep + 
				obj.propiedad.getIdPropiedad() + sep + obj.propiedad.getPropiedad() + sep + obj.propiedad.getEntidad();
		
	}
	
	public static VisitProperty fromConvertString(String val) {
		VisitProperty vp = new VisitProperty();
		
		String[] aVal = val.split(sep);
		vp.setValor(aVal[0]);
		vp.setOrden(Integer.parseInt(aVal[1]));
		vp.setSelected(Boolean.getBoolean(aVal[2]));
		vp.setPropiedad(new Property(Integer.parseInt(aVal[3]),aVal[4],aVal[5]));
		
		return vp;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orden;
		result = prime * result + ((propiedad == null) ? 0 : propiedad.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		result = prime * result + ((visita == null) ? 0 : visita.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VisitProperty other = (VisitProperty) obj;
		if (orden != other.orden)
			return false;
		if (propiedad == null) {
			if (other.propiedad != null)
				return false;
		} else if (!propiedad.equals(other.propiedad))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (visita == null) {
			if (other.visita != null)
				return false;
		} else if (!visita.equals(other.visita))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VisitProperty [visita=" + visita + ", propiedad=" + propiedad + ", orden=" + orden + ", valor=" + valor
				+ "]";
	}

	
	
}
