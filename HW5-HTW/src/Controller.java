import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Controller class is responsible for communication with the model and
 * specified view.
 * 
 * @author Ugo Nwachuku
 *
 */
public class Controller implements ActionListener, KeyListener  {
  private final Readable in;
  private final Appendable out;
  private Model model;
  private IView configView, gameView;

  /**
   * Controller constructor method, constructs a controller.
   * 
   * @param in readable object
   * @param out appendable object
   * @param view the view to use
   */
  public Controller(Readable in, Appendable out, Model model, IView configView,
                    IView gameView) {
    this.in = in;
    this.out = out;
    this.model = model;
    this.configView = configView;
    this.gameView = gameView;
    this.configView.setListener(this, this);
    this.gameView.setListener(this, this);

  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {

    case "Set Difficulty":
      ArrayList<Integer> config = ((ConfigView) this.configView).getGameConfig();
      ArrayList<String> viewDetails = new ArrayList<String> ();
      this.configView.close();
      try {
        ((GameView) this.gameView).setupGame(config, viewDetails);
        this.gameView.setListener(this, this);
      } catch (IOException e1) {
        e1.printStackTrace();
      }

      break;
      
    case "Move":
      ArrayList<String> possibleMoves = new ArrayList<String>();//this.model.playerMoves();
      String playerPosition = null; //this.model.playerPosition();
      playerPosition = "00";
      ((GameView) this.gameView).movePlayer(playerPosition, possibleMoves);
      /** Axctual **/ 
      //ArrayList<Integer> config = view.getGameConfig();
      //this.gameView.displayMaze(config);
      break;

    case "Pass to model":
      //ArrayList<Integer> config = view.getGameConfig();
      //guiStart(config);
      //view.display(); //model would give us an object to build gui off of mo9del response
      this.configView.revealPic();
      break;
      
    case "Exit Button":
      System.exit(0);
      break;

    default:
      throw new IllegalStateException("Error: unknown button");
    }
    
  }

  /**
   * Method starts the controllers control of the maze and player in in it.
   * 
   * @throws IOException if something goes wrong.
   */
  public void start() throws IOException {
    Scanner scan = new Scanner(this.in);

    this.out.append("Welcome " + playerType()
        + " to the caves of destiny. Hunt the Wumpus, or be haunted!\n");
    this.out.append("Where shall I place you?: " + htwLocations());
    int location = scan.nextInt();
    if (!this.model.htwLocations().contains(Integer.toString(location))) {
      throw new IllegalArgumentException("I cannot start you there.");
    }

    setLocation(location);
    this.out.append(
        "I have placed you in cave " + playerLocation() + ", happy hunting ^_^ \n");
    this.out.append(action());
    this.out.append("\n");

    while (running()) {
      this.out.append("(1) Move - (2) Shoot? ");
      int resp = scan.nextInt();
      if (resp != 1 && resp != 2) {
        throw new IllegalArgumentException("Please pick a valid option next time.");
      }
      this.out.append("You are in cave " + playerLocation() + "\n");
      if (resp == 1) {
        move();
      }

      if (resp == 2) {
        shoot();
      }
    }

  }
  
  /**
   * guiStart
   */
  public void guiStart(ArrayList<Integer> config) { 
    Model modelTest = new HTW(config.get(0), config.get(1), config.get(2), config.get(3), 
                          config.get(4), config.get(5), config.get(6));
    
  }
  
  /**
   * running determines if the game is running. 
   */
  public Boolean running() { 
    return this.model.running();
  }
  
  /**
   * playerType returns type of playwr.
   */
  public String playerType() { 
    return this.model.playerType();
  }
  
  /**
   * playerLocations returns location of players.
   */
  public String playerLocation() { 
    return this.model.playerLocation();
  }
  
  /**
   * action performs operation depending on players maze position. 
   */
  public String action() throws IOException { 
    //this.out.append(this.model.action());
    return this.model.action();
  }
  
  /**
   * setLocation sets location in maze of player. 
   * @param location for player to be placed
   */
  public void setLocation(int location) { 
    this.model.placePlayer(location);
  }
  
  /**
   * htwLocation finds locations player can go to.  
   */
  public ArrayList<String> htwLocations() { 
    return this.model.htwLocations();
  }




  /**
   * move function controls the player in the maze to move a certain direction.
   */
  public void move() throws IOException {
    Scanner scan = new Scanner(this.in);

    ArrayList<String> moves = playerMoves();
    this.out.append("Tunnels lead to " + moves + "\n");

    this.out.append("Where to? \n");
    this.out.append("Please choose values in parenthesis for direction, (1) North, (2) South,"
        + " (3) East, (4) West: ");

    int posMove = scan.nextInt();
    this.out.append(movePlayer(posMove, moves));
    this.out.append("\n");

  }
  
  /**
   * playerMoves returns player possible moves. 
   */
  public ArrayList<String> playerMoves() { 
    return this.model.playerMoves();
  }

  
  /**
   * movePlayer moves player in maze. 
   */
  public String movePlayer(int posMove, ArrayList<String> moves) { 
    return this.model.movePlayer(posMove, moves);
  }

  /**
   * shoot function controls the player in the maze to shoot an arrow.
   */
  public void shoot() throws IOException {
    Scanner scan = new Scanner(this.in);
    this.out.append("How many caves deep? \n");
    int distance = scan.nextInt();

    this.out.append("In what direction, (1) North, (2) South," + " (3) East, (4) West: ");
    int direction = scan.nextInt();

    this.out.append(shootArrow(distance, direction));
    this.out.append("\n");
  }
  
  /**
   * shootArrow shoots arrow for player in maze. 
   */
  public String shootArrow(int distance, int direction) { 
    return this.model.shootArrow(distance, direction);
  }


  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void keyPressed(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }
}
