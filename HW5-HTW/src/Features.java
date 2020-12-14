import java.io.IOException;
import java.util.ArrayList;

/**
 * This interface represents a set of features that the program offers. Each
 * feature is exposed as a function in this interface. This function is used
 * suitably as a callback by the view, to pass control to the controller. How
 * the view uses them as callbacks is completely up to how the view is designed
 * (e.g. it could use them as a callback for a button, or a callback for a
 * dialog box, or a set of text inputs, etc.)
 * Each function is designed to take in the necessary data to complete that
 * functionality.
 */

public interface Features {

  /**
   * Opens intro frame.
   */
  void openIntro();

  /**
   * Opens how to play frame.
   */
  void openHowToPlay();

  /**
   * Opens config frame.
   */
  void openConfig();

  /**
   * Opens game menu.
   */
  void openMenu(ArrayList<Integer> inf);

  /**
   * Opens full game menu.
   */
  void openFullMenu();

  /**
   * closeMenu closes the menu.
   */
  void closeMenu();

  /**
   * vloses game and opens intro screen.
   */
  void closeGame();

  /**
   * closeFullMenu closes full menu.
   */
  void closeFullMenu();

  /**
   * Goes back to intro from config screen.
   */
  void backToIntro();

  /**
   * startGame starts the hunt the wumpus game.
   */
  void startGame(ArrayList<Integer> info, Boolean gameOn, Boolean s);

  /**
   * running determines if the game is running.
   */
  Boolean running();

  /**
   * playerType returns type of playwr.
   */
  String playerType();

  /**
   * playerLocations returns location of players.
   */
  String playerLocation(int p);

  /**
   * action performs operation depending on players maze position.
   */
  String action(int p) throws IOException;

  /**
   * setLocation sets location in maze of player.
   * 
   * @param location for player to be placed
   */
  void setLocation(int location);

  /**
   * htwLocation finds locations player can go to.
   */
  ArrayList<String> htwLocations();

  /**
   * move function controls the player in the maze to move a certain direction.
   * 
   */
  void move() throws IOException;

  /**
   * playerMoves returns player possible moves.
   */
  ArrayList<String> playerMoves(int p);

  /**
   * movePlayer moves player in maze.
   */
  String movePlayer(int posMove, ArrayList<String> moves, int p, int numP);

  /**
   * shoot function controls the player in the maze to shoot an arrow.
   */
  void shoot() throws IOException;

  /**
   * shootArrow shoots arrow for player in maze.
   */
  String shootArrow(int distance, int direction, int turn);

  /**
   * Exit the program.
   */
  void exitProgram();

}
