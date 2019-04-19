//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           ServingQueue
// Files:           Guest.java, DessertSolvers.java
// Course:          CS300 Spring 2019
//
// Author:          Rohan Mendiratta
// Email:           rmendiratta@wisc.edu
// Lecturer's Name: Mouna Kacem
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here.  Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * The ServingQueue implements a circular indexing queue.
 * @author Rohan Mendiratta
 */
public class ServingQueue {

	private Guest[] array; // array of guests
	private int seatsAtTable; // number of seats at the table
	private int size; // number of guests in the array
	private int front; // index of front of the array
	private int back; // index of the back of the array

	/**
	 * Creates a new array based queue with a capacity of "seatsAtTable" guests.
	 * This queue should be initialized to be empty.
	 * @param seatsAtTable the size of the array holding this queue data
	 */
	public ServingQueue(int seatsAtTable) {
		array = new Guest[seatsAtTable];
		this.seatsAtTable = seatsAtTable;
		size = 0;
		front = -1;
		back = -1;
	}

	/**
	 * Checks whether there are any guests in this serving queue.
	 * @return true when this queue contains zero guests, and false otherwise.
	 */
	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		return false;
	}

	/**
	 * Adds a single new guest to this queue (to be served after the others that
	 * were previously added to the queue).
	 * @param newGuest is the guest that is being added to this queue.
	 * @throws IllegalStateException when called on a ServingQueue with an array that is full
	 */
	public void add(Guest newGuest) {
		if(size == seatsAtTable){ // Checks serving queue size.
			throw new IllegalStateException("WARNING: Serving Queue is full.");
		}
		if(isEmpty()){ // adds if the queue is empty
			front ++;
			back = front;
			array[front] = newGuest;
			size++;
		}
		else{ // adds if the queue has elements in it already
			back = (back + 1) % array.length;
			array[back] = newGuest;
			size++;
		}
	}

	/**
	 * Accessor for the guest that has been in this queue for the longest.  This method
	 * does not add or remove any guests.
	 * @return a reference to the guest that has been in this queue the longest.
	 * @throws IllegalStateException when called on an empty ServingQueue
	 */
	public Guest peek() {
		if(isEmpty()){
			throw new IllegalStateException("WARNING: Serving Queue is empty.");
		}
		return array[front];
	}

	/**
	 * Removes the guest that has been in this queue for the longest.
	 * @return a reference to the specific guest that is being removed.
	 * @throws IllegalStateException when called on an empty ServingQueue
	 */
	public Guest remove() {
		Guest removeGuest;
		if(isEmpty()){ // checks if the queue is empty
			throw new IllegalStateException("WARNING: Serving Queue is empty.");
		}
		else{ // removes the guest
			removeGuest = array[front];
			array[front] = null;
			front = (front + 1) % array.length;
			size--;
		}
		return removeGuest;
	}

	/**
	 * The string representation of the guests in this queue should display each
	 * of the guests in this queue (using their toString() implementation), and should
	 * display them in a comma separated list that is surrounded by a set of square brackets.
	 * (this is similar to the formatting of java.util.ArrayList.toString()).  The order
	 * that these guests are presented in should be (from left to right) the guest that has
	 * been in this queue the longest, to the guest that has been in this queue the shortest.
	 * When called on an empty ServingQueue, returns "[]".
	 * @return string representation of the ordered guests in this queue
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if(isEmpty()){ // checks if the queue is empty
			return "[]";
		}
		else{
			String output = "[";
			for(int i = front; i != back; i = (i + 1) % array.length){
				output = output.concat(array[i].toString() + ", ");
			}
			return output.concat(array[back].toString() + "]");
		}
	}
}
