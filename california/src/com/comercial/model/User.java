package com.comercial.model;
   
  import java.util.Date;
   
  import javax.persistence.Column;
  import javax.persistence.Entity;
  import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
  import javax.persistence.TemporalType;
   
  @Entity
  @Table(name = "users")
  public class User {
        
        @Id
        @Column(name="id", nullable=false, unique=true)
        private int id;
        
        @Column(name="name", nullable=false, unique=false)
        private String name;
        
        @Column(name="mail", nullable=false, unique=false)
        private String mail;
        
        @Column(name="password", nullable=false, unique=false)
        private String password;
   
        @Column(name="lastAccess",nullable=false, unique=false)
        @Temporal(TemporalType.DATE)
        private Date lastAccess;
        
        
        public String getName() {
              return name;
        }
        
        public void setName(String name) {
              this.name = name;
        }
        
        public String getPassword() {
              return password;
        }
        
        public void setPassword(String password) {
              this.password = password;
        }
        
        public Date getLastAccess() {
              return lastAccess;
        }
        
        public void setLastAccess(Date lastAccess) {
              this.lastAccess = lastAccess;
        }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}		

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", nameUser=" + name + "]";
		}
		
		
		
        
        
   }
