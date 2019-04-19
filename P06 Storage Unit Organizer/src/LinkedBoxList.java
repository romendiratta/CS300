//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Linked Box List
// Files:           LinkedBoxNode.java, Box.java, StorageUnitTests.java
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
// Persons:         Megan De Joya - Helped with add and remove methods
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * List that implements to use of LinkedBoxNodes
 * @author Rohan Mendiratta
 */
public class LinkedBoxList {

  // head of this LinkedBoxList (refers to the element stored at index 0 within this list)
  private LinkedBoxNode head;
  private int size; // number of boxes already stored in this list
  // capacity of this LinkedBoxList maximum number of box elements that this LinkedBoxList can store
  private int capacity;

  /**
   * Creates an empty LinkedBoxList with a given initial capacity
   * @param capacity of the LinkedBoxList
   */
  public LinkedBoxList(int capacity) {
    this.capacity = capacity;
    this.head = null;
    this.size = 0;
  }

  /**
   * Returns the size of this list
   * @return size of list
   */
  public int size() {
    return this.size;
  }

  /**
   * Return the capacity of this list
   * @return capacity of list
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   * Expands the capacity of this LinkedBoxList with the specified number a of additional elements
   * @param a amount that capacity should be expanded by
   */
  public void expandCapacity(int a) {
    this.capacity += a;
  }

  /**
   * Checks whether this LinkedBoxList is empty
   * @return true if this LinkedBoxList is empty, false otherwise
   */
  public boolean isEmpty() {
    return head == null;
  }

  /**
   * Checks whether this LinkedBoxList is full
   * @return true if this list is full, false otherwise
   */
  public boolean isFull() {
    if (size >=  capacity) {
      return true;
	}
	else {
	  return false;
	}
  }

  /**
   * Adds a new box into this sorted list
   * @param newBox object to be added
   * @throws IllegalArgumentException if newBox is null
   * @throws IllegalStateException if this list is full
   */
  public void add(Box newBox) throws IllegalArgumentException, IllegalStateException {
	// checks if list is full
    if (this.isFull()) {
	  throw new IllegalStateException("Error: List is full.");
	}
	// checks if the new box is null
	if (newBox == null) {
	  throw new IllegalArgumentException("Error: New Box is null.");
	}
	LinkedBoxNode newNode = new LinkedBoxNode(newBox); // node to be added
	// adds a node when a list is empty
	if (this.size == 0) {
	  this.head = newNode;
	  size++;
	}
	else {
	  LinkedBoxNode prev = null; // hold previous node reference
	  LinkedBoxNode next = this.head; // holds the next node reference
	  boolean boxAdded = false; // true when a box has been added
	  while (!boxAdded) {
	    // checks the weight of the node to the weight of the box to be added
		if (newBox.compareTo(next.getBox()) >= 0) {
		  //adds the node
		  if (next == this.head) {
			newNode.setNext(this.head);
			this.head = newNode;
			size++;
			boxAdded = true;
		  }
		  // adds the node
		  else {
			newNode.setNext(next);
			if (prev != null) {
			  prev.setNext(newNode);
			}
			size++;
			boxAdded = true;
		  }
		}
		// adds the box if it being added to the back of the list
		if (next.getNext() == null && !boxAdded) {
		  next.setNext(newNode);
		  size++;
		  boxAdded = true;
		}
		prev = next;
		next = next.getNext();
	  }
	}
  }

  /**
   * Checks if this list contains a box that matches with (equals) a specific box object
   * @param findBox box to be searched for
   * @return true if this list contains findBox, false otherwise
   */
  public boolean contains(Box findBox) {
    // checks for an empty list
    if (this.head == null) {
      return false;
	}
	LinkedBoxNode runner = this.head; // runner to check through nodes
	// iterates through the nodes looking for a matching node
    for(int i = 0; i < size; i++) {
	  if (runner.getBox().equals(findBox)) {
		return true;
	  }
	}
	return false;
  }

  /**
   * Returns a box stored in this list given its index
   * @param index of box index to be seached for
   * @return Box object found
   * @throws IndexOutOfBoundsException if index is out of the range 0..size-1
   */
  public Box get(int index) throws IndexOutOfBoundsException {
	// checks that the index is within bounds
	if ((size - 1) < index || index < 0) {
	  throw new IndexOutOfBoundsException("Error: Invalid index.");
	}
	LinkedBoxNode runner = this.head; // runner to go through the nodes
	// iterates through the nodes going up to the given index
	for (int i = 0; i < index; i++) {
	  runner = runner.getNext();
	}
	return runner.getBox();
  }

  /**
   * Removes a returns the box stored at index from this LinkedBoxList
   * @param index of box object to be removed
   * @return box object that has been removed
   * @throws IndexOutOfBoundsException f index is out of bounds. index should be in the range of
   * [0.. size()-1]
   */
  public Box remove(int index) throws IndexOutOfBoundsException {
    // checks if the index is valid
	if (index < 0 || index > size - 1) {
	  throw new IndexOutOfBoundsException("Error: Index out of bounds.");
	}
	LinkedBoxNode previousNode = head; // previous to the node to be removed
	Box boxToRemove;
	if (index == 0) { // checks if the node is at the head
	  boxToRemove = this.head.getBox();
	  this.head = this.head.getNext();
	}
	else {
	  // iterates to the node that references the one to be removed
	  for (int i = 0; i < index - 1; i++) {
		previousNode = previousNode.getNext();
	  }
	  boxToRemove = previousNode.getNext().getBox(); // sets the box data of the node to be removed
	  previousNode.setNext(previousNode.getNext().getNext()); // sets the node previous to two nodes ahead
	}
	size--;
	return boxToRemove;
  }

  /**
   * Removes all the boxes from this list
   */
  public void clear() {
	this.head = null;
	this.size = 0;
  }

  /**
   * Returns a String representation for this LinkedBoxList
   */
  @Override
  public String toString() {
	StringBuilder result = new StringBuilder(); // creates a StringBuilder object
	String newLine = System.getProperty("line.separator");
	result.append("------------------------------------------------"+newLine);
	if (!isEmpty()) {
	  LinkedBoxNode runner = head;
	  int index = 0;
	  // traverse the list and add a String representation for each box
	  while (runner != null) {
		result.insert(0,
			"Box at index " + index + ": " + runner.getBox().getWeight() + " lbs" + newLine);
		runner = runner.getNext();
		index++;
	  }
	  result.insert(0, "Box List Content:"+ newLine);
	}
	result.insert(0,"List size: " + size + " box(es)." + newLine);
	result.insert(0,"Box List is empty: " + isEmpty() + newLine);
	result.insert(0,"------------------------------------------------"+ newLine);
	return result.toString();
  }
}

