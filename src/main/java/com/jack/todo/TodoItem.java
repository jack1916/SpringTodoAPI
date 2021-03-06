package com.jack.todo;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TodoItem {
	// private final long id;
	private String title;
	private boolean complete;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dueDate;
	
	public TodoItem() {
		this.complete=false;
	}
	
	public TodoItem(long id, String title, LocalDate dueDate) {
		//this.id = id;
		this.complete = false;
		this.title = title;
		this.dueDate = dueDate;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isComplete() {
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
	/*public long getId() {
		return id;
	}*/
}
