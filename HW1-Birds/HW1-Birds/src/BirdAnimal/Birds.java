package BirdAnimal;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This abstract class represents an abstraction of methods and attributes
 * for different kinds of birds. 
 * The different kinds of birds include: Shorebirds, Waterfowl, Parrots, 
 * Birds of Prey, Owls, Pigeons and flightless birds. 
 * This class implements a superclass each of these kinds of birds can 
 * inherit from and extend. 
 * 
 */

public abstract class Birds {
  
  protected String TypeOfBird; 
  protected ArrayList<String> BirdCharac;
  protected ArrayList<String> FoodPref;
  protected Boolean isExtinct;
  protected int WingsNum;
  public String[] FoodPrefList = {"berries", "seeds", "fruit", "insects", "other birds",  
      "eggs", "small mammals", "fish", "buds", "larvae", "aquatic invertebrates", "nuts",
      "vegetation"};
  
  /**
   * Abstract method: sets type of bird
   */
  protected abstract void setType(String birdType); 
  
  
  /**
   * Concrete method: returns type of bird
   */
  public String getType() { 
    return this.TypeOfBird;
  }
  
  /**
   * Abstract method: sets characteristic of bird
   */
  protected abstract void setCharac(ArrayList<String> characList); 
  /**
   * Abstract method: adds characteristic of bird
   */
  protected abstract void addCharac(String characAdd); 
  /**
   * Abstract method: removes characteristic of bird
   */
  protected abstract void removeCharac(String charac_remove); 
  
  
  /**
   * Concrete method: gets characteristic of bird
   */
  public ArrayList<String> getCharac() { 
    return this.BirdCharac;
  }
  

  /**
   * Concrete method: Set's the food preference of a bird object. 
   *                  Accepts an array of strings and returns nothing. 
   * 
   */
  protected void setFoodPref(ArrayList<String> PrefFood) 
  {
    
    for (int i = 0; i < PrefFood.size(); i++) 
    {
      if (Arrays.asList(FoodPrefList).contains(PrefFood.get(i)) == false) {
        throw new IllegalArgumentException(
            PrefFood.get(i) + " is not a Food preference for birds.");
      }
    }
    if (PrefFood.size() < 2 || PrefFood.size() > 4) { 
      throw new IllegalArgumentException(
          "A bird must have 2-4 food preferences.");
    }
    
    this.FoodPref = PrefFood; 
  }
  

  /**
   * Concrete method: Adds food to food preference of a bird object. 
   *                  Accepts a strings and returns nothing. 
   * 
   */
  protected void addFoodPref(String PrefFood) 
  {
    
    if (Arrays.asList(FoodPrefList).contains(PrefFood) == false){
      throw new IllegalArgumentException(
          PrefFood + " is not a food choice for birds.");
    }
    
    Boolean add = true; 
    if (this.FoodPref.contains(PrefFood)){
      add = false; 
    }
    if (add) { 
      if (this.FoodPref.size() == 4){
        throw new IllegalArgumentException(
            "A bird cannot have more than 4 food preferences.");
      }
      this.FoodPref.add(PrefFood);
    } 
  }
  
  
  /**
   * Concrete method: Remove a food preference of a bird object. 
   *                  Accepts a strings and returns nothing. 
   * 
   */
  protected void removeFoodPref(String PrefFood) 
  {
   
    if (Arrays.asList(FoodPrefList).contains(PrefFood) == false) {
      throw new IllegalArgumentException(
          PrefFood + " is not a Bird characteristic.");
    }
    
    
    if (this.FoodPref.contains(PrefFood)){
      if (this.FoodPref.size() == 2){
        throw new IllegalArgumentException(
            "A bird cannot have less than 2 food preferences.");
      }
      this.FoodPref.remove(PrefFood);
    }
    else
    {
      throw new IllegalArgumentException(
          PrefFood + " is not a food preference for the Bird object.");
    }  
    
  }
  
  
  /**
   * Concrete method: gets food preference of bird
   */
  public ArrayList<String> getFoodPref() { 
    return this.FoodPref;
  }
  
  
  /** 
   * Concrete method: Set's extinct value of a bird object.
   * 
   */
  protected void setisExtinct(Boolean isExt) 
  {
    this.isExtinct = isExt; 
  }
  

  /**
   * Concrete method: Set's number of wings of a bird object.
   * 
   */
  protected void setWingsNum(int wingNo) 
  {
    if (wingNo > 2 || wingNo < 0) { 
      throw new IllegalArgumentException( 
          "Birds cannot have more than 2 wings or negative number of wings.");
    }
    this.WingsNum = wingNo; 
  }
  
  
  /**
   * Concrete method: gets extinct value of bird
   */
  public Boolean getisExtinct() { 
    return this.isExtinct;
  }
  
  /**
   * Concrete method: gets number of wings of bird
   */
  public int getNumOfWings() { 
    return this.WingsNum;
  }
  
}
