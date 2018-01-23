package com.goliat.gym.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {

	@Id @GeneratedValue
	@Column(name = "id_client")
	private int cId;
	
	@Column(name = "c_name")
	private String cName;
	
	@Column(name = "c_last_name")
	private String cLastName;
	
	@Column(name = "c_second_last_name")
	private String cSecondLastName;
	
	@Column(name = "c_age")
	private int cAge;
	
	@Column(name = "c_weight")
	private float cWeight;

	@Column(name = "c_goal")
	private String cGoal;
	
	@Column(name = "c_starting_date")
	private Date cStartingDate;
	
	public Client() {
	//	this.cStartingDate = new Date(new java.util.Date());
	}
	
	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcLastName() {
		return cLastName;
	}

	public void setcLastName(String cLastName) {
		this.cLastName = cLastName;
	}

	public String getcSecondLastName() {
		return cSecondLastName;
	}

	public void setcSecondLastName(String cSecondLastName) {
		this.cSecondLastName = cSecondLastName;
	}

	public int getcAge() {
		return cAge;
	}

	public void setcAge(int cAge) {
		this.cAge = cAge;
	}

	public float getcWeight() {
		return cWeight;
	}

	public void setcWeight(float cWeight) {
		this.cWeight = cWeight;
	}

	public String getcGoal() {
		return cGoal;
	}

	public void setcGoal(String cGoal) {
		this.cGoal = cGoal;
	}

	public Date getcStartingDate() {
		return cStartingDate;
	}

	public void setcStartingDate(Date cStartingDate) {
		this.cStartingDate = cStartingDate;
	}
	
	
	// TODO : Complete
	/*suffering longtext,
    email varchar(255),    
    phone_number int(20),    
    start_training date not null,
    */ 
	
	
}
