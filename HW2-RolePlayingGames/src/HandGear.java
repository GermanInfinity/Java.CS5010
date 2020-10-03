
/**
 * This class represents the HandGear class which implements the 
 * WearableGear interface. The class is responsible for storing 
 * the attack and defense values of a HandGear. 
 */

public class HandGear implements WearableGear{

  protected String name;
  protected int attack;
  protected int defense;
  
  /**
   * HandGear constructor, constructs a head gear object with it's name,
   * attack and defense values. 
   * 
   * @param: String value for name, int value for the attack, int value for
   *         defense
   * Returns: HandGear object
   */
  public HandGear(String inp_name, int inp_attack) {

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
    
  }

  /**
   * setName sets the name of a HandGear.
   * @param String name of an object
   * Returns does not return anything
   */
  @Override
  public void setName(String inp_name) {
    if (inp_name == ""){
      throw new IllegalArgumentException("No name inputed!");
    }
    if (inp_name.split("\\s+").length != 2){
      throw new IllegalArgumentException("Name is comprised of an adjective and a noun");
    }
    this.name = inp_name;
  }

  /**
   * getName returns the name of a HandGear.
   * @param does not accept anything
   * Returns String name of an object
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * getAdjective returns the adjective in the name of the HandGear.
   * @param accepts nothing
   * Returns String adjective
   */
  @Override
  public String getAdjective() {
    String[] splited = this.name.split("\\s+");
    return splited[0];
  }
  
  /**
   * setDefense sets defense value of a HandGear object. 
   * @param accepts int value
   * Returns does not return anything
   */
  public void setAttack(int inp_attack) {
    if (inp_attack< 0){
      throw new IllegalArgumentException("No non-negative attack values.");
    }
    this.attack = inp_attack;
  }
  
  
  /**
   * getAttack returns attack value of a HandGear object. 
   * @param does not accept anything
   * Returns int attack value
   */
  public int getAttack() {
    return this.attack;
  }
  
  /**
   * getAttack returns defense value of a HandGear object. 
   * @param does not accept anything
   * Returns int defense value
   */
  public int getDefense() {
    return this.defense;
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
