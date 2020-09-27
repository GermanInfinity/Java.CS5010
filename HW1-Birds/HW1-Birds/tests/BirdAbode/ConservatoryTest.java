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

/**
 * A JUnit test class for the BirdsOfPrey class.
 * 
 */
public class ConservatoryTest {

  /** This test cases tests mixing all kinds of birds **/
  @Test
  public void MixingBirds() {
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

    ArrayList<String> av1 = new ArrayList<String>();
    av1.add("Flightless Birds");
    av1.add("Flightless Birds");
    av1.add("Flightless Birds");
    av1.add("Flightless Birds");
    av1.add("Flightless Birds");

    ArrayList<String> av2 = new ArrayList<String>();
    av2.add("Birds of Prey");
    av2.add("Birds of Prey");
    av2.add("Birds of Prey");
    av2.add("Birds of Prey");
    av2.add("Birds of Prey");

    ArrayList<String> av3 = new ArrayList<String>();
    av3.add("Waterfowl");
    av3.add("Waterfowl");
    av3.add("Waterfowl");
    av3.add("Waterfowl");
    av3.add("Waterfowl");

    ArrayList<String> av4 = new ArrayList<String>();
    av4.add("Shorebired");
    av4.add("Parrot");
    av4.add("Owl");
    av4.add("Pigeon");

    System.out.println(av1);
    System.out.println(av2);
    System.out.println(av3);
    System.out.println(av4);
    System.out.println("");

    Aviary test1 = test.getAviary(0);
    test1.printAviary();

    Aviary test2 = test.getAviary(1);
    test2.printAviary();

    Aviary test3 = test.getAviary(2);
    test3.printAviary();

    Aviary test4 = test.getAviary(3);
    test4.printAviary();

    Aviary test5 = test.getAviary(4);
    test5.printAviary();

    Aviary test6 = test.getAviary(5);
    test6.printAviary();

    Aviary test7 = test.getAviary(6);
    test7.printAviary();

  }

  /** This test case tests overloading the conservatory **/
  @Test(expected = IllegalStateException.class)
  public void AddingOver100Birds() {
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

    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(ow);
    test.RescueBird(pgn);

    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(ow);
    test.RescueBird(pgn);

    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(ow);
    test.RescueBird(pgn);

    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(ow);
    test.RescueBird(pgn);

    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(fll);
    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(fll);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(ow);
    test.RescueBird(pgn);
    test.RescueBird(pgn);
    test.RescueBird(ow);
    test.RescueBird(pgn);

    // test.RescueBird(pgn);
    Aviary testAviary = test.getAviary(19);
    testAviary.printAviary();
  }

}
