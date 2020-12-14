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
  private IView introView;
  private IView configView;
  private IView gameView;
  private IView menuView;
  private IView fullMenuView;
  private IView howToPlayView;

  /**
   * Controller constructor method, constructs a controller.
   * 
   * @param in readable object
   * @param out appendable object
   * @param model to control game
   */
  public ControllerX(Readable in, Appendable out, Model model) {

    if (in == null) {
      throw new IllegalArgumentException("Please provide a readable object.");
    }
    if (out == null) {
      throw new IllegalArgumentException("Please provide an appendable object.");
    }
    if (model == null) {
      throw new IllegalArgumentException("Please provide a model object.");
    }
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
   * gameEnd closes game and opens intro screen. 
   */
  public void gameEnd() {
    this.gameView.close();
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
   * openHowToPlay opens how to play view.
   */
  public void openHowToPlayFromGame() {
    this.howToPlayView.display();
  }

  /**
   * openMenu opens the menu.
   */
  public void openMenu(ArrayList<Integer> info) {
    ((MenuView) this.menuView).getInput(info);
    this.menuView.display();
  }

  /**
   * openFullMenu opens the menu.
   */
  public void openFullMenu() {
    this.menuView.close();
    this.fullMenuView.display();
  }

  /**
   * closeMenu closes the menu.
   */
  public void closeMenu() {
    this.menuView.close();
  }

  /**
   * closeGame closes the game.
   */
  public void closeGame() {
    this.gameView.close();
    this.introView.display();
  }

  /**
   * closeFullMenu closes the menu.
   */
  public void closeFullMenu() {
    this.fullMenuView.close();
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
   * setMenuView gives control to the menuview class.
   */
  public void setMenuView(IView view) {
    this.menuView = view;
    this.menuView.setFeatures(this);
  }

  /**
   * setFullMenuView gives control to the menuview class.
   */
  public void setFullMenuView(IView view) {
    this.fullMenuView = view;
    this.fullMenuView.setFeatures(this);
  }

  /**
   * startGame starts hunt the wumpus game.
   */
  public void startGame(ArrayList<Integer> info, Boolean gameOn, Boolean seed) {

    int playerNum = info.get(0);
    int rows = info.get(1);
    int col = info.get(2);
    int walls = info.get(3);
    int type = info.get(4);
    int pits = info.get(5);
    int bats = info.get(6);
    int arrows = info.get(7);

    // First game
    if (!gameOn) {
      this.configView.close();

      this.model.developMaze(playerNum, rows, col, walls, type, pits, bats, arrows, false);
      ArrayList<String> possibleStarts = htwLocations();

      Random ran = new Random();
      if (playerNum == 1) {
        int loc = ran.nextInt(possibleStarts.size());
        System.out.println("1 player mode.");
        String chosen = possibleStarts.get(loc);

        setLocation(Integer.parseInt(chosen));

      }
      if (playerNum == 2) {
        System.out.println("2 player mode.");

        int loc = ran.nextInt(possibleStarts.size());
        String chosen = possibleStarts.get(loc);

        int loc2 = ran.nextInt(possibleStarts.size());
        String chosen1 = possibleStarts.get(loc2);

        setLocation2(Integer.parseInt(chosen), Integer.parseInt(chosen1));

      }

      try {
        ((GameView) this.gameView).receiveConfig(info);
        ((GameView) this.gameView).buildMaze(this.model.getStructure());
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }

    // Game already on.
    else {
      this.gameView.close();
      this.menuView.close();

      this.model.developMaze(playerNum, rows, col, walls, type, pits, bats, arrows, seed);
      ArrayList<String> possibleStarts = htwLocations();

      Random ran = new Random();
      int loc = ran.nextInt(possibleStarts.size());
      String chosen = possibleStarts.get(loc);
      setLocation(Integer.parseInt(chosen));

      try {

        ((GameView) this.gameView).receiveConfig(info);
        ((GameView) this.gameView).buildMaze(this.model.getStructure());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

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
  public String playerLocation(int p) {
    return this.model.playerLocation(p);
  }

  /**
   * returns position of player.
   */
  public String playerRowCol(int p) {
    return this.model.playerPosition(p);
  }

  /**
   * action performs operation depending on players maze position.
   */
  public String action(int p) throws IOException {
    return this.model.action(p);
  }

  /**
   * setLocation places player in location of maze.
   * 
   * @param location for player to be placed
   */
  public void setLocation(int location) {
    this.model.placePlayer(location);
  }

  /**
   * setLocation2 places 2 players in location of maze.
   * 
   */
  public void setLocation2(int locationA, int locationB) {
    this.model.placePlayer2(locationA, locationB);
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

    ArrayList<String> moves = playerMoves(3);
    this.out.append("Tunnels lead to " + moves + "\n");

    this.out.append("Where to? \n");
    this.out.append("Please choose values in parenthesis for direction, (1) North, (2) South,"
        + " (3) East, (4) West: ");

    int posMove = scan.nextInt();
    // this.out.append(movePlayer(posMove, moves, 3));
    this.out.append("\n");

  }

  /**
   * playerMoves returns player possible moves.
   */
  public ArrayList<String> playerMoves(int p) {
    return this.model.playerMoves(p);
  }

  /**
   * movePlayer moves player in maze.
   */
  public String movePlayer(int posMove, ArrayList<String> moves, int p, int numP) {
    return this.model.movePlayer(posMove, moves, p, numP);
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

    // this.out.append(shootArrow(distance, direction));
    this.out.append("\n");
  }

  /**
   * shootArrow shoots arrow for player in maze.
   */
  public String shootArrow(int distance, int direction, int turn) {
    return this.model.shootArrow(distance, direction, turn);
  }

  public void exitProgram() {
    // TODO Auto-generated method stub

  }

}
