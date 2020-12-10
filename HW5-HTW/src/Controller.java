import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The Controller class is responsible for communication with the model and
 * specified view.
 * 
 * @author Ugo Nwachuku
 *
 */
public class Controller implements ActionListener, KeyListener {
  private final Readable in;
  private final Appendable out;
  private Model model;
  private IView introView, configView, gameView, testView;
  private IView howToPlayView;
  private int i; 
  private ArrayList<String> poss;

  /**
   * Controller constructor method, constructs a controller.
   * 
   * @param in readable object
   * @param out appendable object
   * @param view the view to use
   */
  public Controller(Readable in, Appendable out, Model model, IView introView, IView htpView, IView configView,
      IView gameView) {
    
    this.in = in;
    this.out = out;
    this.model = model;
    
    this.i = 0;
    this.poss = new ArrayList<String>();
    this.poss.add("00");
    this.poss.add("01");
    this.poss.add("02");
    this.poss.add("03");
    

    this.introView = introView;
    try {
      this.testView = new TestView();
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.howToPlayView = htpView;
    this.configView = configView;
    this.gameView = gameView;

   

    this.introView.display();
    this.introView.setListener(this, this);
    this.howToPlayView.setListener(this, this);
    this.testView.setListener(this, this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // add panels 
    // frame.add(panel)
    // add panel to scroll pane 
    // then you add scroll pane to frame
    switch (e.getActionCommand()) {

    case "HowToPlay":
      testView.display(); 
      this.testView.setListener(this, this);
      this.introView.close();

      break;
      
    case "Setup":
      this.introView.close();
      //this.configView.setListener(this, this);
      //this.configView.display();
      //ArrayList<Integer> gameConfig = ((ConfigView) this.configView).getGameConfig();
      ArrayList<Integer> gameConfig = new ArrayList<Integer>();
      gameConfig.add(5);
      gameConfig.add(5);
      gameConfig.add(8);
      gameConfig.add(1);
      gameConfig.add(1);
      gameConfig.add(1);
      gameConfig.add(1); 
      this.model.developMaze(gameConfig.get(0), gameConfig.get(1), gameConfig.get(2),
                             gameConfig.get(3), gameConfig.get(4), gameConfig.get(5), gameConfig.get(6));
      ArrayList<String> possibleStarts = htwLocations();
      Random ran = new Random();
      int loc = ran.nextInt(possibleStarts.size());
      String chosen = possibleStarts.get(loc);
      setLocation(Integer.parseInt(chosen));
      ((TestView) this.testView).buildMaze(5, 5, this.model.getStructure());
      
      break;

      
    case "Play":
      //ArrayList<Integer> config = ((ConfigView) this.configView).getGameConfig();
      ArrayList<String> viewDetails = new ArrayList<String>();
      //this.configView.close();
      ArrayList<Integer> config = new ArrayList<Integer>();
      config.add(5);
      config.add(5);
      config.add(5);
      config.add(5);
      config.add(5);
      config.add(5);
      System.out.println("EE");
      try {
        ((TestView) this.testView).setupGame(config, viewDetails);
        this.testView.setListener(this, this);
      } catch (IOException e1) {
        e1.printStackTrace();
      }

      break;

    case "Move":
      ArrayList<String> possibleMoves = new ArrayList<String>();// this.model.playerMoves();
      String playerPosition = null; // this.model.playerPosition();
      
      playerPosition = poss.get(i);
      this.i++;
      ((TestView) this.testView).movePlayer(playerPosition, possibleMoves);
      /** Axctual **/
      // ArrayList<Integer> config = view.getGameConfig();
      // this.gameView.displayMaze(config);
      break;
 

    case "Restart":
      // pass everything to model
      // model returns details
      // pass to view to create
      ArrayList<Integer> settings = this.testView.getGameConfig();
      ArrayList<String> viewDs = new ArrayList<String>();
      this.testView.close();
      try {
        ((TestView) this.testView).setupGame(settings, viewDs);
        this.testView.setListener(this, this);
      } catch (IOException e1) {
        e1.printStackTrace();
      }
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
    
    this.out.append(
        "Welcome " + playerType() + " to the caves of destiny. Hunt the Wumpus, or be haunted!\n");
    this.out.append("Where shall I place you?: " + htwLocations());
    int location = scan.nextInt();
    if (!this.model.htwLocations().contains(Integer.toString(location))) {
      throw new IllegalArgumentException("I cannot start you there.");
    }

    setLocation(location);
    this.out.append("I have placed you in cave " + playerLocation() + ", happy hunting ^_^ \n");
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
    // this.out.append(this.model.action());
    return this.model.action();
  }

  /**
   * setLocation sets location in maze of player.
   * 
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
