package com.comercial.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.comercial.utils.K;

@Entity
@Table(name = "visitas")
public class Visit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idVisita", nullable=false, unique=true)
	private Integer idVisita;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idCliente", nullable = false, unique=false )
	private Customer cliente;
	
	@Column(name="descripcion", nullable=true, unique=false)
	private String descripcion;
	
	@Column(name="fecha", nullable=true, unique=false)
	private Date fecha;
	
	@Transient
	private Date fechaDesde;
	
	@Transient
	private Date fechaHasta;
	
	@Column(name="fechaProxima", nullable=true, unique=false)
	private Date fechaProxima;
	
	@Transient
	private Date fechaProximaDesde;
	
	@Transient
	private Date fechaProximaHasta;
	
	@Column(name="compra", nullable=true, unique=false)
	private String compra;
	
	
	@OneToMany(mappedBy="visita", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<VisitProperty> propiedadesVisita = new ArrayList<VisitProperty>();

	
	public void addVisitProperty(Property prop, String value) {
		int maxOrden = 1;
		for (VisitProperty vProp : propiedadesVisita) {
			if ( vProp.getPropiedad().getIdPropiedad()==prop.getIdPropiedad() ) {
				maxOrden++;
			}
		}
		propiedadesVisita.add(new VisitProperty(this, prop, value, maxOrden));
	}
	
	
	public Integer getIdVisita() {
		return idVisita;
	}


	public void setIdVisita(Integer idVisita) {
		this.idVisita = idVisita;
	}


	public Customer getCliente() {
		return cliente;
	}


	public void setCliente(Customer cliente) {
		this.cliente = cliente;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFecha() {
		return fecha;
	}
	
	public String getFechaFormateada() {
		return K.dateFormat1.format(this.fecha);
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Date getFechaProxima() {
		return fechaProxima;
	}
	
	public String getFechaProximaFormateada() {
		return K.dateFormat1.format(this.fechaProxima);
	}


	public void setFechaProxima(Date fechaProxima) {
		this.fechaProxima = fechaProxima;
	}


	public String getCompra() {
		return compra;
	}


	public void setCompra(String compra) {
		this.compra = compra;
	}
	
	public boolean getEsCompraBoolean() {
		if (this.getCompra()!=null && this.getCompra().equalsIgnoreCase("1")) {
			return true;
		} else {
			return false;
		}
	}
	public void setEsCompraBoolean(boolean es) {
		this.compra = "0";
		if (es) {
			this.compra = "1";
		}
	}


	public List<VisitProperty> getPropiedadesVisita() {
		return propiedadesVisita;
	}


	public void setPorpiedadesVisita(List<VisitProperty> propiedadesVisita) {
		this.propiedadesVisita = propiedadesVisita;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}


	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	public Date getFechaHasta() {
		return fechaHasta;
	}


	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	public Date getFechaProximaDesde() {
		return fechaProximaDesde;
	}


	public void setFechaProximaDesde(Date fechaProximaDesde) {
		this.fechaProximaDesde = fechaProximaDesde;
	}


	public Date getFechaProximaHasta() {
		return fechaProximaHasta;
	}


	public void setFechaProximaHasta(Date fechaProximaHasta) {
		this.fechaProximaHasta = fechaProximaHasta;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((compra == null) ? 0 : compra.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((fechaProxima == null) ? 0 : fechaProxima.hashCode());
		result = prime * result + idVisita;
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
		Visit other = (Visit) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (compra == null) {
			if (other.compra != null)
				return false;
		} else if (!compra.equals(other.compra))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (fechaProxima == null) {
			if (other.fechaProxima != null)
				return false;
		} else if (!fechaProxima.equals(other.fechaProxima))
			return false;
		if (idVisita != other.idVisita)
			return false;
		if (propiedadesVisita == null) {
			if (other.propiedadesVisita != null)
				return false;
		} else if (!propiedadesVisita.equals(other.propiedadesVisita))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Visit [idVisita=" + idVisita + ", cliente=" + cliente + ", descripcion=" + descripcion + ", fecha="
				+ fecha + ", fechaProxima=" + fechaProxima + ", compra=" + compra + ", propiedadesVisita=???]";
	}


	
	
	
}
