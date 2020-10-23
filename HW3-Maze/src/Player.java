import java.util.ArrayList;
import java.util.Random;

public class Player {

  private String name;
  //private String location; 
  private double gold;
  
  public Player(String name, int gold) {
   
    if (gold < 0) { 
      throw new IllegalArgumentException ("Cannot start player with negative gold value.");
    }
    this.name = name; 
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
  
  
  public double getGold() { 
    return this.gold;
  }
  
  public void addGold(int gold) { 
    this.gold += gold; 
    if (this.gold < 0) { this.gold = 0; } 
  }

  @Override
  public String toString() { 
    return this.name + " has " + this.getGold();
  }
}
