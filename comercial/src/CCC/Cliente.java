package CCC;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

	
	
	@Id
	@Column(name="idCliente")
	@GeneratedValue
	private Integer idCliente;
	
	@Column(name="nombreCliente")
	private String nombreCliente;


	public Cliente() {
		
	}


	public Cliente(Integer idCliente, String nombreCliente) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	
	
	
}
