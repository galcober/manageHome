package com.manage.home.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="payroll")
public class Payroll {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Type(type = "text")
	private String pdf;
	private int month;
	private int year;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public Payroll(int id, String pdf, int month, int year) {
		super();
		this.id = id;
		this.pdf = pdf;
		this.month = month;
		this.year = year;
	}

	public Payroll() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Payroll [id=" + id + ", pdf=" + pdf + ", month=" + month + ", year=" + year + "]";
	}

}
