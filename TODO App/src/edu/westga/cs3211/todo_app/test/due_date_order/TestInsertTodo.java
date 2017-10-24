package edu.westga.cs3211.todo_app.test.due_date_order;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import edu.westga.cs3211.todo_app.model.DueDateOrder;
import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.SortedOrder;
import edu.westga.cs3211.todo_app.model.Todo;
import edu.westga.cs3211.todo_app.model.TodoList;

public class TestInsertTodo {

	@Test
	public void testInsert1TodoIsBefore1stTodoAddedInorders() {
		TodoList myList = new TodoList();
		Todo myTodo = new Todo(Priority.HIGH, "DO THE THING!", LocalDate.now().plusDays(1));
		Todo myTodo2 = new Todo(Priority.HIGH, "DO THE THING AGAIN!", LocalDate.now().plusDays(2));
		myList.addTodo(myTodo);
		SortedOrder mySorter = new DueDateOrder();
		mySorter.insertTodo(myTodo2, myList.getTodos());
		assertTrue(myList.getTodos().get(0).getDueDate().isBefore(myList.getTodos().get(1).getDueDate()));
	}

}
