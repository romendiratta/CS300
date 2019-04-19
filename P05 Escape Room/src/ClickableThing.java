//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Clickable Thing
// Files:           Action.java, Thing.java, VisibleThing.java, EscapeRoom.java,
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

/**
 * @author Rohan Mendiratta
 * @author Paul Bartlett
 */
public class ClickableThing extends VisibleThing {

  private Action action; // action returned from update when this object is clicked
  private boolean mouseWasPressed; // tracks whether the mouse was pressed during the last update()

  /**
   * initializes the new object
   * @param name of the object
   * @param x coordinate
   * @param y coordinate
   * @param action of the object
   */
  public ClickableThing(String name, int x, int y, Action action) {
	super(name, x, y);
	this.action = action;

  }

  /**
   * calls VisibleThing update, then returns action only when mouse is first clicked
   * @return action when the mouse clicked
   */
  @Override
  public Action update() {
    Action toReturn = super.update(); // sets action to null
	// checks if x and y are ove the image
	boolean isOver = isOver(getProcessing().mouseX, getProcessing().mouseY);
	// checks if the mouse is pressed and over the image
	if(!(mouseWasPressed) && isOver && getProcessing().mousePressed) {
	  mouseWasPressed = true;
	  toReturn = action;
	}
	// returns action if the mouse was pressed
	else if(mouseWasPressed) {
	  this.mouseWasPressed = getProcessing().mousePressed;
	  return toReturn;
	}
	// sets mouse pressed to false if the mouse is not pressed
	else if (!(getProcessing().mousePressed)) {
	  mouseWasPressed = false;
	}
	return toReturn;
  }

}
