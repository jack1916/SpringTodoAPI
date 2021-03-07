package com.jack.todo.domain.service;

import java.util.Collection;

import com.jack.todo.domain.TodoItem;

public interface TodoService {
	Collection<TodoItem> findAll();
	
	TodoItem create(TodoItem todo);
	
	TodoItem complete(String id);
	
	void delete(String id);
}
