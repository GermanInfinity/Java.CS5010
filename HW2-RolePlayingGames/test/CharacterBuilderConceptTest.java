import java.util.ArrayList;

public class CharacterBuilderConceptTest {

  public CharacterBuilderConceptTest() {
    // TODO Auto-generated constructor stub
  }
  
  /**
   * TestMoreMultipleHandGears This main function tests grabbing the best hand gear from 
   *              more multiple handGears.
   */
  public static void TestMoreMultipleHandGears() {
    ArrayList <WearableGear> list = new ArrayList<WearableGear>();
    
    HandGear hand = new HandGear("Slippery hands", 100, false, true);
    list.add(hand); 
    
    Footwear foot = new Footwear("Fat shoes", 3, 2, false, true);
    list.add(foot);
    HandGear head2 = new HandGear("Strong hands", 31, false, true);
    list.add(head2);
    
    HandGear hand3 = new HandGear("Slippery hands", 1, false, true);
    list.add(hand3); 
    
    HeadGear head = new HeadGear("Heavy Head", 30, false, true);
    list.add(head);
    
    HandGear head4 = new HandGear("Strong hands", 31, false, true);
    list.add(head4);
    HandGear head5 = new HandGear("Weak hands", 40, false, true);
    list.add(head5);
    
    CharacterBuilder player1 = new CharacterBuilder("John Wick", list);
    Character playerA = player1.build();
    System.out.println(playerA.toString());
  }
  
  /**
   * TestMultipleHandGears This main function tests grabbing the best hand gear from 
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
   * TestHeadGear This main function tests grabbing the best footwear from 
   *              multiple handGears.
   */
  public static void TestMoreMultipleFootwears() {
    ArrayList <WearableGear> list = new ArrayList<WearableGear>();
    
    Footwear foot = new Footwear("Fat shoes", 2, 20000, false, true);
    list.add(foot);
    Footwear foot6 = new Footwear("Smooth shoes", 1, 200, false, true);
    list.add(foot6);
    
    HeadGear head = new HeadGear("Heavy Head", 30, false, true);
    list.add(head);
    Footwear foot5 = new Footwear("Hairy shoes", 0, 2, false, true);
    list.add(foot5);
    HandGear hand = new HandGear("Slippery hands", 1, false, true);
    list.add(hand); 
  
    Footwear foot2 = new Footwear("Bulky shoes", 3, 21, false, true);
    list.add(foot2);
    Footwear foot3 = new Footwear("Smooth shoes", 1, 200, false, true);
    list.add(foot3);
    
    CharacterBuilder player1 = new CharacterBuilder("John Wick", list);
    Character playerA = player1.build();
    System.out.println(playerA.toString());
  }
  
  /**
   * TestHeadGear This main function tests grabbing the best footwear from 
   *              multiple handGears.
   */
  public static void TestMultipleFootwears() {
    ArrayList <WearableGear> list = new ArrayList<WearableGear>();
    
    HeadGear head = new HeadGear("Heavy Head", 30, false, true);
    list.add(head);
    HandGear hand = new HandGear("Slippery hands", 1, false, true);
    list.add(hand); 
  
    Footwear foot = new Footwear("Fat shoes", 30, 2, false, true);
    list.add(foot);
    Footwear foot2 = new Footwear("Bulky shoes", 13, 2, false, true);
    list.add(foot2);
    Footwear foot3 = new Footwear("Smooth shoes", 31, 200, false, true);
    list.add(foot3);
    
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
    //TestMultipleHandGears();
    //TestMoreMultipleHandGears();
    //TestMultipleFootwears();
    TestMoreMultipleFootwears();
  }
    

}
