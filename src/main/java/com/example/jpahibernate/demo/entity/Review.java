package com.example.jpahibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Review {

	@Id
	private long id;
	
	private int rating;
	
	private String description;

	
	public Review() {
		super();
	}

	public Review(long id, int rating, String description) {
		super();
		this.id = id;
		this.rating = rating;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + "]";
	}
	
}
