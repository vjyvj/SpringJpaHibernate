package com.example.jpahibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	private long id;
	
	private String passport_number;

	@OneToOne(fetch=FetchType.EAGER,mappedBy="passport")
	private Student student;
	
	public Passport() {
		super();
	}

	public Passport(long id, String passport_number) {
		super();
		this.id = id;
		this.passport_number = passport_number;
	}

	public Passport(String passport_number) {
		super();
		this.passport_number = passport_number;
	}

	public long getId() {
		return id;
	}

	public String getPassport_number() {
		return passport_number;
	}

	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", passport_number=" + passport_number + "]";
	}
	
	
}
