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
		orderer.insertTodo(newTodo, todoList);
		orderer.sortTodos(todoList);
		assertEquals(todoList, todoList.get(0));
	}
	

}
