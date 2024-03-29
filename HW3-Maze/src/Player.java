
/**
 * This class represents the player class. A player is an object that traverses
 * a maze, able to pick up gold coins and be robbed.
 * 
 * @author Ugo Nwachuku
 *
 */
public class Player {

  private String name;
  private double gold;

  /**
   * Player constructor. Constructs a player object with a name, and gold
   * quantity.
   * 
   * @param name is the name of player
   * @param gold is how much gold the player has
   */
  public Player(String name, double gold) {

    if (gold < 0) {
      throw new IllegalArgumentException("Cannot start player with negative gold value.");
    }
    this.name = name;
    this.gold = gold;

  }

  /**
   * getName returns the name of a player object.
   * 
   * @return this.name
   */
  public String getName() {
    return this.name;
  }

  /**
   * setName sets the name of a player object.
   * 
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * pickMove selects move to make for the player.
   * 
   * @param move list of possible moves to make
   * @return
   */
  public String pickMove(int move) {

    if (move > 4 || move < 1) {
      throw new IllegalArgumentException("Please enter a valid movement.");

    } else if (move == 1) {
      return "North";
    } else if (move == 2) {
      return "South";
    } else if (move == 3) {
      return "East";
    } else if (move == 4) {
      return "West";
    }

    return null;
  }

  /**
   * getGold gets the gold value a player object has.
   * 
   * @return this.gold gold value player has.
   */
  public double getGold() {
    return this.gold;
  }

  /**
   * setGold sets gold of a player's gold quantity.
   * 
   * @param gold value to set for player. 
   */
  public void setGold(double gold) {
    this.gold = gold;
    if (this.gold < 0) {
      this.gold = 0;
    }
  }

  @Override
  public String toString() {
    return this.name + " has " + this.getGold() + " gold coins.";
  }
}
