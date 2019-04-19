//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Linked Box Node
// Files:           Box.java, LinkedBoxList.java, StorageUnitTests.java
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
 * Node that contain box data and a reference to the next linked box node
 * @author Rohan Mendiratta
 */
public class LinkedBoxNode {

  private Box box; // box that represents the data for this Linked node
  private LinkedBoxNode next; // reference to the next Linked Box Node

  /**
   * creates a new LinkedBoxNode object with a given
   * box and without referring to any next LinkedBoxNode
   * @param box object to be referred stored
   */
  public LinkedBoxNode(Box box) {
	this.box = box;
	this.next = null;
  }

  /**
   * creates a new LinkedBoxNode object and sets its instance fields box and next to the
   * specified ones
   * @param box object to be stored
   * @param next object to be referred to
   */
  public LinkedBoxNode(Box box, LinkedBoxNode next){
    this.box = box;
    this.next = next;
  }

  /**
   * gets next instance field
   * @return next instance field
   */
  public LinkedBoxNode getNext() {
    return this.next;
  }

  /**
   * Sets the next instance field to the next param
   * @param next object to be referred to
   */
  public void setNext(LinkedBoxNode next) {
    this.next = next;
  }

  /**
   * Gets the box object stored in the LinkedBoxNode
   * @return box object stored
   */
  public Box getBox() {
    return this.box;
  }

  /**
   * Sets the box object instance field to the param
   * @param box object to be stored
   */
  public void setBox(Box box) {
    this.box = box;
  }

}
