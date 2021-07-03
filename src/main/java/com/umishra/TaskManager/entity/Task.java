package com.umishra.TaskManager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@Column(name = "taskid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskid;
	
	
	@Column(name = "task_name")
	private String task_name;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "month")
	private String month;
	
	@Column(name = "day")
	private int day;
	
	@Column(name = "comments")
	private String comments;
	
	
	public Task() {
	}


	public Task(String task_name, int year, String month, int day) {
		super();
		this.task_name = task_name;
		this.year = year;
		this.month = month;
		this.day = day;
	}


	public int getTaskid() {
		return taskid;
	}


	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}


	public String getTask_name() {
		return task_name;
	}


	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		this.day = day;
	}
	
	


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Task [task_name=" + task_name + ", year=" + year + ", month=" + month + ", day=" + day + ", comments="
				+ comments + "]";
	}	
	
	
}
