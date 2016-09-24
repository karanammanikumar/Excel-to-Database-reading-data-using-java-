package com.mani.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exceldatareading", schema="anno")
public class Student {
	@Id
	private double id;
	@Column
	private String name;
	@Column
	private String address;
	public Student() {
	}
	public Student(double id2, String name, String address) {
		super();
		this.id = (int) id2;
		this.name = name;
		this.address = address;
	}
	public double getId() {
		return id;
	}
	public void setId(double id2) {
		this.id = id2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String toString(){
		return name + " " + address;
	}


}
