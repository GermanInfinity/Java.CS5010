
/**
 * The Room class represents a room in a maze. A room can have a thief or gold
 * in it.
 * 
 * @author Ugo Nwachuku
 *
 */
public class Room {

  private String name;
  private Boolean thief;
  private double goldValue;
  private Boolean playerIn;

  /**
   * Room constructor. Constructs a room object possibly, with a thief, gold and
   * a player in.
   * 
   * @param name the name of the room
   * @param thief if a thief is in the room
   * @param playerIn if a player is in the room
   * @param gold the value of gold in the room
   */
  public Room(String name, Boolean thief, Boolean playerIn, double gold) {
    if (gold < 0) {
      throw new IllegalArgumentException("Gold value cannot be negative.");
    }
    this.name = name;
    this.thief = thief;
    this.goldValue = gold;
    this.playerIn = playerIn;

  }

  /**
   * setName sets the name of a room.
   * 
   * @param name of room
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * getName returns the name of a room.
   * 
   * @return
   */
  public String getName() {
    return this.name;
  }

  /**
   * hasThief checks if a thief is in a room.
   * 
   * @return
   */
  public Boolean hasThief() {
    return thief;
  }

  /**
   * thiefAttack takes a value of gold from player object in the room.
   * 
   * @return
   */
  public double thiefAttack(double score) {
    return 0.90 * score;
  }

  /**
   * hasPlayer checks if a player is in a room.
   * 
   * @return boolean value for is a player is in a room
   */
  public Boolean hasPlayer() {
    return playerIn;
  }

  /**
   * setPlayerIn allows a player to be in a room.
   * 
   * @param in boolean value for if a player is in a room
   */
  public void setPlayerIn(Boolean in) {
    this.playerIn = in;
  }

  /**
   * placeThief allows a thief to be in a room.
   * 
   * @param placed boolean value for if a thief is in a room.
   */
  public void placeThief(Boolean placed) {
    this.thief = true;
  }

  /**
   * setGold sets the gold value in a room.
   * 
   * @param gold is the new value of gold in the room
   */
  public void setGold(double gold) {
    if (gold < 0) {
      throw new IllegalArgumentException("Gold value cannot be negative.");
    }
    this.goldValue = gold;
  }

  /**
   * getGold returns the gold stored in a room.
   * 
   * @return
   */
  public double getGold() {
    return goldValue;
  }

  @Override
  public String toString() {
    return "This room: " + getName() + " has this gold value in it: " + getGold() + ". Player in: "
        + hasPlayer() + " Thief in: " + hasThief();
  }

}
