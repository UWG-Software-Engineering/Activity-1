package edu.westga.cs3211.todo_app.test.todo_list;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.Todo;
import edu.westga.cs3211.todo_app.model.TodoList;

public class TestGetTodo {

	/**
	 * Test getTodos method for proper functionality
	 */
	@Test
	public void testGetPriorityWith2ParamConstructor() {
		Todo doto = new Todo(Priority.HIGH, "Work");
		TodoList dotoList = new TodoList();
	    dotoList.addTodo(doto);
	    UUID id = doto.getId();
		assertEquals(doto, dotoList.getTodo(id));
	}

	/**
	 * Test getTodos for proper functionality
	 */
	@Test
	public void testGetPriorityWith2ParamConstructor2TODOS() {
		Todo doto = new Todo(Priority.HIGH, "Work");
		Todo doto2 = new Todo(Priority.MEDIUM, "Water");
		TodoList dotoList = new TodoList();
		UUID id = doto2.getId();
		dotoList.addTodo(doto);
		dotoList.addTodo(doto2);
		assertEquals(doto2, dotoList.getTodo(id));
	}

}
