package edu.westga.cs3211.todo_app.test.priority_order;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.PriorityOrder;
import edu.westga.cs3211.todo_app.model.Todo;

public class TestSortTodo {

	@Test
	public void testSortWhenOneTodo() {
		PriorityOrder orderer = new PriorityOrder();
		List<Todo> todoList = new ArrayList<Todo>();
		Todo newTodo = new Todo(Priority.LOW, "pick up stuff");
		todoList.add(newTodo);
		
		orderer.sortTodos(todoList);
		
		assertEquals(newTodo, todoList.get(0));
	}
	
	@Test
	public void testSortWhenTwoTodos() {
		PriorityOrder orderer = new PriorityOrder();
		List<Todo> todoList = new ArrayList<Todo>();
		Todo newTodo = new Todo(Priority.LOW, "pick up stuff");
		Todo otherTodo = new Todo(Priority.HIGH, "drop off stuff");
		todoList.add(newTodo);
		todoList.add(otherTodo);
		
		orderer.sortTodos(todoList);
		
		assertEquals(newTodo, todoList.get(1));
		assertEquals(otherTodo, todoList.get(0));
	}
	
	@Test
	public void testSortWhenThreeTodos() {
		PriorityOrder orderer = new PriorityOrder();
		List<Todo> todoList = new ArrayList<Todo>();
		Todo newTodo = new Todo(Priority.LOW, "pick up stuff");
		Todo anotherTodo = new Todo(Priority.MEDIUM, "buy stuff");
		Todo otherTodo = new Todo(Priority.HIGH, "drop off stuff");
		todoList.add(newTodo);
		todoList.add(otherTodo);
		todoList.add(anotherTodo);
		
		orderer.sortTodos(todoList);
		
		assertEquals(newTodo, todoList.get(2));
		assertEquals(anotherTodo, todoList.get(1));
		assertEquals(otherTodo, todoList.get(0));
	}

}
