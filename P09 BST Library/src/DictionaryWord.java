//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Dictionary Word
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
 * @author Rohan Mendiratta
 * @author Paul Bartlett
 */
public class DictionaryWord {

  private final String word; // word that represents the search key for this dictionary word
  private final String meaning;   // The meaning of the word that this dictionary node defines
  private DictionaryWord leftChild;  // The leftChild of the the current DictionaryWord
  private DictionaryWord rightChild; // The rightChild of the the current DictionaryWord

  /**
   * Creates a new dictionary word with the provided word and its meaning pair
   * Throws IllegalArgumentException when the word or meaning are either references to an empty
   * string or null references. The thrown exception should include a significant error message
   * describing which of these problems was encountered.
   * @param word
   * @param meaning
   */
  public DictionaryWord(String word, String meaning) {
	// checks for valid inputs
    if(word == null || word.isEmpty()){
	  throw new IllegalArgumentException("WARNING: word cannot be empty or null.");
	}
	if(meaning == null || meaning.isEmpty()){
	  throw new IllegalArgumentException("WARNING: meaning cannot be empty or null.");
	}
	this.word = word;
	this.meaning = meaning;
	leftChild = null;
	rightChild = null;
  }

  /**
   * Getter for the left child of this dictionary word
   * @return the left child of the word in the binary tree
   */
  public DictionaryWord getLeftChild() {
	return leftChild;
  }

  /**
   * Setter for the left child of this dictionary word
   * @param leftChild
   */
  public void setLeftChild(DictionaryWord leftChild) {
	this.leftChild = leftChild;
  }

  /**
   * Getter for the right child of this dictionary word
   * @return the right child of the word in the binary tree
   */
  public DictionaryWord getRightChild() {
	return rightChild;
  }

  /**
   * Getter for the right child of this dictionary word
   * @param rightChild
   */
  public void setRightChild(DictionaryWord rightChild) {
	this.rightChild = rightChild;
  }

  /**
   * Getter for the word of this dictionary word
   * @return the word
   */
  public String getWord() {
	return word;
  }

  /**
   * Getter for the meaning of the word of this dictionary word
   * @return the meaning of the word
   */
  public String getMeaning() {
	return meaning;
  }

  /**
   * Returns a String representation of this DictionaryWord.
   * @return String printout of the dictionary word and its meaning
   */
  public String toString() {
	return getWord() + ": " + getMeaning();
  }
}
