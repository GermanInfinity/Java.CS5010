
/**
 * This class represents the player class.
 * 
 * @author Ugo Nwachuku
 *
 */
public class Player implements Character {

  private String name;
  private int arrowsHeld;

  /**
   * Player constructor. Constructs a character object of type player class.
   * 
   * @param name is the type of player
   */
  public Player(String type, int arrows) {

    this.name = type;
    this.arrowsHeld = arrows;

  }

  /**
   * Returns name of player;
   */
  public String getType() {
    return this.name;
  }

  /**
   * Returns arrows held.
   */
  public int getArrows() {
    return this.arrowsHeld;
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

  @Override
  public String toString() {
    return "Hi, i'm a " + this.name + " character.";
  }

}
