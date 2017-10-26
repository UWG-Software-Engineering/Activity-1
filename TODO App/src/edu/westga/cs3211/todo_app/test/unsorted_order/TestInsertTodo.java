package edu.westga.cs3211.todo_app.test.unsorted_order;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.Todo;
import edu.westga.cs3211.todo_app.model.UnsortedOrder;

public class TestInsertTodo {
	
	@Rule public ExpectedException exception = ExpectedException.none();

	@Test
	public void testNullInsert() {
		List<Todo> list = new ArrayList<Todo>();
		UnsortedOrder unsorted = new UnsortedOrder();

		exception.expect(IllegalArgumentException.class);
		unsorted.insertTodo(null, list);
		
	}
	
	@Test
	public void testAddToEmptyList() {
		Todo num = new Todo(Priority.HIGH, "Eat");
		List<Todo> list = new ArrayList<Todo>();
		UnsortedOrder unsorted = new UnsortedOrder();
		
		unsorted.insertTodo(num, list);

		assertEquals("checking size of list", 1, list.size());
		assertTrue( list.contains(num));
		
	}
	
	@Test
	public void testAddToNonEmptyList() {
		Todo num = new Todo(Priority.HIGH, "Eat");
		Todo num2 = new Todo(Priority.MEDIUM, "Eat");
		List<Todo> list = new ArrayList<Todo>();
		UnsortedOrder unsorted = new UnsortedOrder();
		unsorted.insertTodo(num, list);
		
		unsorted.insertTodo(num2, list);
		
		assertEquals("checking size of list", 2, list.size());
		assertTrue("checking for first todo added", list.contains(num));
		assertTrue("checking for second todo added", list.contains(num2));
		
	}

}
