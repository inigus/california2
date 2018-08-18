package CCC;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Producto {

	@Id
	@Column(name="idProducto")
	@GeneratedValue
	private Integer idProducto;
	
	@Column(name="nombreCliente")
	private String nombreCliente;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(Integer idProducto, String nombreCliente) {
		super();
		this.idProducto = idProducto;
		this.nombreCliente = nombreCliente;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	
	
}
