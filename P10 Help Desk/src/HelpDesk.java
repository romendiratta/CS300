//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Help Desk
// Files:           SupporTicket.java
// Course:          CS300 Spring 2019
//
// Author:          Rohan Mendiratta
// Email:           rmendiratta@wisc.edu
// Lecturer's Name: Mouna Kacem
//
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
 * Help desk that implements a priority queue of Support Tickets
 * @author Rohan Mendiratta
 */
public class HelpDesk implements HelpDeskInterface {

  protected SupportTicket[] array; // zero-indexed max-heap
  protected int size; // heap size

  /**
   * Default constructor creates a HelpDesk with a 15 ticket capacity.
   */
  public HelpDesk() {
    array = new SupportTicket[15];
    size = 0;
  }

  /**
   * Creates a new HelpDesk array
   * @param capacity of the array
   */
  public HelpDesk(int capacity) {
    array = new SupportTicket[capacity];
    size = 0;
  }

  /**
   * Creates and adds a new SupportTicket to this HelpDesk.
   * @param message names the client and describes their need for support.
   * @throws NullPointerException when the String message argument is null.
   * @throws IndexOutOfBoundsException when called on HelpDesk with a full array
   */
  public void createNewTicket(String message) {
    if(size == array.length) { // checks for a full helpdesk
      throw new IndexOutOfBoundsException("WARNING: HelpDesk is full");
	}

    array[size] = new SupportTicket(message); // adds the ticket to the array
    size++;
    propagateUp(size - 1); // calls to correct the max-heap order of the added ticket
  }

  /**
   * Returns the message within this HelpDesk that has the highest priority.
   * This method does not change the state of this HelpDesk.
   * @return the message within the highest priority SupportTicket.
   * @throws IllegalStateException when called on a HelpDesk with zero SupportTickets.
   */
  public String checkNextTicket() {
    if (size == 0) { // checks for an empty HelpDesk
      throw new IllegalStateException("WARNING: Help Desk is empty.");
	}
    return array[0].toString();
  }

  /**
   * Returns and removes the message within this HelpDesk that has the highest priority.
   * @return the message within the highest priority SupportTicket (prior to its removal).
   * @throws IllegalStateException when called on a HelpDesk with zero SupportTickets.
   */
  public String closeNextTicket() {
	if (size == 0) { // Checks for an empty help desk
	  throw new IllegalStateException("WARNING: Help Desk is empty.");
	}
    String message = array[0].toString(); // ticket to be removed
	swap(0, size - 1); // swaps the first and last ticket
    array[size - 1] = null; // sets the last item to null
    size--;
    propagateDown(0); // corrects the max-heap sort order after ticket is removed
    return message;
  }

  /**
   * Given an index into the heap array, this method returns that index's parent index.
   * @param index current index
   * @return parent index
   */
  protected static int parentOf(int index) {
    return (index - 1)/2;
  }

  /**
   * Given an index into the heap array, this method returns that index's left child index.
   * @param index current index
   * @return index of left child
   */
  protected static int leftChildOf(int index) {
    return (index*2) + 1;
  }

  /**
   * Helper method to see if a given index has a left child
   * @param index current index
   * @return true if a left child exists, false otherwise
   */
  private  boolean hasLeftChild(int index){
    if ((index*2) + 1 > size) {
      return false;
	}
	return true;
  }

  /**
   * Given an index into the heap array, this method returns that index's right child index.
   * @param index current index
   * @return index of right child
   */
  protected static int rightChildOf(int index) {
    return (index*2) + 2;
  }

  /**
   * Helper method to see if a given index has a right child
   * @param index current index
   * @return true if a right child exists, false otherwise
   */
  private boolean hasRightChild(int index) {
	if ((index*2) + 2 > size) {
	  return false;
	}
	return true;
  }

  /**
   * Given two indexes into the heap array, this method swaps the SupportTickets at those indexes.
   * @param indexA index of first item
   * @param indexB index of second item
   */
  protected void swap(int indexA, int indexB) {
    SupportTicket temp = array[indexA]; // temp variable
    array[indexA] = array[indexB]; // swap first
    array[indexB] = temp; // swap second
  }

  /**
   * Given an index into the heap array, this method recursively swaps any SupportTickets
   * necessary to enforce the heap's order property between this index and the heap's root.
   * @param index current index
   */
  protected void propagateUp(int index) {
    int parent = parentOf(index);
    // condition checks if the max-heap order is not satisfied
    if (array[index].compareTo(array[parent]) >= 0 && index > 0) {
      swap(index, parent);
      index = parent;
      propagateUp(index);
    }
  }

  /**
   * Given an index into the heap array, this method recursively swaps any SupportTickets
   * necessary to enforce the heap's order property between this index and it's children.
   * @param index current index
   */
  protected void propagateDown(int index) {
    int leftChild = leftChildOf(index);
    int rightChild = rightChildOf(index);
    int largest = index;

    // checks if the left child is larger than the parent
    if( leftChild < size - 1 && array[leftChild].compareTo(array[largest]) > 0 ) {
      largest = leftChild;
    }
    // checks if the right child is larger than the parent
    if( rightChild < size - 1 && array[rightChild].compareTo(array[largest]) > 0) {
      largest = rightChild;
    }
    // swaps if either child is greater than the parent
    if( largest != index ) {
      swap(index, largest);
      propagateDown(largest);
    }
  }

}
