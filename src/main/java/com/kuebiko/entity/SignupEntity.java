package com.kuebiko.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity ///this class object will be saved into database
@Table(name="bsignup_tbl")
public class SignupEntity {
	private int sid;
	private String username;
	private String password;
	private String email;
	private String name;
	private String salutation;
	private Timestamp datecreated;
	private String role;
	private byte[] bphoto;
	
	
    @Column(columnDefinition="longblob")
	public byte[] getBphoto() {
		return bphoto;
	}

	public void setBphoto(byte[] bphoto) {
		this.bphoto = bphoto;
	}

	 @Column(columnDefinition = "varchar(30) default 'customer'")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	
	@Column(length=100)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(length=40)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length=200)
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

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Timestamp getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}

	@Override
	public String toString() {
		return "SignupEntity [sid=" + sid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", name=" + name + ", salutation=" + salutation + ", datecreated=" + datecreated + "]";
	}

}
