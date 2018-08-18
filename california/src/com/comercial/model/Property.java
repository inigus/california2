package com.comercial.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "propiedades")
public class Property {

	@Id
	@Column(name="idPropiedad", nullable=false, unique=true)
	private int idPropiedad;
	
	
	@Column(name="propiedad", nullable=false)
	private String propiedad;
	
	
	@Column(name="entidad", nullable=false)
	private String entidad;
	
	
	@OneToMany(mappedBy="propiedad")
	private List<VisitProperty> propiedadesVisita = new ArrayList<VisitProperty>();


	public Property() {
		
	}
	
	public Property(int idPropiedad, String propiedad, String entidad) {
		this.idPropiedad = idPropiedad;
		this.propiedad = propiedad;
		this.entidad = entidad;
	}
	
	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public String getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	

	public List<VisitProperty> getPropiedadesVisita() {
		return propiedadesVisita;
	}

	public void setPropiedadesVisita(List<VisitProperty> propiedadesVisita) {
		this.propiedadesVisita = propiedadesVisita;
	}

	
	public static Property getPropertyByName(List<Property> lista, String name) {
		Property p = null;
		for (Property property : lista) {
			if (property.getPropiedad().equalsIgnoreCase(name)) {
				p = property;
				break;
			}
		}
		return p;
	}
	
	
	@Override
	public String toString() {
		return "Property [idPropiedad=" + idPropiedad + ", propiedad=" + propiedad + ", entidad=" + entidad + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entidad == null) ? 0 : entidad.hashCode());
		result = prime * result + idPropiedad;
		result = prime * result + ((propiedad == null) ? 0 : propiedad.hashCode());
		result = prime * result + ((propiedadesVisita == null) ? 0 : propiedadesVisita.hashCode());
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
		Property other = (Property) obj;
		if (entidad == null) {
			if (other.entidad != null)
				return false;
		} else if (!entidad.equals(other.entidad))
			return false;
		if (idPropiedad != other.idPropiedad)
			return false;
		return true;
	}


	
	
	
	
	
	
}
