import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents the CharacterBuilder, which is responsible for creating
 * a character object. The class determines the highest power of attire for each 
 * character object it creates.
 * 
 * @author Ugo Nwachuku
 */
public class CharacterBuilder {

  protected Character player; 
  protected String playerName; 
  protected ArrayList <WearableGear> attire; 
  protected ArrayList <WearableGear> bestHeadGear;
  protected ArrayList <WearableGear> bestHandGear;
  protected ArrayList <WearableGear> bestFootwear;
  protected HeadGear combinedHeadGear;
  protected HandGear combinedHandGear;
  protected Footwear combinedFootwear;
  protected int attack;
  protected int defense;
  
  
  /**
   * CharacterBuilder constructor: constructs a character with the highest power 
   * of attire. 
   */
  public CharacterBuilder(String name, ArrayList <WearableGear> wearable) {
    
    Wear(wearable);
    this.attack = getAttack();
    this.defense = getDefense();
    player = new Character(name, this.attire, this.attack, this.defense);
  }
  
  /**
   * uniqueCombinations finds the unique combinations of all elements in a list.
   * 
   * @param an ArrayList
   * Returns indexes of combinations in a list
   */
  public ArrayList <ArrayList <Integer>> uniqueCombinations(ArrayList <WearableGear> list) { 

    // Find all combinations
    ArrayList <ArrayList <Integer>> total = new ArrayList<>();
    for (int i = 0; i <= list.size(); i++) {
      
      for (int y = i + 1; y <= list.size(); y++) {
        ArrayList <Integer> midList = new ArrayList<>();
        total.add(midList);
      }
    }
    return total;
  }
  
  /** 
   * getAttack returns the total attack from an attire list.
   * 
   * @param Nothing
   * Returns integer attack value
   */
  public int getAttack(){ 
    int totalAttack = 0;
    for (int i = 0; i < this.attire.size(); i++) {
      totalAttack += this.attire.get(i).getAttack();
    }
    return totalAttack;
  }
  
  /** 
   * getDefense returns the total defense from an attire list.
   * 
   * @param Nothing
   * Returns integer attack value
   */
  public int getDefense(){ 
    int totalDefense = 0;
    for (int i = 0; i < this.attire.size(); i++) {
      totalDefense += this.attire.get(i).getDefense();
    }
    return totalDefense;
  }

  /**
   * Wear function  sorts the type of attire for the character, and dresses the 
   * character in the highest power attire. 
   * 
   * @param ArrayList of wearable attire
   */
  public void Wear(ArrayList <WearableGear> wearable) { 
    ArrayList <WearableGear> headGear = new ArrayList<WearableGear>();
    ArrayList <WearableGear> handGear = new ArrayList<WearableGear>();
    ArrayList <WearableGear> footWear = new ArrayList<WearableGear>();
    
    for (int i = 0; i < wearable.size(); i++) { 
      if (wearable.get(i) instanceof HeadGear) { 
        headGear.add(wearable.get(i));
      }
      if (wearable.get(i) instanceof HandGear) { 
        handGear.add(wearable.get(i));
      }
      if (wearable.get(i) instanceof Footwear) { 
        footWear.add(wearable.get(i));
      }
    }
    
    /** Get best gear on all types of items **/
    this.bestHeadGear = getBestGear(headGear);
    this.bestHandGear = getBestGear(handGear);
    this.bestFootwear = getBestGear(footWear);
    
    /** Combine best gear **/
    this.combinedHeadGear = (HeadGear) combineBestGear(headGear);
    this.combinedHandGear = (HandGear) combineBestGear(handGear);
    this.combinedFootwear = (Footwear) combineBestGear(footWear);
    
    /** Add to attire list **/
    this.attire.add(this.combinedHeadGear);
    this.attire.add(this.combinedHandGear);
    this.attire.add(this.combinedFootwear);
  }
  
  /**
   * getBestHeadGear function combines and returns highest scoring gears. 
   * 
   * @param ArrayList of Wearable gears
   * Returns best wearable gear from list
   */
  public ArrayList <WearableGear> getBestGear(ArrayList <WearableGear> gear) {
    if (gear.size() == 1) { return gear; } 
    if (gear.size() == 0) { 
      ArrayList <WearableGear> dummyList = new ArrayList <WearableGear>();
      return dummyList;
    }
    
    ArrayList <ArrayList <Integer>> combinationList = uniqueCombinations(gear);
    ArrayList <Integer> scores = new ArrayList<Integer>();
    
    for (int i = 0; i < combinationList.size(); i++) {
      ArrayList<Integer> intSet = combinationList.get(i);
      int gearIndex1 = intSet.get(0);
      int gearIndex2 = intSet.get(1);
      
      /** Get scores from unique combinations **/
      int sum = gear.get(gearIndex1).getAttack() + gear.get(gearIndex2).getAttack();
      /** Store scores **/
      scores.add(sum);
    }
    /** Find combination with highest score **/
    int highestAttack = Collections.max(scores);
    int combinationIdx = combinationList.indexOf(highestAttack);
    
    ArrayList <Integer> highest_combIdx = combinationList.get(combinationIdx);
    int first_idx = highest_combIdx.get(0);
    int second_idx = highest_combIdx.get(1);
    
    /** return highest combining Wearable gears **/
    ArrayList <WearableGear> bestCombination = new ArrayList<WearableGear>();
    bestCombination.add(gear.get(first_idx));
    bestCombination.add(gear.get(second_idx));
    
    return bestCombination;
  }
  


  /**
   * combineBestGear function combines two types of gears. 
   * 
   * @param ArrayList of Wearable gears
   * Returns Wearable gear combination
   */
  public WearableGear combineBestGear(ArrayList <WearableGear> gear) {
    if (gear.size() == 1) { return gear.get(0); }
    
    /** Get adjective **/
    String adjective = gear.get(0).getAdjective();
    /** Get name **/
    String name = adjective + ", " + gear.get(1).getName();
    /** Get defense  **/
    int defense0 = gear.get(0).getDefense();
    int defense1 = gear.get(1).getDefense();
    int totaldefense = defense0 + defense1;
    /** Get attack **/
    int attack0 = gear.get(0).getAttack();
    int attack1 = gear.get(1).getAttack();
    int totalattack = attack0 + attack1;
    
    if (gear.get(0) instanceof HeadGear) { 
      HeadGear combinedHeadGear = new HeadGear(name, totaldefense);
      return combinedHeadGear;
    }
    if (gear.get(0) instanceof HandGear) { 
      HandGear combinedHandGear = new HandGear(name, totalattack);
      return combinedHandGear;
    }
    if (gear.get(0) instanceof Footwear) { 
      Footwear combindedFootwear = new Footwear(name, totalattack, totaldefense);
      return combindedFootwear;
    }
    HeadGear dummyGear = new HeadGear("",0);
    return dummyGear;
    
  }
  
}

