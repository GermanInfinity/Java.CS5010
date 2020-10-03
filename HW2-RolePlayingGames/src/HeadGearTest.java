import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * HeadGear class JUnit test. 
 * @author ugoslight
 *
 */
public class HeadGearTest {

  HeadGear test;
  /**
   * Set up variables for HeadGear test.
   */
  @Before
  public void setup() {
   test = new HeadGear("Fat hat", 2);
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
   * Assertion test: Test no name inputed in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoName() { 
    HeadGear test = new HeadGear("", 2);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test illegal name inputed in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalName() { 
    HeadGear test = new HeadGear("Tom and Jerry", 2);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * Assertion test: Test negative value in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeDefense() { 
    HeadGear test = new HeadGear("Fat hat", -2);
    test.toString(); //remove unused variable warning.
  }
  
  /**
   * setName, tests the correct name is set.
   */
  @Test
  public void setName() {
    test.setName("Slim hat");
    assertEquals("Slim hat", test.name);
  }
  
  /**
   * Assertion test: Test illegal name inputed in constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalName() { 
    HeadGear test = new HeadGear("Tom and Jerry", 2);
    test.toString(); //remove unused variable warning.
  }
  
  

}

