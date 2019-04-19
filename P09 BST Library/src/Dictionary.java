//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Dictionary Inteface
// Files:           NONE
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
 * Dictionary BST interface
 * @author Rohan Mendiratta
 * @author Paul Bartlett
 */
public interface Dictionary {

  /**
   * checks whether the dictionary is empty or not
   * @return true if empty, false otherwise
   */
  public boolean isEmpty();

  /**
   * adds this word definition (word and the provided meaning) to the dictionary
   * Throws IllegalArgumentException if either word or meaning is null or an empty String
   * @param word
   * @param meaning
   * @return true if successfully added, false otherwise.
   */
  public boolean addWord(String word, String meaning);

  /**
   * Finds the meaning of a word.
   * Throws a NoSuchElementException if the word s was not found in this dictionary
   * @param s word to be searched for
   * @return meaning of the word
   */
  public String lookup(String s);

  /**
   * finds the number of words stored in the dictionary
   * @return number of words stored
   */
  public int size();

}
