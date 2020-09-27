package BirdAnimal;

import java.util.ArrayList;
import java.util.Arrays;

public class Shorebirds extends Birds {

  private String[] Shorebirds_Bird_Types = { "Great auk", "Horned puffin", "African Jacana" };
  private String[] Bird_CharacList = { "Live near wetlands", "Live near the ocean" };
  private String[] Bird_WaterBodyList = { "Wetlands", "Freshwater", "Saltwater", "Ocean" };
  public ArrayList<String> closeBodyOfWater;

  /**
   * Constructs a Shorebirds bird object that has the type of bird,
   * characteristics, if it is existing, number of wings, and food preference.
   * 
   * @param birdType the type of Shorebirds bird
   * @param characList the list of Shorebirds bird characteristics
   * @param extinct if the particular Shorebirds bird is extinct
   * @param numWings the number of wings the Shorebirds bird has
   * @param prefFood the food preference of the Shorebirds bird
   * 
   */

  public Shorebirds(String birdType, ArrayList<String> characList, Boolean extinct, int numWings,
      ArrayList<String> prefFood, ArrayList<String> BodyOfWater) {
    ConstructorAssertions(birdType, characList, extinct, numWings, prefFood);
    this.TypeOfBird = birdType;
    this.BirdCharac = characList;
    this.isExtinct = extinct;
    this.WingsNum = numWings;
    this.FoodPref = prefFood;
    this.closeBodyOfWater = BodyOfWater;
  }

  /**
   * Dummy constructor. This constructor serves the purpose of being called by
   * the sub class constructor. Since the sub class needs to call a constructor,
   * we use a dummy constructor to avoid errors.
   * 
   * @param i
   */
  public Shorebirds(int i) {
    // TODO Auto-generated constructor stub
  }

  @Override
  public String toString() {

    return "Type: " + this.TypeOfBird + ", Characteristics: " + this.BirdCharac + ", Is Extinct: "
        + this.isExtinct + ", Wing numbers: " + this.WingsNum + ", Food preference: "
        + this.FoodPref + ", Closest body of water: " + this.closeBodyOfWater;
  }

  /**
   * Get's body of water of a Shorebird
   */
  public ArrayList<String> getBodyOfWater() {
    return this.closeBodyOfWater;
  }

  @Override
  protected void setType(String birdType) {

    if (Arrays.asList(Shorebirds_Bird_Types).contains(birdType) == false) {
      throw new IllegalArgumentException(birdType + " is not a Shorebirds Bird.");
    }
    this.TypeOfBird = birdType;
  }

  @Override
  protected void setCharac(ArrayList<String> charac) {

    for (int i = 0; i < charac.size(); i++) {
      if (Arrays.asList(Bird_CharacList).contains(charac.get(i)) == false) {
        throw new IllegalArgumentException(
            charac.get(i) + " is not a Shorebirds Bird characteristic.");
      }
    }

    if (charac.size() == 0) {
      throw new IllegalArgumentException("Cannot set empty chaarcter list.");
    }

    this.BirdCharac = charac;
  }

  /**
   * Set's the body of water of a Shorebirds bird. Accepts an array of strings
   * and returns nothing.
   * 
   */
  protected void setBodyOfWater(ArrayList<String> Waterbody) {

    for (int i = 0; i < Waterbody.size(); i++) {
      if (Arrays.asList(Bird_WaterBodyList).contains(Waterbody.get(i)) == false) {
        throw new IllegalArgumentException(
            Waterbody.get(i) + " is not a Shorebirds Bird body of water.");
      }
    }
    if (Waterbody.size() == 0) {
      throw new IllegalArgumentException("Cannot set empty water body list.");
    }
    this.closeBodyOfWater = Waterbody;
  }

  /**
   * Adds body of water to a Shorebirds bird object. Accepts a strings and
   * returns nothing.
   * 
   */
  protected void addBodyOfWater(String Waterbody) {

    if (Arrays.asList(Bird_WaterBodyList).contains(Waterbody) == false) {
      throw new IllegalArgumentException(Waterbody + " is not a Shorebirds Bird body of water");
    }

    Boolean add = true;
    if (this.closeBodyOfWater.contains(Waterbody)) {
      add = false;
    }
    if (add) {
      this.closeBodyOfWater.add(Waterbody);
    }

  }

  @Override
  protected void addCharac(String charac) {

    if (Arrays.asList(Bird_CharacList).contains(charac) == false) {
      throw new IllegalArgumentException(charac + " is not a Shorebirds Bird characteristic.");
    }

    Boolean add = true;
    if (this.BirdCharac.contains(charac)) {
      add = false;
    }
    if (add) {
      this.BirdCharac.add(charac);
    }

  }

  /**
   * Remove a body of water of a Shorebirds bird. Accepts a strings and returns
   * nothing.
   * 
   */
  protected void removeBodyOfWater(String Waterbody) {

    if (Arrays.asList(Bird_WaterBodyList).contains(Waterbody) == false) {
      throw new IllegalArgumentException(Waterbody + " is not a Shorebirds Bird body of water");
    }

    if (this.closeBodyOfWater.contains(Waterbody)) {
      if (this.closeBodyOfWater.size() == 1) {
        throw new IllegalArgumentException("The Shorebird object must have 1 body of water!");
      }
      this.closeBodyOfWater.remove(Waterbody);
    } else {
      throw new IllegalArgumentException(Waterbody + " is not a Shorebirds Bird body of water.");
    }

  }

  @Override
  protected void removeCharac(String charac) {

    if (Arrays.asList(Bird_CharacList).contains(charac) == false) {
      throw new IllegalArgumentException(charac + " is not a Shorebirds Bird characteristic.");
    }

    if (this.BirdCharac.contains(charac)) {
      if (this.BirdCharac.size() == 1) {
        throw new IllegalArgumentException("The bird object must have 1 characteristic!");
      }
      this.BirdCharac.remove(charac);
    } else {
      throw new IllegalArgumentException(
          charac + " is not the Shorebirds Bird objects characteristic.");
    }

  }

  /**
   * ConstructorAssertions handles the error check that must be done on new
   * inputs to the constructor. The purpose of this code is to keep the
   * constructor clean and easy to read.
   * 
   */
  private void ConstructorAssertions(String birdType, ArrayList<String> characList, Boolean extinct,
      int numWings, ArrayList<String> prefFood) {
    /**
     * Bird Type assertion.
     */
    if (!Arrays.asList(Shorebirds_Bird_Types).contains(birdType)) {
      throw new IllegalArgumentException(birdType + " is not a Shorebirds Bird.");
    }

    /**
     * Bird characteristic assertion.
     */
    for (int i = 0; i < characList.size(); i++) {
      if (!Arrays.asList(Bird_CharacList).contains(characList.get(i))) {
        throw new IllegalArgumentException(
            characList.get(i) + " is not a Shorebirds Bird characteristic.");
      }
    }

    /**
     * Number of wings assertion.
     */
    if (numWings > 2) {
      throw new IllegalArgumentException("A bird cannot have more than 2 wings.");
    }

    /**
     * Number of wings assertion.
     */
    if (numWings < 0) {
      throw new IllegalArgumentException("A bird cannot have negative number of wings.");
    }

    /**
     * Food preference assertion.
     */
    if (prefFood.size() < 2) {
      throw new IllegalArgumentException("A bird must have 2-4 food preferences.");
    }
    if (prefFood.size() > 4) {
      throw new IllegalArgumentException("A bird must have 2-4 food preferences.");
    }
    for (int i = 0; i < prefFood.size(); i++) {
      if (Arrays.asList(FoodPrefList).contains(prefFood.get(i)) == false) {
        throw new IllegalArgumentException(prefFood.get(i) + " is not a Bird food preference.");
      }
    }

  }

}
