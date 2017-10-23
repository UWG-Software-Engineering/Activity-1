package edu.westga.cs3211.todo_app.model;

import java.util.Comparator;
import java.util.List;

/** Provides standard implementation for maintaining a sorted list of TODOs
 * 
 * @author CS3211
 * @version Fall2017
 */
public abstract class SortedOrder implements TodoOrder, Comparator<Todo> {

	/** Returns the set of TODOs sorted.
	 * 
	 * @precondition todos != null
	 * @postcondition todos is sorted
	 * 
	 * @param todos unsorted set of TODOs
	 * 
	 * @return the sorted set of TODOs
	 */
	@Override
	public void sortTodos(List<Todo> todos) {
		if(todos == null) {
			throw new IllegalArgumentException("must provide set of TODOs");
		}
		todos.sort(this);
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
		//FIXME this should really use an insertion sort approach
		todos.add(todo);
		todos.sort(this);
	}	
	
	/** Compares two TODOs based on the criteria specified in the lessThan method.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return -1 if left == null || lessThan(left, right);
	 * 		    1 if right == null || lessThan(right, left);
	 * 		    0 otherwise;
	 */
	@Override
	public int compare(Todo left, Todo right) {
		if(left == null) {//FIXME not sure this case can actually happen. 
			return -1;
		}
		if(right == null) {
			return 1;
		}
		if(this.lessThan(left, right)) {
			return -1;
		}
		if(this.lessThan(right, left)) {
			return 1;
		}
		return 0;
	}
	
	/** Determine if left < right.
	 * 
	 * @precondition left != null &&
	 * 				 right != null
	 * @postcondition none
	 * 
	 * @param left the left TODO
	 * @param right the right TODO
	 * 
	 * @return true if left < right
	 * 		   false if left >= right
	 */
	protected abstract boolean lessThan(Todo left, Todo right);

}
