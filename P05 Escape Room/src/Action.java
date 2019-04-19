//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Action
// Files:           EscapeRoom.java, Thing.java, VisibleThing.java, ClickableThing.java,
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

import java.util.ArrayList;

/**
 * @author Rohan Mendiratta
 * @author Paul Bartlett
 */
public class Action {

  private String message; // message printed by this action (or null to do nothing)
  private Thing thing; // thing object

  /**
   * Constuctor
   * @param message to be printed out
   */
  public Action(String message) {
    this.message = message;
  }

  /**
   * Constructor
   * @param thing object
   */
  public Action(Thing thing){
    this.thing = thing;
  }

  /**
   * Constructor
   * @param message to be printed
   * @param thing object
   */
  public Action(String message, Thing thing){
    this.message = message;
    this.thing = thing;
  }

  /**
   * when message is not null, message is printed to System.out
   * @param allThings array of Thing objects
   */
  public void act(ArrayList<Thing> allThings) {
    if (this.message != null) { // checks for a null message
      System.out.println(this.message);
	  }
    if(this.thing != null) { // checks for a null Thing object
      this.thing.activate(); // activates the Thing object
      allThings.add(this.thing);
      this.thing = null;
    }
  }

}
