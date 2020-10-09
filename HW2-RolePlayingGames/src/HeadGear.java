
/**
 * This class represents the HeadGear class which extends the 
 * WearableGear abstract class. The class is responsible for storing 
 * the attack and defense values of a HeadGear. 
 */

public class HeadGear extends WearableGear{

  /**
   * HeadGear constructor, constructs a head gear object with it's name,
   * attack and defense values. 
   * 
   * @param: String value for name, int value for the attack, int value for
   *         defense
   * Returns: HeadGear object
   */
  public HeadGear(String inp_name, int inp_defense, Boolean combined, Boolean valid) {

    if (inp_name == ""){
      throw new IllegalArgumentException("No name inputed!");
    }
    if (inp_name.split("\\s+").length != 2){
      throw new IllegalArgumentException("Name is comprised of an adjective and a noun");
    }
    if (inp_defense < 0){
      throw new IllegalArgumentException("Defense cannot be less than zero.");
    }
    
    this.name = inp_name;
    this.defense = inp_defense;
    this.attack = 0;
    this.isCombined = combined;
    this.isValid = valid; 
    
  }


  @Override
  public void setAttack(int att) {
    if (att != 0) { 
      throw new IllegalArgumentException  
        ("Attack value can only be 0 for a HeadGear object.");
      }
  }
  
  
  
  @Override 
  protected Boolean equalsHeadGear(WearableGear object) { 
    return true;
  }
  
  
  
  @Override 
  public Boolean equals(WearableGear object) { 
    return object.equalsHeadGear(this);
  }
  
  
  
  /** It is important to note Headgear objects are not allowed to combine **/ 
  @Override
  public WearableGear combine(WearableGear object) { 

    HeadGear dummyHeadgear = new HeadGear("Dummy gear", 0, false, false);
    return dummyHeadgear;
  }
  
  /**
   * toString method returns string representation of a HeadGear object.
   * Returns String value
   */
  @Override
  public String toString() { 
    return this.name + ", Attack: " + this.attack + ", Defense: " + this.defense;  
  }

}
