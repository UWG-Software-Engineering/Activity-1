package edu.westga.cs3211.todo_app.model;

import java.util.List;

/** Provides hooks for sorting and inserting 
 * (in sorted order) for a list of TODOs.
 * 
 * @author CS3211
 * @version Fall2017
 */
public interface TodoOrder {


	/** Returns the set of TODOs sorted.
	 * 
	 * @precondition todos != null
	 * @postcondition todos is sorted
	 * 
	 * @param todos unsorted set of TODOs
	 */
	public abstract void sortTodos(List<Todo> todos);


	/** Insert the provided TODO into the list of TODOs
	 * at the appropriate location to maintain the intended
	 * sorting scheme for the TODOs
	 * 
	 * @precondition todo != null &&
	 * 				 todos != null
	 * @postcondition todos.size()@pre == todos.size()-1
	 * 
	 * @param todo the TODO to be added to the set
	 * @param todos the set of TODOs to add the TODO to
	 */
	public abstract void insertTodo(Todo todo, List<Todo> todos);

}
