package com.jack.todo.domain.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jack.todo.domain.TodoItem;

public interface TodoRepository extends CrudRepository<TodoItem, String> {
	
	Optional<TodoItem> findById(String id);
	
	Collection<TodoItem> findAll();
		
	<S extends TodoItem> S save(TodoItem todo);
	
	void delete(TodoItem todo);
		
}
