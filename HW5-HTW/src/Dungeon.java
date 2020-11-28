import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a dungeon. A dungeon is a collection of caves in a maze
 * like format.
 * 
 * @author ugoslight
 *
 */
public class Dungeon {

  private int row;
  private int col;
  private int pitNo;
  private int batNo;
  private String mazeType;
  private int numArrows;
  private Cave[] caves;

  private Maze maze;
  private Wumpus wumpus;
  private Boolean gameOn;

  /**
   * Constructs the dungeon object with the required player and maze
   * specifications.
   * 
   * @param row row size of the dungeon
   * @param col column size of the dungeon
   * @param remainingWalls in dungeon
   * @param startRow starting row position of player
   * @param startCol starting column position of player
   * 
   */
  public Dungeon(int row, int col, int numArrows, String mazeType, int remainingWalls, int pitNo,
      int batNo) {
    // TODO Auto-generated constructor stub

    if (pitNo > row * col || pitNo < 0) {
      throw new IllegalArgumentException("Invalid value for pit number.");
    }
    if (batNo > row * col || pitNo < 0) {
      throw new IllegalArgumentException("Invalid value for superbat number.");
    }
    if (numArrows < 0) {
      throw new IllegalArgumentException("Invalid value for arrows.");
    }
    if (remainingWalls < 0) { 
      throw new IllegalArgumentException("Invalid value number of remaining walls.");
    }


    // Determine maze
    this.mazeType = mazeType;
    this.row = row;
    this.col = col;
    this.numArrows = numArrows;
    this.gameOn = true;
    this.pitNo = pitNo;
    this.batNo = batNo;

    
    if (this.mazeType.equals("room")) {
      this.maze = new RoomMaze(row, col, remainingWalls);
    }

    if (this.mazeType.equals("wrapping room")) {
      this.maze = new WrappingRoomMaze(row, col, remainingWalls);
    }
    this.caves = this.maze.getCaves();

    
    // Start with random position, after placing npc's place player last.
    wumpus = new Wumpus("Gretchen", true);
    placeWumpus();
    placePits();
    placeSuperBats();
    

  }

  public void startAt(int location) {
    for (int i = 0; i < this.caves.length; i++) {
      if (this.caves[i].getSecondaryName().equals("tunnel")) {
        continue;
      }
      if (Integer.parseInt(this.caves[i].getSecondaryName()) == location) {
        String name = this.caves[i].getName();
        char playerRow = name.charAt(0);
        char playerCol = name.charAt(1);
        int playerRowNum = java.lang.Character.getNumericValue(playerRow);
        int playerColNum = java.lang.Character.getNumericValue(playerCol);
        this.maze.updatePlayerPosition(this.maze.getCaves(), this.row, this.col, playerRowNum,
            playerColNum);
      }
    }
  }

  /**
   * Action function determines what happens after the player makes move.
   */
  public String action() {
    int playerLocation = Integer.parseInt(this.maze.findPlayerPosition());
    String info = "";

    // Check if wumpus is current cave player is in.
    if (this.caves[playerLocation].getWumpus()) {
      this.gameOn = false;
      return "You've been made meat by the Wumpus. Try again!";
    }

    // Check if super bat in current location.
    if (this.caves[playerLocation].isSuperbatIn()) {
      SuperBat bat = this.caves[playerLocation].getSuperbat();
      Random random = new Random();
      info = "Superbat carried you. ";
      if (random.nextBoolean()) {
        ArrayList<String> locations = this.maze.printLocations(this.caves, this.row, this.col);
        locations.remove(this.caves[playerLocation].getSecondaryName());
        ArrayList<Cave> caveLocations = new ArrayList<Cave>();
        for (String ele : locations) {
          caveLocations.add(this.maze.locateCave(this.caves, this.row, this.col, ele));
        }
        ArrayList<Integer> newPosition = bat.action(caveLocations);
        this.maze.updatePlayerPosition(this.maze.getCaves(), this.row, this.col, newPosition.get(0),
            newPosition.get(1));
        Cave newCave = this.maze.findCave(this.caves, this.row, this.col, newPosition.get(0),
            newPosition.get(1));
        if (newCave.getWumpus()) {
          this.gameOn = false;
          return "The bat whisked you away to the Wumpus, better luck next time!";
        }
        if (newCave.getPit()) {
          this.gameOn = false;
          return "The bat whisked you away to a pit, better luck next time!";
        }
        return "You've been whisked away by a super bat!";
      }
    }

    // Check if player is in a pit.
    if (this.caves[playerLocation].getPit()) {
      this.gameOn = false;
      return info + "Game over: 5250 FALL Damage!";
    }

    String playerPos = this.maze.findPlayer();

    int playerRow = java.lang.Character.getNumericValue(playerPos.charAt(0));
    int playerCol = java.lang.Character.getNumericValue(playerPos.charAt(1));

    int[][] boundaryArray = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    for (int i = 0; i < boundaryArray.length; i++) {
      int currRow = playerRow + boundaryArray[i][0];
      int currCol = playerCol + boundaryArray[i][1];
      Cave nearBy = this.maze.findCave(this.caves, this.row, this.col, currRow, currCol);
      if (nearBy == null) {
        continue;
      }
      if (nearBy.getWumpus()) {
        return "You smell a Wumpus!";
      }
      if (nearBy.getPit()) {
        return "You feel a draft!";
      }
    }
    return "";
  }

  /**
   * makeShot simulates an arrow shot by the player.
   * 
   * @param distance to shoot the arrow.
   * @param direction navigation to send arrow.
   * @return
   */
  public String arrowAction(int distance, int direction) {
    String response = "";
   
    if (this.numArrows == 0) { 
      this.gameOn = false;
      return "You ran out of ammo, thus, you cannot kill the Wumpus. Try again, next time.";
    }
    
    if (this.numArrows > 0) {
      this.numArrows--;
      response = this.maze.fire(distance, direction);
      if (response == "Win") {
        this.gameOn = false;
        return "Hooray, you killed the Wumpus!";
      }
    }
   
    return response;
  }

  

  /**
   * All possible locations characters could inhabit in maze.
   */
  public ArrayList<String> locations() {
    return this.maze.printLocations(caves, row, col);
  }

  /**
   * Places wumpus in a single random location in the dungeon.
   */
  public void placeWumpus() {
    Random ran = new Random();
    ArrayList<String> locations = this.maze.printLocations(this.caves, this.row, this.col);

    int num = ran.nextInt(locations.size());

    Cave wumpusCave = this.maze.locateCave(this.caves, this.row, this.col, locations.get(num));
    System.out.println(locations.get(num));
    wumpusCave.addNPC(this.wumpus);

  }

  /**
   * Places n number of pits in the dungeon.
   */
  public void placePits() {
    int pitsIn = 0;
    ArrayList<String> locations = this.maze.printLocations(this.caves, this.row, this.col);

    if (locations.size() < this.pitNo) {
      throw new IllegalArgumentException("Cannot have that many pits in maze.");
    }
    
    while (pitsIn < this.pitNo) {
      // grab random spot in maze
      Random ran = new Random();
      int num = ran.nextInt(locations.size());
      Cave currCave = this.maze.locateCave(this.caves, this.row, this.col, locations.get(num));

      if (currCave.getPit()) {
        continue;
      }

      currCave.setPit(true);

      pitsIn++;
    }
  }

  /**
   * Places n number of superbats in the dungeon.
   */
  public void placeSuperBats() {
    int batsIn = 0;
    ArrayList<String> locations = this.maze.printLocations(this.caves, this.row, this.col);

    if (locations.size() < this.batNo) {
      throw new IllegalArgumentException("Cannot have that many superbats in maze.");
    }
    
    while (batsIn < this.batNo) {
      // grab random spot in maze
      Random ran = new Random();
      int num = ran.nextInt(locations.size());
      Cave currCave = this.maze.locateCave(this.caves, this.row, this.col, locations.get(num));

      if (currCave.isSuperbatIn()) {
        continue;
      }
      SuperBat batMan = new SuperBat("Bruce Wayne");
      currCave.addNPC(batMan);

      batsIn++;
    }
  }

  
  /**
   * Checks the maze to see if the game is ongoing.
   */
  public Boolean gameOn() {
    return this.gameOn;
  }

  /**
   * getLocation returns players current location.
   */
  public String playerLocation() {
    return this.maze.findPlayerPosition();
  }

  /**
   * getMoves determines moves for player.
   */
  public ArrayList<String> getMoves() {
    return this.maze.getMoves();
  }

  /**
   * makesMove for player in the maze.
   * 
   * @param move move the pkayer made.
   * @param moves moves available to make.
   */
  public void makeMove(String move, ArrayList<String> moves) {
    this.caves = this.maze.makeMove(move, moves, caves);
  }

  @Override
  public String toString() {
    return "A wall format is [row, column position in maze]."
        + "[row, column position in maze]. Example a wall "
        + "between cell 00 and 01 would be: 00.01. Thus, " + "Cave Maze.";
  }

}
