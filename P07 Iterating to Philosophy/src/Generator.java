//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Generator
// Files:           InfiniteGenerator.java, FiniteGenerator.java
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

import java.util.Iterator;
import java.util.function.Function;

/**
 * @author Rohan Mendiratta
 * Creates a finite or infinite iterator based on user input
 * @param <T> type of the generator
 */
public class Generator <T> implements Iterable {

  private T initialValue; // initial value
  private Function function; // function to be applied
  private int length; // number of iterations

  /**
   * Infinite generator constructor
   * @param initialValue initial value
   * @param generateNextFromLast function to be applied
   */
  public Generator(T initialValue, Function<T,T> generateNextFromLast) {
	this.initialValue = initialValue;
	this.function = generateNextFromLast;
	this.length = 0;
  }

  /**
   * Finite generator constructor
   * @param initialValue initial value
   * @param generateNextFromLast function to be applied
   * @param length number of iterations
   */
  public Generator(T initialValue, Function<T,T> generateNextFromLast, int length) {
    this.initialValue = initialValue;
    this.function = generateNextFromLast;
    this.length = length;
  }

  /**
   * Creates a finite or infinite iterator based if the user specifies a length
   * @return a finite or infinite iterator
   */
  @Override
  public Iterator<T> iterator() {
    InfiniteIterator iterator =  new InfiniteIterator<T>(initialValue, function);
	if (length == 0) {
	  return iterator;
	}
	return new FiniteIterator<T>(iterator, length);
  }
}
