import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * This interface represents the methods that can be implemented to build a maze
 * object.
 * 
 * @author Ugo Nwachuku
 *
 */
public interface Maze {

  /**
   * insertRooms fills every position in the maze with room objects.
   */
  Room[] insertRooms(Room[] array, int mazeRow, int mazeCol);

  /**
   * updatePlayerPosition updates room to reflect position of player.
   */
  void updatePlayerPosition(Room[] array, int mazeRow, int mazeCol, int newPlayRow, int newPlayCol);

  /**
   * spreadGold spreads gold in 20% of the cells in the maze.
   */
  void spreadGold(Room[] array, int mazeRow, int mazeCol);

  /**
   * spreadThief places thieves in 10% of the cells in the maze.
   */
  void spreadThieves(Room[] array, int mazeRow, int mazeCol);

  /**
   * findPlayer wrapper for playerLocation function.
   */
  String findPlayer();

  /**
   * playerLocation returns the players location in the maze.
   * 
   * @return string location of player
   */
  String playerLocation(Room[] array, int mazeRow, int mazeCol);

  /**
   * Wrapper function for playerMove.
   */
  void makeMove(String move, ArrayList<String> moves);

  /**
   * playerMoves moves a player in the cell.
   */
  void playerMove(int mazeRow, int mazeCol, String mazeType, Room[] array, String move);

  /**
   * BoundaryHelper, updates the row and columns of a wrapping room maze properly. 
   * @param row
   * @param col
   * @param mazeRow
   * @param mazeCol
   * @return
   */
  int[] boundaryHelper(int row, int col, int mazeRow, int mazeCol);
  
  
  /**
   * Wrapper for mazeSolved.
   */
  Boolean atGoal();

  /**
   * mazeSolved returns if the maze has been solved or not.
   * 
   * @return true or false
   */
  Boolean mazeSolved(Room[] array, int mazeRow, int mazeCol, int goalRow, int goalCol);

  /**
   * Wrapper function for possibleMoves.
   */
  ArrayList<String> getMoves();

  /**
   * possibleMoves returns the possible moves a player can make.
   */

  ArrayList<String> possibleMoves(String mazeType, Room[] array, ArrayList<String> walls,
      ArrayList<String> possibleMoves, int mazeRow, int mazeCol);

  /**
   * Wrapper for got gold. 
   * @return
   */
  String gotGold();
  
  /** 
   * Wrapper for was attacked.
   * @return
   */
  String wasAttacked();
  
  /**
   * Checks if player got gold. 
   *
   */
  String checkGotGold(Room[] array, int row, int col);
  
  /**
   * Checks if player was attacked.
   */
  String checkWasAttacked(Room[] array, int row, int col);
  
  /**
   * Wrapper for action method.
   */
  int Event();

  /**
   * Action determines what happens to a player in the room. Depending on if a
   * thief or gold is in the room.
   */
  int Action(Room[] array, int mazeRow, int mazeCol);

  /**
   * makeWalls makes the walls in the maze.
   */
  ArrayList<String> makeWalls(int mazeRow, int mazeCol, ArrayList<String> walls);

  /**
   * showWalls shows the walls in the maze.
   */
  ArrayList<String> showWalls(ArrayList<String> walls);

  /**
   * makeSets makes the initials sets in the maze. Sets represent rooms that are
   * linked by a hallway.
   */
  Map<String, Set<String>> makeSets(int mazeRow, int mazeCol, Map<String, Set<String>> sets,
      ArrayList<String> walls);

  /**
   * updateSets updates the sets in the maze after a wall has been broken.
   */
  Map<String, Set<String>> updateSets(int mazeRow, int mazeCol, Map<String, Set<String>> sets,
      ArrayList<String> removedWalls);

  /**
   * updateSetsHelper calculates all the connections from other cells that are
   * linked to a certain cell have. Helps the updateSets method by doing this.
   */
  void updateSetsHelper(Map<String, Set<String>> set);

  /**
   * canBreakWall determines if a wall can be broken.
   */
  Boolean canBreakWall(String breakWall, Map<String, Set<String>> sets, ArrayList<String> walls);

  /**
   * breakWall breaks a wall between two cells.
   */
  ArrayList<String> breakWall(String breakWall, ArrayList<String> walls,
      ArrayList<String> removedWalls);

  /**
   * buildMaze builds the specified maze.
   */
  void buildMaze(ArrayList<String> walls, ArrayList<String> removedWalls,
      Map<String, Set<String>> sets, String mazeType, int row, int col, int goal);
  
}
