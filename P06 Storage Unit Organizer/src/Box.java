//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Box
// Files:           LinkedBoxNode.java, LinkedBoxList.java, StorageUnitTests.java
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

import java.util.Random;

/**
 * Simple box object that has a color and weight.
 * @author Rohan Mendiratta
 */
public class Box implements Comparable<Box>{

  private static Random randGen = new Random(); // generator of random numbers
  private int color; // color of this box
  private int weight; // weight of this box in lbs between 1 inclusive and 31 exclusive

  /**
   * Creates a new Box and initializes its instance fields color and weight to random values
   */
  public Box() {
    this.color = randGen.nextInt();
    this.weight = randGen.nextInt(30) + 1;
  }

  /**
   *  Creates a new Box and initializes its instance fields color and weight to the specified values
   * Throws IllegalArgumentException if the provided weight value is out of the range of [1..30]
   * @param color box color
   * @param weight box weight
   */
  public Box(int color, int weight) {
    this.color = color;
    // checks for a valid weight
    if (weight < 1 || weight > 30) {
      throw new IllegalArgumentException("Error: Weight must be between 1 and 30.");
	}
	else {
	  this.weight = weight;
	}
  }

  /**
   * Checks if two boxes are equal to each other.
   * @param other other box object
   * @return true if equals, false otherwise
   */
  @Override
  public boolean equals(Object other) {
    // checks types of instance and color/weight of both boxes
	if (other instanceof Box &&
		this.color == ((Box) other).getColor() &&
		this.weight == ((Box) other).getWeight()) {
	  return true;
	}
	else {
	  return false;
	}
  }

  /**
   * Compares two box objects
   * @param otherBox box object to be compared to
   * @return -1 if weight is less than the other box, 1 if the weight is more than the other box,
   * and 0 if they are equal in weight
   */
  @Override
  public int compareTo(Box otherBox) {
	if (this.weight < otherBox.getWeight()) {
	  return -1;
	}
	else if (this.weight > otherBox.getWeight()) {
	  return 1;
	}
	else {
	  return 0;
	}
  }

  /**
   * Getter for the instance field color of this box
   * @return color of box
   */
  public int getColor() {
    return this.color;
  }

  /**
   * Getter for the instance field weight of this box
   * @return weight of box
   */
  public int getWeight() {
    return this.weight;
  }

}
