import java.util.ArrayList;

/**
 * HTW class is the entry point model for the dungeon and player class. This
 * class is responsible for communicating with the controller, and carrying out
 * the controllers commands.
 * 
 * @author Ugo Nwachuku
 *
 */
public class HTW {

  private Dungeon home;
  private Character player;

  /**
   * Constructs an entry point model object for dungeon and player class.
   */
  public HTW() {

    this.player = null;
    this.home = null;
  }

  /**
   * Sets up the dungeon per specified game configurations.
   * 
   * @param rows number of rows in dungeon
   * @param col number of columns in dungeon
   * @param walls number of remaining walls in dungeon
   * @param mazeType type of maze
   * @param pits number of pits in dungeon
   * @param bats number of super bats in dungeon
   * @param arrows number of arrows in dungeon
   */
  public void setUp(int rows, int col, int walls, int mazeType, int pits, int bats, int arrows) {
    String mazeTypeStr = "";

    if (mazeType == 1) {
      mazeTypeStr = "room";
    } else if (mazeType == 2) {
      mazeTypeStr = "wrapping room";
    } else if (mazeType > 2 || mazeType < 1) {
      throw new IllegalArgumentException("Invalid maze type.");
    }

    this.home = new Dungeon(rows, col, arrows, mazeTypeStr, walls, pits, bats);
    this.player = new Player("Player", arrows);

  }

  /**
   * Finds the desired action to take based on players location.
   */
  public String action() {
    return this.home.action();
  }

  /**
   * Finds the name of the player.
   * 
   * @return
   */
  public String playerType() {
    return this.player.getType();
  }

  /**
   * Finds the location of the player.
   */
  public String playerLocation() {
    return this.home.playerLocation();
  }

  /**
   * Finds the possible moves the player can make from their location.
   */
  public ArrayList<String> playerMoves() {
    return this.home.getMoves();
  }

  /**
   * Finds the possible locations the player can go to in the dungeon.
   */
  public ArrayList<String> htwLocations() {
    return this.home.locations();
  }

  /**
   * placePlayer places player at specified location in dungeon.
   * 
   * @param location to place player
   */
  public void placePlayer(int location) {
    this.home.startAt(location);
  }

  /**
   * Informs controller if the game is still running or not.
   */
  public Boolean running() {
    return this.home.gameOn();
  }

  /**
   * shootArrow instructs the dungeon object to move the player.
   * 
   * @param playersMove players choice of move.
   * @param moves possible moves player can make.
   */
  public String movePlayer(int playersMove, ArrayList<String> moves) {
    String move = ((Player) this.player).pickMove(playersMove);
    this.home.makeMove(move, moves);
    return this.home.action();
  }

  /**
   * shootArrow instructs the dungeon object to shoot an arrow for the player.
   * 
   * @param distance to shoot
   * @param direction to shoot
   */
  public String shootArrow(int distance, int direction) {
    if (distance < 0) {
      throw new IllegalArgumentException("Arrows can't be shot at a negative distance.");
    }
    if (direction != 1 && direction != 2 && direction != 3 && direction != 4) {
      throw new IllegalArgumentException("Please pick a valid direction next time.");
    }
    return this.home.arrowAction(distance, direction);
  }

}
