package edu.westga.cs3211.todo_app.test.unsorted_order;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.Todo;
import edu.westga.cs3211.todo_app.model.UnsortedOrder;

public class TestSortTodo {

	private UnsortedOrder anUnsortedOrder;
	
	private Todo high1Todo;
	private Todo high2Todo;
	private Todo med1Todo;
	private Todo med2Todo;
	private Todo low1Todo;
	private Todo low2Todo;
	
	private List<Todo> todoList;
	private List<Todo> sortedList;
	
	@Before
	public void setUp() {
		this.anUnsortedOrder = new UnsortedOrder();

		this.high1Todo = new Todo(Priority.HIGH, "High1");
		this.high2Todo = new Todo(Priority.HIGH, "High2");
		this.med1Todo = new Todo(Priority.MEDIUM, "Medium1");
		this.med2Todo = new Todo(Priority.MEDIUM, "Medium2");
		this.low1Todo = new Todo(Priority.LOW, "Low1");
		this.low2Todo = new Todo(Priority.LOW, "Low2");
		
		this.todoList = new ArrayList<Todo>();
		this.sortedList = new ArrayList<Todo>();
	}

	@Test
	public void when2HighToLowTodoAreSortedOrderDoesntChange() {
		this.sortedList.add(this.high1Todo);
		this.sortedList.add(this.low2Todo);
		
		this.todoList = this.sortedList;
		this.anUnsortedOrder.sortTodos(this.sortedList);
		
		assertTrue(this.todoList.equals(this.sortedList));
		
	}
	
	@Test
	public void when2LowToHighTodoAreSortedOrderDoesntChange() {
		this.sortedList.add(this.low1Todo);
		this.sortedList.add(this.high2Todo);
		
		this.todoList = this.sortedList;
		this.anUnsortedOrder.sortTodos(this.sortedList);
		
		assertTrue(this.todoList.equals(this.sortedList));
		
	}
	
	@Test
	public void when3HighToLowTodoAreSortedOrderDoesntChange() {
		this.sortedList.add(this.high1Todo);
		this.sortedList.add(this.med1Todo);
		this.sortedList.add(this.low2Todo);
		
		this.todoList = this.sortedList;
		this.anUnsortedOrder.sortTodos(this.sortedList);
		
		assertTrue(this.todoList.equals(this.sortedList));
		
	}
	
	@Test
	public void when3LowToHighTodoAreSortedOrderDoesntChange() {
		this.sortedList.add(this.low1Todo);
		this.sortedList.add(this.med2Todo);
		this.sortedList.add(this.high1Todo);
		
		this.todoList = this.sortedList;
		this.anUnsortedOrder.sortTodos(this.sortedList);
		
		assertTrue(this.todoList.equals(this.sortedList));
		
	}
	
	@Test
	public void when2Low3High1MediumTodoAreSortedOrderDoesntChange() {
		this.sortedList.add(this.low1Todo);
		this.sortedList.add(this.low2Todo);
		this.sortedList.add(this.med2Todo);
		this.sortedList.add(this.high1Todo);
		this.sortedList.add(this.high2Todo);
		this.sortedList.add(this.high1Todo);
		
		this.todoList = this.sortedList;
		this.anUnsortedOrder.sortTodos(this.sortedList);
		
		assertTrue(this.todoList.equals(this.sortedList));
		
	}

}
