package com.jack.todo.domain;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 *  The model TodoItem class - POJO of a todo, used as an Entity for Hibernate
 */
@Entity // tell Hibernate to make a table from this model
public class TodoItem {
	private String title;
	private Boolean complete;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dueDate;
	@Id // tell Hibernate id will be used as the primary key
	private String id;
	
	public TodoItem() {
		this.complete=false;
	}
	
	public TodoItem(String title) {
		this.complete=false;
		this.title= title;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
}