
/**
 * This class represents the HandGear class which extends the 
 * WearableGear abstract class. The class is responsible for storing 
 * the attack and defense values of a HandGear. 
 */

public class HandGear extends WearableGear{

  /**
   * HandGear constructor, constructs a head gear object with it's name,
   * attack and defense values. 
   * 
   * @param: String value for name, int value for the attack, int value for
   *         defense
   * Returns: HandGear object
   */
  public HandGear(String inp_name, int inp_attack, Boolean combined, Boolean valid) {

    if (inp_name == ""){
      throw new IllegalArgumentException("No name inputed!");
    }
    if (inp_name.split("\\s+").length != 2){
      throw new IllegalArgumentException("Name is comprised of an adjective and a noun");
    }
    if (inp_attack < 0){
      throw new IllegalArgumentException("Attack cannot be less than zero.");
    }
    
    this.name = inp_name;
    this.attack = inp_attack;
    this.defense = 0;
    this.isCombined = combined;
    this.isValid = valid;
    
  }


   
  @Override
  public void setDefense(int def) {
    if (def != 0) { 
      throw new IllegalArgumentException  
        ("Defense value can only be 0 for a HandGear object.");
      }
     
    this.defense = def;
  }
  
  
  
  @Override 
  protected Boolean equalsHandGear(WearableGear object) { 
    return true;
  }
  
  
  
  @Override 
  public Boolean equals(WearableGear object) {
    object.equalsHandGear(this);
    return false;
  }
  
  
  
  @Override
  public WearableGear combine(WearableGear object) { 
    if (equals(object)) { 
      String name = this.getAdjective() + ", " + object.getName();
      int attack = this.getAttack() + object.getAttack();
      
      HandGear newHandgear = new HandGear(name, attack, true, true);
      return newHandgear;
    }
    HandGear dummyHandgear = new HandGear("Dummy gear", 0, false, false);
    return dummyHandgear;
  }
  

  /**
   * toString method returns string representation of a HandGear object.
   * Returns String value
   */
  @Override
  public String toString() { 
    return this.name + ", Attack: " + this.attack + ", Defense: " + this.defense;  
  }

  

}
