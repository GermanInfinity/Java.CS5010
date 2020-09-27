package BirdAnimal;

import java.util.ArrayList;
import java.util.Arrays;

public class Parrots extends Birds {

  private String[] ParrotTypes = { "Rose-ringed parakeet", "Gray parrot",
      "Sulfur-crested cockatoo" };
  private String[] Bird_CharacList = { "Short beak", "Intelligence" };
  protected int numOfVocabWords;
  protected String favWord;

  /**
   * Constructs a Parrots bird object that has the type of bird,
   * characteristics, if it is existing, number of wings, and food preference.
   * 
   * @param birdType the type of Parrots bird
   * @param characList the list of Parrots bird characteristics
   * @param extinct if the particular Parrots bird is extinct
   * @param numWings the number of wings the Parrots bird has
   * @param prefFood the food preference of the Parrots bird
   * @param numOfVocabWords the number of vocabulary words
   * @param favWord the parrot's favorite word
   * 
   */
  public Parrots(String birdType, ArrayList<String> characList, Boolean extinct, int numWings,
      ArrayList<String> prefFood, int numOfVocabWords, String favWord) {

    ConstructorAssertions(birdType, characList, extinct, numWings, prefFood, numOfVocabWords);
    this.TypeOfBird = birdType;
    this.BirdCharac = characList;
    this.isExtinct = extinct;
    this.WingsNum = numWings;
    this.FoodPref = prefFood;
    this.numOfVocabWords = numOfVocabWords;
    this.favWord = favWord;
  }

  @Override
  public String toString() {

    return "Type: " + this.TypeOfBird + ", Characteristics: " + this.BirdCharac + ", Is Extinct: "
        + this.isExtinct + ", Wing numbers: " + this.WingsNum + ", Food preference: "
        + this.FoodPref + ", Number of vocabulary words: " + this.numOfVocabWords
        + ", Favorite word: " + this.favWord;
  }

  @Override
  protected void setType(String birdType) {

    if (Arrays.asList(ParrotTypes).contains(birdType) == false) {
      throw new IllegalArgumentException(birdType + " is not a Parrots Bird.");
    }
    this.TypeOfBird = birdType;
  }

  @Override
  protected void setCharac(ArrayList<String> charac) {

    for (int i = 0; i < charac.size(); i++) {
      if (Arrays.asList(Bird_CharacList).contains(charac.get(i)) == false) {
        throw new IllegalArgumentException(
            charac.get(i) + " is not a Parrots Bird characteristic.");
      }
    }

    if (charac.size() == 0) {
      throw new IllegalArgumentException("Cannot set empty chaarcter list.");
    }

    this.BirdCharac = charac;
  }

  /**
   * Set's the number of vocabulary words of a Parrots bird. Accepts an integer
   * argument and returns nothing.
   * 
   */
  protected void setNumOfvocabWords(int Vocabnum) {

    if (Vocabnum < 0) {
      throw new IllegalArgumentException("Parrot's cannot speak a negative amount of words");
    }
    this.numOfVocabWords = Vocabnum;
  }

  /**
   * Set's the favorite word of a Parrots bird. Accepts a string argument and
   * returns nothing.
   * 
   */
  protected void setFavWord(String favoriteWord) {
    this.favWord = favoriteWord;
  }

  /**
   * Adds the characteristic of a Parrots bird. Accepts a strings and returns
   * nothing.
   * 
   */

  /**
   * Get's the number of vocabulary words of a Parrots bird. Returns an integer.
   * 
   */
  protected int getNumOfvocabWords() {

    return this.numOfVocabWords;
  }

  /**
   * Get's the favorite vocabulary word of a Parrots bird. Returns a String
   * 
   */
  protected String getFavWord() {

    return this.favWord;
  }

  @Override
  protected void addCharac(String charac) {

    if (Arrays.asList(Bird_CharacList).contains(charac) == false) {
      throw new IllegalArgumentException(charac + " is not a Parrots Bird characteristic.");
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
      throw new IllegalArgumentException(charac + " is not a Parrots Bird characteristic.");
    }

    if (this.BirdCharac.contains(charac)) {
      if (this.BirdCharac.size() == 1) {
        throw new IllegalArgumentException("The bird object must have 1 characteristic!");
      }
      this.BirdCharac.remove(charac);
    } else {
      throw new IllegalArgumentException(
          charac + " is not the Parrots Bird objects characteristic.");
    }

  }

  /**
   * ConstructorAssertions handles the error check that must be done on new
   * inputs to the constructor. The purpose of this code is to keep the
   * constructor clean and easy to read.
   * 
   */
  private void ConstructorAssertions(String birdType, ArrayList<String> characList, Boolean extinct,
      int numWings, ArrayList<String> prefFood, int numOfVocabWords) {
    /**
     * Bird Type assertion.
     */
    if (!Arrays.asList(ParrotTypes).contains(birdType)) {
      throw new IllegalArgumentException(birdType + " is not a Parrots Bird.");
    }

    /**
     * Bird characteristic assertion.
     */
    for (int i = 0; i < characList.size(); i++) {
      if (!Arrays.asList(Bird_CharacList).contains(characList.get(i))) {
        throw new IllegalArgumentException(
            characList.get(i) + " is not a Parrots Bird characteristic.");
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
     * Number of words assertion.
     */
    if (numOfVocabWords < 0) {
      throw new IllegalArgumentException("A parrot cannot have negative number of words to speak.");
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
