package com.springboot.tutorial.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name="employee")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private int id;
	
	@Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "joiningDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;
	
	@Column(name = "birthDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	
	@Column(name = "salary")
	private float salary;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
		
		
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}


