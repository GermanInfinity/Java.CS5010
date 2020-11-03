/** 
 * This class exists to tests the methods in State.java
 * @author Ugo nwachuku 
 *
 */
public class StateTest {

  public static void main(String [] args) { 
    State test = new State("SHE SELLS SEA SHELLS BY THE SEA SHORE", 2);
    test.createFrequencyTable();
    test.createPriorityQueue();
    test.popQueue();
    test.popQueue();
    test.popQueue();
    
  }

}
/// dot need tree when encoding just encoding table
//only need tree for decoding 
//iterator to decode tree