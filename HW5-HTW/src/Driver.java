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
//    System.out.println("Select between Room maze (1) or Wrapping room maze (2), please use the numbers: ");
//    int mazeType = scan.nextInt();
//    System.out.println("Number of pits in the dungeon: ");
//    int pits = scan.nextInt();
//    System.out.println("Number of super bats in the dungeon: ");
//    int bats = scan.nextInt();
//    System.out.println("Number of arrows player has: ");
//    int arrows = scan.nextInt();

    //
    Model model = new HTW();
    
    //Model model = new HTW(rows, col, walls, mazeType, pits, bats, arrows);

    //StringBuilder log = new StringBuilder();
    //Model mockModel = new MockModel(log, "Hello");
    
    
    
    

    // View for config
    // Controller for config, create new model object
    // everything in one controller, takes in two views

    ControllerX control = new ControllerX(reader, System.out, model);
    
    IView iView = new IntroView("Welcome to Hunt the Wumpus.", control);
    IView hView = new HowToPlayView("How to play: Hunt the Wumpus.", control);
    IView cView = new ConfigView("Hunt The Wumpus-Setup", control);
    IView gView = new GameView("Hunt The Wumpus-Game", control);
    IView mView = new MenuView("Hunt The Wumpus-Menu", control);
    IView fmView = new FullMenuView("Hunt The Wumpus-Full Menu", control);

    control.setIntroView(iView);
    control.setHTPView(hView);
    control.setConfigView(cView);
    control.setGameView(gView);
    control.setMenuView(mView);
    control.setFullMenuView(fmView);
  }

}
