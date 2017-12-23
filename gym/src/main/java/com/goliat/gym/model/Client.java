package com.goliat.gym.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GymClient")
public class Client {

	@Id @GeneratedValue
	@Column(name = "id_client")
	
	private int id;
	
	@Column(name = "client_name")
	private String name;
	
	@Column(name = "f_last_name")
	private String f_last_name;
	
	@Column(name = "m_last_name")
	private String m_last_name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "weight")
	private float weight;

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

	public String getF_last_name() {
		return f_last_name;
	}

	public void setF_last_name(String f_last_name) {
		this.f_last_name = f_last_name;
	}

	public String getM_last_name() {
		return m_last_name;
	}

	public void setM_last_name(String m_last_name) {
		this.m_last_name = m_last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	// TODO : Complete
	/*suffering longtext,
    email varchar(255),    
    phone_number int(20),    
    start_training date not null,
    */ 
	
	
}
