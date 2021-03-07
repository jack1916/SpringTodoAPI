package com.jack.todo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jack.todo.domain.TodoItem;
import com.jack.todo.domain.service.TodoService;

@RestController
public class TodoController {
	@Autowired
	TodoService todoService;
	
	@GetMapping("/todos")
	public Collection<TodoItem> getAll(){
		return todoService.findAll();
	}
	
	@PostMapping("/todos")
	public TodoItem createTodoItem(@RequestBody final TodoItem todo) {
		return todoService.create(todo);
	}
	
	
	@PatchMapping("/todos")
	public TodoItem update(@RequestBody final TodoItem todo){
		return todoService.complete(todo.getId());
	}
	
	@DeleteMapping("/todos")
	public void delete(@RequestBody final TodoItem todo) {
		todoService.delete(todo.getId());
	}
}
