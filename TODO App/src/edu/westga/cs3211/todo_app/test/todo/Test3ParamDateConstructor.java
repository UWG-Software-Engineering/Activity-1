package edu.westga.cs3211.todo_app.test.todo;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs3211.todo_app.model.Priority;
import edu.westga.cs3211.todo_app.model.Todo;

public class Test3ParamDateConstructor {
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testDateisAfter() {
		exception.expect(IllegalArgumentException.class);
		LocalDate date = LocalDate.of(2017, 10, 23);
		Todo todo = new Todo(Priority.HIGH, "do it", date);
	}

	@Test
	public void testValidDate() {
		LocalDate date = LocalDate.of(2017, 10, 25);
		Todo todo = new Todo(Priority.HIGH, "do it", date);
		assertEquals(LocalDateTime.of(date, LocalTime.of(9, 00)), todo.getDueDate());
	}

}
