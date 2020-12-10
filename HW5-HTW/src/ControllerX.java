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
public class ControllerX implements Features {
  private final Readable in;
  private final Appendable out;
  private Model model;
  private IView introView, configView, gameView, testView;
  private IView howToPlayView;


  /**
   * Controller constructor method, constructs a controller.
   * 
   * @param in readable object
   * @param out appendable object
   * @param view the view to use
   */
  public ControllerX(Readable in, Appendable out, Model model) {
    
    this.in = in;
    this.out = out;
    this.model = model;

 
  }
  
  /**
   * openIntro opens configuration view. 
   */
  public void openIntro() { 
    this.howToPlayView.close();
    this.introView.display();
  }
  
  /**
   * backToIntro goes back to the intro view from the game setup.
   */
  public void backToIntro() { 
    this.configView.close(); 
    this.introView.display();
  }

  /**
   * openConfig opens configuration view. 
   */
  public void openConfig() { 
    this.introView.close();
    this.configView.display();
  }
  
  /**
   * openHowToPlay opens how to play view. 
   */
  public void openHowToPlay() { 
    this.introView.close();
    this.howToPlayView.display();
  }
  
  /**
   * setIntroView gives control to the intro view class. 
   */
  public void setIntroView(IView view) { 
    this.introView = view;
    this.introView.setFeatures(this);
  }
  
  /**
   * setHowToPlayView gives control to the how to play view class. 
   */
  public void setHTPView(IView view) { 
    this.howToPlayView = view;
    this.howToPlayView.setFeatures(this);
  }
  
  /**
   * setConfigView gives control to the config view class. 
   */
  public void setConfigView(IView view) { 
    this.configView = view;
    this.configView.setFeatures(this);
  }
  
  /**
   * setGameView gives control to the gameview class. 
   */
  public void setGameView(IView view) { 
    this.gameView = view;
    this.gameView.setFeatures(this);
  }
  
  
  /**
   * startGame starts hun the wumpus game.
   */
  public void startGame(String difficulty) { 
    this.configView.close();
    if (difficulty.equals("Easy")) {
      this.model.developMaze(4, 4, 8, 1, 1, 1, 1);
    }
    ArrayList<String> possibleStarts = htwLocations();
    Random ran = new Random();
    int loc = ran.nextInt(possibleStarts.size());
    String chosen = possibleStarts.get(loc);
    setLocation(Integer.parseInt(chosen));
    
    //((GameView) this.gameView).buildMaze(4, 4, this.model.getStructure());
    this.gameView.display();
    
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



  public void exitProgram() {
    // TODO Auto-generated method stub
    
  }



}
