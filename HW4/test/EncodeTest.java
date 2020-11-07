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

    
    Encode message = new Encode("SHE SELLS SEA SHELLS BY THE SEA SHORE", 2);
    message.createFrequencyTable();
    message.createPriorityQueue();
    while (message.stillEncoding()) { 
      message.build();
    }


    
  }

}
