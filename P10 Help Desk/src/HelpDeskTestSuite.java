//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Help Desk Test Suite
// Files:           HelpDesk.java, SupportTicket.java
// Course:          CS300 Spring 2019
//
// Author:          Rohan Mendiratta
// Email:           rmendiratta@wisc.edu
// Lecturer's Name: Mouna Kacem
//
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
 * This class contains unit tests to test the HelpDesk and SupportTicket classes
 * @author Rohan Mendiratta
 */
public class HelpDeskTestSuite extends HelpDesk {

  /**
   * Tests the implementation of the HelpDesk constructor
   * @return true if passes, false otherwise
   */
  public static boolean testHelpDeskConstructor() {
    boolean result = true; // test variable
    HelpDesk helpDesk = new HelpDesk(15); // initial HelpDesk
    // checks that a HelpDesk with the correct capacity is constructed.
    if(helpDesk.array.length != 15) {
      result = false;
    }
    return result;
  }

  /**
   * Tests the implementation of the createNewTicket method in HelpDesk
   * @return true if passes, false otherwise
   */
  public static boolean testCreateNewTicket() {
    boolean result = true; // test variable
    HelpDesk helpDesk = new HelpDesk(15); // initial HelpDesk
    helpDesk.createNewTicket("Test Message"); // creates new ticket
    // checks that a ticket with the correct message is added to the array
    if(!helpDesk.array[0].toString().equals("Test Message")) {
      result = false;
    }
    return result;
  }

  /**
   * Tests the implementation of the checkNextTicket in HelpDesk
   * @return true if passes, false otherwise
   */
  public static boolean testCheckNextTicket() {
    boolean result = true; // test variable
    HelpDesk helpDesk = new HelpDesk(15); // initial HelpDesk
    helpDesk.createNewTicket("Test Message"); // adds new ticket
    // checks that checkNextTicket() returns the correct message
    if(!helpDesk.checkNextTicket().equals("Test Message")) {
      result = false;
    }
    return result;
  }

  /**
   * Tests the implementation closeNextTicket in HelpDesk
   * @return true if passes, false otherwise
   */
  public static boolean testCloseNextTicket() {
    boolean result = true; // test variable
    HelpDesk helpDesk = new HelpDesk(15);
    helpDesk.createNewTicket("Test Message");
    helpDesk.closeNextTicket(); // removes ticket
    // checks that the ticket has been removed
    if(helpDesk.array[0] != null) {
      result = false;
    }
    return result;
  }

  /**
   * Tests the implementation swap in HelpDesk
   * @return true if passes, false otherwise
   */
  public static boolean testSwap() {
    boolean result = true; // test variable
    HelpDesk helpDesk = new HelpDesk(15); // initial HelpDesk
    // adds two tickets
    helpDesk.createNewTicket("Test Message at root");
    helpDesk.createNewTicket("Test Message");
    // switches tickets
    helpDesk.swap(0,1);
    // checks that both tickets have been switched
    if(!helpDesk.array[0].toString().equals("Test Message") ||
    !helpDesk.array[1].toString().equals("Test Message at root")) {
      result = false;
    }
    return result;
  }

  /**
   * Tests the implementation of error messages in HelpDesk
   * @return true if passes, false otherwise
   */
  public static boolean testFullEmptyHelpDesk() {
    boolean result = true; // test variable
    HelpDesk helpDesk = new HelpDesk(1); // intial helpDesk
    try { // tests an empty desk throws an exception
      helpDesk.checkNextTicket();
      result = false;
    } catch (IllegalStateException e) {}

    try { // tests an empty desk throws an exception
      helpDesk.closeNextTicket();
      result = false;
    } catch (IllegalStateException e) {}

    try { // tests an full desk throws an exception
      helpDesk.createNewTicket("Test Message");
      helpDesk.createNewTicket("Test Message");
      result = false;
    } catch (IndexOutOfBoundsException e) {}

    return result;
  }

  /**
   * Tests the implementation of propagateUp in HelpDesk
   * @return true if passes, false otherwise
   */
  public static boolean testPropagateUp() {
    boolean result = true; // test variable
    HelpDesk helpDesk = new HelpDesk(7); // initial HelpDesk
    // adds tickets from min to max
    helpDesk.createNewTicket("1");
    helpDesk.createNewTicket("22");
    helpDesk.createNewTicket("333");
    helpDesk.createNewTicket("4444");
    helpDesk.createNewTicket("55555");
    helpDesk.createNewTicket("666666");
    helpDesk.createNewTicket("7777777");

    // checks that the array in max-heap sorted
    if(!helpDesk.array[0].toString().equals("7777777")){
      result = false;
    }
    if(!helpDesk.array[1].toString().equals("4444")) {
      result = false;
    }
    if(!helpDesk.array[2].toString().equals("666666")) {
      result = false;
    }
    if(!helpDesk.array[3].toString().equals("1")) {
      result = false;
    }
    if(!helpDesk.array[4].toString().equals("333")) {
      result = false;
    }
    if(!helpDesk.array[5].toString().equals("22")) {
      result = false;
    }
    if(!helpDesk.array[6].toString().equals("55555")) {
      result = false;
    }
    return result;
  }

  /**
   * Tests the implementation of propagateDown in HelpDesk
   * @return true if passes, false otherwise
   */
  public static boolean testPropagateDown() {
    boolean result = true; // test variable
    HelpDesk helpDesk = new HelpDesk(8); // initial HelpDesk
    // adds tickets from min to max
    helpDesk.createNewTicket("1");
    helpDesk.createNewTicket("22");
    helpDesk.createNewTicket("333");
    helpDesk.createNewTicket("4444");
    helpDesk.createNewTicket("55555");
    helpDesk.createNewTicket("666666");
    helpDesk.createNewTicket("7777777");
    helpDesk.createNewTicket("88888888");
    // removes the top ticket
    helpDesk.closeNextTicket();

    // checks that the array is max-heap sorted
    if(!helpDesk.array[0].toString().equals("7777777")){
      result = false;
    }
    if(!helpDesk.array[1].toString().equals("4444")) {
      result = false;
    }
    if(!helpDesk.array[2].toString().equals("666666")) {
      result = false;
    }
    if(!helpDesk.array[3].toString().equals("1")) {
      result = false;
    }
    if(!helpDesk.array[4].toString().equals("333")) {
      result = false;
    }
    if(!helpDesk.array[5].toString().equals("22")) {
      result = false;
    }
    if(!helpDesk.array[6].toString().equals("55555")) {
      result = false;
    }

    return result;
  }


  /**
   * Main driver of all the unit tests
   * @param args NONE
   */
  public static void main(String[] args) {
    System.out.println("Testing HelpDesk constructor: " +
        testHelpDeskConstructor());
    System.out.println("Testing createNewTicket(): " +
        testCreateNewTicket());
    System.out.println("Testing checkNextTicket(): " +
        testCheckNextTicket());
    System.out.println("Testing closeNextTicket(): " +
        testCloseNextTicket());
    System.out.println("Testing swap(): " +
        testSwap());
    System.out.println("Testing Full/Empty array error handling: " +
        testFullEmptyHelpDesk());
    System.out.println("Testing propagateUp(): " +
        testPropagateUp());
    System.out.println("Testing propagateDown(): " +
        testPropagateDown());
  }

}
