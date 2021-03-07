package com.jack.todo.domain.repository;

import java.util.Collection;

import com.jack.todo.domain.TodoItem;

public interface TodoRepository {
	TodoItem findById(String id);
	
	Collection<TodoItem> findAll();
	
	void create(TodoItem todo);
	
	boolean update(TodoItem todo);
	
	void delete(TodoItem todo);
	
	long countByCompleted(boolean completed);
	
}
