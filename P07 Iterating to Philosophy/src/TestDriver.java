//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Test Driver
// Files:           Generator.java, FiniteGenerator.java, InfiniteGenerator.java, EvenNumbers.java
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
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.function.Function;

/**
 * @author Rohan Mendiratta
 * Test driver class for unit tests.
 */
public class TestDriver {

  /**
   * Tests EvenNumber class
   * @return true if passes, false otherwise
   */
  public static boolean testEvenNumbers() {
	EvenNumbers it = new EvenNumbers(44); // creates new even number generator
	if(it.next() != 44) { // checks the original number is returned
	  System.out.println("The first call of EvenNumbers.next() "
		  + "did not return the value passed into its constructor.");
	  return false;
	}
	if(it.next() != 46) { // checks the next number is returned correctly
	  System.out.println("The second call of EvenNumbers.next() "
		  + "did not return the smallest even number, "
		  + "that is larger than the previously returned number.");
	  return false;
	}
	if(it.hasNext() != true) { // checks the hasNext method
	  System.out.println("EvenNumbers.next() returned false, "
		  + "but should always return true.");
	  return false;
	}
	return true;
  }

  /**
   * Tests that the infiniteGenerator works with the PowersOfTwo class function
   * @return true if passes, false otherwise
   */
  public static boolean testPowersOfTwo() {
    // creates new infinite iterator
	InfiniteIterator it = new InfiniteIterator(8, new NextPowerOfTwo());
	if(!it.next().equals(8)) { // tests that original number is returned
	  System.out.println("The first call of InfiniteIterator.next() "
		  + "did not return the number passed into its constructor.");
	  return false;
	}
	if(!it.next().equals(16)) { // tests that the next number is returned correctly
	  System.out.println("The second call of InfiniteIterator.next() "
		  + "did not return the smallest power of two number, "
		  + "that is larger than the previously returned number.");
	  return false;
	}
	if(it.hasNext() != true) { // tests the hasNext method
	  System.out.println("InfiniteIterator.next() returned false, "
		  + "but should always return true.");
	  return false;
	}
	return true;
  }

  /**
   * Tests that the infiniteGenerator works with the AddExtraSmile class function
   * @return true if passes, false otherwise
   */
  public static boolean testAddExtraSmile() {
    // creates a new infinite iterator
	InfiniteIterator<String> it = new InfiniteIterator<>("Hello", new AddExtraSmile());
	if(!it.next().equals("Hello")) { // tests that the original output is returned
	  System.out.println("The first call of InfiniteIterator.next() "
		  + "did not return the string passed into its constructor.");
	  return false;
	}
	if(!it.next().contains(" :)")) { // tests that a smile is added using th next method
	  System.out.println("The second call of InfiniteIterator.next() "
		  + "did not return the a string with one more :), "
		  + "than the previously returned string.");
	  return false;
	}
	if(it.hasNext() != true) { // tests the hasNext method
	  System.out.println("InfiniteIterator.next() returned false, "
		  + "but should always return true.");
	  return false;
	}
	return true;
  }

  /**
   * Tests the FiniteIterator class
   * @return true if passes, false otherwise
   */
  public static boolean testFiniteIterator() {
    // creates a new finite iterator
	InfiniteIterator<Integer> infinite = new InfiniteIterator<>(2, new NextPowerOfTwo());
	FiniteIterator<Integer> it = new FiniteIterator<>(infinite, 8);
	String s = "";
	// adds the numbers to a string and compares the final result
	while(it.hasNext())
	  s += " " + it.next();
	if(!s.equals(" 2 4 8 16 32 64 128 256")) {
	  System.out.println("Repeatedly called the next() method of a FiniteIterator,"
		  + "and the incorrect values were returned:" + s);
	  return false;
	}
	return true;
  }

  /**
   * Tests the Generator class
   * @return true if passes, false otherwise
   */
  public static boolean testGenerator() {
    // creates a new generator
	Generator<Integer> generator = new Generator<>(2, new NextPowerOfTwo(),8);
	String s = "";
	// adds the numbers to a string and compares the final result
	for (Object str: generator) {
		s +=" " + str;
	}
	if(!s.equals(" 2 4 8 16 32 64 128 256")) {
	  System.out.println("Repeatedly called the next() method of a FiniteIterator,"
		  + "and the incorrect values were returned:" + s);
	  return false;
	}
	return true;
  }

  /**
   * Test Driver for all of the unit tests
   * @param args
   */
  public static void main(String[] args) {
	System.out.println(testEvenNumbers());
	System.out.println(testPowersOfTwo());
	System.out.println(testAddExtraSmile());
	System.out.println(testFiniteIterator());
	System.out.println(testGenerator());
  }

}

/**
 * @author Mouna Kacem
 * Class that implements the function to find the next power of two
 */
class NextPowerOfTwo implements Function<Integer,Integer> {
  @Override
  public Integer apply(Integer previous) {
	return 2*previous;
  }
}

/**
 * @author Mouna Kacem
 * Class that implements the function to add a smile to end of a string
 */
class AddExtraSmile implements Function<String,String> {
  @Override
  public String apply(String t) {
	return t + " :)";
  }
}
