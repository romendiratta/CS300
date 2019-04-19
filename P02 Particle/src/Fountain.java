//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Fountain
// Files:           P2ParticleFountain.jar
// Course:          CS300 Spring 2019
//
// Author:          Rohan Mendiratta
// Email:           rmendiratta@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Paul Bartlett
// Partner Email:   psbartlett@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here.  Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         Megan De Joya: Helped initialize static variables.
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Random;

/**
 * Fountain class creates particles to create a fountain visual.
 *
 * @author Rohan Mendiratta
 * @author Paul Bartlett
 * @version 1.0
 *
 */
public class Fountain {
  private static Particle[] particles; // Particle array.
  private static Random randGen = new Random(); // Random num generator.
  private static int positionX; // middle of the screen (left to right): 400
  private static int positionY; // middle of the screen (top to bottom): 300
  private static int startColor; // blue: Utility.color(23,141,235)
  private static int endColor; // lighter blue: Utility.color(23,200,255)

  /**
   * Creates a single particle at position (3,3) with velocity (-1,-2). Then checks whether calling
   * updateParticle() on this particle's index correctly results in changing its position to
   * (2,1.3).
   *
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testUpdateParticle() {
    particles[0] = new Particle(); // Creates a new particle object.
    boolean testPassed = true;
    // Sets the position and velocity of this particle.
    particles[0].setPositionX(3.0f);
    particles[0].setPositionY(3.0f);
    particles[0].setVelocityX(-1.0f);
    particles[0].setVelocityY(-2.0f);
    updateParticle(0); // Runs the update particle method on newly created particle.
    if (particles[0].getPositionX() != 2.0f ||
        particles[0].getPositionY() != 1.3f ) { // Checks that the position is correct after update.
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Calls removeOldParticles(6) on an array with three particles (two of which have ages over six
   * and another that does not). Then checks whether the old particles were removed and the young
   * particle was left alone.
   *
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testRemoveOldParticles() {
    boolean testPassed = true;
    // Creates 3 new particles.
    particles[0] = new Particle();
    particles[1] = new Particle();
    particles[2] = new Particle();
    // Sets the ages of these particles.
    particles[0].setAge(1);
    particles[1].setAge(11);
    particles[2].setAge(100);
    removeOldParticles(6); // Removes particles with an age over 6.
    // Checks that the correct particles have been removed.
    if (particles[0] == null || particles[1] != null || particles[2] != null) {
      testPassed = false;
    }
    // Resets the particle array.
    particles[0] = null;
    particles[1] = null;
    particles[2] = null;
    return testPassed;
  }

  /**
   * Takes a screenshot of fountain.
   *
   * @param key user inputted key
   */
  public static void keyPressed(char key) {
    // Checks if key is 'p' and takes a screenshot.
    if (key == 'p') {
      Utility.save("screenshot.png");
    }
  }

  /**
   * Moves the fountain around by updating the x and y position, based on a mouse click.
   *
   * @param positionX x-pos of the mouse click.
   * @param positionY y-pos of the mouse click.
   */
  public static void mousePressed(int positionX, int positionY) {
    Fountain.positionX = positionX; // Sets the x-position.
    Fountain.positionY = positionY; // Sets the y-position.
  }

  /**
   * Removes particles that have reached the maximum age.
   *
   * @param maxAge maximum age of the particle.
   */
  private static void removeOldParticles(int maxAge){
    for(int i = 0; i < particles.length; i++) { // Iterates through the particle array.
      // Checks the age of the particle and compares it to maxAge.
      if (particles[i] == null || particles[i].getAge() > maxAge) {
        particles[i] = null; // Sets the particle to null.
      }
    }
  }

  /**
   * Creates new particles.
   *
   * @param numOfParticles maximum number of particles to be created.
   */
  private static void createNewParticles(int numOfParticles) {
    int particleCounter = 0; // Amount of particles created.
    for (int i = 0; i < particles.length; i++) { // Iterates through the particles array.
      if (particles[i] == null) { // Checks for null objects.
        // Creates a new particle, altering the position/size/color using the random generator.
        particles[i] = new Particle (
            positionX + (randGen.nextInt(6) - 3) + randGen.nextFloat(),
            positionY + (randGen.nextInt(6) - 3) + randGen.nextFloat(),
            randGen.nextInt(8) + 4,
            Utility.lerpColor(startColor, endColor, randGen.nextFloat()));
        particles[i].setVelocityX(
            (randGen.nextInt(2) - 1) + randGen.nextFloat()); // Sets X-velocity.
        particles[i].setVelocityY(
            (randGen.nextInt(5) - 10) + randGen.nextFloat());// Sets Y-velocity.
        particles[i].setAge(randGen.nextInt(41)); // Sets age.
        particles[i].setTransparency(randGen.nextInt(96) + 32); // Sets transparency.
        particleCounter++;
      }
      // Breaks the loop if the particles created exceeds the max amount set.
      if (particleCounter >= numOfParticles) {
        break;
      }
    }
  }

  /**
   * Updates individual particles.
   *
   * @param index index of the Particle in particles array.
   */
  private static void updateParticle(int index) {
    // Changes the Y-velocity to account for the gravitational affect.
    particles[index].setVelocityY(particles[index].getVelocityY()+ .3f);
    // Creates a circle based on the values of the Particle Object.
    Utility.circle(particles[index].getPositionX(), particles[index].getPositionY(),
        particles[index].getSize());
    // Fills the circle with correct color/transparency based on the values of the Particle Object.
    Utility.fill(particles[index].getColor(), particles[index].getTransparency());
    // Sets the new position of the particle based on velocity value.
    particles[index].setPositionX(particles[index].getPositionX() +
        particles[index].getVelocityX());
    particles[index].setPositionY(particles[index].getPositionY() +
        particles[index].getVelocityY());
    // Sets the new age of the particle.
    particles[index].setAge(particles[index].getAge() + 1);
  }

  /**
   * Updates the fountain of particles.
   */
  public static void update() {
    Utility.background(Utility.color(235, 213, 186)); // Sets the background color.
    createNewParticles(10);; // Creates new particles.
    for (int i = 0; i < particles.length; i++) { // Iterates through the particle array.
      if (particles[i] != null) { // Checks if the index is null.
        updateParticle(i); // Updates the particle if it exists.
      }
    }
    removeOldParticles(80); // Removes old particles.

  }

  /**
   * Sets up the intitial values of the particle fountain.
   */
  public static void setup(){
    particles = new Particle[800]; // Initializes particle array.
    // Runs test methods against updateParticle and removeOldParticles.
    if (!testUpdateParticle()|| !testRemoveOldParticles()) {
      System.out.println("FAILED");
    }
    positionX = 400; // Sets initial X-Position.
    positionY = 300; // Sets initial Y-Position.
    startColor = Utility.color(23, 141, 235); // Sets the start color of particles.
    endColor = Utility.color(23,200,255); // Sets the end color of of particles.
  }

  /**
   * Runs the fountain application.
   *
   * @param args None
   */
  public static void main(String[] args){
    Utility.runApplication();
  }
}
