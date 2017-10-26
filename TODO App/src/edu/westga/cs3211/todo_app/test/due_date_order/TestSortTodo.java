package edu.westga.cs3211.todo_app.test.due_date_order;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.westga.cs3211.todo_app.model.DueDateOrder;
import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.Todo;

public class TestSortTodo {

	@Test
	public void testSortWhenOneTodo() {
		LocalDate date = LocalDate.of(9999, 9, 9);
		LocalTime time = LocalTime.of(9, 9);
		LocalDateTime datetime = LocalDateTime.of(date, time);
		DueDateOrder orderer = new DueDateOrder();
		List<Todo> todoList = new ArrayList<Todo>();
		Todo newTodo = new Todo(Priority.HIGH, "pick up stuff", datetime);
		todoList.add(newTodo);
		
		orderer.sortTodos(todoList);
		
		assertEquals(newTodo, todoList.get(0));
	}
	
	@Test
	public void testSortWhenTwoTodos() {
		LocalDate date = LocalDate.of(9999, 9, 9);
		LocalTime time = LocalTime.of(9, 9);
		LocalDateTime datetime = LocalDateTime.of(date, time);
		DueDateOrder orderer = new DueDateOrder();
		List<Todo> todoList = new ArrayList<Todo>();
		Todo newTodo = new Todo(Priority.HIGH, "pick up stuff", datetime.plusDays(1));
		Todo otherTodo = new Todo(Priority.HIGH, "drop off stuff", datetime);
		todoList.add(newTodo);
		todoList.add(otherTodo);
		
		orderer.sortTodos(todoList);
		
		assertEquals(newTodo, todoList.get(1));
		assertEquals(otherTodo, todoList.get(0));
	}
	
	@Test
	public void testSortWhenThreeTodos() {
		LocalDate date = LocalDate.of(9999, 9, 9);
		LocalTime time = LocalTime.of(9, 9);
		LocalDateTime datetime = LocalDateTime.of(date, time);
		DueDateOrder orderer = new DueDateOrder();
		List<Todo> todoList = new ArrayList<Todo>();
		Todo newTodo = new Todo(Priority.HIGH, "pick up stuff", datetime.plusDays(3));
		Todo anotherTodo = new Todo(Priority.HIGH, "buy stuff", datetime.plusDays(2));
		Todo otherTodo = new Todo(Priority.HIGH, "drop off stuff", datetime.plusDays(1));
		todoList.add(newTodo);
		todoList.add(otherTodo);
		todoList.add(anotherTodo);
		
		orderer.sortTodos(todoList);
		
		assertEquals(newTodo, todoList.get(2));
		assertEquals(anotherTodo, todoList.get(1));
		assertEquals(otherTodo, todoList.get(0));
	}

}
