package com.jack.todo;
import java.net.URI;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TodoItem {
	private String title;
	private Boolean complete;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dueDate;
	private URI url;
	
	public TodoItem() {
		this.complete=false;
	}
	
	public TodoItem(long id, String title, LocalDate dueDate) {
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
	public void setUrl(URI url) {
		this.url = url;
	}
	public URI getUrl() {
		return url;
	}
	public TodoItem patchWith(TodoItem todo) {
		if(todo.getTitle() != null) {
			this.title = todo.getTitle();
		}
		if(todo.isComplete() != null) {
			this.complete = todo.isComplete();
		}
		if(todo.getDueDate() != null) {
			this.dueDate = todo.getDueDate();
		}
		return this;
	}
}