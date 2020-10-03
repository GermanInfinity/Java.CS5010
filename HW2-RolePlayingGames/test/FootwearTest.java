import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Footwear class JUnit test. 
 * @author Ugo Nwachuku
 *
 */
public class FootwearTest {

  Footwear test;
  /**
   * Set up variables for Footwear test.
   */
  @Before
  public void setup() {
   test = new Footwear("Heavy boots", 30, 45);
  }
  
  /**
   * Constructor test. We ensure constructor stores desired values testing for
   * valid inputs.
   */
  @Test
  public void testInputs() {
    assertEquals("Heavy boots", test.name);
    assertEquals(30, test.attack);
    assertEquals(45, test.defense);
  }
 
  /** 
   * toString test. We ensure toString method prints out values as expected. 
   */
  @Test
  public void toStringtest(){ 
    assertEquals("Heavy boots, Attack: 30, Defense: 45", test.toString());
  }
  /**
   * Assertion test: Test no name inputed in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoName() { 
    Footwear test = new Footwear("", 2, 13);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test illegal name inputed in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalName() { 
    Footwear test = new Footwear("Tom and Jerry", 2, 13);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test negative defense value in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeDefense() { 
    Footwear test = new Footwear("Heavy boots", -2, 12);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test negative attack value in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAttack() { 
    Footwear test = new Footwear("Heavy boots", 2, -12);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * setName, tests the correct name is set.
   */
  @Test
  public void testsetName() {
    test.setName("Thick shoes");
    assertEquals("Thick shoes", test.name);
  }
  
  /**
   * Assertion test: Test illegal empty name in setName function.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalSetEmptyName() { 
    test.setName("");
  }
  
  /**
   * Assertion test: Test illegal name in setName function.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalSetName() { 
    test.setName("Ugly weak boots");
  }
  
  /**
   * getName, tests the getting the correct name.
   */
  @Test
  public void testgetName() {
    assertEquals("Heavy boots", test.getName());
  }
  
  /**
   * getAdjective, tests the getting the correct adjective.
   */
  @Test
  public void testgetAdjective() {
    assertEquals("Heavy", test.getAdjective());
  }
  
  /**
   * setAttack, tests the setAttack function works.
   */
  @Test
  public void testsetAttack() {
    test.setAttack(46);
    assertEquals(46, test.attack);
  }
  
  /**
   * setAttack, tests the illegal attack set.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testsetIllegalAttack() {
    test.setAttack(-46);
  }
  
  /**
   * getAttack, tests the getAttack function works.
   */
  @Test
  public void testgetAttack() {
    assertEquals(30, test.getAttack());
  }
  
  /**
   * setDefense, tests the setDefense function works.
   */
  @Test
  public void testsetDefense() {
    test.setDefense(46);
    assertEquals(46, test.defense);
  }
  
  /**
   * setDefense, tests the illegal defense set.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testsetIllegalDefense() {
    test.setDefense(-46);
  }
  
  
  /**
   * getDefense, tests the getDefensefunction works.
   */
  @Test
  public void testgetDefense() {
    assertEquals(45, test.getDefense());
  }

}

