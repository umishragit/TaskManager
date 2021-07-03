package com.umishra.TaskManager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quotes")
public class Quotes {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "quotes")
	private String Quotes;
	
	Quotes(){
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuotes() {
		return Quotes;
	}

	public void setQuotes(String quotes) {
		Quotes = quotes;
	}

	@Override
	public String toString() {
		return "Quotes [id=" + id + ", Quotes=" + Quotes + "]";
	}

	
}
