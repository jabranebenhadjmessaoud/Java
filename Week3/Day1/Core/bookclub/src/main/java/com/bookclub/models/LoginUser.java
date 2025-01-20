package com.bookclub.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginUser {
	//email
		@Email
		@NotNull
		private String email;
		
		//password
		@Size(min=4,message="Wrong Password")
		private String password;
		
		//empty constructor
		public LoginUser() {}

		//Getters & Setters
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
}
