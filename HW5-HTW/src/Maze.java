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
   * insertCaves fills every position in the maze with Cave objects.
   */
  Cave[] insertCaves(Cave[] array, int mazeRow, int mazeCol);

  /**
   * getCaves returns all the caves in the maze.
   */
  Cave[] getCaves();

  /**
   * getWalls returns all the walls in the maze.
   */
  ArrayList<String> getWalls();

  /**
   * updatePlayerPosition updates Cave to reflect position of player.
   */
  void updatePlayerPosition(Cave[] array, int mazeRow, int mazeCol, int newPlayRow, int newPlayCol);

  /**
   * updatePlayerPosition2 updates Cave to reflect position of player for two
   * players.
   */
  void updatePlayerPosition2(Cave[] array, int row, int col, int newPosRow, int newPosCol,
      int newPosRow2, int newPosCol2);

  /**
   * wrapper to find current cave player is in.
   */
  Cave currentCave();

  /**
   * finds current cave player is in.
   */
  Cave getCave(Cave[] array, int row, int col);

  /**
   * findPlayerPosition wrapper for playerPosition function.
   */
  String findPlayerPosition(int pNum);

  /**
   * findPlayer wrapper for playerLocation function.
   */
  String findPlayer(int pNum);

  /**
   * Returns player position in a different format.
   */
  String playerPosition(int p, Cave[] array, int row, int col);

  /**
   * playerLocation returns the players location in the maze.
   * 
   * @return string location of player
   */
  String playerLocation(int p, Cave[] array, int mazeRow, int mazeCol);

  /**
   * findCave finds cave by name in maze.
   */
  Cave findCave(Cave[] array, int row, int col, int posRow, int posCol);

  /**
   * locateCave finds a cave basedon secondary name.
   */
  Cave locateCave(Cave[] array, int row, int col, String num);

  /**
   * Prints all startable locations for the player.
   */
  ArrayList<String> printLocations(Cave[] array, int row, int col);

  /**
   * Wrapper function for playerMove.
   */
  Cave[] makeMove(String move, ArrayList<String> moves, Cave[] cav, int p, int numP);

  /**
   * playerMoves moves a player in the cell.
   */
  Cave[] playerMove(int mazeRow, int mazeCol, String mazeType, Cave[] array, String move, int p,
      int numP);

  /**
   * Wrapper for fire arrow.
   */
  String fire(int dist, int direct, int turn);

  /**
   * Shoots arrow in the maze.
   */
  String shootArrow(Cave[] array, ArrayList<String> walls, String mazeType, int row, int col,
      int distance, int direction, int turn);

  /**
   * BoundaryHelper, updates the row and columns of a wrapping Cave maze
   * properly.
   */
  int[] boundaryHelper(int row, int col, int mazeRow, int mazeCol);

  /**
   * Wrapper function for possibleMoves.
   */
  ArrayList<String> getMoves(int p);

  /**
   * possibleMoves returns the possible moves a player can make.
   */
  ArrayList<String> possibleMoves(String mazeType, Cave[] array, ArrayList<String> walls,
      ArrayList<String> possibleMoves, int mazeRow, int mazeCol, int p);

  /**
   * makeWalls makes the walls in the maze.
   */
  ArrayList<String> makeWalls(int mazeRow, int mazeCol, ArrayList<String> walls);

  /**
   * showWalls shows the walls in the maze.
   */
  ArrayList<String> showWalls(ArrayList<String> walls);

  /**
   * doorCount counts the doors in the maze.
   */
  Map<String, Integer> doorCount(Cave[] array, int row, int col, ArrayList<String> walls);

  /**
   * makeNeighbours finds the neighbours in the maze.
   */
  Map<String, ArrayList<String>> makeNeighbours(Cave[] array, int row, int col,
      ArrayList<String> walls);

  /**
   * builTunnels builds tunnels in the maze.
   */
  void buildTunnels(Cave[] array, Map<String, Integer> doors,
      Map<String, ArrayList<String>> neighbours);

  /**
   * makeSets makes the initial sets in the maze. Sets represent Caves that are
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
      Map<String, Set<String>> sets, String mazeType, int row, int col, int goal, Boolean s);

}
