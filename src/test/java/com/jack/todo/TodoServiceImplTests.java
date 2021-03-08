package com.jack.todo;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jack.todo.domain.TodoItem;
import com.jack.todo.domain.repository.TodoRepository;
import com.jack.todo.domain.service.TodoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TodoServiceImplTests {
	
	private static TodoItem MY_TODO = new TodoItem("a testing title");
	private static String id = UUID.randomUUID().toString();
	
	@Mock
	private TodoRepository mockRepository;
	
	@InjectMocks
	private TodoServiceImpl todoService;
	
	/*
	 * Should run findAll in mocked repository.
	 */
	@Test
	public void findAll_WillRun(){
		// When
		todoService.findAll();
		
		// Expect
		Mockito.verify(mockRepository).findAll();
	}
	/*
	 * Should return a TodoItem with an ID and run create method in mocked repository.
	 */
	@Test
	public void create_ReturnsTodoItem() {
		// When
		final TodoItem result = todoService.create(MY_TODO);
		
		// Expect
		assertEquals(result.getTitle(),MY_TODO.getTitle());
		assertNotNull(result.getId());
		assertEquals(result.isComplete(),false);
		Mockito.verify(mockRepository).create(any());
	}
	/*
	 * Should run the delete method in the mocked repository.
	 */
	@Test
	public void delete_WillRun() {
		// When
		todoService.delete(MY_TODO.getId());
		
		// Expect
		Mockito.verify(mockRepository).delete(any());
	}
	/* 
	 * Should return a TodoItem with complete set to true and update should be ran.
	 */
	@Test
	public void complete_ReturnsTodoItem() {
		// Given 
		when(mockRepository.findById(id)).thenReturn(MY_TODO);

		// When 
		final TodoItem result = todoService.complete(id);
		
		// Expect
		Mockito.verify(mockRepository).update(any());
		assertEquals(result.isComplete(), true);
	}
}


