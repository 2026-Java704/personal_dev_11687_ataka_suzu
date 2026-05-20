package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String password;
	//	private Integer age;
	//	private Integer gender;
	//	private Integer weight;

	public Users() {
	}

	public Users(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public Integer getId() {
		return id;
	}
}

//	public Integer getAge() {
//		return age;
//	}
//
//	public Integer getGender() {
//		return gender;
//	}
//
//	public Integer getWeight() {
//		return weight;
//	}
//
//}
