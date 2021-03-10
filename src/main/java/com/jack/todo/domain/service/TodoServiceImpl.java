package com.jack.todo.domain.service;

import java.util.Collection;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.todo.domain.TodoItem;
import com.jack.todo.domain.repository.TodoRepository;

/*
 * Implements the TodoService interface - abstracts interaction with the CRUD TodoRepository.
 * Makes any changes required to the data before it reaches TodoRepository
 */

@Service //Marks this class as a Bean for component scanning so it can be picked up for the application context
public class TodoServiceImpl implements TodoService{
	@Autowired
	TodoRepository todoRepository; //Inject the TodoRepository dependency
	
	public TodoItem findById(String id) {
		return todoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(id));
	}
	@Override
	public Collection<TodoItem> findAll() {
		return todoRepository.findAll();
	}
	
	@Override
	public TodoItem create(TodoItem todo) {
		String id = UUID.randomUUID().toString();
		todo.setId(id);
		todo.setComplete(false);
		
		todoRepository.save(todo);
		
		return todo;
	}

	@Override
	public TodoItem complete(String id) {
		TodoItem todo = findById(id);
		todo.setComplete(true);
		todoRepository.save(todo);
		return todo;

	}

	@Override
	public void delete(String id) {
		todoRepository.deleteById(id);
		
	}
	
}
