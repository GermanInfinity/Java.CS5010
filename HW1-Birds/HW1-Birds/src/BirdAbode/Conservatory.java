package BirdAbode;

import java.util.ArrayList;
import java.util.Collections;

import BirdAnimal.Birds;
import BirdAnimal.BirdsOfPrey;
import BirdAnimal.FlightlessBirds;
import BirdAnimal.Owls;
import BirdAnimal.Pigeons;

/**
 * This script implements the conservatory class, which is used for storing and
 * tracking of birds in the conservatory.
 * 
 * @author Ugo Nwachuku
 *
 */
public class Conservatory {
  
  private ArrayList<Aviary> inHouseAviaries;
  
  
  /** 
   * Constructor of the Conservatory class, initializes 20 aviaries.
   * Takes no parameters and returns a Conservatory object.
   */
  public Conservatory() 
  {
    this.inHouseAviaries = new ArrayList<Aviary>();
    this.inHouseAviaries.add(new Aviary(false, "1"));
    this.inHouseAviaries.add(new Aviary(false, "2"));
    this.inHouseAviaries.add(new Aviary(false, "3"));
    this.inHouseAviaries.add(new Aviary(false, "4"));
    this.inHouseAviaries.add(new Aviary(false, "5"));
    this.inHouseAviaries.add(new Aviary(false, "6"));
    this.inHouseAviaries.add(new Aviary(false, "7"));
    this.inHouseAviaries.add(new Aviary(false, "8"));
    this.inHouseAviaries.add(new Aviary(false, "9"));
    this.inHouseAviaries.add(new Aviary(false, "10"));
    this.inHouseAviaries.add(new Aviary(false, "11"));
    this.inHouseAviaries.add(new Aviary(false, "12"));
    this.inHouseAviaries.add(new Aviary(false, "13"));
    this.inHouseAviaries.add(new Aviary(false, "14"));
    this.inHouseAviaries.add(new Aviary(false, "15"));
    this.inHouseAviaries.add(new Aviary(false, "16"));
    this.inHouseAviaries.add(new Aviary(false, "17"));
    this.inHouseAviaries.add(new Aviary(false, "18"));
    this.inHouseAviaries.add(new Aviary(false, "19"));
    this.inHouseAviaries.add(new Aviary(false, "20"));

  }
  
  /**
   * getAviary function returns the aviary object in the conservatory.
   * @param takes number of aviary
   */
  public Aviary getAviary(int idx) { 
    if (idx < 20 && idx > 0) { return this.inHouseAviaries.get(idx); } 
    else {
      throw new IllegalArgumentException(
          "There are only 20 aviaries in the conservatory.");
    }
    
  }
  /** 
   * RescueBird function stores a bird object in a desired aviary in the 
   * conservatory.
   * @param bird object.
   */
  public void RescueBird(Birds bird)
  {
    int count = 0;
    Boolean simpleAdd;
    Boolean complexAdd;
    
    if (bird.getisExtinct() == false) 
    {
      for (int i = 0; i < inHouseAviaries.size(); i++)
      {
        Aviary currentAviary = inHouseAviaries.get(i);
        
        if (currentAviary.locked == false)
        {
          simpleAdd = currentAviary.AddSpecialBird(bird);
          complexAdd = currentAviary.AddBird(bird);
          
          //System.out.println(simpleAdd);
          if (simpleAdd) { break; }
          if (complexAdd) { break; }
        }
        
        if (currentAviary.locked == true) { count++; }
      }
      
      if (count == 20) {
        throw new IllegalArgumentException (
            "All the aviaries in the conseratory are full!");
      }
    }
  }
  
  /**
   * FoodQuant function calculates what food needs to be kept and the quantity 
   * across all aviaries in the Conservatory. 
   */
  public String FoodQuant()
  {
    ArrayList<String> totalFood = new ArrayList<String>();;
    
    for (int i = 0; i < inHouseAviaries.size(); i++)
    {
      Aviary aviary = this.inHouseAviaries.get(i);
      ArrayList<String> foodHere = aviary.FoodKept();
      
      for (int idx = 0; idx < foodHere.size(); idx++)
      { 
        totalFood.add(foodHere.get(i));
      }
    }
    
    /* 
     * This loop loops through the food preference list and counts there occurrences
     * in the food preferences list from the aviaries. 
     */
    String[] FoodPrefList = {"berries", "seeds", "fruit", "insects", "other birds",  
        "eggs", "small mammals", "fish", "buds", "larvae", "aquatic invertebrates", "nuts",
        "vegetation"};
    String result = "";
    for (int i = 0; i < FoodPrefList.length; i++)
    {
      result += FoodPrefList[i] + Collections.frequency(totalFood, FoodPrefList[i]) + "\n";
    }
    
    return result;
  }
  
  /** 
   * FindBird function finds a bird object's aviary.
   * @param Bird object type.
   */
  public String FindBird(String birdType)
  {
    String result = ""; 
    Boolean found = false;
    
    /** 
     * Loop through aviaries in conservatory.
     */
    for (int i = 0; i < inHouseAviaries.size(); i++)
    {
      Aviary currentAviary = inHouseAviaries.get(i);
      ArrayList<Birds> aviaryList = currentAviary.getAviary();
      
      /**
       * Loop through birds in aviary. 
       */
      for (int idx = 0; idx < aviaryList.size(); idx++)
      {
        String birdinAviary = aviaryList.get(idx).getType();
        if (birdType == birdinAviary) 
        {
          result += currentAviary.getAviaryName() + "... ";
          found = true;
        }
      }
    }
    
    if (found) { return birdType + " was found in " + result; } 
    else { return "Sorry, that bird is not in the conservatory."; } 
    
  }
  
  
  public static void main(String[] args) {
    
    Conservatory test = new Conservatory();
    
    ArrayList<String> CharaclistTest = new ArrayList<String>();
    CharaclistTest.add("Cannot fly");
    
    ArrayList<String> CharaclistTest2 = new ArrayList<String>();
    CharaclistTest2.add("Facial disk");
    
    ArrayList<String> CharaclistTest3 = new ArrayList<String>();
    CharaclistTest3.add("Small heads");
    
    
    ArrayList<String> FoodlistTest = new ArrayList<String>();
    FoodlistTest.add("fruit");
    FoodlistTest.add("fish");
    
    FlightlessBirds fll = new FlightlessBirds("Emus", CharaclistTest, false, 0, FoodlistTest);
    Owls ow = new Owls("True owl", CharaclistTest2, false, 2, FoodlistTest);
    Pigeons pgn = new Pigeons("Doves", CharaclistTest3, false, 1, FoodlistTest);
    
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
//    test.RescueBird(pgn);
//    test.RescueBird(ow);
    
    
    Aviary testAviary = test.getAviary(1);
    System.out.println(testAviary.getSize());
    //testAviary.AviarySign();
    
  }

}
