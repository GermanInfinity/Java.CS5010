import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a Superbat class object.
 * @author ugoslight
 *
 */
public class SuperBat implements Character {

  private String name;
  
  /**
   * Constructor for super bat object.
   * @param type of superbat
   */
  public SuperBat(String type) {
    this.name = type; 
  }

  
  
  
  @Override
  public String getType() {
    return this.name; 
  }

  
  

  /**
   * Produces a new random location to transport the player to.
   * @param locations all possible locations player could go
   */
  public ArrayList<Integer> action(ArrayList<Cave> locations) {
    Random ran = new Random();
    int num =  ran.nextInt(locations.size());
    ArrayList<Integer> ans = new ArrayList<Integer>();
    Cave toCave = locations.get(num);
    int newRow = java.lang.Character.getNumericValue(toCave.getName().charAt(0));
    int newCol = java.lang.Character.getNumericValue(toCave.getName().charAt(1));
    ans.add(newRow); 
    ans.add(newCol);
    return ans;
  }


}
