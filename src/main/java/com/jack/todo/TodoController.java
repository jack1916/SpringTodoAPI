package com.jack.todo;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	Map<Long, TodoItem> todos ;
	private final AtomicLong counter;
	
	public TodoController() {
		todos = new HashMap<Long, TodoItem>();
		counter = new AtomicLong();
	}
	
	@GetMapping("/todos")
	public List<TodoItem> getAll(){
		return new ArrayList<TodoItem>(todos.values());
	}
	
	@PostMapping("/todos")
	public TodoItem createTodoItem(@RequestBody final TodoItem todo, HttpServletRequest request) {
		todo.setUrl(URI.create(request.getRequestURL() + "/" + counter.get()));
		todos.put(counter.getAndIncrement(), todo);
		return todo;
	}
	
	@GetMapping("/todos/{id}")
	public TodoItem getTodoItemById(@PathVariable long id){
		return todos.get(id);
	}
	
	@PatchMapping("/todos/{id}")
	public TodoItem update(@RequestBody final TodoItem todo, @PathVariable long id){
		return todos.get(id).patchWith(todo);
	}
	
	
}
