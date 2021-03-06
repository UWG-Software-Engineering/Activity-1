package edu.westga.cs3211.todo_app.test.todo_list;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.Todo;
import edu.westga.cs3211.todo_app.model.TodoList;

public class TestRemoveTodo {

	@Test
	public void testRemoveTodoWhenNoneExist() {
		TodoList testList = new TodoList();
		testList.removeTodo(new Todo(Priority.MEDIUM, "Something").getId());
		assertEquals(0, testList.size());
	}
	
	@Test
	public void testRemoveTodoWhenOneExists() {
		TodoList testList = new TodoList();
		Todo testTodo = new Todo(Priority.HIGH, "Go away");
		testList.addTodo(testTodo);
		
		assertEquals(1, testList.size());
		testList.removeTodo(testTodo.getId());
		assertEquals(0, testList.size());
	}
	
	@Test
	public void testRemoveTodoWhenRemovingFromFront() {
		TodoList testList = new TodoList();
		Todo testTodo1 = new Todo(Priority.LOW, "Low Todo");
		Todo testTodo2 = new Todo(Priority.MEDIUM, "Medium Todo");
		Todo testTodo3 = new Todo(Priority.HIGH, "High Todo");
		
		testList.addTodo(testTodo1);
		testList.addTodo(testTodo2);
		testList.addTodo(testTodo3);
		
		testList.removeTodo(testTodo1.getId());
		List<Todo> remainingTodos = testList.getTodos();
		
		assertEquals(2, remainingTodos.size());
		assertEquals(Priority.MEDIUM, remainingTodos.get(0).getPriority());
		assertEquals(Priority.HIGH, remainingTodos.get(1).getPriority());
	}

}
