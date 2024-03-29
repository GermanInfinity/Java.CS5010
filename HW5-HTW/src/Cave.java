import java.util.ArrayList;

/**
 * This cave class represents a cave in the maze.
 * 
 * @author ugoslight
 *
 */
public class Cave {

  private String name;
  private String secondName;
  private Boolean playerIn;
  private ArrayList<Character> occupants;
  private Boolean pit;
  private Boolean pDouble;
  private Boolean wumpus;
  private SuperBat superbat;
  private Boolean superbatIn;
  private ArrayList<String> neighbours;

  /**
   * Constructs a cave object.
   */
  public Cave(String name, String secondName, Boolean playerIn) {
    this.name = name;
    this.secondName = secondName;
    this.playerIn = playerIn;
    this.occupants = new ArrayList<Character>();
    this.superbatIn = false;
    this.pit = false;
    this.wumpus = false;
    this.neighbours = new ArrayList<String>();
    this.pDouble = false;

  }

  /**
   * Returns the name of the cave.
   */
  public String getName() {
    return this.name;
  }

  /**
   * getSecondaryName returns the secondary name of a cave.
   */
  public String getSecondaryName() {
    return this.secondName;
  }

  /**
   * setSecondaryName sets the secondary name of a particular cave.
   * 
   * @param name to set this.secondName to
   */
  public void setSecondaryName(String name) {
    this.secondName = name;
  }

  /**
   * This function returns true if a player is in the cave, and false otherwise.
   */
  public Boolean hasPlayerIn() {
    return this.playerIn;
  }

  /**
   * setLeadingCave sets the cave a tunnel leads to.
   */
  public void setNeighbours(ArrayList<String> neighbours) {
    this.neighbours = neighbours;
  }

  /**
   * getNeighbours gets the neighbours of a cave.
   */
  public ArrayList<String> getNeighbours() {
    return this.neighbours;
  }

  /**
   * findNext finds the next cave in a tunnel.
   */
  public String findNext(int prevRow, int prevCol) {
    String prevPos = Integer.toString(prevRow) + Integer.toString(prevCol);
    String direc = "";
    for (String ele : this.neighbours) {
      if (!ele.equals(prevPos)) {
        direc = ele;
      }
    }
    int nextRow = java.lang.Character.getNumericValue(direc.charAt(0));
    int nextCol = java.lang.Character.getNumericValue(direc.charAt(1));

    int currRow = java.lang.Character.getNumericValue(getName().charAt(0));
    int currCol = java.lang.Character.getNumericValue(getName().charAt(1));

    if (nextRow - currRow == -1 && nextCol == currCol) {
      return "North";
    }
    if (nextRow - currRow == 1 && nextCol == currCol) {
      return "South";
    }
    if (nextRow == currRow && nextCol - currCol == 1) {
      return "East";
    }
    if (nextRow == currRow && nextCol - currCol == -1) {
      return "West";
    }
    return "";

  }

  /**
   * This function sets if a player is in the cave or not.
   * 
   * @param in boolean concerning if player is in the cave.
   */
  public void setPlayerIn(Boolean in) {
    this.playerIn = in;
  }

  /**
   * Adds a non-playable character to the cave.
   * 
   * @param obj to add to cave.
   */
  public void addNPC(Character obj) {
    if (obj instanceof SuperBat) {
      this.superbat = (SuperBat) obj;
      this.superbatIn = true;
    }
    if (obj instanceof Wumpus) {
      this.wumpus = true;
    }

    this.occupants.add(obj);
  }

  /**
   * Returns non-playable characters in the cave.
   */
  public ArrayList<Character> getNPC() {
    return this.occupants;
  }

  /**
   * Set's a cave to contain a pit.
   * 
   * @param hole boolean value if a cave is a black hole or not.
   */
  public void setPit(Boolean hole) {
    this.pit = hole;
  }

  /**
   * Returns true if a cave has a pit.
   */
  public Boolean getPit() {
    return this.pit;
  }

  /**
   * Returns true if a cave has a wumpus.
   */
  public Boolean getWumpus() {
    return this.wumpus;
  }

  /**
   * Returns true if super bat is in the cave.
   */
  public Boolean isSuperbatIn() {
    return this.superbatIn;
  }

  public void setDouble(Boolean a) {
    this.pDouble = a;
  }

  /**
   * Informs if two players in cave.
   */
  public Boolean getDouble() {
    return this.pDouble;
  }

  /**
   * Returns the superbat in the cave.
   */
  public SuperBat getSuperbat() {
    return this.superbat;
  }

  @Override
  public String toString() {
    return this.name;
  }

}
