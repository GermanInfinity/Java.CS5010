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
   * setValid test. We set the valid parameter of a WearableGear object. 
   */
  @Test
  public void testsetValid(){ 
    test.setValid(false);
    assertEquals(false, test.isValid);
  }
  /** 
   * getValid test. We set the valid parameter of a WearableGear object. 
   */
  @Test
  public void testgetValid(){ 
    assertEquals(true, test.getValid());
  }
  /** 
   * setCombined test. We set the combined parameter of a WearableGear object. 
   */
  @Test
  public void testsetCombined(){ 
    test.setCombined(true);
    assertEquals(true, test.isCombined);
  }
  /** 
   * getCombined test. We set the combined parameter of a WearableGear object. 
   */
  @Test
  public void testgetCombined(){ 
    assertEquals(false, test.getCombined());
  }
  /**
   * equals test this returns true.
   */
  @Test 
  public void testequals() { 
    HeadGear test2 = new HeadGear("Strong hat", 30, false, true);
    assertEquals(true, test.equals(test2));
    HandGear test3 = new HandGear("Strong hand", 30, false, true);
    assertEquals(false, test.equals(test3));
  }
  /**
   * testCombine tests the dummy combine function
   */
  @Test 
  public void testCombine(){ 
    HandGear test2 = new HandGear("Hairy hands", 2, false, true);
    WearableGear res = test.combine(test2);
    assertEquals("Dummy gear", res.getName());
    assertEquals(false, res.getValid());
    assertEquals(0, res.getDefense());
  }
  /**
   * equalsHandgear test this returns false.
   */
  @Test 
  public void testequalsHeadgearFalse() { 
    HandGear test2 = new HandGear("Strong gloves", 30, false, true);
    assertEquals(false, test2.equalsHeadGear(test));
  }
  /**
   * equalsFootwear test this returns false.
   */
  @Test 
  public void testequalsFootwear() { 
    HeadGear test2 = new HeadGear("Strong gloves", 30, false, true);
    assertEquals(false, test.equalsFootwear(test2));
  }
  /**
   * equalsHandGear test this returns false.
   */
  @Test 
  public void testequalsHandGear() { 
    HeadGear test2 = new HeadGear("Strong hat", 30, false, true);
    assertEquals(false, test.equalsHandGear(test2));
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
  @Test(expected = IllegalArgumentException.class)
  public void testsetAttack() {
    test.setAttack(46);
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

