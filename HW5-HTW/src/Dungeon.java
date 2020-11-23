import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a dungeon. A dungeon is a collection of caves in a 
 * maze like format. 
 * @author ugoslight
 *
 */
public class Dungeon {

  private int row;
  private int col; 
  private int startRow;
  private int startCol; 
  private int pitNo;
  private int batNo; 
  private String mazeType;
  private int numArrows;
  private Cave[] caves;
  
  private ArrayList<String> possibleMoves;
  private ArrayList<String> walls;
  
  private Maze maze;
  private Wumpus wumpus;
  
  /**
   * Constructs the dungeon object with the required player and maze specifications. 
   * 
   * @param row row size of the dungeon
   * @param col column size of the dungeon 
   * @param remainingWalls in dungeon 
   * @param startRow starting row position of player
   * @param startCol starting column position of player
   * 
   */
  public Dungeon(int row, int col, String mazeType, 
                 int remainingWalls, int pitNo, int batNo) {
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
    if (startRow < 0 || startRow > row || startCol < 0 || startCol > col) {
      throw new IllegalArgumentException("Invalid row and column starting positions.");
    }
    
    // Determine maze
    this.mazeType = mazeType;
    this.row = row; 
    this.col = col; 

    this.pitNo = pitNo; 
    this.batNo = batNo;

    
    if (this.mazeType.equals("room")) { 
      this.maze = new RoomMaze(row, col, remainingWalls, startRow, startCol);
    }
    
    if (this.mazeType.equals("wrapping room")) { 
      this.maze = new WrappingRoomMaze(row, col, remainingWalls, startRow, startCol);
    }
    this.caves = this.maze.getCaves();
    
    
    //Start with random position, after placing npc's place player last. 
    wumpus = new Wumpus("Gretchen", true);
    placeWumpus();
    placePits();
    placeSuperBats();

  }

  /**
   * update function determines what happens to player when he is in a new location. 
   */
  public void action() { 
    int playerLocation = Integer.parseInt(this.maze.findPlayerPosition());
    
    // Draft bottomless pit
    // Smelling Wumpus
    
    // Check if wumpus is current cave player is in. 
    if (this.caves[playerLocation].getWumpus()) { 
      System.out.println("Player dead"); 
      return;
    }
    
    // Check if super bat in current location. 
    if (this.caves[playerLocation].isSuperbatIn()) { 
      System.out.println("Super bat here."); 
      SuperBat bat = this.caves[playerLocation].getSuperbat();
      Random random = new Random();
      
      if (random.nextBoolean()) {
        ArrayList<Integer> newPosition = bat.action(this.row, this.col);
        this.maze.updatePlayerPosition(this.maze.getCaves(), this.row, this.col, newPosition.get(0), newPosition.get(1));
        return;
      }
    }
    
    //Check if player is in a pit.
    if (this.caves[playerLocation].getPit()) {
      System.out.println("Player dead"); 
      return;
    }
    
    
    
  }
  
  public void startAt(int location) {
    for (int i = 0; i < this.caves.length; i++) {
      if (this.caves[i].getSecondaryName().equals("tunnel")) { continue; }
      if (Integer.parseInt(this.caves[i].getSecondaryName()) == location) {
        String name = this.caves[i].getName();
        char playerRow = name.charAt(0);
        char playerCol = name.charAt(1);
        int playerRowNum = java.lang.Character.getNumericValue(playerRow);
        int playerColNum = java.lang.Character.getNumericValue(playerCol);
        this.maze.updatePlayerPosition(this.maze.getCaves(), this.row, this.col, playerRowNum, playerColNum);
      }
    }
  }
  
  public ArrayList<String> locations() { 
    return this.maze.printLocations(caves, row, col);
  }
  /**
   * Places wunpus in a single ranodm locqation in the dungeon. 
   */
  public void placeWumpus() { 
    Random ran = new Random();
    int num = ran.nextInt(this.row * this.col);

    this.caves[num].addNPC(this.wumpus);
  }
  
  
  /**
   * Places n number of pits in the dungeon. 
   */
  public void placePits() { 
    int pitsIn = 0;
    
    while (pitsIn < this.pitNo) {
      //grab random spot in maze
      Random ran = new Random();
      int num =  ran.nextInt(this.row * this.col);
      
      if (this.caves[num].getPit()) {
        continue;
      }
      this.caves[num].setPit(true);
      
      pitsIn++;
    }
  }
  
  /**
   * Places n number of superbats in the dungeon. 
   */
  public void placeSuperBats() { 
    int batsIn = 0;
    
    while (batsIn < this.batNo) {
      //grab random spot in maze
      Random ran = new Random();
      int num =  ran.nextInt(this.row * this.col) + 0;
      
      if (this.caves[num].isSuperbatIn()) {
        continue;
      }
      SuperBat batMan = new SuperBat("Bruce Wayne");
      this.caves[num].addNPC(batMan);

      batsIn++;
    }
  }
  

  /**
   * Checks the maze to see if the wumpus is alive. 
   */
  public Boolean wumpusAlive() { 
    return this.wumpus.isAlive(); 
  }
  
  /**
   * getLocation returns players current location.
   */
  public String playerLocation() { 

    return this.maze.findPlayerPosition();
    //return this.maze.findPlayer();
  }
  /**
   * getMoves determines moves for player. 
   */
  public ArrayList<String> getMoves() { 
    return this.maze.getMoves();
  }
  
  /** 
   * makesMove for player in the maze. 
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
        + "between cell 00 and 01 would be: 00.01. Thus, "
        + "Cave Maze.";
  }


  
  
  
}
