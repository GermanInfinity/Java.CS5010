
/**
 * This class represents the Footwear class which implements the 
 * WearableGear interface. The class is responsible for storing 
 * the attack and defense values of a Footwear. 
 */

public class Footwear implements WearableGear{

  protected String name;
  protected int attack;
  protected int defense;
  
  /**
   * Footwear constructor, constructs a head gear object with it's name,
   * attack and defense values. 
   * 
   * @param: String value for name, int value for the attack, int value for
   *         defense
   * Returns: Footwear object
   */
  public Footwear(String inp_name, int inp_attack, int inp_defense) {

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
    
  }

  /**
   * setName sets the name of a Footwear.
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
   * getName returns the name of a Footwear.
   * @param does not accept anything
   * Returns String name of an object
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * getAdjective returns the adjective in the name of the Footwear.
   * @param accepts nothing
   * Returns String adjective
   */
  @Override
  public String getAdjective() {
    String[] splited = this.name.split("\\s+");
    return splited[0];
  }
  
  
  @Override
  public void setDefense(int inp_defense) {
    if (inp_defense < 0){
      throw new IllegalArgumentException("No non-negative defense values.");
    }
    this.defense = inp_defense;
  }
  
  
  
  @Override
  public int getDefense() {
    return this.defense;
  }
  
  
  @Override
  public void setAttack(int inp_attack) {
    if (inp_attack < 0){
      throw new IllegalArgumentException("No non-negative attack values.");
    }
    this.attack = inp_attack;
  }
  
  
  @Override
  public int getAttack() {
    return this.attack;
  }
  
  /**
   * toString method returns string representation of a Footwear object.
   * Returns String value
   */
  @Override
  public String toString() { 
    return this.name + ", Attack: " + this.attack + ", Defense: " + this.defense;  
  }

}
