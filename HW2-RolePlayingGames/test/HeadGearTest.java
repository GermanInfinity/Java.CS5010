import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * HeadGear class JUnit test. 
 * @author Ugo Nwachuku
 *
 */
public class HeadGearTest {

  HeadGear test;
  /**
   * Set up variables for HeadGear test.
   */
  @Before
  public void setup() {
   test = new HeadGear("Fat hat", 2, false, true);
  }
  
  /**
   * Constructor test. We ensure constructor stores desired values testing for
   * valid inputs.
   */
  @Test
  public void testInputs() {
    assertEquals("Fat hat", test.name);
    assertEquals(0, test.attack);
    assertEquals(2, test.defense);
  }
 
  /** 
   * toString test. We ensure toString method prints out values as expected. 
   */
  @Test
  public void toStringtest(){ 
    assertEquals("Fat hat, Attack: 0, Defense: 2", test.toString());
  }
  /**
   * Assertion test: Test no name inputed in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoName() { 
    HeadGear test = new HeadGear("", 2, false, true);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test illegal name inputed in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalName() { 
    HeadGear test = new HeadGear("Tom and Jerry", 2, false, true);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test negative value in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeDefense() { 
    HeadGear test = new HeadGear("Fat hat", -2, false, true);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * setName, tests the correct name is set.
   */
  @Test
  public void testsetName() {
    test.setName("Slim hat");
    assertEquals("Slim hat", test.name);
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
    test.setName("Tall Scary hat");
  }
  
  /**
   * getName, tests the getting the correct name.
   */
  @Test
  public void testgetName() {
    assertEquals("Fat hat", test.getName());
  }
  
  /**
   * getAdjective, tests the getting the correct adjective.
   */
  @Test
  public void testgetAdjective() {
    assertEquals("Fat", test.getAdjective());
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
   * setAttack, tests the setAttack function works.
   */
  @Test
  public void testsetAttack() {
    test.setAttack(46);
    assertEquals(0, test.attack);
  }
  
  /**
   * getDefense, tests the getDefense function works.
   */
  @Test
  public void testgetDefense() {
    assertEquals(2, test.getDefense());
  }
  
  /**
   * getAttack, tests the getAttack function works.
   */
  @Test
  public void testgetAttack() {
    assertEquals(0, test.getAttack());
  }

}

