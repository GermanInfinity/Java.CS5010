import java.util.ArrayList;

public interface Maze {
  
  /**
   * insertRooms fills every position in the maze with room objects.
   */
  void insertRooms();
  /**
   * spreadGold spreads gold in 20% of the cells in the maze. 
   */
  void spreadGold(); 
  
  /**
   * spreadThief places thieves in 10% of the cells in the maze.
   */
  void spreadThief(); 
  
  /**
   * playerLocation returns the players location in the maze. 
   * @return
   */
  String playerLocation(); 
  
  /**
   * playerMoves moves a player in the cell. 
   */
  void playerMove(); 
  
  /**
   * mazeSolved returns if the maze has been solved or not. 
   * @return true or false
   */
  Boolean mazeSolved(); 
  /**
   * possibleMoves returns the possible moves a player can make. 
   */
  
  void possibleMoves(); 
  
  /** 
   * Action determines what happens to a player in the room.
   * Depending on if a thief or gold is in the room.
   */
  void Action(); 
  
  /**
   * makeWalls makes the walls in the maze. 
   */
  void makeWalls(); 
  
  /**
   * showWalls shows the walls in the maze. 
   */
  ArrayList<String> showWalls();
  /**
   * makeSets makes the initials sets in the maze. Sets represent rooms that 
   * are linked by a hallway.
   */
  void makeSets(); 
  
  /**
   * updateSets updates the sets in the maze after a wall has been broken. 
   */
  void updateSets(); 
  
  /**
   * updateSetsHelper calculates all the connections from other cells that are linked to 
   * a certain cell have. Helps the updateSets method by doing this. 
   */
  void updateSetsHelper(); 
  
  /**
   * breakWall breaks a wall between two cells. 
   */
  void breakWall(); 
}
