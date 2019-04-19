//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           QueueTests
// Files:           Guest.java, ServingQueue.java, DessertSolvers.java
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

/**
 * This class contains unit tests to test each part of the project.
 * @author Rohan Mendiratta
 */
public class QueueTests {

  /**
   * Tests the add implementation within the ServingQueue class.
   * @return true if passes, false otherwise
   */
  public static boolean testAdd(){
    boolean res = true; // test variable
    ServingQueue queue = new ServingQueue(10); // initial queue
    String resString = "[#1(no dairy), #2, #3]"; // final string
    // creates new guests
    Guest guest1 = new Guest("no dairy");
    Guest guest2 = new Guest();
    Guest guest3 = new Guest();
    // adds guests to the queue
    queue.add(guest1);
    queue.add(guest2);
    queue.add(guest3);
    // checks that the resulting queue is correct
    if(!resString.equals(queue.toString())) {
      res = false;
    }
    return res;
  }

  /**
   * Tests the remove method in the ServingQueue class.
   * @return true if passes, false otherwise
   */
  public static boolean testRemove() {
    Guest.resetNextGuestIndex();
    boolean res = true; // test variable
    ServingQueue queue = new ServingQueue(10); // initial queue
    String resString = "[#3]"; // final string
    // creates new guests
    Guest guest1 = new Guest();
    Guest guest2 = new Guest();
    Guest guest3 = new Guest();
    // adds and removes guests
    queue.add(guest1);
    queue.add(guest2);
    queue.add(guest3);
    queue.remove();
    queue.remove();
    // checks that the final queue is correct
    if(!resString.equals(queue.toString())) {
      res = false;
    }
    return res;
  }

  /**
   * Tests the circular indexing of the ServingQueue class.
   * @return true if passes, false otherwise.
   */
  public static boolean testCircularIndex() {
    Guest.resetNextGuestIndex();
    boolean res = true; // test variable
    ServingQueue queue = new ServingQueue(10); // initial queue
    String resString = "[#3, #2, #1]"; // final string
    // creates new guests
    Guest guest1 = new Guest();
    Guest guest2 = new Guest();
    Guest guest3 = new Guest();
    // adds and removes guests
    queue.add(guest1);
    queue.add(guest2);
    queue.add(guest3);
    queue.remove();
    queue.remove();
    queue.add(guest2);
    queue.add(guest1);
    // checks that the final result is correct after forcing circular indexing.
    if(!resString.equals(queue.toString())) {
      res = false;
    }
    return res;
  }

  /**
   * main driver of the tests
   * @param args none
   */
  public static void main(String[] args) {
    System.out.println("Testing Add: " +
        testAdd());
    System.out.println("Testing Remove: " +
        testRemove());
    System.out.println("Testing Circular Indexing: " +
        testCircularIndex());
  }
}
