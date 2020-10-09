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
   test = new HandGear("Strong gloves", 30, false, true);
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
   * testCombine method. Ensures combines gears correctly. 
   */
  @Test
  public void testCombine(){ 
    HandGear test2 = new HandGear("Hairy hands", 2, false, true);
    WearableGear res = test.combine(test2);
    assertEquals("Strong, Hairy hands", res.getName());
    assertEquals(32, res.getAttack());
    assertEquals(0, res.getDefense());
  }
  /**
   * testFalseCombine method. Ensures combines illegal gears combine but return 
   * invalid gears. 
   */
  @Test
  public void testFalseCombine(){ 
    HeadGear test2 = new HeadGear("Hairy head", 2, false, true);
    WearableGear res = test.combine(test2);
    assertEquals("Dummy gear", res.getName());
    assertEquals(false, res.getValid());
    assertEquals(0, res.getAttack());
  }
  /**
   * equals test this returns true.
   */
  @Test 
  public void testequals() { 
    HandGear test2 = new HandGear("Strong hand", 30, false, true);
    assertEquals(true, test.equals(test2));
    HeadGear test3 = new HeadGear("Strong hat", 30, false, true);
    assertEquals(false, test.equals(test3));
  }
  /**
   * equalsHandgear test this returns false.
   */
  @Test 
  public void testequalsHandgear() { 
    HeadGear test2 = new HeadGear("Strong hat", 30, false, true);
    assertEquals(false, test2.equalsHandGear(test));
  }
  /**
   * equalsFootwear test this returns false.
   */
  @Test 
  public void testequalsFootwear() { 
    HandGear test2 = new HandGear("Strong gloves", 30, false, true);
    assertEquals(false, test.equalsFootwear(test2));
  }
  /**
   * equalsHandGear test this returns false.
   */
  @Test 
  public void testequalsHeadGear() { 
    HandGear test2 = new HandGear("Strong gloves", 30, false, true);
    assertEquals(false, test.equalsHeadGear(test2));
  }
  /**
   * Assertion test: Test no name inputed in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoName() { 
    HandGear test = new HandGear("", 2, false, true);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test illegal name inputed in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalName() { 
    HandGear test = new HandGear("Ed, Edd and Eddy", 2, false, true);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test negative value in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeDefense() { 
    HandGear test = new HandGear("Strong gloves", -2, false, true);
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
   * setAttack, tests the setAttack function works.
   */
  @Test
  public void testsetAttack() {
    test.setAttack(46);
    assertEquals(46, test.attack);
  }
  /**
   * setIllegalAttack, tests the setAttack function works for illegal arguements. 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testsetIllegalAttack() {
    test.setAttack(-46);
  }
  
  /**
   * setDefense, tests the setDefense function works.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testsetDefense() {
    test.setDefense(46);
    assertEquals(0, test.defense);
  }
  
 
  /**
   * getAttack, tests the getAttack function works.
   */
  @Test
  public void testgetAttack() {
    assertEquals(30, test.getAttack());
  }
  
  /**
   * getDefense, tests the getDefensefunction works.
   */
  @Test
  public void testgetDefense() {
    assertEquals(0, test.getDefense());
  }

}

