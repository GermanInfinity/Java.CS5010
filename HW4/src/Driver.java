import java.util.Scanner;

/**
 * This driver class represents an execution of encoding. 
 * @author ugoslight
 *
 */
public class Driver {

  /**
   * main method for showing examples. 
   */
  public static void main(String [] args) {
    
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    String inputString = scanner.nextLine();
    Encode encodeThis = new Encode(inputString, 2);
    encodeThis.createFrequencyTable();
    encodeThis.createPriorityQueue();
    while (encodeThis.stillEncoding()) { 
      encodeThis.build();
    }
    String codedMessage = encodeThis.encodedMessage(); 
    System.out.println(codedMessage);
  }

}


