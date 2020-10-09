import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * This class represents the CharacterBuilder, which is responsible for creating
 * a character object. The class determines the highest power of attire for each 
 * character object it creates, wears a character object with these attires; and 
 * outputs a character object.
 * 
 * @author Ugo Nwachuku
 */
public class CharacterBuilder {

  protected Character player; 
  protected String playerName; 
  protected ArrayList <WearableGear> attire = new ArrayList<WearableGear>(); 
  protected int attack;
  protected int defense;
  
  protected ArrayList <ArrayList <Integer>> gearCombinations; 
  
  /**
   * CharacterBuilder constructor: constructs a character with the highest power 
   * of attire. 
   */
  public CharacterBuilder(String name, ArrayList <WearableGear> wearable) {
    
    Wear(wearable);
    HeadGear dropHead = new HeadGear("Dummy HeadGear",0, false, false);
 
    MakeGearSolo(dropHead);
 
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
      
      for (int y = i + 1; y < list.size(); y++) {
        ArrayList <Integer> midList = new ArrayList<>();
        midList.add(i);
        midList.add(y);
        total.add(midList);
      }
    }
    
    return total;
  }
  
  
  /** 
   * MakeGearSolo function drops a specified gear from the attire list till there is only
   *              one left. 
   *
   * @param Takes in WearableGear type to be dropped
   * Returns nothing
   */
  public void MakeGearSolo(WearableGear drop) { 
    int count = 0; 

    /** get number of occurences **/
    for (int i = 0; i < this.attire.size(); i++) { 
      WearableGear currentAttire = this.attire.get(i);

      if (currentAttire.equals(drop)){ 
        count += 1; 
        }
    }
    
    /** Drop gears from lowest to highest **/ 
    if (count > 1) {      
      for (int i = this.attire.size()-1; i >= 0; i--) { 
        WearableGear currentAttire = this.attire.get(i);
        if (currentAttire.equals(drop)){
          
          if (count == 1) { break; }
          
          this.attire.remove(i);
          count -= 1;
          
        }
      }  
    }
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
    /** Combine all types of gears **/ 
    /** We create combinations on all gears.
     */
    this.gearCombinations = uniqueCombinations(wearable);
    
   
    /** Combine all gears, but set valid parameter on combinable gears **/ 
    ArrayList <WearableGear> combinedGears = new ArrayList<WearableGear>();
    for (int i = 0; i < this.gearCombinations.size(); i++) { 
      ArrayList<Integer> indexes = this.gearCombinations.get(i);
      
      WearableGear first = wearable.get(indexes.get(0)); 
      WearableGear second = wearable.get(indexes.get(1)); 
      WearableGear newGear = combineGears(first, second);
      
      combinedGears.add(newGear);
    }
    /**Add combined gears original gear list **/
    wearable.addAll(combinedGears);

    /** Invalid Gears **/
    wearable = DropInvalidGears(wearable);
    
    /**
     * Sort wearable list from highest to lowest.
     */
    Comparator<WearableGear> attacks = (c1, c2) -> (int) (c1.getAttack() - c2.getAttack()); 
    wearable.sort(Collections.reverseOrder(attacks)); 
    getBestGear(wearable);
    
  }
  
  
  
  /**
   * combineGears function combines two similar type of gears.
   *             the first input parameter gear is modified to be the newly
   *             combined gear, if they are of the same type. 
   * @param Wearable gear, Wearable gear
   * returns nothing
   */
  public WearableGear combineGears(WearableGear gear1, WearableGear gear2) { 
    return gear1.combine(gear2);
  }
  
  
  

  /**
   * getBestHeadGear function populates the attire list with the highest scoring gears. 
   * 
   * @param ArrayList of Wearable gears
   * Returns best wearable gear from list
   */
  public void getBestGear(ArrayList <WearableGear> wearable) {
    
    /** Add to attire list, highest powered items **/ 
    for (int i = 0; i < wearable.size(); i++) { 

      WearableGear currentGear = wearable.get(i);
      
      /** First entry in attire list. **/ 
      if (this.attire.size() == 0) { 
        this.attire.add(currentGear);
        continue;
      }

      int similarTypeCount = 0;
 
      /** Loop to check what is already in attire list **/
      for (int y = 0; y < this.attire.size(); y++) { 
        WearableGear attireGear = this.attire.get(y);
        
        if (attireGear.getCombined() && currentGear.equals(attireGear)) { 
          similarTypeCount = 2;
          break;
        }
        
        /** Seen the same type **/
        if (currentGear.equals(attireGear)) { similarTypeCount += 1; }
      }
      
      if (similarTypeCount < 2) { this.attire.add(currentGear); }
    }

  }
  
  
  
  /**
   * DropInvalidGears function drops all invalid gears from an arraylist of wearableGears
   * 
   * @param ArrayList <WearableGear> wearable
   * Returns ArrayList <WearableGear> wearable
   */
  public ArrayList <WearableGear> DropInvalidGears(ArrayList <WearableGear> wearable){ 
    ArrayList <WearableGear> edittedList = new ArrayList<WearableGear>(); 
    for (int i = 0; i < wearable.size(); i++) { 
      WearableGear currentGear = wearable.get(i); 
      if (currentGear.getValid()) { 
        edittedList.add(currentGear);
      }
    }
    return edittedList;
  }
  
  /**
   * This method builds a completely constructed Character.
   *
   * @return level Level Object
   * 
   */
  public Character build() { 
    return player;
  }
  
}

