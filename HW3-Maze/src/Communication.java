import java.util.ArrayList;

/**
 * This class represents the communication between the model and controller. 
 * @author Ugo Nwachcuku
 *
 */
public class Communication {

  /**
   * Communication constructor, constructs a communication object that
   * is used to send information between the controller and the model. 
   */
  public Communication(int row, int col, int startRow, int startCol, int goalRow, int goalCol) {
    
    if (row < 0 || col < 0 || startRow < 0 || goalRow < 0 || startCol < 0 || goalCol < 0) {
      throw new IllegalArgumentException("No negative values.");
    }
    if (startRow < 0 || startRow >= row || startCol < 0 || startCol >= col) {
      throw new IllegalArgumentException("Invalid starting entry.");
    }
    if (goalRow < 0 || goalRow >= row || goalCol < 0 || goalCol >= col) {
      throw new IllegalArgumentException("Invalid goal locaion.");
    }
    
    Maze maze = new MazeBuilder(row, col, startRow, startCol, goalRow, goalCol);
    
  }
  /**
   * MazeOn get's boolean value if maze is solved or not. 
   */
  public Boolean MazeOn(){ 
    return false; 
  }
  /**
   * getMoves get's the possible moves on the maze.
   */
  public ArrayList<String> getMoves() {
    ArrayList<String> moves = new ArrayList<String>();
    return moves; 
  }
  /**
   * playMoves move's player on maze.
   */
  public void playMove(String move) { 
    
  }
  
}
