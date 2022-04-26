package com.example.PBGS.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "c_name")
	private String name;
	
	@Column(name = "c_contact")
	private long contact;
	
	@Column(name = "c_address")
	private String address;
	
	@Column(name = "c_email")
	private String email;
	
	@Column(name = "c_password")
	private String password;

	
	public Customer() {
	}	
	
	public Customer(String name, long contact, String address, String email, String password) {
		super();
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.email = email;
		this.password = password;
	
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	

}
