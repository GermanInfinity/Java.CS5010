import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** 
 * This class exists to tests the methods in State.java
 * @author Ugo nwachuku 
 *
 */
public class EncodeTest {

  public static void main(String [] args) { 

    
    Encode message = new Encode("SHE SELLS SEA SHELLS BY THE SEA SHORE", 2);
    message.createFrequencyTable();
    message.createPriorityQueue();
    while (message.stillEncoding()) { 
      message.build();

    }


    
  }

}
