import java.util.ArrayList;
import java.util.Map;

/**
 * Model interface represents all the signature methods of this maze game.
 * 
 * @author Ugo Nwachuku
 *
 */
public interface Model {

  /**
   * developMaze creates the maze in the backend of the model.
   */
  public void developMaze(int pNum, int rows, int col, int walls, int mazeType, int pits, int bats,
      int arrows, Boolean s);

  /**
   * Finds the desired action to take based on players location.
   */
  public String action(int p);

  /**
   * Finds the name of the player.
   * 
   * @return
   */
  public String playerType();

  /**
   * Finds the location of the player.
   */
  public String playerLocation(int pNum);

  /**
   * Finds the position of a player.
   */
  public String playerPosition(int pNum);

  /**
   * getStructure returns structure of maze.
   */
  public Map<String, Object> getStructure();

  /**
   * Finds the possible moves the player can make from their location.
   */
  public ArrayList<String> playerMoves(int p);

  /**
   * Finds the possible locations the player can go to in the dungeon.
   */
  public ArrayList<String> htwLocations();

  /**
   * placePlayer places player at specified location in dungeon.
   * 
   * @param location to place player
   */
  public void placePlayer(int location);

  public void placePlayer2(int location, int loc2);

  /**
   * Informs controller if the game is still running or not.
   */
  public Boolean running();

  /**
   * shootArrow instructs the dungeon object to move the player.
   * 
   * @param playersMove players choice of move.
   * @param moves possible moves player can make.
   */
  public String movePlayer(int playersMove, ArrayList<String> moves, int p, int numP);

  /**
   * shootArrow instructs the dungeon object to shoot an arrow for the player.
   * 
   * @param distance to shoot
   * @param direction to shoot
   */
  public String shootArrow(int distance, int direction, int turn);

}
