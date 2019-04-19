//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Shopping Cart Application
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

import java.util.Scanner;

/**
 * @author Rohan Mendiratta
 * @version 1.0
 */
public class ShoppingCart {
  // Define final parameters
  private static final int CART_CAPACITY = 20; // shopping cart max capacity
  private static final double TAX_RATE = 0.05; // sales tax

  // a perfect-size two-dimensional array that stores the available items in the market
  // MARKET_ITEMS[i][0] refers to a String that represents the description of the item
  //                   identified by index i
  // MARKET_ITEMS[i][1] refers to a String that represents the unit price of the item
  //                   identified by index i in dollars.
  public static final String[][] MARKET_ITEMS = new String[][]{{"Apple", "$1.59"},
	  {"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"}, {"Blueberry", "$6.89"},
	  {"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"}, {"Cereal", "$3.69"},
	  {"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"}, {"Cookie", "$9.5"},
	  {"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"}, {"Ice Cream", "$5.39"},
	  {"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"}, {"Pepper", "$1.99"},
	  {"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"}, {"Tomato", "$1.79"}};

  /**
   * adds the item with the given identifier index at the end of the cart
   *
   * @param index of the item within the marketItems array
   * @param cart  shopping cart
   * @return the number of items present in the cart after the item with identifier index is added
   */
  public static int add(int index, String[] cart, int count) {
	if (count == CART_CAPACITY) { // Checks if cart is full.
	  System.out.println("WARNING: The cart is full. You cannot add any new item.");
	  return count;
	}
	cart[count] = MARKET_ITEMS[index][0]; // Adds item to cart.
	count++; // Increments the count variable.
	return count;
  }

  /**
   * Returns how many occurrences of the item with index itemIndex are present in the shopping cart
   *
   * @param itemIndex identifier of the item to count its occurrences in the cart
   * @param cart      shopping cart
   * @param count     number of items present within the cart
   * @return the number of occurrences of item in the cart
   */
  public static int occurrencesOf(int itemIndex, String[] cart, int count) {
	String itemDescription = getItemDescription(itemIndex); // Gets the item description.
	int itemCount = 0;
	for (int i = 0; i < cart.length; i++) { // Iterates through the cart and checks matching items.
	  if (itemDescription.equals(cart[i])) {
		itemCount++; // Adds to item count if a matching item is found.
	  }
	}
	return itemCount;
  }

  /**
   * finds the description of an item in MARKET_LIST.
   *
   * @param itemIndex is the index of item in the MARKET_LIST
   * @return a string with the description of the item in MARKET_LIST
   */
  private static String getItemDescription(int itemIndex) {
	String itemDescription = MARKET_ITEMS[itemIndex][0];
	return itemDescription;
  }

  /**
   * Removes the first (only one) occurrence of itemToRemove if found and returns the number of
   * items in the cart after remove operation is completed either successfully or not.
   *
   * @param itemToRemove String description of item to be removed.
   * @param cart         shopping cart.
   * @param count        the number of occurrences of item in the cart
   * @return count of items in the cart.
   */
  public static int  remove(String itemToRemove, String[] cart, int count) {
	int itemIndex = indexOf(itemToRemove, cart, count); // finds the index of item in the cart.

	if (itemIndex == -1) { // Warning if item is not found in the cart.
	  System.out.println("WARNING: " + itemToRemove + " not found in the shopping cart.");
	  return count;
	}
	cart[itemIndex] = cart[count - 1]; // Sets the item to be removed to the last item in cart.
	cart[count - 1] = null; // Sets the last item in the cart to null.
	count--; // Decrements the number of items in the cart.
	return count;
  }

  /**
   * Returns the index of an item within the shopping cart
   *
   * @param item  description
   * @param cart  Shopping cart
   * @param count number of items present in the shopping cart
   * @return index of the item within the shopping cart, and -1 if the item does not exist in the
   * cart
   */
  private static int indexOf(String item, String[] cart, int count) {
	int itemIndex = -1; // Default index if item is not in the cart.
	for (int i = 0; i < count; i++) { // Iterates through the cart looking for a matching item.
	  if (item.equals(cart[i])) {
		itemIndex = i; // Sets itemIndex to the first index of the matching item in the cart.
		break;
	  }
	}
	return itemIndex;
  }

  /**
   * returns the total value (cost) of the cart without tax in $ (double)
   *
   * @param cart  shopping cart.
   * @param count the number of occurrences of item in the cart
   * @return returns the total value (cost) of the cart without tax
   */
  public static double getSubTotalPrice(String[] cart, int count) {
	// Gets indexes of all the items in the cart.
	int[] indexOfCartItems = getIndexOfCartItems(cart, count);
	// Gets strings of all the prices in the cart.
	String[] stringPricesInCart = getPricesInCart(indexOfCartItems);
	// Changes all of the strings in the cart to doubles.
	double[] doublePricesInCart = convertStringIntoDouble(stringPricesInCart);

	double subtotalPrice = 0.0;
	// Iterates through the prices and adds them all together.
	for (int i = 0; i < doublePricesInCart.length; i++) {
	  subtotalPrice = subtotalPrice + doublePricesInCart[i];
	}
	return subtotalPrice;
  }

  /**
   * Finds the index of a items in the cart.
   *
   * @param cart  Shopping cart
   * @param count Amount of items in the cart.
   * @return an int array of the index of cart items.
   */
  private static int[] getIndexOfCartItems(String[] cart, int count) {
	int[] indexOfCartItems = new int[count]; // int array for indexes of cart items.
	int arrayIndex = 0; // counter index for array.
	// Iterates through market items/cart checking for matching items and recording the indexes.
	for (int i = 0; i < MARKET_ITEMS.length; i++) {
	  for (int j = 0; j < count; j++) {
		if (MARKET_ITEMS[i][0].equals(cart[j])) {
		  indexOfCartItems[arrayIndex] = i;
		  arrayIndex++;
		}
	  }
	}
	return indexOfCartItems;
  }

  /**
   * Gets the prices of the items in the cart.
   *
   * @param indexOfCartItems int array of items in the cart.
   * @return a String array of the prices in the cart.
   */
  private static String[] getPricesInCart(int[] indexOfCartItems) {
	String[] itemPricesArray = new String[indexOfCartItems.length]; // Array of item prices.
	// Uses an array of indexes to find the item prices.
	for (int i = 0; i < itemPricesArray.length; i++) {
	  itemPricesArray[i] = MARKET_ITEMS[indexOfCartItems[i]][1];
	}
	return itemPricesArray;
  }

  /**
   * Converts the prices of the string array into doubles.
   *
   * @param pricesInCart String array of the prices in the cart.
   * @return a double of the prices in the cart.
   */
  private static double[] convertStringIntoDouble(String[] pricesInCart) {
	double[] doubleOfCartPrices = new double[pricesInCart.length]; // Array of item prices.
	// Iterates through an array of prices and converts them into doubles.
	for (int i = 0; i < doubleOfCartPrices.length; i++) {
	  String currentString = pricesInCart[i];
	  currentString = currentString.substring(1);
	  double currentDouble = Double.valueOf(currentString);
	  doubleOfCartPrices[i] = currentDouble;
	}
	return doubleOfCartPrices;
  }

  /**
   * prints the Market Catalog (item identifiers, description, and unit prices)
   */
  public static void printMarketCatalog() {
	// Prints top of market catalog.
	System.out.print("+++++++++++++++++++++++++++++++++++++++++++++\n" + "Item id" + "         " +
		"Description" + "      " + "Price\n" +
		"+++++++++++++++++++++++++++++++++++++++++++++\n");
	// Iterates through each item in the MARKET_ITEMS array.
	for (int i = 0; i < MARKET_ITEMS.length; i++) {
	  System.out.printf("%-16d", i); // Prints catalog id #.
	  System.out.printf("%-17s", MARKET_ITEMS[i][0]); // Prints item description.
	  System.out.print(MARKET_ITEMS[i][1] + "\n"); // Prints item price.
	}
  }

  /**
   * Displays the cart content (items separated by commas)
   *
   * @param cart  shopping cart
   * @param count number of items in the cart
   */
  public static void displayCartContent(String[] cart, int count) {
	System.out.print("Cart Content: ");
	// Iterates through the cart array printing each item followed by a comma.
	for (int i = 0; i < count; i++) {
	  System.out.print(cart[i] + ", ");
	}
	System.out.print("\n"); // New line printed for formatting.
  }

  /**
   * Gets the tax on the items in the cart.
   *
   * @param cartValue value of items in the cart.
   * @return value of the tax.
   */
  private static double getTaxRate(double cartValue) {
	double taxRate = cartValue * TAX_RATE; // Multiplies the value of items in the cart with TAXRATE
	return taxRate;
  }

  /**
   * This main methods takes user responses runs the Shopping Cart application.
   *
   * @param args user arguments
   */
  public static void main(String[] args) {
	Scanner scnr = new Scanner(System.in);
	String[] cart = new String[CART_CAPACITY]; //  Cart array.
	int count = 0; // Number of items in the cart.

	int index = 0; // number that the user may give for remove/add/etc...
	char userChar; // char that the user gives to complete a command.
	String userInput; // User input string.
	boolean quitApplication = false; // Tracks whether the user wants to quit.

	System.out.println("=============   Welcome to the Shopping Cart App   =============\n");
	while (!quitApplication) {
	  System.out.println("\nCOMMAND MENU:\n" + " [P] print the market catalog\n" +
		  " [A <index>] add one occurrence of an item to the cart given its identifier\n" +
		  " [C] checkout\n" + " [D] display the cart content\n" +
		  " [O <index>] number of occurrences of an item in the cart given its identifier\n" +
		  " [R <index>] remove one occurrence of an item from the cart given its " +
		  "identifier\n" + " [Q]uit the application\n");
	  System.out.print("ENTER COMMAND: ");

	  // Parses the user input and find the command character and index if one is given.
	  userInput = scnr.nextLine().trim();
	  userChar= userInput.charAt(0);
	  userInput = userInput.replace(userChar, ' ').trim();
	  if (!userInput.isEmpty()){
		index = Integer.parseInt(userInput);
	  }

	  // Checks the user input and executes the correct command based on their input.
	  if (userChar == 'p' || userChar == 'P') {
		printMarketCatalog();
	  } else if (userChar == 'a' || userChar == 'A') {
		count = add(index, cart, count);
	  } else if (userChar == 'c' || userChar == 'c') {
		double subTotal = getSubTotalPrice(cart, count);
		double taxRate = getTaxRate(subTotal);
		double finalPrice = subTotal + taxRate;
		System.out.println("#items: " + count + " Subtotal: $" +
			String.format("%.2f", subTotal) + " Tax: $" +
			String.format("%.2f", taxRate) + " TOTAL: $" +
			String.format("%.2f", finalPrice));
	  } else if (userChar == 'D' || userChar == 'd') {
		displayCartContent(cart, count);
	  } else if (userChar == 'O' || userChar == 'o') {
		System.out.println("The number of occurrences of " + getItemDescription(index) +
			" (id #" + index + ") is: " + occurrencesOf(index, cart, count));
	  } else if (userChar == 'R' || userChar == 'r') {
		String itemDescription = getItemDescription(index);
		count = remove(itemDescription, cart, count);
	  } else
		quitApplication = true;
	}
	System.out.println("=============  Thank you for using this App!!!!!  =============");
  }
}