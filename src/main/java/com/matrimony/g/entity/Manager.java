package com.matrimony.g.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sub_tbl")
public class Manager implements Serializable {

	
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -7223654670562814003L;
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private int subId;
	private int subMonth;
	private int subYear;
	private double amount;
	private String subType;
	
	public Manager() {
		
	}
	


	public Manager(int subId, int subMonth, int subYear, double amount, String subType) {
		super();
		this.subId = subId;
		this.subMonth = subMonth;
		this.subYear = subYear;
		this.amount = amount;
		this.subType = subType;
	}


	public int getSubId() {
		return subId;
	}


	public void setSubId(int subId) {
		this.subId = subId;
	}


	public int getSubMonth() {
		return subMonth;
	}

	public void setSubMonth(int subMonth) {
		this.subMonth = subMonth;
	}

	public int getSubYear() {
		return subYear;
	}

	public void setSubYear(int subYear) {
		this.subYear = subYear;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	@Override
	public String toString() {
		return "Manager [id=" + subId + ", subMonth=" + subMonth + ", subYear=" + subYear + ", amount=" + amount
				+ ", subType=" + subType + "]";
	}
	
	
	
}
