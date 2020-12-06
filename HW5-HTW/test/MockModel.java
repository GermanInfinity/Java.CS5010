import java.util.ArrayList;

/**
 * This Mock model class is used to test the controllers ability to read and
 * output data.
 *
 */
public class MockModel implements Model {

  private StringBuilder log;
  private final String goodOutput;

  /**
   * Constructor for Mock model class.
   */
  public MockModel(StringBuilder log, String goodOutput) {
    this.log = log;
    this.goodOutput = goodOutput;
  }

  @Override
  public String action() {
    this.log.append("Action taken");
    return goodOutput;
  }

  @Override
  public String playerType() {
    this.log.append("Player is a character.");
    return goodOutput;
  }

  @Override
  public String playerLocation() {
    this.log.append("Player is in maze.");
    return goodOutput;
  }

  @Override
  public ArrayList<String> playerMoves() {
    this.log.append("Player is a character.");
    ArrayList<String> good = new ArrayList<String>();
    good.add("Player can move any direction.");
    return good;
  }

  @Override
  public ArrayList<String> htwLocations() {
    this.log.append("Player is a winner.");
    ArrayList<String> good = new ArrayList<String>();
    good.add("Player stays in a location.");
    return good;
  }

  @Override
  public void placePlayer(int location) {
    this.log.append("Player is placed at: " + location);
  }

  @Override
  public Boolean running() {
    this.log.append("Game is running.");
    return true;
  }

  @Override
  public String movePlayer(int playersMove, ArrayList<String> moves) {
    log.append("Player Move: " + playersMove);
    return goodOutput;
  }

  @Override
  public String shootArrow(int distance, int direction) {
    log.append("Arrow shot this far: " + distance + " In this direction: " + direction + "\n");
    return null;
  }

}
