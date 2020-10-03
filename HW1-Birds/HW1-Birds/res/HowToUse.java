package BirdAbode;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import BirdAnimal.FlightlessBirds;
import BirdAnimal.Owls;
import BirdAnimal.Pigeons;
import BirdAnimal.BirdsOfPrey;
import BirdAnimal.Parrots;
import BirdAnimal.Shorebirds;
import BirdAnimal.Waterfowls;


public class HowToUse {

  /** Dummy constructor **/ 
  public HowToUse() {
    // TODO Auto-generated constructor stub
  }
  
  public static void main(String[] args) {

    Conservatory test = new Conservatory();

    ArrayList<String> CharaclistTest = new ArrayList<String>();
    CharaclistTest.add("Cannot fly");

    ArrayList<String> CharaclistTest2 = new ArrayList<String>();
    CharaclistTest2.add("Facial disk");

    ArrayList<String> CharaclistTest3 = new ArrayList<String>();
    CharaclistTest3.add("Small heads");

    ArrayList<String> CharaclistTest4 = new ArrayList<String>();
    CharaclistTest4.add("Sharp beaks");

    ArrayList<String> CharaclistTest5 = new ArrayList<String>();
    CharaclistTest5.add("Short beak");

    ArrayList<String> CharaclistTest6 = new ArrayList<String>();
    CharaclistTest6.add("Live near wetlands");

    ArrayList<String> CharaclistTest7 = new ArrayList<String>();
    CharaclistTest7.add("Live near freshwater");

    ArrayList<String> bodyOfWaterlist = new ArrayList<String>();
    bodyOfWaterlist.add("Saltwater");

    ArrayList<String> FoodlistTest = new ArrayList<String>();
    FoodlistTest.add("fruit");
    FoodlistTest.add("fish");

    FlightlessBirds fll = new FlightlessBirds("Emus", CharaclistTest, false, 0, FoodlistTest);
    Owls ow = new Owls("True owl", CharaclistTest2, false, 2, FoodlistTest);
    Pigeons pgn = new Pigeons("Doves", CharaclistTest3, false, 1, FoodlistTest);
    BirdsOfPrey bop = new BirdsOfPrey("Eagles", CharaclistTest4, false, 0, FoodlistTest);
    Parrots ptn = new Parrots("Rose-ringed parakeet", CharaclistTest5, false, 0, FoodlistTest, 3,
        "Hamburger");
    Shorebirds sbd = new Shorebirds("Great auk", CharaclistTest6, false, 0, FoodlistTest,
        bodyOfWaterlist);
    Waterfowls wtf = new Waterfowls("Ducks", CharaclistTest7, false, 0, FoodlistTest,
        bodyOfWaterlist);

    test.RescueBird(fll);
    test.RescueBird(bop);
    test.RescueBird(wtf);
    
    test.RescueBird(fll);
    test.RescueBird(bop);
    test.RescueBird(wtf);

    test.RescueBird(fll);
    test.RescueBird(bop);
    test.RescueBird(wtf);

    test.RescueBird(fll);
    test.RescueBird(bop);
    test.RescueBird(wtf);

    test.RescueBird(fll);
    test.RescueBird(bop);
    test.RescueBird(wtf);

    test.RescueBird(fll);
    test.RescueBird(bop);
    test.RescueBird(wtf);

    test.RescueBird(sbd);
    test.RescueBird(ptn);
    test.RescueBird(ow);
    test.RescueBird(pgn);

    
    
    // Food Quantity
    System.out.println(test.FoodQuant());
    
    // Find Bird
    System.out.println(test.FindBird("Eagles"));
    
    // Sign of an Aviary
    test.getAviary(1).AviarySign();
    
    // Map of Conservatiory 
    test.map();
    
    // Index of all birds
    System.out.println(test.toString());
    
    

  }

}
