package com.umishra.TaskManager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "targetDate")
	private Date targetDate;
	
	@Column(name = "status")
	private boolean status;
	
	public Todo() {
	}
	
	
	public Todo(int id, String description, Date date, boolean status) {
		super();
		this.id = id;
		this.description = description;
		this.targetDate = date;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", targetDate=" + targetDate + ", status=" + status
				+ "]";
	}

	
}
