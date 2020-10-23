
public class Room {

  private String name;
  private Boolean thief;
  private double goldValue;
  private Boolean playerIn;
  
  public Room(String name, Boolean thief, Boolean playerIn, double gold) {
    if (gold < 0) { 
      throw new IllegalArgumentException ("Gold value cannot be negative.");
    }
    this.name = name;
    this.thief = thief;
    this.goldValue = gold;
    this.playerIn = playerIn; 
    
    
  }
  
  public void setName(String name) { 
    this.name = name;
  }
  
  public String getName() { 
    return this.name;
  }
  
  public Boolean hasThief() { 
    return thief;
  }
  
  public int thiefAttack() {
    return -50;
  }
  
  public Boolean hasPlayer() { 
    return playerIn;
  }
  
  public void setPlayerIn(Boolean in) { 
    this.playerIn = in;
  }
  public void placeThief(Boolean placed) { 
    this.thief = true; 
  }
  
  public void setGold(double gold) { 
    if (gold < 0) { 
      throw new IllegalArgumentException ("Gold value cannot be negative.");
    }
    this.goldValue = gold;
  }
  
  public double getGold() { 
    return goldValue;
  }
  
  

}
