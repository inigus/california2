package com.comercial.model;
   
   
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
   
  @Entity
  @Table(name = "clientes")
  public class Customer {
        
        @Id
        @Column(name="idCliente", nullable=false, unique=true)
        private Integer idCliente;
        
        @Column(name="nombre", nullable=false, unique=false)
        private String nombre;
        
        @Column(name="apellidos", nullable=true, unique=false)
        private String apellidos;
        
        @Column(name="poblacion", nullable=true, unique=false)
        private String  poblacion;
        
        @Column(name="telefono", nullable=true, unique=false)
        private String telefono;
        
        @Column(name="mail", nullable=true, unique=false)
        private String mail;
        
        @Column(name="descripcion", nullable=true, unique=false)
        private String descripcion;
        
        @Column(name="esPrescriptor", nullable=true, unique=false)
        private String esPrescriptor;
        
        @Column(name="fechaAlta", nullable=true, unique=false)
        private Date fechaAlta;
   
        
        public Customer() {        }
        
        public Customer(Integer id) {
        	this.idCliente = id;
        }
        
		public Integer getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(Integer idCliente) {
			this.idCliente = idCliente;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public String getPoblacion() {
			return poblacion;
		}

		public void setPoblacion(String poblacion) {
			this.poblacion = poblacion;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getEsPrescriptor() {
			return esPrescriptor;
		}

		public void setEsPrescriptor(String esPrescriptor) {
			this.esPrescriptor = esPrescriptor;
		}

		public Date getFechaAlta() {
			return fechaAlta;
		}

		public void setFechaAlta(Date fechaAlta) {
			this.fechaAlta = fechaAlta;
		}
		
		
		public boolean getEsPrescriptorBoolean() {
			if (this.getEsPrescriptor()!=null && this.getEsPrescriptor().equalsIgnoreCase("1")) {
				return true;
			} else {
				return false;
			}
		}
		public void setEsPrescriptorBoolean(boolean es) {
			this.esPrescriptor = "0";
			if (es) {
				this.esPrescriptor = "1";
			}
		}
		
		public String getNombreCompleto() {
			
			return this.nombre + " " + this.apellidos;
		}
		
		public String getNombrePoblacion() {
			return this.nombre + ", " + this.getPoblacion();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
			result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
			result = prime * result + ((esPrescriptor == null) ? 0 : esPrescriptor.hashCode());
			result = prime * result + idCliente;
			result = prime * result + ((mail == null) ? 0 : mail.hashCode());
			result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
			result = prime * result + ((poblacion == null) ? 0 : poblacion.hashCode());
			result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
			Customer other = (Customer) obj;
			if (apellidos == null) {
				if (other.apellidos != null)
					return false;
			} else if (!apellidos.equals(other.apellidos))
				return false;
			if (descripcion == null) {
				if (other.descripcion != null)
					return false;
			} else if (!descripcion.equals(other.descripcion))
				return false;
			if (esPrescriptor == null) {
				if (other.esPrescriptor != null)
					return false;
			} else if (!esPrescriptor.equals(other.esPrescriptor))
				return false;
			if (idCliente != other.idCliente)
				return false;
			if (mail == null) {
				if (other.mail != null)
					return false;
			} else if (!mail.equals(other.mail))
				return false;
			if (nombre == null) {
				if (other.nombre != null)
					return false;
			} else if (!nombre.equals(other.nombre))
				return false;
			if (poblacion == null) {
				if (other.poblacion != null)
					return false;
			} else if (!poblacion.equals(other.poblacion))
				return false;
			if (telefono == null) {
				if (other.telefono != null)
					return false;
			} else if (!telefono.equals(other.telefono))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Customer [idCliente=" + idCliente + ", nombre=" + nombre + ", apellidos=" + apellidos
					+ ", poblacion=" + poblacion + ", telefono=" + telefono + ", mail=" + mail + ", descripcion="
					+ descripcion + ", esPrescriptor=" + esPrescriptor + ", fechaAlta=" + fechaAlta + "]";
		}

		
        
   }
