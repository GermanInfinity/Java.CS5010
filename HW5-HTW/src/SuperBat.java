import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a Superbat class object.
 * @author ugoslight
 *
 */
public class SuperBat implements Character {

  private String name;
  
  public SuperBat(String type) {
    this.name = type; 
  }

  @Override
  public String getType() {
    return this.name; 
  }


  /**
   * Produces a new random location to transport the player to.
   * @param row row size of maze
   * @param col column size of maze
   */
  public ArrayList<Integer> action(int row, int col) {
    Random ran = new Random();
    int newRow = ran.nextInt(row);
    int newCol = ran.nextInt(col);
    ArrayList<Integer> ans = new ArrayList<Integer>();
    ans.add(newRow); 
    ans.add(newCol);
    return ans;
  }

  @Override
  public String action() {
    return null;
  }
  
  @Override
  public String pickMove(int direction) {
    return null;
  }

}
