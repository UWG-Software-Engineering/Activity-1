package edu.westga.cs3211.todo_app.model;

/** Provides implementation maintaining sorted order 
 * where the TODO priority is considered before due date. 
 * 
 * @author CS3211
 * @version Fall2017
 */
public class PriorityOrder extends SortedOrder {

	/** Generate label for UnsortedOrder
	 * 
	 * @precondition none
	 * @postcondiion none
	 * 
	 * @return "PriorityOrder"
	 */
	@Override
	public String toString() {
		return "PriorityOrder";
	}
	
	protected boolean lessThan(Todo left, Todo right) {
		if(left.getPriority().compareTo(right.getPriority()) < 0) {
			return true;
		}
		if(left.getPriority().compareTo(right.getPriority()) == 0 && left.getDueDate().compareTo(right.getDueDate()) < 0) {
			return true;
		}
		return false;
	}
	
}
