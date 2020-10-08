
/**
 * This class represents the Footwear class which extends the 
 * WearableGear abstract class. The class is responsible for storing 
 * the attack and defense values of a Footwear. 
 */

public class Footwear extends WearableGear{

  
  /**
   * Footwear constructor, constructs a head gear object with it's name,
   * attack and defense values. 
   * 
   * @param: String value for name, int value for the attack, int value for
   *         defense
   * Returns: Footwear object
   */
  public Footwear(String inp_name, int inp_attack, int inp_defense,  Boolean combined, Boolean valid) {

    if (inp_name == ""){
      throw new IllegalArgumentException("No name inputed!");
    }
    if (inp_name.split("\\s+").length != 2){
      throw new IllegalArgumentException("Name is comprised of an adjective and a noun");
    }
    if (inp_attack < 0){
      throw new IllegalArgumentException("Attack cannot be less than zero.");
    }
    if (inp_defense < 0){
      throw new IllegalArgumentException("Defense cannot be less than zero.");
    }
    
    this.name = inp_name;
    this.attack = inp_attack;
    this.defense = inp_defense;
    this.isCombined = combined;
    this.isValid = valid;
    
  }

  @Override 
  protected Boolean equalsFootwear(WearableGear object) { 
    return true;
  }

  @Override 
  public Boolean equals(WearableGear object) { 
    object.equalsFootwear(this);
    return false;
  }
  
  
  @Override
  public WearableGear combine(WearableGear object) { 
    if (equals(object)) { 
      String name = this.getAdjective() + ", " + object.getName();
      int attack = this.getAttack() + object.getAttack();
      int defense = this.getDefense() + object.getDefense();
      
      Footwear newFootwear = new Footwear(name, attack, defense, true, true);
      return newFootwear;
    }
    Footwear dummyFootwear = new Footwear("Dummy gear", 0, 0, false, false);
    return dummyFootwear;
  }
  
  @Override
  public String toString() { 
    return this.name + ", Attack: " + this.attack + ", Defense: " + this.defense;  
  }

}
