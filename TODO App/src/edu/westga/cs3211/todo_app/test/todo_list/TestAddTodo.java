package edu.westga.cs3211.todo_app.test.todo_list;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3211.todo_app.model.Todo;
import edu.westga.cs3211.todo_app.model.TodoList;
import edu.westga.cs3211.todo_app.model.Priority;

public class TestAddTodo {
	
	@Test
	public void testWhenAddOne() {
		Todo testTodo = new Todo(Priority.LOW , "Do something");
		TodoList TodoList = new TodoList();
		
		TodoList.addTodo(testTodo);
		
		assertEquals(1, TodoList.size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWhenAddNull() {
		TodoList TodoList = new TodoList();
		
		TodoList.addTodo(null);
		
		assertEquals(1, TodoList.size());
	}
	
	@Test
	public void testWhenAddThree() {
		Todo testTodo1 = new Todo(Priority.LOW , "Do something.");
		Todo testTodo2 = new Todo(Priority.LOW , "Do something else.");
		Todo testTodo3 = new Todo(Priority.LOW , "Do some more.");

		TodoList TodoList = new TodoList();
		
		TodoList.addTodo(testTodo1);
		TodoList.addTodo(testTodo2);
		TodoList.addTodo(testTodo3);

		
		assertEquals(3, TodoList.size());
	}
	
	

}
