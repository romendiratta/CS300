//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Thing
// Files:           Action.java, EscapeRoom.java, VisibleThing.java, ClickableThing.java,
//                  DraggableThing.java, DragAndDroppableThing.java
// Course:          CS300 Spring 2019
//
// Author:          Rohan Mendiratta
// Email:           rmendiratta@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Paul Bartlett
// Partner Email:   psbartlett@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here.  Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         Megan de Joya
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import processing.core.PApplet;

/**
 * @author Rohan Mendiratta
 * @author Paul Bartlett
 */
public class Thing {

  private static PApplet processing = null;
  private final String NAME; // the constant name identifying this object
  private boolean isActive; // active means thing is visible and can be interacted with

  /**
   * Default constructor
   */
  public Thing() {
    NAME = null;
    this.isActive = true;
  }

  /**
   * Initializes name and sets Thing to active
   * @param name of Thing
   */
  public Thing(String name) {
    NAME = name;
    this.isActive = true;
  }

  /**
   * Checks the name of the Thing object
   * @param name to be compared with
   * @return true if names are the same, false otherwise
   */
  public boolean hasName(String name) {
    if(NAME.equals(name)) {
	  return true;
	}
	else {
	  return false;
	}
  }

  /**
   * Checks whether a thing is active
   * @return true if active, false otherwise
   */
  public boolean isActive() {
    return this.isActive;
  }

  /**
   * Sets isActive to true
   */
  public void activate() {
    this.isActive = true;
  }

  /**
   * sets isActive to false
   */
  public void deactivate() {
    this.isActive = false;
  }

  /**
   * Updates the Thing
   * @return Action object
   */
  public Action update() {
    return null;
  }

  /**
   * initializes the processing field
   * @param processing PApplet of the application
   */
  public static void setProcessing(PApplet processing) {
	Thing.processing = processing;
  }

  /**
   * Retrives the processing field
   * @return reference to PApplet
   */
  protected static PApplet getProcessing() {
	return processing;
  }

}
