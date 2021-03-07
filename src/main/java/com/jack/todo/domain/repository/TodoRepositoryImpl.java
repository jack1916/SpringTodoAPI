package com.jack.todo.domain.repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.jack.todo.domain.TodoItem;

@Repository
public class TodoRepositoryImpl implements TodoRepository{
	public static final Map<String, TodoItem> TODO_MAP = new ConcurrentHashMap<String, TodoItem>();
	
	@Override
	public TodoItem findById(String id) {
		return TODO_MAP.get(id);
	}
	
	@Override
	public Collection<TodoItem> findAll(){
		return TODO_MAP.values();
	}
	
	@Override
	public boolean update(TodoItem todo) {
		TODO_MAP.put(todo.getId(), todo);
		return true;
	}
	
	@Override
	public void delete(TodoItem todo) {
		TODO_MAP.remove(todo.getId());
	}

	@Override
	public void create(TodoItem todo) {
		TODO_MAP.put(todo.getId(), todo);
	}

	@Override
	public long countByCompleted(boolean completed) {
		long count = 0;
		for(TodoItem todo : TODO_MAP.values()) {
			if(completed == todo.isComplete()) {
				count++;
			}
		}
		return count;
	}
}
