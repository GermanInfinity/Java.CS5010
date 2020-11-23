
/**
 * This class represents a Wumpus in the maze. 
 * @author ugoslight
 *
 */
public class Wumpus implements Character{

  private String name;
  private Boolean alive; 
 
  
  public Wumpus(String name, Boolean alive) {
    this.name = name;
    this.alive = alive;
  }

  public String action() { 
    return "Player capped.";
  }
  
  public String toString() { 
    return "Hi, I'm a Wumpus. Eat me!";
  }
  
  public Boolean isAlive() { 
    return this.alive; 
  }
  
  public void setAlive(Boolean alive) { 
    this.alive = alive;
  }

  @Override
  public String getType() {
    return this.name; 
  }

  @Override
  public String pickMove(int a) {
    return null;
  }

}

