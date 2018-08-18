package CCC;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class LineaFactura implements Serializable {

	private static final long serialVersionUID = -7345086493378306956L;

	@Id
	@ManyToOne
	@JoinColumn(name = "idFactura")
	private Factura factura;
	
	@Id
	@Column(name="numLinea")
	private Integer numLinea;
	
	@ManyToOne
	@JoinColumn(name="idProducto", nullable=false)
	private Producto producto;
	
	@Column(name="numProducto", nullable=false)
	private Integer numProducto;

	
	public LineaFactura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LineaFactura(Factura factura, Integer numLinea, Producto producto, Integer numProducto) {
		super();
		this.factura = factura;
		this.numLinea = numLinea;
		this.producto = producto;
		this.numProducto = numProducto;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Integer getNumLinea() {
		return numLinea;
	}

	public void setNumLinea(Integer numLinea) {
		this.numLinea = numLinea;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getNumProducto() {
		return numProducto;
	}

	public void setNumProducto(Integer numProducto) {
		this.numProducto = numProducto;
	}
	
	
	
}
