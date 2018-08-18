package CCC;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Factura {

	
	@Id
	@Column(name="idFactura")
	@GeneratedValue
	private Integer idFactura;
	
	@ManyToOne
	@JoinColumn(name="idCliente", nullable=false)
	private Cliente cliente;
	
	
	@OneToMany(mappedBy="factura", cascade={CascadeType.ALL}, orphanRemoval=true)
	private List<LineaFactura> lineas = new ArrayList<LineaFactura>();


	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Factura(Integer idFactura, Cliente cliente, List<LineaFactura> lineas) {
		super();
		this.idFactura = idFactura;
		this.cliente = cliente;
		this.lineas = lineas;
	}


	public Integer getIdFactura() {
		return idFactura;
	}


	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<LineaFactura> getLineas() {
		return lineas;
	}


	public void setLineas(List<LineaFactura> lineas) {
		this.lineas = lineas;
	}
	
	
	
}
