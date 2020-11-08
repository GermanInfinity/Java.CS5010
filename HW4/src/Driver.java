import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This driver class represents an execution of encoding.
 * 
 * @author ugoslight
 *
 */
public class Driver {

  /**
   * main method for showing examples.
   */
  public static void main(String[] args) {

    /** Reading a message from the keyboard **/
    // @SuppressWarnings("resource")
    // Scanner scanner = new Scanner(System.in);
    // System.out.println("Please enter a message to be encoded: ");
    // String inputString = scanner.nextLine();
    //
    // System.out.println("Please enter the code length: ");
    // String codeLen = scanner.nextLine();
    // int num = Integer.parseInt(codeLen);
    // Encode encodeThis = new Encode(inputString, num);
    // encodeThis.createFrequencyTable();
    // encodeThis.createPriorityQueue();
    // while (encodeThis.stillEncoding()) {
    // encodeThis.build();
    // }
    // String codedMessage = encodeThis.getEncodedMessage();
    // /** Printing message to the screen **/
    // System.out.println(codedMessage);

    /** Reading message from a file **/
    ArrayList<String> info = new ArrayList<String>();
    try {
      File file = new File("/Users/ugoslight/Desktop/message.txt");
      Scanner reader = new Scanner(file);

      while (reader.hasNextLine()) {
        String data = reader.nextLine();
        info.add(data);
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("No file found.");
      e.printStackTrace();
    }

    /** Encoding message from file **/
    Encode encodeThis = new Encode(info.get(0), Integer.parseInt(info.get(1)));
    encodeThis.createFrequencyTable();
    encodeThis.createPriorityQueue();
    while (encodeThis.stillEncoding()) {
      encodeThis.build();
    }
    String codedMessage = encodeThis.getEncodedMessage();
    /** Create new file **/
    try {
      File myObj = new File("/Users/ugoslight/Desktop/filename.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    /** Write to file **/
    try {
      FileWriter myWriter = new FileWriter("/Users/ugoslight/Desktop/filename.txt");
      myWriter.write(codedMessage);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }



  }
}
