package BirdAnimal;

import java.util.ArrayList;
import java.util.Arrays;

public class FlightlessBirds extends Birds {

  private String[] Flightless_Bird_Types = { "Emus", "Kiwis", "Moas" };
  private String[] Bird_CharacList = { "Live on ground", "Cannot fly" };

  /**
   * Constructs a Flightless bird object that has the type of bird,
   * characteristics, if it is existing, number of wings, and food preference.
   * 
   * @param birdType the type of flightless bird
   * @param characList the list of flightless bird characteristics
   * @param extinct if the particular flightless bird is extinct
   * @param numWings the number of wings the flightless bird has
   * @param prefFood the food preference of the flightless bird
   * 
   */
  public FlightlessBirds(String birdType, ArrayList<String> characList, Boolean extinct,
      int numWings, ArrayList<String> prefFood) {

    ConstructorAssertions(birdType, characList, extinct, numWings, prefFood);
    this.TypeOfBird = birdType;
    this.BirdCharac = characList;
    this.isExtinct = extinct;
    this.WingsNum = numWings;
    this.FoodPref = prefFood;
  }

  @Override
  public String toString() {

    return "Type: " + this.TypeOfBird + ", Characteristics: " + this.BirdCharac + ", Is Extinct: "
        + this.isExtinct + ", Wing numbers: " + this.WingsNum + ", Food preference: "
        + this.FoodPref;
  }

  @Override
  protected void setType(String birdType) {

    if (Arrays.asList(Flightless_Bird_Types).contains(birdType) == false) {
      throw new IllegalArgumentException(birdType + " is not a Flightless Bird.");
    }
    this.TypeOfBird = birdType;
  }

  @Override
  protected void setCharac(ArrayList<String> charac) {

    for (int i = 0; i < charac.size(); i++) {
      if (Arrays.asList(Bird_CharacList).contains(charac.get(i)) == false) {
        throw new IllegalArgumentException(
            charac.get(i) + " is not a Flightless Bird characteristic.");
      }
    }

    if (charac.size() == 0) {
      throw new IllegalArgumentException("Cannot set empty chaarcter list.");
    }

    this.BirdCharac = charac;
  }

  @Override
  protected void addCharac(String charac) {

    if (Arrays.asList(Bird_CharacList).contains(charac) == false) {
      throw new IllegalArgumentException(charac + " is not a Flightless Bird characteristic.");
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
      throw new IllegalArgumentException(charac + " is not a Flightless Bird characteristic.");
    }

    if (this.BirdCharac.contains(charac)) {
      if (this.BirdCharac.size() == 1) {
        throw new IllegalArgumentException("The bird object must have 1 characteristic!");
      }
      this.BirdCharac.remove(charac);
    } else {
      throw new IllegalArgumentException(
          charac + " is not the Flightless Bird objects characteristic.");
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
    if (!Arrays.asList(Flightless_Bird_Types).contains(birdType)) {
      throw new IllegalArgumentException(birdType + " is not a Flightless Bird.");
    }

    /**
     * Bird characteristic assertion.
     */
    for (int i = 0; i < characList.size(); i++) {
      if (!Arrays.asList(Bird_CharacList).contains(characList.get(i))) {
        throw new IllegalArgumentException(
            characList.get(i) + " is not a Flightless Bird characteristic.");
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
