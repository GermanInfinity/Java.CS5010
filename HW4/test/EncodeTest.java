import java.util.HashMap;
import java.util.Map;

/** 
 * This class exists to tests the methods in State.java
 * @author Ugo nwachuku 
 *
 */
public class EncodeTest {

  /**
   * main method for testing the encoding class. 
   */
  public static void main(String [] args) { 

    
    Encode message = new Encode("SHE SELLS SEA SHELLS BY THE SEA SHORE", 12);
    message.createFrequencyTable();
    message.createPriorityQueue();
    while (message.stillEncoding()) { 
      message.build();
    }


    /** Symbol Set giving test **/
//    Map<String, String> test = new HashMap<String, String>(); 
//    test.put("d", "100");
//    test.put("e", "010");
//    test.put("f", "001");
//    
//    Encode mess = new Encode("sfed" , test);
//    System.out.println(mess.encodeMessage());

    
  }

}
