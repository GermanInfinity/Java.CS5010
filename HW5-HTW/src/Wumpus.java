
/**
 * This class represents a Wumpus in the maze. 
 * @author ugoslight
 *
 */
public class Wumpus implements Character{

  private String name;
  private Boolean alive; 
 
  /**
   * Constructs a wumpus object.
   * @param name of the wumpus
   * @param alive if the wumpus is alive
   */
  public Wumpus(String name, Boolean alive) {
    this.name = name;
    this.alive = alive;
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

