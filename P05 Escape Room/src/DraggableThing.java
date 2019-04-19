//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Draggable Thing
// Files:           Action.java, Thing.java, VisibleThing.java, ClickableThing.java,
//                  EscapeRoom.java, DragAndDroppableThing.java
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
public class DraggableThing extends VisibleThing {

  private boolean mouseWasPressed; // similar to use in ClickableThing
  private boolean isDragging; // true when this object is being dragged by the user
  private int oldMouseX; // horizontal position of mouse during last update
  private int oldMouseY; // vertical position of mouse during last update

  /**
   * Default constructor
   */
  public DraggableThing(){}

  /**
   * Initializes the new thing
   * @param name of the Thing
   * @param x coordinate
   * @param y coordinate
   */
  public DraggableThing(String name, int x, int y) {
    super(name, x, y);
    this.isDragging = false;
    this.oldMouseX = x;
    this.oldMouseY = y;

  }


  /**
   * calls VisibleThing update(), then moves according to mouse drag
   * each time isDragging changes from true to false, the drop() method below will be called once
   * @return null
   */
  @Override
  public Action update() {
	super.update();
	// checks if x and y are over the image
	boolean isOver = isOver(getProcessing().mouseX, getProcessing().mouseY);
	if(isOver && getProcessing().mousePressed) {
	  mouseWasPressed = true;
	  isDragging = true;
	}
	// moves the object if it is being dragged
	if (isDragging) {
	 move(getProcessing().mouseX - oldMouseX, getProcessing().mouseY - oldMouseY);
	 oldMouseX = getProcessing().mouseX;
	 oldMouseY = getProcessing().mouseY;
	}
	// stops dragging once the mouse is released
	if (!getProcessing().mousePressed) {
	  isDragging = false;
	  return drop();
	}
	return null;
  }

  /**
   * Overrided by subclasses to perform actions
   * @return null
   */
  protected Action drop() {
    return null;
  }

}
