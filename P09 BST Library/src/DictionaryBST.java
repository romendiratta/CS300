//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Dictionary Binary Search Tree
// Files:           Dictionary.java, DictionaryWord.java,
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

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class DictionaryBST implements Dictionary {

  private DictionaryWord root; // root of the BST

  /**
   * Creates an empty DictionaryBST
   */
  public DictionaryBST() {
    root = null;
  }

  /**
   * checks whether the dictionary is empty or not
   * @return true if empty, false otherwise
   */
  public boolean isEmpty() {
    return root == null;
  }

  /**
   * adds this word definition (word and the provided meaning) to the dictionary
   * Throws IllegalArgumentException if either word or meaning is null or an empty String
   * @param word
   * @param meaning
   * @return true if word was successfully added, false otherwise
   */
  public boolean addWord(String word, String meaning) {
    boolean result;
    if(this.isEmpty()) { // checks if root is empty
      result = true;
      root = new DictionaryWord(word, meaning);
    }
    else { // starts a recursive call to insert the DictionaryWord
      result = addWordHelper(new DictionaryWord(word, meaning), root);
    }
    return result;
  }

  /**
   * Returns the meaning of the word s if it is present in this dictionary
   * Throws a NoSuchElementException if the word s was not found in this dictionary
   * @param s word to be looked up
   * @return meaning of word looked up
   */
  public String lookup(String s) {
    return lookupHelper(s, root);
  }

  /**
   * Returns the number of words stored in this dictionary
   * @return number of words
   */
  public int size(){
    return sizeHelper(root);
  }

  /**
   * Computes and returns the height of this dictionaryBST, as the number of nodes
   * from root to the deepest leaf DictionaryWord node.
   *
   * @return the height of this Binary Search Tree counting the number of DictionaryWord nodes
   */
  public int height() {
    return heightHelper(root);
  }

  /**
   * Returns all the words within this dictionary sorted from A to Z
   *
   * @return an ArrayList that contains all the words within this dictionary sorted in
   *         the ascendant order
   */
  public ArrayList<String> getAllWords() {
    if (this.isEmpty()) {
      return new ArrayList<>(); // returns an empty arrayList is the BST is empty
    }
    return getAllWordsHelper(root);
  }

  /**
   * Recursive helper method to add newWord in the subtree rooted at node
   *
   * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
   * @param current the current DictionaryWord that is the root of the subtree where
   *        newWord will be inserted
   * @return true if the newWordNode is successfully added to this dictionary, false otherwise
   */
  private static boolean addWordHelper(DictionaryWord newWordNode, DictionaryWord current) {
    if (current.getWord().equalsIgnoreCase(newWordNode.getWord())) { // checks for a matching word
      return false;
    }
    else if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) < 0) {
      if (current.getLeftChild() != null) { // recur on the left subtree
        addWordHelper(newWordNode, current.getLeftChild());
      }

      else { // add newWordNode to left subtree
        current.setLeftChild(newWordNode);
        return true;
      }
    }
    else if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) > 0) {
      if (current.getRightChild() != null) { // recur on the right subtree
        addWordHelper(newWordNode, current.getRightChild());
      }
      else { // add newWordNode to right subtree
        current.setRightChild(newWordNode);
        return true;
      }
    }
    return true;
  }

  /**
   * Recursive helper method to lookup a word s in the subtree rooted at current
   *
   * @param s String that represents a word
   * @param current pointer to the current DictionaryWord within this dictionary
   * @return the meaning of the word s if it is present in this dictionary
   * @throws NoSuchElementException if s is not found in this dictionary
   */
  private static String lookupHelper(String s, DictionaryWord current) {
    if (current == null) { // empty tree or leaf reached
      throw new NoSuchElementException("WARNING: Could not find a matching word."); // unsuccessful
    }
    if (s.compareToIgnoreCase(current.getWord()) == 0) {
      return current.getMeaning(); // successful search
    }
    if (s.compareToIgnoreCase(current.getWord()) < 0) { // recur on the left left sub-tree
      return lookupHelper(s, current.getLeftChild());
    }
    return lookupHelper(s, current.getRightChild());  // recur on the right right sub-tree
  }

  /**
   * Recursive helper method that returns the number of dictionary words stored in
   * the subtree rooted at current
   *
   * @param current current DictionaryWord within this dictionaryBST
   * @return the size of the subtree rooted at current
   */
  private static int sizeHelper(DictionaryWord current) {
    if (current == null)
      return 0;
    else { //recursively steps through the tree and counts each word
      return(sizeHelper(current.getLeftChild()) + 1 + sizeHelper(current.getRightChild()));
    }
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   *
   * @param current pointer to the current DictionaryWord within this DictionaryBST
   * @return height of the subtree rooted at current counting the number of
   * DictionaryWord nodes from the current node to the deepest leaf in the subtree
   * rooted at current
   */
  private static int heightHelper(DictionaryWord current) {
    if (current == null) { // checks if the BST is empty
      return 0;
    }
    else {
      // compute the depth of each subtree
      int leftDepth = heightHelper(current.getLeftChild());
      int rightDepth = heightHelper(current.getRightChild());

      // use the bigger one
      if (leftDepth > rightDepth){
        return (leftDepth + 1);
      }
      else {
        return (rightDepth + 1);
      }
    }
  }

  /**
   * Recursive Helper method that returns a list of all the words stored in
   * the subtree rooted at current sorted alphabetically from A to Z
   *
   * @param current pointer to the current DictionaryWord within this dictionaryBST
   * @return an ArrayList of all the words stored in the subtree rooted at current
   */
  private static ArrayList<String> getAllWordsHelper(DictionaryWord current) {

    ArrayList<String> arrayList = new ArrayList<>(); // initial array list

    if(current.getLeftChild() != null) {
      arrayList.addAll(getAllWordsHelper(current.getLeftChild())); // recurs through left subtree
    }
    arrayList.add(current.getWord()); // adds current word
    if(current.getRightChild() != null) { // recurs through right subtree
      arrayList.addAll(getAllWordsHelper(current.getRightChild()));
    }
    return arrayList;
  }

}
