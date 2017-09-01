package com.team12.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "practise")

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username) {
		this.username = username;
	}

	/** full constructor */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 45)

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 45)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}