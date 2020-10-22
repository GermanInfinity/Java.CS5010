import java.util.ArrayList;
import java.util.Random;

public class Player {

  private String name;
  private String position; 
  private double gold;
  
  public Player(String name, String position, double gold) {
   
    if (gold < 0) { 
      throw new IllegalArgumentException ("Cannot start player with negative gold value.");
    }
    this.name = name; 
    this.position = position; 
    this.gold = gold; 
    
  }
  
  public String getName() { 
    return this.name;
  }
  
  public void setName(String name) { 
    this.name = name; 
  }
  
  public String pickMove(ArrayList<String> moves) { 
    Random ran = new Random();
    int i = ran.nextInt(moves.size()) + 0;
    return moves.get(i);
  }
  
  public String getPosition() { 
    return this.position;
  }
  
  public void setPosition(String position) { 
    this.position = position; 
  }
  
  public double getGold() { 
    return this.gold;
  }
  
  public void addGold(double gold) { 
    this.gold += gold; 
  }

  @Override
  public String toString() { 
    return this.name + " is at " + this.position + " and has " + this.getGold();
  }
}
