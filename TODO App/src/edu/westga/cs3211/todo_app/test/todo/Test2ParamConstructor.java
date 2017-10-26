package edu.westga.cs3211.todo_app.test.todo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.Todo;

public class Test2ParamConstructor {
	
	@Rule public ExpectedException exception = ExpectedException.none();

	@Test
	public void testNullPriority() {
		exception.expect(IllegalArgumentException.class);
		new Todo(null, "description");
	}

	@Test
	public void testNullDescription() {
		exception.expect(IllegalArgumentException.class);
		new Todo(Priority.HIGH, null);
	}

	@Test
	public void testEmptyDescription() {
		exception.expect(IllegalArgumentException.class);
		new Todo(Priority.HIGH, "");
	}

	@Test
	public void testValidTodo() {
		Todo result = new Todo(Priority.HIGH, "description");
		
		assertEquals("checking priority", Priority.HIGH, result.getPriority());
		assertEquals("checking description", "description", result.getDescription());
		assertNull("checking due date", result.getDueDate());
	}

}
