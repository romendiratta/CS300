//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Drag and Droppable Thing
// Files:           Action.java, Thing.java, VisibleThing.java, ClickableThing.java,
//                  DraggableThing.java, EscapeRoom.java
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

/**
 * @author Rohan Mendiratta
 * @author Paul Bartlett
 */
public class DragAndDroppableThing extends DraggableThing {

  private VisibleThing target; // object over which this object can be dropped
  private Action action; // action that results from dropping this object over target

  /**
   * Initializes the new object
   * @param name of the object
   * @param x coordinate
   * @param y coordinate
   * @param target object that this can be dropped on
   * @param action result of dropping this object on the target
   */
  public DragAndDroppableThing(String name, int x, int y, VisibleThing target, Action action) {
    super(name, x, y);
    this.target = target;
    this.action = action;
  }

  /**
   * returns action and deactivates objects in response to successful drop
   * @return action if successful, otherwise null
   */
  @Override
  protected Action drop() {
    // checks if one object is over another and if they are both active
	if(isOver(target) && target.isActive()) {
	  this.deactivate(); // deactivates
	  target.deactivate();
	  return this.action;
	}
	return null;
  }

}
