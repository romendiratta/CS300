//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Next Wiki Link
// Files:           Generator.java
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

import java.io.IOException;
import java.util.Scanner;
import java.util.function.Function;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author Mouna Kacem
 * Class that implements a function to find the first hyperlink on a Wikipedia page
 */
public class NextWikiLink implements Function<String, String> {

  private static boolean notFound = false; // keeps track if a page cannot be found

  @Override
  public String apply(String t) {
	try {
	  // Download a Wikipedia page, using t in their internal link format: /wiki/Some_Subject
	  Document doc = Jsoup.connect("https://en.wikipedia.org" + t).get();
	  // Use .css selector to retrieve a collection of links from this page's description
	  // "p a" selects links within paragraphs
	  // ":not([title^='Help'])" skips pronunciations
	  // ":not(sup a)" skips citations
	  Elements links = doc.select("p a:not([title^='Help']):not(sup a)");
	  // return the link attribute from the first element of this list
	  return links.get(0).attr("href");
	  // Otherwise return an appropriate error message:
	}
	catch (IOException | IllegalArgumentException e) {
	  notFound = true;
	  return "FAILED to find wikipedia page: " + t;
	}
	catch (IndexOutOfBoundsException e) {
	  notFound = true;
	  return "FAILED to find a link in wikipedia page: " + t;
	}
  }

  /**
   * Takes a user input and iterates through the specified amount of Wikipedia pages
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // takes user input and formats the input correctly
    System.out.print("Enter a wikipedia page topic: ");
    String topic = scanner.nextLine();
    System.out.print("Enter the number of pages you'd like to step through: ");
    Integer length = scanner.nextInt();
	topic = "/wiki/" + topic;
	topic = topic.replace(" ", "_");

	//creates a generator and it from user input
	Generator generator = new Generator<String>(topic, new NextWikiLink(), length);

	// iterates through Wikipedia pages, stopping if one cannot be found
	for (Object str : generator) {
	  System.out.println(str);
	}
  }
}