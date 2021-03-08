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

	@Test
	// findAll in the repository should run when findAll is ran by TodoService
	public void TodoServiceFindAll_WillRunTest(){
		// When findAll is ran
		todoService.findAll();
		
		// Expect findAll to be ran in the repository
		Mockito.verify(mockRepository).findAll();
	}
	
	@Test
	// create should return a todo with an ID and run create method in mocked repository
	public void TodoServiceCreate_ReturnsTodoTest() {
		// When create is ran
		final TodoItem result = todoService.create(MY_TODO);
		
		// Expect return of same object
		assertEquals(result.getTitle(),MY_TODO.getTitle());
		// Expect returned object to have a UUID
		assertNotNull(result.getId());
		// Expect create to have ran in mocked repository
		Mockito.verify(mockRepository).create(any());
	}
	
	@Test
	// delete should run the delete method in the mocked repository
	public void TodoServiceDelete_WillRunTest() {
		// When delete is ran
		todoService.delete(MY_TODO.getId());
		
		// Expect delete method to be ran in repository
		Mockito.verify(mockRepository).delete(any());
	}
	@Test
	// complete should return a TodoItem with complete set to true and update should be ran
	public void TodoServiceComplete_ReturnsTodoTest() {
		// when 
		when(mockRepository.findById(id)).thenReturn(MY_TODO);
		final TodoItem result = todoService.complete(id);
		
		// Expect update method to be ran in repository
		Mockito.verify(mockRepository).update(any());
		// Expect complete to be true
		assertEquals(result.isComplete(), true);
	}
}


