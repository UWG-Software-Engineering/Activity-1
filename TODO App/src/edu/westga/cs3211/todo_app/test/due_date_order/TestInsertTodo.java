package edu.westga.cs3211.todo_app.test.due_date_order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs3211.todo_app.model.DueDateOrder;
import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.PriorityOrder;
import edu.westga.cs3211.todo_app.model.SortedOrder;
import edu.westga.cs3211.todo_app.model.Todo;
import edu.westga.cs3211.todo_app.model.TodoList;

public class TestInsertTodo {
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testInsert1TodoIsBefore1stTodoAddedInorders() {
		TodoList myList = new TodoList();
		Todo myTodo = new Todo(Priority.HIGH, "DO THE THING!", LocalDate.now().plusDays(1));
		Todo myTodo2 = new Todo(Priority.HIGH, "DO THE THING AGAIN!", LocalDate.now().plusDays(2));
		myList.addTodo(myTodo);
		DueDateOrder order = new DueDateOrder();
		order.insertTodo(myTodo2, myList.getTodos());
		assertTrue(myList.getTodos().get(0).getDueDate().isBefore(myList.getTodos().get(1).getDueDate()));
	}
	
	@Test
	public void testInsertNullTodoAndValidTodoList() {
		DueDateOrder order = new DueDateOrder();
		exception.expect(IllegalArgumentException.class);
		List<Todo> todos = new ArrayList<Todo>();
		
		order.insertTodo(null, todos);
	}
	
	@Test
	public void testInsertValidTodoAndNullTodoList() {
		DueDateOrder order = new DueDateOrder();
		exception.expect(IllegalArgumentException.class);
		Todo todo = new Todo(Priority.HIGH, "Test");
		
		order.insertTodo(todo, null);
	}
	
	@Test
	public void testAddToEmptyList() {
		DueDateOrder order = new DueDateOrder();
		Todo num = new Todo(Priority.HIGH, "Eat");
		List<Todo> list = new ArrayList<Todo>();
		
		order.insertTodo(num, list);

		assertEquals("checking size of list", 1, list.size());
		assertTrue( list.contains(num));
		
	}
	
	@Test
	public void testAddToNonEmptyList() {
		DueDateOrder order = new DueDateOrder();
		LocalDate date = LocalDate.of(9999, 9, 9);
		LocalTime time = LocalTime.of(9, 9);
		LocalDateTime datetime = LocalDateTime.of(date, time);
		Todo num2 = new Todo(Priority.HIGH, "Eat", datetime);
		Todo num = new Todo(Priority.HIGH, "Eat", datetime.plusDays(1));
		List<Todo> list = new ArrayList<Todo>();
		order.insertTodo(num, list);
		
		order.insertTodo(num2, list);
		
		assertEquals("checking size of list", 2, list.size());
		assertSame("checking for first todo added", num, list.get(1));
		assertSame("checking for second todo added", num2, list.get(0));
		
	}

}
