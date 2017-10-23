package edu.westga.cs3211.todo_app.model;

import java.util.List;

/** Provides implementation for maintaining an unsorted list of TODOs
 * 
 * @author CS3211
 * @version Fall2017
 */
public class UnsortedOrder implements TodoOrder {

	/** Generate label for UnsortedOrder
	 * 
	 * @precondition none
	 * @postcondiion none
	 * 
	 * @return "UnsortedOrder"
	 */
	@Override
	public String toString() {
		return "UnsortedOrder";
	}

	/** Returns the set of TODOs without sorting.
	 * 
	 * @precondition todos != null
	 * @postcondition none
	 * 
	 * @param todos unsorted set of TODOs
	 */
	@Override
	public void sortTodos(List<Todo> todos) {
		if(todos == null) {
			throw new IllegalArgumentException("must provide set of TODOs");
		}
	}

	/** Insert the provided TODO into the list of TODOs
	 * 
	 * @precondition todo != null &&
	 * 				 todos != null
	 * @postcondition todos.size()@pre == todos.size()-1
	 * 
	 * @param todo the TODO to be added to the set
	 * @param todos the set of TODOs to add the TODO to
	 */
	@Override
	public void insertTodo(Todo todo, List<Todo> todos) {
		if(todo == null) {
			throw new IllegalArgumentException("must provide TODO");
		}
		if(todos == null) {
			throw new IllegalArgumentException("must provide set of TODOs");
		}
		todos.add(todo);
	}

}
