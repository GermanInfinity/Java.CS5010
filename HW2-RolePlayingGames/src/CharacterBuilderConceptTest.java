import java.util.ArrayList;

public class CharacterBuilderConceptTest {

  public CharacterBuilderConceptTest() {
    // TODO Auto-generated constructor stub
  }
  /**
   * TestHeadGear This main function tests grabbing the best head gear out of a list.
   */
  public static void TestHeadGear() {
    ArrayList <WearableGear> list = new ArrayList<WearableGear>();
    
    Footwear foot = new Footwear("Fat shoes", 3, 2, false, true);
    list.add(foot);
    
    HeadGear head = new HeadGear("Heavy heads", 30, false, true);
    list.add(head);
    HeadGear head2 = new HeadGear("Heavy heads2", 31, false, true);
    list.add(head2);
    HeadGear head3 = new HeadGear("Heavy heads3", 33, false, true);
    list.add(head3);
    
    HandGear hand = new HandGear("Slow hands", 1, false, true);
    list.add(hand);
    
    
    CharacterBuilder player1 = new CharacterBuilder("John Snow", list);
    Character playerA = player1.build();
    System.out.println(playerA.toString());
  }
  
  
  /** Main calls all the functions to test the inner workings of the CharacterBuilder
   * class.
   * @param args
   */
  public static void main(String args[]) {
    TestHeadGear();
  }
    

}
