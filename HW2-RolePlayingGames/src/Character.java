import java.util.ArrayList;

/**
 * This class represents the Character class which implements.
 * The class is responsible for storing the name, attire, attack and defense values,
 * of a Character.
 */

public class Character {

  protected String name;
  protected ArrayList<WearableGear> attire;
  protected int attack;
  protected int defense; 
  
  /**
   * Character constructor; constructs a Character with a name, attire 
   * and determines attack and defense values. 
   * 
   * @param String name, 
   */
  public Character(String inp_name, ArrayList<WearableGear> inp_attire, 
                                                 int inp_attack, int inp_defense) {
    
    if (inp_attack < 0) { 
      throw new IllegalArgumentException 
        ("Only Non-negative attack values allowed.");
    }
    if (inp_defense < 0) { 
      throw new IllegalArgumentException 
        ("Only Non-negative defense values allowed.");
    }
    this.name = inp_name;
    this.attire = inp_attire; 
    this.attack = inp_attack;
    this.defense = inp_defense; 
    
    /**
     * This statement is here to modify the name appropriately.
     */
    if (inp_name == "") { 
      this.name = "unknown";
    }
    
    /** 
     * This if statement check is here to avoid a user creating an attireless player, 
     * but setting attack and defense values. 
     */
    if (inp_attire.size() == 0) {
      this.attack = 0;
      this.defense = 0;
    }
  }
  
  /**
   * setName sets name of a Character.
   * @param String name of an object
   * Returns does not accept anything
   */
  public void setName(String inp_name) {
    this.name = inp_name;
    if (inp_name == "") { 
      this.name = "unknown";
    }
  }
  
  /**
   * getName returns the name of a Character.
   * @param does not accept anything
   * Returns String name of an object
   */
  public String getName() {
    return this.name;
  }
  
  /** 
   * setAttire sets the attire of a player object.
   * @param ArrayList<String> attire list
   * Returns does not return anything
   */
  public void setAttire(ArrayList <WearableGear> inp_attire) { 
    this.attire = inp_attire;
  }
  
  /** 
   * getAttire gets the attire of a player object.
   * @param does not accept anything
   * Returns ArrayList<String> attire list
   */
  public ArrayList<WearableGear> getAttire() { 
    return this.attire;
  }
  
  
  /**
   * setAttack sets attack value of a player object. 
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
   * getAttack returns attack value of a Character object. 
   * @param does not accept anything
   * Returns int attack value
   */
  public int getAttack() {
    return this.attack;
  }
  
  /**
   * setDefense sets defense value of a Character object. 
   * @param accepts int value
   * Returns does not return anything
   */
  public void setDefense(int inp_defense) {
    this.defense = inp_defense;
  }
  
  /**
   * getDefense returns defense value of a Character object. 
   * @param does not accept anything
   * Returns int defense value
   */
  public int getDefense() {
    return this.defense;
  }
  
  /**
   * toString method returns string representation of a Character object.
   * Returns String value
   */
  @Override
  public String toString() { 
    ArrayList<String> attireNames = new ArrayList<String>(); 

    for (int i = 0; i < attire.size(); i++) {
      attireNames.add(this.attire.get(i).getName());
    }
    return this.name + " Attire: " + attireNames +  ", Attack: " + this.attack + 
                                                  ", Defense: " + this.defense;  
  }
  

}
