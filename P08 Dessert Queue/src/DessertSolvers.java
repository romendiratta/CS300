//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DessertSolvers
// Files:           Guest.java, ServingQueue.java
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
 * The DessertSolvers class determines what person is to be served desert first based on the
 * guests order of arrival.
 * @author Rohan Mendiratta
 */
public class DessertSolvers {

  /**
   * Determines who should be served desert first based on the number of guests at the table and
   * the number of guest skipped.
   * @param numberOfGuests amount of guests at the table
   * @param guestsSkipped  number of guest that should be skipped
   * @return Guest that is served last
   */
  public static Guest firstDessertVariableSkips(int numberOfGuests, int guestsSkipped){
	Guest.resetNextGuestIndex(); // resets the guest index to start at 0.
	// temp guest instance variables
	Guest guest = null;
	Guest returnGuest = null;

	//checks that the number of guests and guests skipped are valid
	if(numberOfGuests <= 0){
	  throw new IllegalArgumentException("WARNING: Number of guests must be positive.");
	}
	if(guestsSkipped < 0){
	  throw new IllegalArgumentException("WARNING: Number of guests skipped cannot be negative.");
	}

	// creates a new serving queue with the allotted number of guests
	ServingQueue queue = new ServingQueue(numberOfGuests);
	for(int i = 0; i < numberOfGuests; i++){
	  queue.add(new Guest());
	}
	// serves and skips guests
	while(!queue.isEmpty()){
	  returnGuest = queue.remove(); // removes the guest that is served
	  if (queue.isEmpty()) {
		break;
	  }
	  for(int j = 0; j < guestsSkipped; j++){ // skips the guests and adds them to the back
		guest = queue.remove();
		queue.add(guest);
	  }
	}
	return returnGuest;
  }

  /**
   * Determines the first guest to be served desert based on the number of courses served
   * @param numberOfGuests amount of guest at the table
   * @param coursesServed number of courses served
   * @return guest that is served dessert first
   */
  public static Guest firstDessertVariableCourses(int numberOfGuests, int coursesServed){
	Guest.resetNextGuestIndex(); // resets the guest index to 0

	// checks that the numbers of guests and courses are valid
	if(numberOfGuests <= 0){
	  throw new IllegalArgumentException("WARNING: Number of guests must be positive.");
	}
	if(coursesServed <= 0){
	  throw new IllegalArgumentException("WARNING: Number of courses served must be positive.");
	}
	// creates a new serving queue with the allotted number of guests
	ServingQueue queue = new ServingQueue(numberOfGuests);
	for(int i = 0; i < numberOfGuests; i++){
	  queue.add(new Guest());
	}

	int count = 0; // courses served
	while(count < coursesServed - 1){
	  // temp serving queues
	  ServingQueue served = new ServingQueue(numberOfGuests);
	  ServingQueue nextTable = new ServingQueue(numberOfGuests);

	  // serves ands skips guests
	  for(int i = 0; i < numberOfGuests - 1; i++){
		Guest servedGuest = queue.remove();
		served.add(servedGuest);
		Guest skippedGuest = queue.remove();
		queue.add(skippedGuest);
	  }
	  // adds the last guest to be served into the next queue
	  Guest firstServed = queue.remove();
	  nextTable.add(firstServed);

	  // serves the guests at the next table
	  for(int i = 1; i < numberOfGuests; i++){
		Guest nextGuest = served.remove();
		nextTable.add(nextGuest);
	  }
	  queue = nextTable;
	  count++;
	}
	return queue.peek();
  }
}
