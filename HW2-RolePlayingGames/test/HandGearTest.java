import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * HandGear class JUnit test. 
 * @author Ugo Nwachuku
 *
 */
public class HandGearTest {

  HandGear test;
  /**
   * Set up variables for HandGear test.
   */
  @Before
  public void setup() {
   test = new HandGear("Strong gloves", 30);
  }
  
  /**
   * Constructor test. We ensure constructor stores desired values testing for
   * valid inputs.
   */
  @Test
  public void testInputs() {
    assertEquals("Strong gloves", test.name);
    assertEquals(30, test.attack);
    assertEquals(0, test.defense);
  }
 
  /** 
   * toString test. We ensure toString method prints out values as expected. 
   */
  @Test
  public void toStringtest(){ 
    assertEquals("Strong gloves, Attack: 30, Defense: 0", test.toString());
  }
  /**
   * Assertion test: Test no name inputed in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoName() { 
    HandGear test = new HandGear("", 2);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test illegal name inputed in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalName() { 
    HandGear test = new HandGear("Tom and Jerry", 2);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test negative value in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeDefense() { 
    HandGear test = new HandGear("Strong gloves", -2);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * setName, tests the correct name is set.
   */
  @Test
  public void testsetName() {
    test.setName("Sloppy gloves");
    assertEquals("Sloppy gloves", test.name);
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
    test.setName("Ugly weak gloves");
  }
  
  /**
   * getName, tests the getting the correct name.
   */
  @Test
  public void testgetName() {
    assertEquals("Strong gloves", test.getName());
  }
  
  /**
   * getAdjective, tests the getting the correct adjective.
   */
  @Test
  public void testgetAdjective() {
    assertEquals("Strong", test.getAdjective());
  }
  
  /**
   * setDefense, tests the setAttack function works.
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
   * getDefense, tests the getAttack function works.
   */
  @Test
  public void testgetAttack() {
    assertEquals(30, test.getAttack());
  }
  
  /**
   * getAttack, tests the getDefensefunction works.
   */
  @Test
  public void testgetDefense() {
    assertEquals(0, test.getDefense());
  }

}

