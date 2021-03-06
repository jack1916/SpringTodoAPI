package com.jack.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
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
	public TodoItem createTodoItem(@RequestBody final TodoItem todo) {
		todos.put(counter.incrementAndGet(), todo);
		return todo;
	}
}
