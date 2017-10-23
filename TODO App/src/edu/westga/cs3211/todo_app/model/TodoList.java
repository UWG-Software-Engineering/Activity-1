package edu.westga.cs3211.todo_app.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/** Manages a set of TODOs
 * 
 * @author CS3211
 * @version Fall2017
 */
public class TodoList implements Iterable<Todo> {
	private List<Todo> todos;
	private TodoOrder orderStrategy;

	/** Create an initially empty TodoList.
	 * 
	 * @precondition none
	 * @postcondition 
	 * 
	 */
	public TodoList() {
		this.todos = new ArrayList<Todo>();
		this.orderStrategy = new UnsortedOrder();
	}
	
	/** Return the list of TODOs.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list of TODOs
	 */
	public List<Todo> getTodos() {
		return this.todos;
	}
	
	/** Change the order strategy being used.
	 * 
	 * @precondition order != null
	 * @postcondition todos are ordered accordingly...
	 * 
	 * @param order the order strategy to be used for the list
	 */
	public void setOrder(TodoOrder order) {
		this.orderStrategy = order;
		this.orderStrategy.sortTodos(this.todos);
	}
	
	/** Returns the number of TODOs in the list
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of TODOs in the list
	 */
	public int size() {
		return this.todos.size();
	}
	
	/** Insert the TODO into the appropriate location 
	 * based on the current sorting strategy.
	 * 
	 * @precondition todo != null
	 * @postcondition size()@pre == size()-1 &&
	 * 				  getTodo(todo.getId()) == todo
	 * 
	 * @param todo the TODO to be added
	 */
	public void addTodo(Todo todo) {
		if(todo == null) {
			throw new IllegalArgumentException("Must provide a valid TODO");
		}
		this.orderStrategy.insertTodo(todo, this.todos);
	}
	
	/** Remove the TODO with the specified id
	 * 
	 * @precondition none
	 * @postcondition size()@pre == size()+1 if a TODO with the specified id exists
	 * 				  size()@pre == size() if no TODO with the specified id exists
	 * 
	 * @param id UUID of the TODO to be removed
	 */
	public void removeTodo(UUID id) {
		Todo todo = this.getTodo(id);
		if(todo != null) {
			this.todos.remove(todo);
		}
	}
	
	/** Get a TODO by the id of the TODO
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param id UUID of the Todo to find
	 * 
	 * @return the TODO with the matching id
	 */
	public Todo getTodo(UUID id) {
		for(Todo todo : this.todos) {
			if(todo.getId().equals(id)) {
				return todo;
			}
		}
		return null;
	}

	/** Enables support of for-each loops, and general iteration 
	 * by exposing the iterator of the underlying list.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the iterator for the underlying list of TODOs
	 */
	@Override
	public Iterator<Todo> iterator() {
		return this.todos.iterator();
	}

}
