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

public class Test3ParamDateTimeConstructor {
	
	@Rule public ExpectedException exception = ExpectedException.none();

	@Test
	public void testDateisAfter() {
		LocalDate date = LocalDate.of(2017, 10, 23);
		LocalTime time = LocalTime.of(9, 0);
		LocalDateTime datetime = LocalDateTime.of(date,  time);
		
		exception.expect(IllegalArgumentException.class);
		new Todo(Priority.HIGH, "do it", datetime);
	}

	@Test
	public void testValidDate() {
		LocalDate date = LocalDate.now().plusDays(1);
		LocalTime time = LocalTime.of(9, 0);
		LocalDateTime datetime = LocalDateTime.of(date,  time);
		
		Todo result = new Todo(Priority.HIGH, "do it", datetime);

		assertEquals("checking priority", Priority.HIGH, result.getPriority());
		assertEquals("checking description", "do it", result.getDescription());
		assertEquals("checking due date", datetime, result.getDueDate());
	}

}
