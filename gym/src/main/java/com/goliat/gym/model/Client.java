package com.goliat.gym.model;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private int cId;	
	private String cName;
	private String cLastName;
	private String cSecondLastName;
	private int cAge;
	private float cWeight;
	private String cGoal;
	private String cStartingDate;
	private String cRoutine;
	private String cNextPaymentDate;
	private int cPaidMonths;
	private Payment payment;
	private List<Payment> payments;
	
	public Client() {
		this.payment = new Payment();
		this.payments = new ArrayList<Payment>();
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

	public String getcStartingDate() {
		return cStartingDate;
	}

	public void setcStartingDate(String cStartingDate) {
		this.cStartingDate = cStartingDate;
	}

	public String getcRoutine() {
		return cRoutine;
	}

	public void setcRoutine(String cRoutine) {
		this.cRoutine = cRoutine;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public String getcNextPaymentDate() {
		return cNextPaymentDate;
	}

	public void setcNextPaymentDate(String cNextPaymentDate) {
		this.cNextPaymentDate = cNextPaymentDate;
	}

	public int getcPaidMonths() {
		return cPaidMonths;
	}

	public void setcPaidMonths(int cPaidMonths) {
		this.cPaidMonths = cPaidMonths;
	}
	
	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "Client [cId=" + cId + ", cName=" + cName + ", cLastName=" + cLastName + ", cSecondLastName="
				+ cSecondLastName + ", cAge=" + cAge + ", cWeight=" + cWeight + ", cGoal=" + cGoal + ", cStartingDate="
				+ cStartingDate + ", cRoutine=" + cRoutine + ", cNextPaymentDate=" + cNextPaymentDate + ", cPaidMonths="
				+ cPaidMonths + ", payment=" + payment + ", payments=" + payments + "]";
	}
	
}
