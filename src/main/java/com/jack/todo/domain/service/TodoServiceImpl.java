package com.jack.todo.domain.service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.todo.domain.TodoItem;
import com.jack.todo.domain.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{
	@Autowired
	TodoRepository todoRepository;
	
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
