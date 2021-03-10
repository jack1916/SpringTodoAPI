package com.jack.todo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jack.todo.domain.TodoItem;
import com.jack.todo.domain.service.TodoService;
/*
 * The rest controller, responsible for handling incoming REST requests, prepares the TodoItem model and responses
 */
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
	
	
	@PatchMapping("/todos/{id}")
	public TodoItem update(@PathVariable final String id){
		return todoService.complete(id);
	}
	
	@DeleteMapping("/todos/{id}")
	public void delete(@PathVariable final String id) {
		todoService.delete(id);
	}
}
