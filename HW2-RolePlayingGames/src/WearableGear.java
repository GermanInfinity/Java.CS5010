
/**
 * This abstract class represents the WearableGear abstraction. It is a concise
 * declaration of functions used by classes that extend the class. 
 */

public abstract class WearableGear {
  
  protected String name;
  protected int attack;
  protected int defense;
  protected Boolean isValid;
  protected Boolean isCombined;
  
  /**
   * setName: This function sets the name of wearable gear.
   * 
   * @param: String name 
   * Returns: nothing
   */
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
   * getName: This function gets the name of wearable gear.
   * 
   * @param: No parameters Returns: String
   * Returns String name of an object
   */
  public String getName() {
    return this.name;
  }

  /**
   * setValid sets the value of if a WearableGear object is valid or not.
   * 
   * @param Boolean 
   * Returns nothing
   */
  public void setValid(Boolean valid) {
    this.isValid = valid;
  }
  
  /**
   * getValid gets the isValid value of a WearableGear object.
   * 
   * @param nothing
   * Returns Boolean
   */
  public Boolean getValid() {
    return this.isValid;
  }
  
  /**
   * setCombined sets the value of if a WearableGear object was combined or not.
   * 
   * @param Boolean 
   * Returns nothing
   */
  public void setCombined(Boolean combined) {
    this.isCombined = combined;
  }
  
  /**
   * getCombined gets the combined value of a WearableGear object. 
   * 
   * @param nothing
   * Returns Boolean
   */
  public Boolean getCombined() {
    return this.isCombined;
  }
  
  /**
   * getAdjective: This function gets the adjective of wearable gear.
   * 
   * @param: No parameters 
   * Returns: String
   */
  public String getAdjective() {
    String[] splited = this.name.split("\\s+");
    return splited[0];
  }
 
  
  
  /**
   * getAttack returns attack value of a WearableGear object.
   *  
   * @param does not accept anything
   * Returns int attack value
   */
  public int getAttack() {
    return this.attack;
  }
  
  
  
  /**
   * getDefense returns defense value of a WearableGear object. 
   * 
   * @param does not accept anything
   * Returns int defense value
   */
  public int getDefense() {
    return this.defense;
  }
  
  
  
  /**
   * setAttack sets attack value of a WearableGear object.
   *  
   * @param accepts int value
   * Returns does not return anything
   */
  public void setAttack(int inp_attack) {
    if (inp_attack < 0){
      throw new IllegalArgumentException("No non-negative attack values.");
    }
    this.attack = inp_attack;
  }
  
  
  
  /**
   * setDefense sets defense value of a WearableGear object. 
   * 
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
   * combine function combines two WearableGear's of the same type. 
   *         The function adds the attack, defense values and changes the name
   *         per specification. The object being referenced to with the 'this'
   *         operator becomes the newly combined WearableGear. 
   *         
   * @param WearableGear object
   * Returns nothing
   */
  public abstract WearableGear combine(WearableGear object);
  
  
  /**
   * equalsFootwear function is an equality function that determines if an
   *                object is a Footwear object. 
   *                
   * @param accepts WearableGear object
   * Returns Boolean
   */
  protected Boolean equalsFootwear(WearableGear object) { 
    return false; 
  }
  
  
  
  /**
   * equalsHeadgear function is an equality function that determines if an
   *                object is a HeadGear object.
   *                
   * @param accepts WearableGear object
   * Returns Boolean
   */
  protected Boolean equalsHeadGear(WearableGear object) { 
    return false; 
  }
  
  
  /**
   * equalsHandgear function is an equality function that determines if an
   *                object is a HandGear object.
   *                
   * @param accepts WearableGear object
   * Returns Boolean
   */
  protected Boolean equalsHandGear(WearableGear object) { 
    return false; 
  }
  
  
  /**
   * equals function is an equality function that does a deep equality check 
   *        on the equality of two objects.
   *        
   * @param accepts WearableGear object
   * Returns Boolean
   */
  public abstract Boolean equals(WearableGear object);
  
  
  /**
   * toString: This function returns the string representation of a wearable
   * gear.
   * 
   * @param: No parameters Returns: String
   */
  public abstract String toString();
  
}
