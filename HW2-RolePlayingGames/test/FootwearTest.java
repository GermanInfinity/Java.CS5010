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
   test = new Footwear("Heavy boots", 30, 45, false, true);
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
   * testIllegalCombine tests the dummy combine function.
   */
  @Test 
  public void testIllegalCombine(){ 
    HandGear test2 = new HandGear("Hairy hands", 2, false, true);
    WearableGear res = test.combine(test2);
    assertEquals("Dummy gear", res.getName());
    assertEquals(false, res.getValid());
    assertEquals(0, res.getDefense());
  }
  /**
   * testCombine tests the combine function between two similar gears.
   */
  @Test 
  public void testCombine(){ 
    Footwear test2 = new Footwear("Big feet",2, 2, false, true);
    WearableGear res = test.combine(test2);
    assertEquals("Heavy, Big feet", res.getName());
    assertEquals(true, res.getValid());
    assertEquals(47, res.getDefense());
  }
  /**
   * equals test this returns false and true.
   */
  @Test 
  public void testequals() { 
    Footwear test3 = new Footwear("Heavy boots", 45, 12, false, true);
    assertEquals(true, test.equals(test3));
    HandGear test4 = new HandGear("Heavy hands", 12, false, true);
    assertEquals(false, test.equals(test4));
  }
  /**
   * equalsFootwear test this returns false and true.
   */
  @Test 
  public void testequalsFootwear() { 
    HandGear test2 = new HandGear("Heavy gloves", 45, false, true);
    assertEquals(false, test2.equalsFootwear(test));
    
    Footwear test3 = new Footwear("Heavy boots", 45, 12, false, true);
    assertEquals(true, test3.equalsFootwear(test));
  }
  /**
   * equalsHeadGear test this returns false.
   */
  @Test 
  public void testequalsHeadGear() { 
    Footwear test2 = new Footwear("Heavy boots", 30, 45, false, true);
    assertEquals(false, test.equalsHeadGear(test2));
  }
  /**
   * equalsHandGear test this returns false.
   */
  @Test 
  public void testequalsHandGear() { 
    Footwear test2 = new Footwear("Heavy boots", 30, 45, false, true);
    assertEquals(false, test.equalsHandGear(test2));
  }
  /**
   * Assertion test: Test no name inputed in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoName() { 
    Footwear test = new Footwear("", 2, 13, false, true);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test illegal name inputed in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalName() { 
    Footwear test = new Footwear("Ed, Edd, and Eddy", 2, 13, false, true);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test negative defense value in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeDefense() { 
    Footwear test = new Footwear("Heavy boots", -2, 12, false, true);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test negative attack value in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAttack() { 
    Footwear test = new Footwear("Heavy boots", 2, -12, false, true);
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

