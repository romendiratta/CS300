//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Visible Thing
// Files:           Action.java, Thing.java, EscapeRoom.java, ClickableThing.java,
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

import processing.core.PImage;
import java.io.File;

/**
 * @author Rohan Mendiratta
 * @author Paul Bartlett
 */
public class VisibleThing extends Thing {

  private PImage image; // the graphical representation of this thing
  private int x; // the horizontal position (in pixels of this thing's left side)
  private int y; // the vertical position (in pixels of this thing's top side)


  /**
   * Default constructor
   */
  public VisibleThing() {}

  /**
   * Creates the visible thing and creates the PImage based on the name
   * @param name of the VisibleThing
   * @param x coordinate
   * @param y coordinate
   */
  public VisibleThing(String name, int x, int y) {
	super(name);
	this.x = x;
	this.y = y;
	// loads the image based on the name
	this.image = Thing.getProcessing().loadImage("images" + File.separator + name + ".png");
  }

  /**
   * Draws the image at its position and returns null
   */
  @Override
  public Action update() {
	Thing.getProcessing().image(image, this.x, this.y);
	return null;
  }

  /**
   * moves the x and y coordinates
   * @param dx amount of x to be changed
   * @param dy amount of y to be changed
   */
  public void move(int dx, int dy) {
	this.x += dx;
	this.y += dy;
  }

  /**
   * Returns true when x and y is over the image
   * @param x coordinate to check
   * @param y coordinate to check
   * @return true if coordinates are over the picture, false otherwise
   */
  public boolean isOver(int x, int y) {

    // gets the bounds of the image
	float leftBound = this.x;
	float rightBound = leftBound + image.width;
	float topBound = this.y;
	float bottomBound = topBound + image.height;

	float mouseX = (float) x;
	float mouseY = (float) y;

	// checks the bounds to see if x and y are in between them
	if ((leftBound < mouseX) && (mouseX < rightBound)) {
	  if ((bottomBound > mouseY) && (mouseY > topBound)) {
		return true;
	  }
	}
	return false;
  }

  /**
   * Checks if this image overlaps other image
   * @param other PImage to be check
   * @return true if they overlap, false otherwise
   */
  public boolean isOver(VisibleThing other) {

    // gets the bounds to this image
	float leftBoundThis = this.x;
	float rightBoundThis = leftBoundThis + image.width;
	float topBoundThis = this.y;
	float bottomBoundThis = topBoundThis + image.height;

	// gets the bounds of the other image
	float leftBoundOther = other.x;
	float rightBoundOther = leftBoundOther + other.image.width;
	float topBoundOther = other.y;
	float bottomBoundOther = topBoundOther + other.image.height;

	//no overlap
	if ((rightBoundThis < leftBoundOther) || (rightBoundOther < leftBoundThis)) {
	  return false;
	}
	// no overlap
	if ((bottomBoundThis < topBoundOther) || (bottomBoundOther < topBoundThis)) {
	  return false;
	}
	// this is within other
	if ((topBoundThis > topBoundOther) && (bottomBoundThis < bottomBoundOther)) {
	  if ((rightBoundThis < rightBoundOther) && (leftBoundThis > leftBoundOther)) {
		return true;
	  }
	}
	// other is within this
	if ((topBoundOther > topBoundThis) && (bottomBoundOther < bottomBoundThis)) {
	  if ((rightBoundOther < rightBoundThis) && (leftBoundOther > leftBoundThis)) {
		return true;
	  }
	}
	return true;
  }
}
