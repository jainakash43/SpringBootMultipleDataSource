package com.example.FacultyEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Faculty {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="faculty_Id")
	private int id;
	
	@Column(name="faculty_Name")
	private String name;
	
	@Column(name="City")
	private String city;
	
	
	
	
	
	public Faculty() {
		// TODO Auto-generated constructor stub
	}

	public Faculty(String name, String city)
	{
		this.name = name;
		this.city = city;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "faculty [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
		
	
}
