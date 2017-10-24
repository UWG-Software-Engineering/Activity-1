package edu.westga.cs3211.todo_app.test.todo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.Todo;

public class Test2ParamConstructor {
	
	private Todo goodTodo;
	
	@Before
	public void setUp() throws Exception {
		goodTodo = new Todo(Priority.HIGH, "FirstOne");
	}

	@Test
	public void testSunnyDay() {
		assertEquals("FirstOne", goodTodo.get);
	}

}
