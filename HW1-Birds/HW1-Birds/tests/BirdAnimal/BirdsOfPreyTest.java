package BirdAnimal;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the BirdsOfPrey class.
 * 
 */
public class BirdsOfPreyTest {

  BirdsOfPrey test;

  /**
   * Creating Test Data.
   * 
   */
  @Before
  public void setup() {

    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("buds");
    Foodlist.add("larvae");

    test = new BirdsOfPrey("Hawks", Characlist, false, 0, Foodlist);
  }

  /**
   * Constructor test. We ensure constructor stores desired values Testing for
   * Valid Inputs.
   * 
   */
  @Test
  public void testInputs() {
    String expectedOutput = "Type: Hawks, Characteristics: [Sharp beaks], Is Extinct: "
                              + "false, Wing numbers: 0, Food preference: [buds, larvae]";

    ArrayList<String> CharaclistTest = new ArrayList<String>();
    CharaclistTest.add("Sharp beaks");

    ArrayList<String> FoodlistTest = new ArrayList<String>();
    FoodlistTest.add("buds");
    FoodlistTest.add("larvae");

    assertEquals("Hawks", test.TypeOfBird);
    assertTrue("Both character lists are not equal", CharaclistTest.equals(test.BirdCharac));
    assertFalse("Is extinct parameters are not similar.", test.isExtinct);
    assertEquals(0, test.WingsNum, 0);
    assertTrue("Both food lists are not equal", FoodlistTest.equals(test.FoodPref));
    assertEquals(expectedOutput, test.toString());
  }

  /**
   * Test the to string method.
   */
  @Test
  public void testtoString() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");
    Foodlist.add("buds");

    test = new BirdsOfPrey("Eagles", Characlist, false, 0, Foodlist);
    String expectedOutput = "Type: Eagles, Characteristics: [Sharp beaks], Is Extinct: "
                             + "false, Wing numbers: 0, Food preference: [fish, buds]";
    assertEquals(expectedOutput, test.toString());
  }

  /**
   * 
   * Test the getType function works as expected.
   */
  @Test
  public void testgetType() {
    assertEquals("Hawks", test.getType());
  }

  /**
   * Test the getCharac function works as expected.
   * 
   */
  @Test
  public void testgetCharac() {
    ArrayList<String> CharaclistTest = new ArrayList<String>();
    CharaclistTest.add("Sharp beaks");
    assertTrue("Both character lists are not equal", 
                           CharaclistTest.equals(test.getCharac()));
  }

  /**
   * Test the getisExtinct function works as expected.
   * 
   */
  @Test
  public void testgetisExtinct() {
    assertFalse("Is extinct parameters are not similar.", test.getisExtinct());
  }

  /**
   * Test the getNumOfWings function works as expected.
   * 
   */
  @Test
  public void testgetNumOfWings() {
    assertEquals(0, test.getNumOfWings(), 0);
  }

  /**
   * Test the getFoodPref function works as expected.
   * 
   */
  @Test
  public void testgetFoodPref() {
    ArrayList<String> FoodlistTest = new ArrayList<String>();
    FoodlistTest.add("buds");
    FoodlistTest.add("larvae");
    assertTrue("Both food lists are not equal", 
                           FoodlistTest.equals(test.getFoodPref()));
  }

  /**
   * Test add a character to character list.
   * 
   */
  @Test
  public void testaddCharac() {
    test.addCharac("Hooked beaks");

    ArrayList<String> CharaclistTest = new ArrayList<String>();
    CharaclistTest.add("Sharp beaks");
    CharaclistTest.add("Hooked beaks");

    assertTrue("Both character lists are not equal", 
                            CharaclistTest.equals(test.getCharac()));

  }

  /**
   * Assertion test: Test add character that is already in the list.
   * 
   */
  @Test
  public void testaddSameCharac() {
    test.addCharac("Sharp beaks");
  }

  /**
   * Test set character list of an object.
   * 
   */
  @Test
  public void testsetCharac() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Hooked beaks");
    test.setCharac(Characlist);

    ArrayList<String> CharaclistTest = new ArrayList<String>();
    CharaclistTest.add("Hooked beaks");

    test.setCharac(CharaclistTest);
    assertTrue("Both character lists are not equal", 
                           CharaclistTest.equals(test.getCharac()));

  }

  /**
   * Test remove character from character list of an object.
   */
  @Test
  public void testremoveCharac() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");
    Characlist.add("Hooked beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("buds");
    Foodlist.add("larvae");

    test = new BirdsOfPrey("Hawks", Characlist, false, 0, Foodlist);
    test.removeCharac("Sharp beaks");

    ArrayList<String> CharaclistTest2 = new ArrayList<String>();
    CharaclistTest2.add("Hooked beaks");
    assertTrue("Both character lists are not equal", 
                          CharaclistTest2.equals(test.getCharac()));
  }

  /**
   * Test the setType function works as expected.
   */
  @Test
  public void testsetType() {
    test.setType("Osprey");
    assertEquals("Osprey", test.TypeOfBird);
  }

  /**
   * Test the setisExtinct function works as expected.
   */
  @Test
  public void testsetisExtinct() {
    test.setisExtinct(true);
    assertTrue("Is extinct parameters are not similar.", test.getisExtinct());
  }

  /**
   * Test the setNumOfWings function works as expected.
   */
  @Test
  public void testsetWingsNum() {
    test.setWingsNum(1);
    assertEquals(1, test.getNumOfWings());
  }

  /**
   * Test add a food to food preference list.
   */
  @Test
  public void testaddFoodPref() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("buds");
    Foodlist.add("fruit");

    test = new BirdsOfPrey("Hawks", Characlist, false, 0, Foodlist);

    test.addFoodPref("other birds");

    ArrayList<String> FoodlistTest = new ArrayList<String>();
    FoodlistTest.add("buds");
    FoodlistTest.add("fruit");
    FoodlistTest.add("other birds");

    assertTrue("Both food lists are not equal", FoodlistTest.equals(test.getFoodPref()));

  }

  /**
   * Test set food preference of an object.
   */
  @Test
  public void testsetFoodPref() {

    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");
    Foodlist.add("buds");

    test = new BirdsOfPrey("Hawks", Characlist, false, 0, Foodlist);

    ArrayList<String> FoodlistTest = new ArrayList<String>();
    FoodlistTest.add("fish");
    FoodlistTest.add("buds");

    test.setFoodPref(FoodlistTest);
    assertTrue("Both character lists are not equal", FoodlistTest.equals(test.getFoodPref()));

  }

  /**
   * Test remove food from food preference list of an object.
   */
  @Test
  public void testremoveFoodPref() {

    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("buds");
    Foodlist.add("fish");
    Foodlist.add("larvae");

    test = new BirdsOfPrey("Hawks", Characlist, false, 0, Foodlist);
    test.removeFoodPref("buds");

    ArrayList<String> FoodlistTest = new ArrayList<String>();
    FoodlistTest.add("fish");
    FoodlistTest.add("larvae");

    assertTrue("Both character lists are not equal", FoodlistTest.equals(test.getFoodPref()));

  }

  /**
   * Assertion test: Test the setType function catches a wrong type.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testsetWrongType() {
    test.setType("Kiwis");
  }

  /**
   * Assertion test: Test add character function catches a wrong character
   * added.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testaddWrongCharac() {
    test.addCharac("Cannot dance");
  }

  
  /**
   * Assertion test on invalid bird type constructed.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidBirdType() {

    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");

    test = new BirdsOfPrey("Emus", Characlist, false, 0, Foodlist);

  }

  /**
   * Assertion test on invalid bird characteristic constructed.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCharacteristic() {

    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Feeds on prey");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");

    test = new BirdsOfPrey("Hawks", Characlist, false, 0, Foodlist);

  }

  /**
   * Assertion test on adding an invalid bird characteristic.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddInvalidCharacteristic() {

    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");

    test = new BirdsOfPrey("Hawks", Characlist, false, 0, Foodlist);
    test.addCharac("Lives in a cave");

  }

  /**
   * Assertion test on setting an invalid bird characteristic list.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetInvalidCharacteristic() {

    ArrayList<String> CharaclistTest = new ArrayList<String>();
    CharaclistTest.add("Eats it's own feet!");
    test.setCharac(CharaclistTest);

  }

  /**
   * Assertion test on setting an invalid food list
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testtSetInvalidFoodlist() {

    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Hooked beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");
    Foodlist.add("berries");

    test = new BirdsOfPrey("Hawks", Characlist, false, 0, Foodlist);

    ArrayList<String> FoodlistTest = new ArrayList<String>();
    FoodlistTest.add("oat meal");
    FoodlistTest.add("milk");

    test.setFoodPref(FoodlistTest);

  }

  /**
   * Assertion test on adding an invalid food.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddInvalidFood() {

    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");

    test = new BirdsOfPrey("Hawks", Characlist, false, 0, Foodlist);
    test.addFoodPref("Potatoes");

  }

  /**
   * Edge case and assertion test on invalid number of wings constructed(lower
   * bound).
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegNumOfWings() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");

    test = new BirdsOfPrey("Hawks", Characlist, false, -89, Foodlist);
  }

  /**
   * Edge case and assertion test on invalid number of wings constructed(upper
   * bound).
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMaxNumOfWings() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");

    test = new BirdsOfPrey("Hawks", Characlist, false, 3, Foodlist);
  }

  /**
   * Edge case and assertion test on invalid number of food preferences(upper
   * bound).
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMaxFoodPref() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");
    Foodlist.add("berries");
    Foodlist.add("other birds");
    Foodlist.add("buds");
    Foodlist.add("larvae");

    test = new BirdsOfPrey("Hawks", Characlist, false, 3, Foodlist);
  }

  /**
   * Edge case and assertion test on invalid number of food preferences(lower
   * bound).
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMiinFoodPref() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("larvae");

    test = new BirdsOfPrey("Hawks", Characlist, false, 3, Foodlist);
  }

  /**
   * Edge case and assertion test on invalid number of wings set(lower bound).
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetnegNumOfWings() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");

    test = new BirdsOfPrey("Hawks", Characlist, false, 2, Foodlist);
    test.setWingsNum(-1);
  }

  /**
   * Edge case and assertion test on invalid number of wings set(upper bound).
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetmaxNumOfWings() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");

    test = new BirdsOfPrey("Hawks", Characlist, false, 2, Foodlist);
    test.setWingsNum(10);
  }

  /**
   * Edge case and assertion test on invalid number of characteristics.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCharacNum() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");

    test = new BirdsOfPrey("Hawks", Characlist, false, 2, Foodlist);
    test.removeCharac("Sharp beaks");
  }

  /**
   * Edge case and assertion test on removing a characteristic.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveIllegalCharac() {
    test.removeCharac("Dancing in the moonlight");
  }

  /**
   * Edge case and assertion test on removing the last characteristic.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveLastCharac() {
    test.removeCharac("Sharp beaks");
  }

  /**
   * Edge case and assertion test on removing the wrong characteristic.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveWrongCharac() {
    test.removeCharac("Hooked beaks");
  }

  /**
   * Edge case and assertion test on invalid number of food removed(lower
   * bound).
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFoodNumMin() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");
    Foodlist.add("larvae");

    test = new BirdsOfPrey("Hawks", Characlist, false, 2, Foodlist);
    test.removeFoodPref("fish");
  }

  /**
   * Edge case and assertion test on invalid number of food added(upper bound).
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFoodNumMax() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");
    Foodlist.add("larvae");
    Foodlist.add("berries");
    Foodlist.add("fruit");

    test = new BirdsOfPrey("Hawks", Characlist, false, 2, Foodlist);
    test.addFoodPref("other birds");
  }

  /**
   * Edge case and assertion test on setting invalid number of food(upper
   * bound).
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetInvalidFoodNumMax() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");
    Foodlist.add("larvae");
    Foodlist.add("berries");
    Foodlist.add("fruit");

    test = new BirdsOfPrey("Hawks", Characlist, false, 2, Foodlist);

    ArrayList<String> FoodlistTest = new ArrayList<String>();
    FoodlistTest.add("fish");
    FoodlistTest.add("larvae");
    FoodlistTest.add("berries");
    FoodlistTest.add("fruit");
    FoodlistTest.add("other birds");
    test.setFoodPref(FoodlistTest);

  }

  /**
   * Edge case and assertion test on setting invalid number of food(lower
   * bound).
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetInvalidFoodNumMin() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");
    Foodlist.add("larvae");

    test = new BirdsOfPrey("Hawks", Characlist, false, 2, Foodlist);
    ArrayList<String> FoodlistTest = new ArrayList<String>();
    FoodlistTest.add("berries");

    test.setFoodPref(FoodlistTest);
  }

  /**
   * Edge case and assertion testing -- adding a wrong food preference.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testaddWrongFoodPref() {

    test.addFoodPref("Donuts");

  }

  /**
   * Edge case and assertion testing -- adding a present food preference.
   */
  @Test
  public void testaddSimilarFoodPref() {
    test.addFoodPref("buds");
  }

  /**
   * Edge case and assertion testing -- setting wrong wing number(lower bound).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testsetMinWrongWingsNum() {

    test.setWingsNum(-40);

  }

  /**
   * Edge case and assertion testing -- setting wrong wing number(upper bound).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testsetMaxWrongWingsNum() {

    test.setWingsNum(40);

  }

  /**
   * Edge case and assertion testing -- when food is not in global food list.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testsetWrongFoodPref() {

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("fish");
    Foodlist.add("buds");
    Foodlist.add("Hamburgers");

    test.setFoodPref(Foodlist);

  }

  /**
   * Edge case and assertion testing -- remove food preference of unlisted food.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testremoveWrongFoodPref() {

    test.removeFoodPref("Onions");

  }

  /**
   * Edge case and assertion testing -- remove unchosen food preference.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testremoveUnchosenFoodPref() {

    test.removeFoodPref("fruit");

  }

  /**
   * Assertion test: Test the object is constructed with more food preferences.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMaxFoodPrefConstructor() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("buds");
    Foodlist.add("fish");
    Foodlist.add("larvae");
    Foodlist.add("fruit");
    Foodlist.add("other birds");

    test = new BirdsOfPrey("Hawks", Characlist, false, 0, Foodlist);
  }

  /**
   * Assertion test: Test the object is constructed with a wrong food
   * preference.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testWrongFoodPrefConstructor() {
    ArrayList<String> Characlist = new ArrayList<String>();
    Characlist.add("Sharp beaks");

    ArrayList<String> Foodlist = new ArrayList<String>();
    Foodlist.add("buds");
    Foodlist.add("Hotdogs");
    Foodlist.add("larvae");
    Foodlist.add("fruit");

    test = new BirdsOfPrey("Hawks", Characlist, false, 0, Foodlist);
  }
}
