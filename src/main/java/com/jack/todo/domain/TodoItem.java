package com.jack.todo.domain;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TodoItem {
	private String title;
	private Boolean complete;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dueDate;
	private String id;
	
	public TodoItem() {
		this.complete=false;
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