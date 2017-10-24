package edu.westga.cs3211.todo_app.test.todo_list;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.Todo;
import edu.westga.cs3211.todo_app.model.TodoList;

public class TestRemoveTodo {

	@Test
	public void testRemoveTodoWhenNoneExist() {
		TodoList testList = new TodoList();
		testList.removeTodo(new Todo(Priority.MEDIUM, "Something").getId());
		assertEquals(0, testList.size());
	}
	
	@Test
	public void testRemoveTodoWhenOneExists() {
		TodoList testList = new TodoList();
		Todo testTodo = new Todo(Priority.HIGH, "Go away");
		testList.addTodo(testTodo);
		
		assertEquals(1, testList.size());
		testList.removeTodo(testTodo.getId());
		assertEquals(0, testList.size());
	}

}
