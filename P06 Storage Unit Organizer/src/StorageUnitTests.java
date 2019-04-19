//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Storage Unit Test
// Files:           LinkedBoxNode.java, LinkedBoxList.java, Box.java
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
 * Test the box.java, LinkedBoxNode.java, and LinkedBoxList.java methods
 * @author Rohan Mendiratta
 */
public class StorageUnitTests {

  /**
   * Checks whether the behavior of equals method is correct
   * @return true is passes, false otherwise
   */
  public static boolean testBoxEquals(){
    boolean res = true; // test variable

	// test boxes
    Box box1 = new Box(1, 2);
    Box box2 = new Box (1, 2);
    Box box3 = new Box(2,1);

    try { // checks that an exception is thrown when creating an invalid box
      Box box4 = new Box(1,31);
      res = false;
	}
	catch (IllegalArgumentException e) {}

    if (!box1.equals(box2)) {
      res = false;
	}
	if (box2.equals(box3)) {
	  res = false;
	}
	return res;
  }

  /**
   * Checks whether the behavior of compareTo method is correctly implemented
   * @return true is passes, false otherwise
   */
  public static boolean testBoxCompareTo(){
	boolean res = true; // test boolean

	// test boxes
	Box box1 = new Box(1, 15);
	Box box2 = new Box (1, 15);
	Box box3 = new Box(2,30);

	if (box1.compareTo(box3) != -1) {
	  res = false;
	}

	if (box1.compareTo(box2) != 0) {
	  res = false;
	}
	return res;
  }

  /**
   * Checks whether remove method defined in your LinkedBoxList works correctly
   * @return true is passes, false otherwise
   */
  public static boolean testLinkedBoxListRemove() {
	LinkedBoxList test = new LinkedBoxList(10); // test linkedboxlist
	boolean res = true; // test variable
	// test boxes
	Box box1 = new Box(1, 20);
	Box box2 = new Box (1, 15);
	Box box3 = new Box(1,30);
	test.add(box1);
	test.add(box2);
	test.add(box3);
	test.remove(1);

	// test that boxes are added and removed correctly
	if (!test.get(0).equals(box3) || !test.get(1).equals(box2)) {
	  res = false;
	}
	return res;
  }

  /**
   * Checks whether contains method defined in your LinkedBoxList works correctly
   * @return true is passes, false otherwise
   */
  public static boolean testLinkedBoxListContains() {
	LinkedBoxList test = new LinkedBoxList(10); // test linkedboxlist
	boolean res = true; // test variable
	// test boxes
	Box box1 = new Box(1, 20);
	Box box2 = new Box (1, 15);
	Box box3 = new Box(1,30);
	test.add(box1);
	test.add(box2);
	if(!test.contains(box1)) {
	  res = false;
	}
	if(test.contains(box3)) {
	  res = false;
	}
	return res;
  }

  /**
   * Checks whether add method defined in your LinkedBoxList works correctly
   * @return true i passes, false otherwise
   */
  public static boolean testLinkedBoxListAdd() {
	LinkedBoxList test = new LinkedBoxList(10); // test linkedboxlist
	boolean res = true; // test variable
	// test boxes
	Box box1 = new Box(1, 30);
	Box box2 = new Box (1, 15);
	Box box3 = new Box(1,20);
	test.add(box1);
	test.add(box2);
	test.add(box3);
	if(test.get(0) != box1 || test.get(1) != box3 || test.get(2) != box2) {
	  res = false;
	}
	return res;
  }

  /**
   * Main driver application of the tests.
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(testBoxEquals());
    System.out.println(testBoxCompareTo());
    System.out.println(testLinkedBoxListRemove());
    System.out.println(testLinkedBoxListContains());
    System.out.println(testLinkedBoxListAdd());
  }
}
