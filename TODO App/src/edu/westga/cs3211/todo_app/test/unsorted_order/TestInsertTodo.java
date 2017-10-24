package edu.westga.cs3211.todo_app.test.unsorted_order;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.Todo;
import edu.westga.cs3211.todo_app.model.UnsortedOrder;

public class TestInsertTodo {

	@Test (expected = IllegalArgumentException.class)
	public void testNullInsert() {
		List<Todo> list = new ArrayList<Todo>();
		UnsortedOrder unsorted = new UnsortedOrder();
		unsorted.insertTodo(null, list);
		equals(null);
		
	}
	@Test
	public void testValidToDoAndList() {
		Todo num = new Todo(Priority.HIGH, "Eat");
		Todo num2 = new Todo(Priority.MEDIUM, "Eat");
		Todo num3 = new Todo(Priority.LOW, "Eat");
		List<Todo> list = new ArrayList<Todo>();
		UnsortedOrder unsorted = new UnsortedOrder();
		unsorted.insertTodo(num, list);
		unsorted.insertTodo(num3, list);
		unsorted.insertTodo(num2, list);
		assertTrue( list.contains(num));
		assertTrue( list.contains(num3));
		assertTrue( list.contains(num2));
		
	}
	
	@Test
	public void testInvalidToDoAndList() {
		Todo num = new Todo(Priority.HIGH, "Eat");
		Todo num2 = new Todo(Priority.MEDIUM, "Eat");
		Todo num3 = new Todo(Priority.LOW, "Eat");
		List<Todo> list = new ArrayList<Todo>();
		UnsortedOrder unsorted = new UnsortedOrder();
		unsorted.insertTodo(num, list);
		
		unsorted.insertTodo(num2, list);
		assertTrue( list.contains(num));
		assertFalse( list.contains(num3));
		assertTrue( list.contains(num2));
		
	}

}
