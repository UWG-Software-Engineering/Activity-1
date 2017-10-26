package edu.westga.cs3211.todo_app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Stores basic information for a TODO
 * 
 * @author CS3211
 * @version Fall2017
 */
public class Todo {
	private static final String URGENT_PRIORITY_TEXT = "<URGENT>";
	
	private UUID id;
	private Priority priority;
	private LocalDateTime dueDate;
	private String description;

	/**
	 * Create a new TODO with the provided details.
	 * 
	 * @precondition priority != null && description != null &&
	 *               description.length() > 3
	 * @postcondition getPriority() == priority && getDueDate() == dueDate &&
	 *                getDescription() == description &&
	 * 
	 * @param priority
	 *            priority of the TODO
	 * @param description
	 *            description of the TODO
	 */
	public Todo(Priority priority, String description) {
		if (priority == null) {
			throw new IllegalArgumentException("Must provide a priority.");
		}
		if (description == null || description.length() < 3) {
			throw new IllegalArgumentException("Must provide a description.");
		}
		this.priority = priority;
		this.description = description;
		this.id = UUID.randomUUID();
		this.dueDate = null;
	}

	/**
	 * Create a new TODO with the provided details.
	 * 
	 * @precondition priority != null && dueDate != null &&
	 *               dueDateTime.after(LocalDateTime.now()) &&
	 *               description != null &&
	 *               description.length() > 3
	 * @postcondition getPriority() == priority && getDueDate() == dueDate &&
	 *                getDescription() == description &&
	 * 
	 * @param priority
	 *            priority of the TODO
	 * @param description
	 *            description of the TODO
	 * @param dueDateTime
	 *            when the TODO is due OR null if the TODO has no deadline
	 */
	public Todo(Priority priority, String description, LocalDateTime dueDateTime) {
		this(priority, description);
		if (dueDateTime == null) {
			throw new IllegalArgumentException("Must provide a due date.");
		}
		if (!dueDateTime.isAfter(LocalDateTime.now())) {
			throw new IllegalArgumentException("Must provide a future due date.");
		}
		this.dueDate = dueDateTime;
	}

	/**
	 * Create a new TODO with the provided details.
	 * 
	 * @precondition priority != null && dueDate != null &&
	 *               dueDate.after(LocalDate.now()) &&
	 *               description != null &&
	 *               description.length() > 3
	 * @postcondition getPriority() == priority && getDueDate() == dueDate &&
	 *                getDescription() == description &&
	 * 
	 * @param priority
	 *            priority of the TODO
	 * @param description
	 *            description of the TODO
	 * @param dueDate
	 *            when the TODO is due OR null if the TODO has no deadline
	 */
	public Todo(Priority priority, String description, LocalDate dueDate) {
		this(priority, description);
		if (dueDate == null) {
			throw new IllegalArgumentException("Must provide a due date.");
		}
		if (!dueDate.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Must provide a future due date.");
		}
		this.dueDate = LocalDateTime.of(dueDate, LocalTime.of(9, 00));
	}

	/**
	 * Return the priority of the TODO
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the priority of the TODO
	 */
	public Priority getPriority() {
		return priority;
	}

	/**
	 * Return the due date of the TODO
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the due date of the TODO
	 */
	public LocalDateTime getDueDate() {
		return dueDate;
	}

	/**
	 * Return the description of the TODO
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the description of the TODO
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Return the id of the TODO
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the id of the TODO
	 */
	public UUID getId() {
		return this.id;
	}

	/** Generate and return TODO priority/description text. 
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return TODO priority/description text
	 */
	@Override
	public String toString() {
		String priorityText = "";
		if(this.priority == Priority.HIGH) {
			priorityText = Todo.URGENT_PRIORITY_TEXT;
		}
		else if(this.priority == Priority.LOW || this.dueDate == null) {
			priorityText = "";
		}
		else if(this.dueDate.isBefore(LocalDateTime.now().plusDays(1))){
			priorityText = Todo.URGENT_PRIORITY_TEXT;
		}
		
		return priorityText + description;
	}
	
	

}
