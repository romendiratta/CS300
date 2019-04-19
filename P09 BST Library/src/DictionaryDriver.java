//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Dictionary Driver
// Files:           DictionaryWord.java, DictionaryBST.java
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

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Dictionary Driver of all the applications.
 * @author Rohan Mendiratta
 * @author Paul Bartlett
 */
public class DictionaryDriver {

  /**
   * Main Driver interface for the DictionaryBST
   * @param args
   */
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in); // scanner to take input
	DictionaryBST dictionary = new DictionaryBST(); // initial dictionary
	while (true) { // menu screen
	  System.out.print("=========================== Dictionary ============================\n"
		  + "Enter one of the following options:\n"
		  + "[A <word> <meaning>] to add a new word and its definition in the dictionary\n"
		  + "[L <word>] to search a word in the dictionary and display its definition\n"
		  + "[G] to print all the words in the dictionary in sorted order\n"
		  + "[S] to get the count of all words in the dictionary\n"
		  + "[H] to get the height of this dictionary implemented as a binary search tree\n"
		  + "[Q] to quit the program\n" + "Please enter your command: ");
	  try {
		String[] line = sc.nextLine().split(" ", 3);
		switch (line[0].toUpperCase().charAt(0)) {
		  case 'A': // adds to dictionary
			if (!dictionary.addWord(line[1], line[2])) {
			  System.out.println("WARNING: failed to add duplicate word: " + line[1] + ".");
			}
			break;
		  case 'L':
			if (dictionary.isEmpty()) { // checks for an empty dictionary
			  System.out.println("There are no definitions in this empty dictionary.");
			}
			else {
			  try { // prints if a definition is found
				String definition = dictionary.lookup(line[1]);
				System.out.println(definition);
			  }
			  catch (NoSuchElementException e) { // if no definition is found
				System.out.println("No definition found for the word: " + line[1]);
			  }
			}
			break;
		  case 'G': // prints all the words in a sorted order
			System.out.println(dictionary.getAllWords().toString());
			break;
		  case 'S': // counts the amount of words in teh dictionary
			System.out.println(dictionary.size());
			break;
		  case 'H': // counts the height of the dictionary
		    System.out.println(dictionary.height());
		    break;
		  case 'Q': // quit
			return;
		  default:
			System.out.println("WARNING: Unrecognized command.");
			break;
		}
		System.out.println();
	  }
	  catch (ArrayIndexOutOfBoundsException e){ // if not enough commands are given
		System.out.println("WARNING: Syntax Error");
	  }
	}
  }
}
