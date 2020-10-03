
/**
 * This class represents the HeadGear class which implements the 
 * WearableGear interface. The class is responsible for storing 
 * the attack and defense values of a HeadGear. 
 */

public class HeadGear implements WearableGear{

  protected String name;
  protected int attack;
  protected int defense;
  
  /**
   * HeadGear constructor, constructs a head gear object with it's name,
   * attack and defense values. 
   * 
   * @param: String value for name, int value for the attack, int value for
   *         defense
   * Returns: HeadGear object
   */
  public HeadGear(String inp_name, int inp_defense) {

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
    
  }

  /**
   * setName sets the name of a HeadGear.
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
   * getName returns the name of a HeadGear.
   * @param does not accept anything
   * Returns String name of an object
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * getAdjective returns the adjective in the name of the HeadGear.
   * @param accepts nothing
   * Returns String adjective
   */
  @Override
  public String getAdjective() {
    String[] splited = this.name.split("\\s+");
    return splited[0];
  }
  
  /**
   * setDefense sets defense value of a HeadGear object. 
   * @param accepts int value
   * Returns does not return anything
   */
  public void setDefense(int inp_defense) {
    if (inp_defense < 0){
      throw new IllegalArgumentException("No non-negative defense values.");
    }
    this.defense = inp_defense;
  }
  
  
  /**
   * getDefense returns defense value of a HeadGear object. 
   * @param does not accept anything
   * Returns int defense value
   */
  public int getDefense() {
    return this.defense;
  }
  
  /**
   * getAttack returns attack value of a HeadGear object. 
   * @param does not accept anything
   * Returns int attack value
   */
  public int getAttack() {
    return this.attack;
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
