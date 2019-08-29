package com.niit.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="User")
public class User implements Serializable{
	@Id
	@NotBlank(message="Must not be blank")
	@Email(message="Must be a well-formed email address")
	private String email;
		
	@Size(min=6, max=12, message="Username must be between 8 to 12 characters")
	private String name;
	
	@NotBlank(message="Must not be blank")
	@Size(min=6, max=12, message="Password must be between 8 to 12 characters")

	private String	password;
	@NotBlank(message="Must not be blank")
	@Size(min=1, max=200, message="Address must be between 1 to 200 characters")

	private String	address;
	
	@NotBlank(message="Must not be blank")
	@Pattern(regexp="([0-9]{10})", message="Please enter a 10 digit number")
	private String phone;
	private String role;
	private boolean enabled;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
}
