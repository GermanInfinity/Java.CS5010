import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Character class JUnit test. 
 * @author Ugo Nwachuku
 *
 */
public class CharacterTest {

  Character test;
  /**
   * Set up variables for Character test.
   */
  @Before
  public void setup() {
   Footwear footGear = new Footwear("Heavy boots", 30, 45, false, true);
   HandGear handGear = new HandGear("Strong gloves", 30, false, true);
   HeadGear headGear = new HeadGear("Fat hat", 2, false, true);
   
   ArrayList<WearableGear> attire = new ArrayList<WearableGear>(); 
   attire.add(footGear);
   attire.add(handGear);
   attire.add(headGear);
   
   test = new Character("Jim Wilson", attire, 30, 45);
  }
  
  /**
   * Constructor test. We ensure constructor stores desired values testing for
   * valid inputs.
   */
  @Test
  public void testInputs() {
    assertEquals("Jim Wilson", test.name);
    assertEquals(30, test.attack);
    assertEquals(45, test.defense);
    
    if (test.attire.get(0) instanceof Footwear) { 
      assertTrue("Correct type", true);
    }
    if (test.attire.get(1) instanceof HandGear) { 
      assertTrue("Correct type", true);
    }
    if (test.attire.get(2) instanceof HeadGear) { 
      assertTrue("Correct type", true);
    }

  }
  
  /**
   * Constructor test. Testing empty string name input.
   */
  @Test
  public void testEmptyNameInput() {
    Footwear footGear = new Footwear("Heavy boots", 30, 45, false, true);
    HandGear handGear = new HandGear("Strong gloves", 30, false, true);
    HeadGear headGear = new HeadGear("Fat hat", 2, false, true);
    
    ArrayList<WearableGear> attire = new ArrayList<WearableGear>(); 
    attire.add(footGear);
    attire.add(handGear);
    attire.add(headGear);
    
    test = new Character("", attire, 30, 45);
    
    assertEquals("unknown", test.name);
  }
  
  /**
   * Constructor test. Testing empty attire list input.
   */
  @Test
  public void testEmptyAttireInput() {
    Footwear footGear = new Footwear("Heavy boots", 30, 45, false, true);
    HandGear handGear = new HandGear("Strong gloves", 30, false, true);
    HeadGear headGear = new HeadGear("Fat hat", 2, false, true);
    
    ArrayList<WearableGear> attire = new ArrayList<WearableGear>(); 
    
    test = new Character("John doe", attire, 30, 45);
    assertEquals(0, test.attack);
    assertEquals(0, test.defense);
  }
  
  /**
   * Constructor Assertion test. Testing negative attack input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegAttackInput() {
    Footwear footGear = new Footwear("Heavy boots", 30, 45, false, true);
    HandGear handGear = new HandGear("Strong gloves", 30, false, true);
    HeadGear headGear = new HeadGear("Fat hat", 2, false, true);
    
    ArrayList<WearableGear> attire = new ArrayList<WearableGear>(); 
    attire.add(footGear);
    attire.add(handGear);
    attire.add(headGear);
    
    test = new Character("", attire, -30, 45);
  }
  
  /**
   * Constructor Assertion test. Testing negative defense input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegDefenseInput() {
    Footwear footGear = new Footwear("Heavy boots", 30, 45, false, true);
    HandGear handGear = new HandGear("Strong gloves", 30, false, true);
    HeadGear headGear = new HeadGear("Fat hat", 2, false, true);
    
    ArrayList<WearableGear> attire = new ArrayList<WearableGear>(); 
    attire.add(footGear);
    attire.add(handGear);
    attire.add(headGear);
    
    test = new Character("", attire, 30, -45);
  }
  
  /** 
   * toString test. We ensure toString method prints out values as expected. 
   */
  @Test
  public void toStringtest(){  
    assertEquals("Jim Wilson Attire: [Heavy boots, Strong gloves, Fat hat], Attack: 30,"
                                              + " Defense: 45", test.toString());
  }
  
  /**
   * setAttire, tests the setting the attire.
   */
  @Test
  public void testsetAttire() {
    Footwear footGear = new Footwear("Strong boots", 30, 45, false, true);
    ArrayList<WearableGear> attire = new ArrayList<WearableGear>(); 
    attire.add(footGear);
    
    test = new Character("John doe", attire, 30, 45);
    
    HeadGear headgear = new HeadGear("Big Head", 45, false, true);
    ArrayList<WearableGear> attire2 = new ArrayList<WearableGear>(); 
    attire2.add(headgear);
    
    test.setAttire(attire2);
    if (test.attire.get(0) instanceof HeadGear) { 
      assertTrue("Correct type", true);
    }
  }
  
  /**
   * getAttire, tests the setting the attire.
   */
  @Test
  public void testgetAttire() {
    HeadGear headgear = new HeadGear("Big Head", 45, false, true);
    ArrayList<WearableGear> attire = new ArrayList<WearableGear>(); 
    attire.add(headgear);

    test = new Character("John doe", attire, 30, 45);
    
    assertEquals(attire, test.getAttire());

  }
  
  /**
   * setName, tests the setting the correct name.
   */
  @Test
  public void testsetName() {
    test.setName("John Doe");
    assertEquals("John Doe", test.getName());
  }
  
  /**
   * setName, tests the setting empty name.
   */
  @Test
  public void testsetEmptyName() {
    test.setName("");
    assertEquals("unknown", test.getName());
  }

  
  /**
   * getName, tests the getting the correct name.
   */
  @Test
  public void testgetName() {
    assertEquals("Jim Wilson", test.getName());
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
   * getDefense, tests the getDefensefunction works.
   */
  @Test
  public void testgetDefense() {
    assertEquals(45, test.getDefense());
  }
  
}
