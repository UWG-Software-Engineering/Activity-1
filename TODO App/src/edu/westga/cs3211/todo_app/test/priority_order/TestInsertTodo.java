package edu.westga.cs3211.todo_app.test.priority_order;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.PriorityOrder;
import edu.westga.cs3211.todo_app.model.Todo;


public class TestInsertTodo {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testInsertNullTodoAndNullTodoList() {
		PriorityOrder priorityOrder = new PriorityOrder();
		exception.expect(IllegalArgumentException.class);
		
		priorityOrder.insertTodo(null, null);

	}
	
	@Test
	public void testInsertNullTodoAndValidTodoList() {
		PriorityOrder priorityOrder = new PriorityOrder();
		exception.expect(IllegalArgumentException.class);
		List<Todo> todos = new ArrayList<Todo>();
		
		priorityOrder.insertTodo(null, todos);
	}
	
	@Test
	public void testInsertValidTodoAndNullTodoList() {
		PriorityOrder priorityOrder = new PriorityOrder();
		exception.expect(IllegalArgumentException.class);
		Todo todo = new Todo(Priority.HIGH, "Test");
		
		priorityOrder.insertTodo(todo, null);
	}

}
