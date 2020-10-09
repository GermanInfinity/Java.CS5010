import java.util.ArrayList;

public class CharacterBuilderConceptTest {

  public CharacterBuilderConceptTest() {
    // TODO Auto-generated constructor stub
  }
  
  /**
   * TestHeadGear This main function tests grabbing the best hand gear from 
   *              multiple handGears.
   */
  public static void TestMultipleHandGears() {
    ArrayList <WearableGear> list = new ArrayList<WearableGear>();
    
    Footwear foot = new Footwear("Fat shoes", 3, 2, false, true);
    list.add(foot);
    HeadGear head = new HeadGear("Heavy Head", 30, false, true);
    list.add(head);
    
    HandGear hand = new HandGear("Slippery hands", 1, false, true);
    list.add(hand); 
    HandGear head2 = new HandGear("Strong hands", 31, false, true);
    list.add(head2);
    HandGear head3 = new HandGear("Best hands", 40, false, true);
    list.add(head3);
    
    CharacterBuilder player1 = new CharacterBuilder("John Wick", list);
    Character playerA = player1.build();
    System.out.println(playerA.toString());
  }
  /**
   * TestHeadGear This main function tests grabbing the best head gear from 
   *              multiple headGears.
   */
  public static void TestMultipleHeadGears() {
    ArrayList <WearableGear> list = new ArrayList<WearableGear>();
    
    Footwear foot = new Footwear("Fat shoes", 3, 2, false, true);
    list.add(foot);
    HandGear hand = new HandGear("Slow hands", 1, false, true);
    list.add(hand);
    
    HeadGear head = new HeadGear("Heavy min", 30, false, true);
    list.add(head);
    HeadGear head2 = new HeadGear("Heavy mid", 31, false, true);
    list.add(head2);
    HeadGear head3 = new HeadGear("Heavy max", 40, false, true);
    list.add(head3);
    
    
    CharacterBuilder player1 = new CharacterBuilder("John Wick", list);
    Character playerA = player1.build();
    System.out.println(playerA.toString());
  }
  
  /**
   * TestAddGear This function tests adding basic gear to the attire. 
   */
  public static void TestAddGear() {
    ArrayList <WearableGear> list = new ArrayList<WearableGear>();
    
    Footwear foot = new Footwear("Fat shoes", 3, 2, false, true);
    list.add(foot);
    HandGear hand = new HandGear("Slow hands", 1, false, true);
    list.add(hand);
    HeadGear head = new HeadGear("Heavy heads", 30, false, true);
    list.add(head);

    CharacterBuilder player1 = new CharacterBuilder("John Snow", list);
    Character playerA = player1.build();
    System.out.println(playerA.toString());
  }
  
  /** Main calls all the functions to test the inner workings of the CharacterBuilder
   * class.
   * @param args
   */
  public static void main(String args[]) {
    //TestAddGear();
    //TestMultipleHeadGears();
    TestMultipleHandGears();
    
  }
    

}
