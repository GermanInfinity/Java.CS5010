import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** 
 * This class exists to tests the methods in State.java
 * @author Ugo nwachuku 
 *
 */
public class StateTest {

  public static void main(String [] args) { 
//    State test = new State("SHE SELLS SEA SHELLS BY THE SEA SHORE", 2);
//    test.createFrequencyTable();
//    test.createPriorityQueue();
//    test.popQueue();
//    test.popQueue();
//    test.popQueue();
    
//    while (!test.doneBuild()) { 
//      test.popQueue();
//    }
    
    Encode message = new Encode("SHE SELLS SEA SHELLS BY THE SEA SHORE", 2);
    message.createFrequencyTable();
    message.createPriorityQueue();
    while (message.stillEncoding()) { 
      message.build();

    }
//    ArrayList<SymbolNode> a = message.popQueue();
//    message.addToQueue(a);
    
    /** Second Encoding Test **/
//    Map<String, String> test = new HashMap<String, String>();
//    test.put("a", "100");
//    test.put("b", "010");
//    Encode message2 = new Encode("100010", test);
//    System.out.println(message2.encodeMessage());

    
  }

}
