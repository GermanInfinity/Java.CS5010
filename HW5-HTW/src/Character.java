
/**
 * This interface represents all possible characters that could exist in the maze.
 * @author ugoslight
 *
 */
public interface Character {
  
  /**
   * getName Returns the type of character object.
   * 
   */
  String getType(); 
  
  /**
   * pickMove Picks a move for the character.
   */
  String pickMove(int direction);
  
  /**
   * action Performs an operation from the type of character.
   */
  String action();
  
  /**
   * toString string representation of the character. 
   */
  String toString();

 
  
}
