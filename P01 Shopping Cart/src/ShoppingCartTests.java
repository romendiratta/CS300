//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Shopping Cart Unit Tests
// Files:           NONE
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
 * Test methods for ShoppingCart class.
 * @author Rohan Mendiratta
 */
public class ShoppingCartTests {

  /**
   * Checks whether the total number of items within the cart is incremented after adding one item
   *
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testCountIncrementedAfterAddingOnlyOneItem() {
	boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise

	String[] cart = new String[20]; // shopping cart
	int count = 0; // number of items present in the cart (initially the cart is empty)

	// Add an item to the cart
	count = ShoppingCart.add(3, cart, count); // add an item of index 3 to the cart
	// Check that count was incremented
	if (count != 1) {
	  System.out.println("Problem detected: After adding only one item to the cart, "
		  + "the cart count should be incremented. But, it was not the case.");
	  testPassed = false;
	}
	return testPassed;
  }

  /**
   * Checks whether add and OccurrencesOf return the correct output when only one item is added to
   * the cart
   *
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testAddAndOccurrencesOfForOnlyOneItem() {
	boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
	// define the shopping cart as an oversize array of elements of type String
	// we can set an arbitrary capacity for the cart - for instance 10
	String[] cart = new String[10]; // shopping cart
	int count = 0; // number of items present in the cart (initially the cart is empty)

	// check that OccurrencesOf returns 0 when called with an empty cart
	if (ShoppingCart.occurrencesOf(10, cart, count) != 0) {
	  System.out.println("Problem detected: Tried calling OccurrencesOf() method when the cart is "
		  + "empty. The result should be 0. But, it was not.");
	  testPassed = false;
	}

	// add one item of key 0 to the cart
	count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart

	// check that OccurrencesOf("Apples", cart, count) returns 1 after adding the item with key 0
	if (ShoppingCart.occurrencesOf(0, cart, count) != 1) {
	  System.out.println("Problem detected: After adding only one item with key 0 to the cart, "
		  + "OccurrencesOf to count how many of that item the cart contains should return 1. "
		  + "But, it was not the case.");
	  testPassed = false;
	}

	return testPassed;
  }

  /**
   * Checks that items can be added more than one time and are found
   *
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testAddOccurrencesOfDuplicateItems() {
	boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
	// define the shopping cart as an oversize array of elements of type String
	// we can set an arbitrary capacity for the cart - for instance 10
	String[] cart = new String[10]; // shopping cart
	int count = 0; // number of items present in the cart (initially the cart is empty)

	// adds 5 items item to the cart
	count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart
	count = ShoppingCart.add(1, cart, count); // add an item of index 1 to the cart
	count = ShoppingCart.add(4, cart, count); // add an item of index 4 to the cart
	count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart
	count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart

	// check that OccurrencesOf(0, cart, count) returns 3 after adding the item with key 0, 3 times.
	if (ShoppingCart.occurrencesOf(0, cart, count) != 3) {
	  System.out.println("Problem detected: After adding three items with key 0 to the cart, "
		  + "OccurrencesOf to count how many of that item the cart contains should return 3. "
		  + "But, it was not the case.");
	  testPassed = false;
	}

	return testPassed;
  }

  /**
   * Checks that the correct output is returned when the user tries to add too much items to the
   * cart exceeding its capacity.
   *
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testAddingTooMuchItems() {
	boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
	// define the shopping cart as an oversize array of elements of type String
	String[] cart = new String[20]; // shopping cart
	// number of items present in the cart (set to 15 to assume our cart is almost full.
	int count = 15;

	// adds 5 items item to the cart
	count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart
	count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart
	count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart
	count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart
	count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart

	// Checks that the count is still 20 after attempting to add another item to the cart.
	if (ShoppingCart.add(0, cart, count) != 20) {
	  System.out.println("Problem detected: After adding 5 items to a cart with capacity 5 "
		  + "Another add should should not occur. "
		  + "But, it was not the case.");
	  testPassed = false;
	}

	return testPassed;
  }

  /**
   * Checks that when only one attempt to remove an item present in the cart is made, only one
   * occurrence of that item is removed from the cart
   *
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testRemoveOnlyOneOccurrenceOfItem() {
	boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
	// define the shopping cart as an oversize array of elements of type String
	// we can set an arbitrary capacity for the cart - for instance 10
	String[] cart = new String[10]; // shopping cart
	int count = 0; // number of items present in the cart (initially the cart is empty

	// adds tw0 item to the cart
	count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart
	count = ShoppingCart.add(1, cart, count); // add an item of index 0 to the cart

	// check that remove("Apple", cart, count) returns 1 after adding the item with key 0 twice.
	if (ShoppingCart.remove("Apple", cart, count) != 1) {
	  System.out.println("Problem detected: After adding two items with key 0 to the cart, "
		  + "remove should remove only one occurence of an item with key 0. "
		  + "But, it was not the case.");
	  testPassed = false;
	}
	return testPassed;
  }

  /**
   * Checks that remove does not make any change to count (number of items in the cart) when the
   * user tries to remove an item not present within the cart.
   *
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testRemoveItemNotFoundInCart() {
	boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
	// define the shopping cart as an oversize array of elements of type String
	// we can set an arbitrary capacity for the cart - for instance 10
	String[] cart = new String[10]; // shopping cart
	int count = 0; // number of items present in the cart (initially the cart is empty

	// add one item to the cart
	count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart
	count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart


	// check that remove("Avocado", cart, count) returns 2 after adding the item with key 0 twice.
	if (ShoppingCart.remove("Avocado", cart, count) != 2) {
	  System.out.println("Problem detected: After adding two items with key 0 to the cart, "
		  + "remove should not remove any occurences of the item. "
		  + "But, it was not the case.");
	  testPassed = false;
	}
	return testPassed;
  }

  /**
   * Checks that the correct subtotal price is returned.
   *
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testSubtotalPrice() {
	boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
	// define the shopping cart as an oversize array of elements of type String
	// we can set an arbitrary capacity for the cart - for instance 10
	String[] cart = new String[10]; // shopping cart
	int count = 0; // number of items present in the cart (initially the cart is empty

	// adds five items to the cart
	count = ShoppingCart.add(1, cart, count); // add an item of index 0 to the cart
	count = ShoppingCart.add(2, cart, count); // add an item of index 0 to the cart
	count = ShoppingCart.add(3, cart, count); // add an item of index 0 to the cart
	count = ShoppingCart.add(2, cart, count); // add an item of index 0 to the cart
	count = ShoppingCart.add(1, cart, count); // add an item of index 0 to the cart

	// Checks that the subtotal is correct after adding 5 items the cart.
	if (ShoppingCart.getSubTotalPrice(cart, count) != 5.95) {
	  System.out.println("Problem detected: After adding five items to the cart, "
		  + "the total price of the items should be 5.95. "
		  + "But, it was not the case.");
	  testPassed = false;
	}
	return testPassed;
  }

  /**
   * main method used to call the unit tests
   *
   * @param args none
   */
  public static void main(String[] args) {
	System.out.println("testCountIncrementedAfterAddingOnlyOneItem(): "
		+ testCountIncrementedAfterAddingOnlyOneItem());
	System.out.println(
		"testAddAndOccurrencesOfForOnlyOneItem(): " + testAddAndOccurrencesOfForOnlyOneItem());
	System.out.println(
		"testAddOccurrencesOfDuplicateItems(): " + testAddOccurrencesOfDuplicateItems());
	System.out.println(
		"testAddingTooMuchItems(): " + testAddingTooMuchItems());
	System.out.println(
		"testRemoveOnlyOneOccurrenceOfItem() " + testRemoveOnlyOneOccurrenceOfItem());
	System.out.println(
		"testRemoveItemNotFoundInCart() " + testRemoveItemNotFoundInCart());
	System.out.println(
		"testSubtotalPrice() " + testSubtotalPrice());
  }

}
