package BirdAnimal;
import java.util.ArrayList;

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
   * Abstract method: sets food preference of bird
   */
  protected abstract void setFoodPref(ArrayList<String> foodList); 
  /**
   * Abstract method: adds food to food preference of bird
   */
  protected abstract void addFoodPref(String foodAdd); 
  /**
   * Abstract method: removes food from food preference of bird
   */
  protected abstract void removeFoodPref(String foodemove); 
  
  
  /**
   * Concrete method: gets food preference of bird
   */
  public ArrayList<String> getFoodPref() { 
    return this.FoodPref;
  }
  
  
  /**
   * Abstract method: sets extinct value of bird
   */
  protected abstract void setisExtinct(Boolean extinct); 
  /**
   * Abstract method: sets number of wings of bird
   */
  protected abstract void setWingsNum(int numWings); 
  
  
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
