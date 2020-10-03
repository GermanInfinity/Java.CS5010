package BirdAbode;

import java.util.ArrayList;
import BirdAnimal.Birds;
import java.util.Random;

public class Aviary {

  private ArrayList<Birds> aviary;
  public Boolean locked;
  private String num;

  /**
   * Constructor of an Aviary class. Creates an object that stores 5 bird
   * objects.
   * 
   * @param lock sets the availability of the aviary for insertion.
   * @param num sets an identifying number of aviary.
   */
  public Aviary(Boolean lock, String num) {
    this.aviary = new ArrayList<Birds>();
    this.locked = lock;
    this.num = num;
  }

  /**
   * getAviaryName returns name of Aviary.
   * 
   * @param accepts nothing.
   */
  public String getAviaryName() {
    String birdName = this.aviary.get(0).getType();
    String name = "";
    if (ClassOfBird(birdName) == "Birds Of Prey") {
      name = "Roofvogels " + this.num;
    }
    ;
    if (ClassOfBird(birdName) == "Flightless Birds") {
      name = "Loopvogels " + this.num;
    }
    ;
    if (ClassOfBird(birdName) == "Owls") {
      name = "Uilen " + this.num;
    }
    ;
    if (ClassOfBird(birdName) == "Parrots") {
      name = "Papegaaien " + this.num;
    }
    ;
    if (ClassOfBird(birdName) == "Pigeons") {
      name = "Duiven " + this.num;
    }
    ;
    if (ClassOfBird(birdName) == "Shorebirds") {
      name = "Kustvogels " + this.num;
    }
    ;
    if (ClassOfBird(birdName) == "Waterfowl") {
      name = "Watervogels " + this.num;
    }
    ;

    return name;
  }
  
  /**
   * getAviary returns the array list of birds in the aviary.
   * 
   * @param accepts nothing.
   */
  public ArrayList<Birds> getAviary() {
    return this.aviary;
  }

  /**
   * printAviary prints the array list of birds in the aviary.
   * 
   * @param accepts nothing.
   */
  public void printAviary() {
    ArrayList<String> printTypes = new ArrayList<String>();
    for (int i = 0; i < this.aviary.size(); i++) {
      printTypes.add(ClassOfBird(this.aviary.get(i).getType()));
    }
    System.out.println(printTypes);
  }

  /**
   * getSize function returns the size of an Aviary.
   */
  public int Size() {
    return this.aviary.size();
  }

  /**
   * FoodKept function combines all the food preferences of the birds in an
   * aviary.
   */
  public ArrayList<String> FoodKept() {

    ArrayList<String> totalFood = new ArrayList<String>();

    for (int i = 0; i < this.aviary.size(); i++) {
      Birds bird = this.aviary.get(i);
      ArrayList<String> birdFoodPref = bird.getFoodPref();

      for (int idx = 0; idx < birdFoodPref.size(); idx++) {
        totalFood.add(birdFoodPref.get(idx));
      }
    }

    return totalFood;

  }

  /**
   * AddBird function handles adding birds in bird classes that mix with other
   * classes.
   * 
   * @param a Bird object to store.
   */
  public Boolean AddBird(Birds Bird) {
    String birdClass = ClassOfBird(Bird.getType());
    Boolean added = false;

    /**
     * If aviary is full, we cannot add more birds.
     */
    if (this.aviary.size() == 5) {
      this.locked = true;
      return added;
    }

    if (birdClass != "Flightless Birds" && birdClass != "Birds Of Prey" && birdClass != "Waterfowl"
        && this.locked == false) {
      this.aviary.add(Bird);
      added = true;
      return added;
    }
    return added;
  }

  /**
   * AddSpecialBird function handles adding birds in bird classes that do mix
   * with other bird classes.
   * 
   * @param a Bird object to store.
   */
  public Boolean AddSpecialBird(Birds Bird) {
    String birdClass = ClassOfBird(Bird.getType());
    Boolean added = false;

    /**
     * If aviary is full, we cannot add more birds.
     */
    if (this.aviary.size() == 5) {
      this.locked = true;
      return added;
    }

    /**
     * Avoid mixing with other birds.
     */
    if (this.aviary.size() > 0) {
      for (int i = 0; i < this.aviary.size(); i++) {
        Birds birdInAviary = this.aviary.get(i);
        String birdInAviaryClass = ClassOfBird(birdInAviary.getType());

        /** Avoid other birds */
        if (birdInAviaryClass != "Flightless Birds" && birdInAviaryClass != "Birds Of Prey"
            && birdInAviaryClass != "Waterfowl") {
          return added;
        }
        /** Avoid other special birds */
        if (birdInAviaryClass != birdClass) {
          return added;
        }
      }
    }

    /**
     * Adding to aviary of special birds.
     */
    if (this.locked == false && this.aviary.size() < 5) {

      if (birdClass == "Flightless Birds") {
        this.aviary.add(Bird);
        added = true;
        this.locked = true;
        return added;
      }

      if (birdClass == "Birds Of Prey") {
        this.aviary.add(Bird);
        added = true;
        this.locked = true;
        return added;
      }

      if (birdClass == "Waterfowl") {
        this.aviary.add(Bird);
        added = true;
        this.locked = true;
        return added;
      }
    }

    if (this.locked == true && this.aviary.size() < 5) {

      if (birdClass == "Flightless Birds") {
        this.aviary.add(Bird);
        added = true;
        return added;
      }

      if (birdClass == "Birds Of Prey") {
        this.aviary.add(Bird);
        added = true;
        return added;
      }

      if (birdClass == "Waterfowl") {
        this.aviary.add(Bird);
        added = true;
        return added;
      }
    }

    return added;

  }

  /**
   * 
   * AviarySign function prints the sign of an Aviary on the console.
   * 
   * @param String name of the aviary.
   */
  public void AviarySign() {
    Random ran = new Random();
    int randInt = ran.nextInt(5) + 0;

    Birds bird = this.aviary.get(randInt);
    String birdName = bird.getType();

    int aviaryNameLen = this.getAviaryName().length();
    int end = aviaryNameLen - 1;

    System.out.println("--------------------------------------------------");
    System.out.println("|                                                |");
    System.out.println("|                                                |");
    System.out.println("|                                                |");
    System.out.println("                   " + this.getAviaryName() + "                   ");
    System.out.println("|                                                |");
    System.out.println("|     Did you know...                            |");

    System.out.println(ExtractBirdInfo(birdName));

    System.out.println("|                                                |");
    System.out.println("|                                                |");
    System.out.println("|     At our Conservatory, we give each aviary \n|     the dutch "
        + "name of the first bird that was \n|     put in it.                                 |");
    System.out.println("|                                                |");
    System.out.println("|     Can you tell what a                        |");
    System.out.println("                   " + this.getAviaryName().substring(0, end) + "is?       "
        + "           ");
    System.out.println("|                                                |");
    System.out.println("|                                                |");
    System.out.println("|                                                |");
    System.out.println("--------------------------------------------------");
  }

  /**
   * 
   * ClassOfBird determines what class a bird type falls under into.
   * 
   * @param string name of bird.
   */
  public String ClassOfBird(String birdName) {
    ArrayList<String> BirdsOfPreyList = new ArrayList<String>();
    BirdsOfPreyList.add("Hawks");
    BirdsOfPreyList.add("Eagles");
    BirdsOfPreyList.add("Osprey");

    if (BirdsOfPreyList.contains(birdName)) {
      return ("Birds Of Prey");
    }
    ;

    ArrayList<String> FlightlessBirdsList = new ArrayList<String>();
    FlightlessBirdsList.add("Emus");
    FlightlessBirdsList.add("Kiwis");
    FlightlessBirdsList.add("Moas");

    if (FlightlessBirdsList.contains(birdName)) {
      return "Flightless Birds";
    }
    ;

    ArrayList<String> OwlsList = new ArrayList<String>();
    OwlsList.add("Owls");
    OwlsList.add("True owl");

    if (OwlsList.contains(birdName)) {
      return "Owls";
    }
    ;

    ArrayList<String> ParrotsList = new ArrayList<String>();
    ParrotsList.add("Parrots");
    ParrotsList.add("Rose-ringed parakeet");
    ParrotsList.add("Gray parrot");
    ParrotsList.add("Sulfur-crested cockatoo");

    if (ParrotsList.contains(birdName)) {
      return "Parrots";
    }
    ;

    ArrayList<String> PigeonsList = new ArrayList<String>();
    PigeonsList.add("Pigeons");
    PigeonsList.add("Doves");

    if (PigeonsList.contains(birdName)) {
      return "Pigeons";
    }
    ;

    ArrayList<String> ShorebirdsList = new ArrayList<String>();
    ShorebirdsList.add("Great auk");
    ShorebirdsList.add("Horned puffin");
    ShorebirdsList.add("African Jacana");

    if (ShorebirdsList.contains(birdName)) {
      return "Shorebirds";
    }
    ;

    ArrayList<String> WaterfowlList = new ArrayList<String>();
    WaterfowlList.add("Ducks");
    WaterfowlList.add("Swan");
    WaterfowlList.add("Geese");

    if (WaterfowlList.contains(birdName)) {
      return "Waterfowl";
    }
    ;

    throw new IllegalArgumentException("Cannot find bird class");

  }

  /**
   * 
   * ExtractBirdInfo extracts interesting information for a certain bird type.
   * 
   * @param string name of bird.
   */
  public String ExtractBirdInfo(String birdName) {
    if (birdName == "Hawks") {
      return "                Hawks often hunt at dawn. \n"
          + "                Hawks often fight in the air over food. \n"
          + "                Hawks mate for life. ";
    }

    if (birdName == "Eagles") {
      return "                Eagles have excellent eyesight. \n"
          + "                Eagles have pwerful talons. \n"
          + "                Eagles build there nests on high cliffs. ";
    }

    if (birdName == "Osprey") {
      return "                Ospreys only eat fish. \n"
          + "                Ospreys can reverse there outter toes. \n"
          + "                Ospreys are also called sea-hawks. ";
    }

    if (birdName == "Emus") {
      return "                Emus grow up to 2m tall. \n"
          + "                Emus can be 20 years old. \n"
          + "                Emus are covered in soft fluffy feathers. ";
    }

    if (birdName == "Kiwis") {
      return "                Kiwis have tiny wings. \n"
          + "                Kiwis have a keen sense of smell. \n"
          + "                Kiwis have whiskers. ";
    }

    if (birdName == "Moas") {
      return "                Moas was the tallest bird that ever lived. \n"
          + "                Moas female were heavier than male. \n"
          + "                Moas were covered in rough feathers. ";
    }

    if (birdName == "Owls") {
      return "                A group of Owls is called a parliament. \n"
          + "                There are over 200 types of Owls. \n"
          + "                Owls are nocturnal. ";
    }

    if (birdName == "Rose-ringed parakeet") {
      return "                Live in large groups. \n"
          + "                Are excellent mimics!. \n"
          + "                Have chicks that grow very quickly!. ";
    }

    if (birdName == "Gray parrot") {
      return "                Fluff up to defend themselves. \n"
          + "                Most accomplished mimic. \n"
          + "                Can outlive their human owners!. ";
    }

    if (birdName == "Sulfur-crested cockatoo") {
      return "                Super beuatiful parrots. \n"
          + "                Very common in forests in Australia. \n"
          + "                Chew branches to stop ther beaks from going too long. ";
    }

    if (birdName == "Pigeons") {
      return "                Pigeons understand space and time. \n"
          + "                Can find heir nests from 1300 miles away. \n"
          + "                Saved thousands of human lives in WWI and WWII. ";
    }

    if (birdName == "Doves") {
      return "                Doves mate for life. \n"
          + "                Referred to as pigeons with a good PR agent. \n"
          + "                Don't neeed to lift their head to swallow water. ";
    }

    if (birdName == "Great Auk") {
      return "                Sometimes called a garefowl. \n" + "                Very social! \n"
          + "                Referred to as penguin of the north. ";
    }

    if (birdName == "Horned Puffin") {
      return "                Carries small fish in it's bill. \n"
          + "                Nests in rock \n" + "                Nicknames sea-parrots. ";
    }

    if (birdName == "African Jacana") {
      return "                Jacanas can walk on water. \n"
          + "                Jacanas are weak fliers. \n"
          + "                Jacana males raise the chick, the females are protectors. ";
    }

    if (birdName == "Ducks") {
      return "                Ducks are omnivors. \n"
          + "                Male ducks are called Drakes. \n"
          + "                Female ducks are alled hens. ";
    }

    if (birdName == "Swans") {
      return "                Swans have elongated curved necks. \n"
          + "                Swans kiss and mate for life. \n"
          + "                Swans can weigh 30 pounds. ";
    }

    if (birdName == "Geese") {
      return "                Geese are highly social animals. \n"
          + "                Geese are very loyal. \n"
          + "                Geese mourn their lost mating partners. ";
    }

    return "";
  }
}
