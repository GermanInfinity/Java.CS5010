package BirdAnimal;

import java.util.ArrayList;
import java.util.Arrays;

public class Waterfowls extends Shorebirds {

  private String[] Waterfowls_Bird_Types = { "Ducks", "Swans", "Geese" };
  private String[] Bird_CharacList = { "Live near freshwater", "Live near saltwater" };
  private String[] Bird_WaterBodyList = { "Freshwater", "Saltwater" };
  public ArrayList<String> closeBodyOfWater;

  /**
   * Constructs a Waterfowls bird object that has the type of bird,
   * characteristics, if it is existing, number of wings, and food preference.
   * 
   * @param birdType the type of Waterfowls bird
   * @param characList the list of Waterfowls bird characteristics
   * @param extinct if the particular Waterfowls bird is extinct
   * @param numWings the number of wings the Waterfowls bird has
   * @param prefFood the food preference of the Waterfowls bird
   * 
   */
  public Waterfowls(String birdType, ArrayList<String> characList, Boolean extinct, int numWings,
      ArrayList<String> prefFood, ArrayList<String> BodyOfWater) {
    super(2);

    ConstructorAssertions(birdType, characList, extinct, numWings, prefFood);
    this.TypeOfBird = birdType;
    this.BirdCharac = characList;
    this.isExtinct = extinct;
    this.WingsNum = numWings;
    this.FoodPref = prefFood;
    this.closeBodyOfWater = BodyOfWater;
  }

  @Override
  public String toString() {

    return "Type: " + this.TypeOfBird + ", Characteristics: " + this.BirdCharac + ", Is Extinct: "
        + this.isExtinct + ", Wing numbers: " + this.WingsNum + ", Food preference: "
        + this.FoodPref + ", Closest body of water: " + this.closeBodyOfWater;
  }

  /**
   * getbodyOfWater returns the body of water in the waterfowl object.
   */
  public ArrayList<String> getBodyOfWater() {
    return this.closeBodyOfWater;
  }

  @Override
  protected void addCharac(String charac) {

    if (Arrays.asList(Bird_CharacList).contains(charac) == false) {
      throw new IllegalArgumentException(charac + " is not a Waterfowl Bird characteristic.");
    }

    Boolean add = true;
    if (this.BirdCharac.contains(charac)) {
      add = false;
    }
    if (add) {
      this.BirdCharac.add(charac);
    }

  }

  @Override
  protected void removeCharac(String charac) {

    if (Arrays.asList(Bird_CharacList).contains(charac) == false) {
      throw new IllegalArgumentException(charac + " is not a Waterbirds Bird characteristic.");
    }

    if (this.BirdCharac.contains(charac)) {
      if (this.BirdCharac.size() == 1) {
        throw new IllegalArgumentException("The bird object must have 1 characteristic!");
      }
      this.BirdCharac.remove(charac);
    } else {
      throw new IllegalArgumentException(
          charac + " is not the Waterbirds Bird objects characteristic.");
    }

  }

  @Override
  protected void setBodyOfWater(ArrayList<String> Waterbody) {

    for (int i = 0; i < Waterbody.size(); i++) {
      if (Arrays.asList(Bird_WaterBodyList).contains(Waterbody.get(i)) == false) {
        throw new IllegalArgumentException(
            Waterbody.get(i) + " is not a Waterfowls Bird body of water.");
      }
    }
    if (Waterbody.size() == 0) {
      throw new IllegalArgumentException("Cannot set empty Water body list.");
    }
    this.closeBodyOfWater = Waterbody;
  }

  @Override
  protected void addBodyOfWater(String Waterbody) {

    if (Arrays.asList(Bird_WaterBodyList).contains(Waterbody) == false) {
      throw new IllegalArgumentException(Waterbody + " is not a Waterfowl Bird body of water");
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
  protected void removeBodyOfWater(String Waterbody) {

    if (Arrays.asList(Bird_WaterBodyList).contains(Waterbody) == false) {
      throw new IllegalArgumentException(Waterbody + " is not a Waterfowls Bird body of water");
    }

    if (this.closeBodyOfWater.contains(Waterbody)) {
      if (this.closeBodyOfWater.size() == 1) {
        throw new IllegalArgumentException("The Shorebird object must have 1 body of water!");
      }
      this.closeBodyOfWater.remove(Waterbody);
    } else {
      throw new IllegalArgumentException(Waterbody + " is not a Waterfowls Bird body of water.");
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
    if (!Arrays.asList(Waterfowls_Bird_Types).contains(birdType)) {
      throw new IllegalArgumentException(birdType + " is not a Waterfowls Bird.");
    }

    /**
     * Bird characteristic assertion.
     */
    for (int i = 0; i < characList.size(); i++) {
      if (!Arrays.asList(Bird_CharacList).contains(characList.get(i))) {
        throw new IllegalArgumentException(
            characList.get(i) + " is not a Waterfowls Bird characteristic.");
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
