package edu.westga.cs3211.todo_app.model;

/** Provides implementation maintaining sorted order 
 * where the TODO due date is considered before priority. 
 * 
 * @author CS3211
 * @version Fall2017
 */
public class DueDateOrder extends SortedOrder {

	/** Generate label for DueDateOrder
	 * 
	 * @precondition none
	 * @postcondiion none
	 * 
	 * @return "DueDateOrder"
	 */
	@Override
	public String toString() {
		return "DueDateOrder";
	}
	
	protected boolean lessThan(Todo left, Todo right) {
		if(left.getDueDate().compareTo(right.getDueDate()) < 0) {
			return true;
		}
		if(left.getDueDate().compareTo(right.getDueDate()) == 0 && left.getPriority().compareTo(right.getPriority()) < 0) {
			return true;
		}
		return false;
	}
}
