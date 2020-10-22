
public class Room {

  private String name;
  private Boolean thief;
  private double goldValue;
  
  public Room(String name, Boolean thief, double gold) {
    if (gold < 0) { 
      throw new IllegalArgumentException ("Gold value cannot be negative.");
    }
    this.name = name;
    this.thief = thief;
    this.goldValue = gold;
    
    
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
