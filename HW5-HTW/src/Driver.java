import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This class acts as the entry point into the program.
 *
 */
public class Driver {

  /**
   * main method to run program.
   */
  public static void main(String[] args) throws IOException {

    Readable reader = new InputStreamReader(System.in);
//
//    Scanner scan = new Scanner(System.in);
//    System.out.println("Welcome to Hunt the Wumpus. To start, set:\n");
//    System.out.println("Number of dungeon rows: ");
//    int rows = scan.nextInt();
//    System.out.println("Number of dungeon columns: ");
//    int col = scan.nextInt();
//    System.out.println("Number of remaining walls in dungeon: ");
//    int walls = scan.nextInt();
//    System.out.println(
//        "Select between Room maze (1) or Wrapping room maze (2), please use the numbers: ");
//    int mazeType = scan.nextInt();
//    System.out.println("Number of pits in the dungeon: ");
//    int pits = scan.nextInt();
//    System.out.println("Number of super bats in the dungeon: ");
//    int bats = scan.nextInt();
//    System.out.println("Number of arrows player has: ");
//    int arrows = scan.nextInt();
//    
//    
//    Model model = new HTW(rows, col, walls, mazeType, pits, bats, arrows);
    
    StringBuilder log = new StringBuilder();
    Model mockModel = new MockModel(log, "Hello");
    IView cView = new ConfigView("Hunt The Wumpus-Setup");
    IView gView = new GameView("Hunt The Wumpus-Game");
    
    //View for config
    //Controller for config, create new model object
    //everything in one controller, takes in two views
   
    Controller control = new Controller(reader, System.out, mockModel, cView, gView);

    control.start();
  }

}
