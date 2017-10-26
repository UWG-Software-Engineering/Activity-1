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
		LocalDate date = LocalDate.of(2017, 10, 23);
		exception.expect(IllegalArgumentException.class);
		Todo todo = new Todo(Priority.HIGH, "do it", date);
	}

	@Test
	public void testValidDate() {
		LocalDate date = LocalDate.now().plusDays(1);
		
		Todo result = new Todo(Priority.HIGH, "do it", date);
		
		assertEquals("checking priority", Priority.HIGH, result.getPriority());
		assertEquals("checking description", "do it", result.getDescription());
		assertEquals(LocalDateTime.of(date, LocalTime.of(9, 00)), result.getDueDate());
	}

}
