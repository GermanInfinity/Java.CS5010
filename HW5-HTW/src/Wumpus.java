
/**
 * This class represents a Wumpus in the maze. 
 * @author ugoslight
 *
 */
public class Wumpus implements Character {

  private String name;
 
  /**
   * Constructs a wumpus object.
   * @param name of the wumpus
   */
  public Wumpus(String name) {
    this.name = name;
  }

  
  
  
  /**
   * Returns a string on action wumpus takes on player. 
   */
  public String action() { 
    return "Player capped.";
  }
  
  
  
  
  /**
   * Returns string representation of wumpus. 
   */
  public String toString() { 
    return "Hi, I'm a Wumpus. Eat me!";
  }
  

  
  
  /**
   * Returns name of wumpus.  
   */
  @Override
  public String getType() {
    return this.name; 
  }


}

