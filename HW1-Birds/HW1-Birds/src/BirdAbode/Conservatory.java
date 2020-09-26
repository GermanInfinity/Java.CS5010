package BirdAbode;

import java.util.ArrayList;
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
    inHouseAviaries = new ArrayList<Aviary>();
    inHouseAviaries.add(new Aviary(false, "1"));
    inHouseAviaries.add(new Aviary(false, "2"));
    inHouseAviaries.add(new Aviary(false, "3"));
    inHouseAviaries.add(new Aviary(false, "4"));
    inHouseAviaries.add(new Aviary(false, "5"));
    inHouseAviaries.add(new Aviary(false, "6"));
    inHouseAviaries.add(new Aviary(false, "7"));
    inHouseAviaries.add(new Aviary(false, "8"));
    inHouseAviaries.add(new Aviary(false, "9"));
    inHouseAviaries.add(new Aviary(false, "10"));
    inHouseAviaries.add(new Aviary(false, "11"));
    inHouseAviaries.add(new Aviary(false, "12"));
    inHouseAviaries.add(new Aviary(false, "13"));
    inHouseAviaries.add(new Aviary(false, "14"));
    inHouseAviaries.add(new Aviary(false, "15"));
    inHouseAviaries.add(new Aviary(false, "16"));
    inHouseAviaries.add(new Aviary(false, "17"));
    inHouseAviaries.add(new Aviary(false, "18"));
    inHouseAviaries.add(new Aviary(false, "19"));
    inHouseAviaries.add(new Aviary(false, "20"));

  }
  
  
  /**
   * 
   * ExtractBirdInfo extracts interesting information for a certain bird type.
   * @param string name of bird. 
   */
  public String ExtractBirdInfo(String birdName)
  {
    if (birdName == "Hawks")
    {
      return "                Hawks often hunt at dawn. \n"
          + "                Hawks often fight in the air over food. \n"
          + "                Hawks mate for life. ";
    }
    
    if (birdName == "Eagles")
    {
      return "                Eagles have excellent eyesight. \n"
          + "                Eagles have pwerful talons. \n"
          + "                Eagles build there nests on high cliffs. ";
    }
    
    if (birdName == "Osprey")
    {
      return "                Ospreys only eat fish. \n"
          + "                Ospreys can reverse there outter toes. \n"
          + "                Ospreys are also called sea-hawks. ";
    }
    
    if (birdName == "Emus")
    {
      return "                Emus grow up to 2m tall. \n"
          + "                Emus can be 20 years old. \n"
          + "                Emus are covered in soft fluffy feathers. ";
    }
    
    if (birdName == "Kiwis")
    {
      return "                Kiwis have tiny wings. \n"
          + "                Kiwis have a keen sense of smell. \n"
          + "                Kiwis have whiskers. ";
    }
    
    if (birdName == "Moas")
    {
      return "                Moas was the tallest bird that ever lived. \n"
          + "                Moas female were heavier than male. \n"
          + "                Moas were covered in rough feathers. ";
    }
    
    if (birdName == "Owls")
    {
      return "                A group of Owls is called a parliament. \n"
          + "                There are over 200 types of Owls. \n"
          + "                Owls are nocturnal. ";
    }
    
    if (birdName == "Rose-Ringed Parakeet")
    {
      return "                Live in large groups. \n"
          + "                Are excellent mimics!. \n"
          + "                Have chicks that grow very quickly!. ";
    }
    
    if (birdName == "Gray Parrot")
    {
      return "                Fluff up to defend themselves. \n"
          + "                Most accomplished mimic. \n"
          + "                Can outlive their human owners!. ";
    }
    
    if (birdName == "Sulfur-crested cockatoo")
    {
      return "                Super beuatiful parrots. \n"
          + "                Very common in forests in Australia. \n"
          + "                Chew branches to stop ther beaks from going too long. ";
    }
    
    if (birdName == "Pigeons")
    {
      return "                Pigeons understand space and time. \n"
          + "                Can find heir nests from 1300 miles away. \n"
          + "                Saved thousands of human lives in WWI and WWII. ";
    }
    
    if (birdName == "Doves")
    {
      return "                Doves mate for life. \n"
          + "                Referred to as pigeons with a good PR agent. \n"
          + "                Don't neeed to lift their head to swallow water. ";
    }
    
    if (birdName == "Great Auk")
    {
      return "                Sometimes called a garefowl. \n"
          + "                Very social! \n"
          + "                Referred to as penguin of the north. ";
    }
    
    if (birdName == "Horned Puffin")
    {
      return "                Carries small fish in it's bill. \n"
          + "                Nests in rock \n"
          + "                Nicknames sea-parrots. ";
    }
    
    if (birdName == "African Jacana")
    {
      return "                Jacanas can walk on water. \n"
          + "                Jacanas are weak fliers. \n"
          + "                Jacana males raise the chick, the females are protectors. ";
    }
    
    if (birdName == "Ducks")
    {
      return "                Ducks are omnivors. \n"
          + "                Male ducks are called Drakes. \n"
          + "                Female ducks are alled hens. ";
    }
    
    if (birdName == "Swans")
    {
      return "                Swans have elongated curved necks. \n"
          + "                Swans kiss and mate for life. \n"
          + "                Swans can weigh 30 pounds. ";
    }
    
    
    if (birdName == "Geese")
    {
      return "                Geese are highly social animals. \n"
          + "                Geese are very loyal. \n"
          + "                Geese mourn their lost mating partners. ";
    }
    
    
    
    return "";
  }
  
  /** 
   * RescueBird function stores a bird object in a desired aviary in the 
   * conservatory.
   * @param bird object.
   */
  public void RescueBird(Birds bird)
  {
    int count = 0;
    
    if (bird.getisExtinct() == false) 
    {
      for (int i = 0; i < inHouseAviaries.size(); i++)
      {
        Aviary currentAviary = inHouseAviaries.get(i);
        
        if (currentAviary.locked == false)
        {
          currentAviary.AddSpecialBird(bird);
          currentAviary.AddBird(bird);
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
    test.AviarySign("helo");
    
  }

}
