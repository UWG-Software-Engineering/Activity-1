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
import edu.westga.cs3211.todo_app.model.UnsortedOrder;


public class TestInsertTodo {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
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
	
	@Test
	public void testAddToEmptyList() {
		PriorityOrder priorityOrder = new PriorityOrder();
		Todo num = new Todo(Priority.HIGH, "Eat");
		List<Todo> list = new ArrayList<Todo>();
		
		priorityOrder.insertTodo(num, list);

		assertEquals("checking size of list", 1, list.size());
		assertTrue( list.contains(num));
		
	}
	
	@Test
	public void testAddToNonEmptyList() {
		PriorityOrder priorityOrder = new PriorityOrder();
		Todo num = new Todo(Priority.MEDIUM, "Eat");
		Todo num2 = new Todo(Priority.HIGH, "Eat");
		List<Todo> list = new ArrayList<Todo>();
		priorityOrder.insertTodo(num, list);
		
		priorityOrder.insertTodo(num2, list);
		
		assertEquals("checking size of list", 2, list.size());
		assertSame("checking for first todo added", num, list.get(1));
		assertSame("checking for second todo added", num2, list.get(0));
		
	}

}
