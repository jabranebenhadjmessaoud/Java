package com.bookclub.models;

import java.util.Date;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	//Id
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		private Long id;
		
		//userName
		@NotNull(message="User Name can't be empty !!")
		@Size(min=3, message="User Name at least 3 characters, not blank")
		private String userName;
		
		//email
		@Email
		@NotNull(message="Email can't be empty")
		private String email;
		
		//password
		@Size(min=8,message="Password at least 8 characters, not blank")
		private String password;
		
		//confirm password
		@Transient
		@Size(min=8,message="Confirm Password at least 8 characters, not blank")
		private String confirm;
		
		@Column(updatable=false)
		private Date createdAt;
		
		private Date updatedAt;
		
			
		@PrePersist
		protected void onCreate() {
			this.createdAt=new Date();
			this.updatedAt=new Date();
		}
		
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt=new Date();
		}
		
		//One to many
	    @OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
	    List<Book> myBooks;
		
		//Empty Constructor
		public User() {}
		
		
		//Getters & Setters
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirm() {
			return confirm;
		}

		public void setConfirm(String confirm) {
			this.confirm = confirm;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}


}
