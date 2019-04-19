//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Dictionary Tests
// Files:           Dictionary.java, DictionaryWord.java, DictionaryBST.java
// Course:          CS300 Spring 2019
//
// Author:          Rohan Mendiratta
// Email:           rmendiratta@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Paul Bartlett
// Partner Email:   psbartlet@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   x Write-up states that pair programming is allowed for this assignment.
//   x We have both read and understand the course Pair Programming Policy.
//   x We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here.  Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * A class of unit tests for the dictionary BST
 * @author Rohan Mendiratta
 * @author Paul Bartlett
 */
public class DictionaryTests {

  /**
   * Tests the add function of the BST Dictionary.
   * @return true if passes false otherwise.
   */
  public static boolean testAddToBST(){
	boolean res = true; // test variable
	// resulting string
	String end = "[a, airplane, allocate, exceptional, famous, Gigantic, main, sofa, Success]";
	DictionaryBST test = new DictionaryBST(); // initial BST
	// BST addtions
	test.addWord("famous", "meaning");
	test.addWord("exceptional","meaning");
	test.addWord("Gigantic","meaning");
	test.addWord("airplane","meaning");
	test.addWord("sofa","meaning");
	test.addWord("main","meaning");
	test.addWord("allocate","meaning");
	test.addWord("Success","meaning");
	test.addWord("a","meaning");
	// tests final BST against end string
	if(!(test.getAllWords().toString().equals(end))){
	  res = false;
	}
	return res;
  }

  /**
   * Tests that the add method does not add duplicates to the BST
   * @return true if passes, false otherwise
   */
  public static boolean testAddDuplicate(){
	boolean res = true; // test variable
	// resulting string
	String end = "[a, airplane, allocate, exceptional, famous, Gigantic, main, sofa, Success]";
	DictionaryBST test = new DictionaryBST(); // initial BST
	// BST addtions
	test.addWord("famous", "meaning");
	test.addWord("exceptional","meaning");
	test.addWord("Gigantic","meaning");
	test.addWord("airplane","meaning");
	test.addWord("airplane","meaning"); // airplane gets added twice
	test.addWord("sofa","meaning");
	test.addWord("main","meaning");
	test.addWord("allocate","meaning");
	test.addWord("Success","meaning");
	test.addWord("a","meaning");
	// tests final BST against end string
	if(!(test.getAllWords().toString().equals(end))){
	  res = false;
	}
	return res;
  }

  /**
   * Tests the size function that finds the amount of words in the dictionary
   * @return true if passes, false otherwise
   */
  public static boolean testSize(){
	boolean res = true; // test variable
	DictionaryBST test = new DictionaryBST(); // initial BST
	// BST addtions
	test.addWord("famous", "meaning");
	test.addWord("exceptional","meaning");
	test.addWord("Gigantic","meaning");
	test.addWord("airplane","meaning");
	test.addWord("airplane","meaning"); // airplane gets added twice
	test.addWord("sofa","meaning");
	test.addWord("main","meaning");
	test.addWord("allocate","meaning");
	test.addWord("Success","meaning");
	test.addWord("a","meaning");
	// tests final BST against correct size
	if(!(test.size() != 10)){
	  res = false;
	}
	return res;

  }

   /**
   * Tests the height function that finds the height of the tree
   * @return true if passes, false otherwise
   */
  public static boolean testHeight(){
	boolean res = true; // test variable
	DictionaryBST test = new DictionaryBST(); // initial BST
	// BST additions
	test.addWord("famous", "meaning");
	test.addWord("exceptional","meaning");
	test.addWord("Gigantic","meaning");
	test.addWord("airplane","meaning");
	test.addWord("airplane","meaning"); // airplane gets added twice
	test.addWord("sofa","meaning");
	test.addWord("main","meaning");
	test.addWord("allocate","meaning");
	test.addWord("Success","meaning");
	test.addWord("a","meaning");
	// tests final BST against correct height
	if(!(test.height() != 3)){
	  res = false;
	}
	return res;
  }

  /**
   * Tests the isEmpty function that finds if the BST is empty or not
   * @return true if passes, false otherwise
   */
  public static boolean testIsEmpty(){
	boolean res = true; // test variable
	DictionaryBST test = new DictionaryBST(); // initial BST
	if(!test.isEmpty()){ // tests that it should be empty
	  res = false;
	}
	// BST addition
	test.addWord("famous", "meaning");
	if(test.isEmpty()){ // test that it should not be empty
	  res = false;
	}
	return res;
  }

  /**
   * Driver of all of the unit tests
   * @param args NONE
   */
  public static void main(String[] args){
	System.out.println("Testing Add to BST: " + testAddToBST());
	System.out.println("Testing Adding Duplicates to tree: " + testAddDuplicate());
	System.out.println("Testing size function: "+ testSize());
	System.out.println("Testing height function: " + testHeight());
	System.out.println("Testing isEmpty function: " + testIsEmpty());
  }

}
