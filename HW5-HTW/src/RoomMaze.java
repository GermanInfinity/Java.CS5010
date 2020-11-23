import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class represents the Cave maze that extends the mazeImple abstract
 * class.
 * 
 * @author Ugo Nwachuku
 *
 */
public class RoomMaze extends MazeImpl {

  private int row;
  private int col;
  private String mazeType;

  private Cave[] array;

  private ArrayList<String> possibleMoves;

  private ArrayList<String> walls;
  private Map<String, Integer> doors;
  private Map<String, ArrayList<String>> neighbours;

  /**
   * CaveMaze constructor constructs a maze that has Caves and hallways,
   * multiple paths exist to the goal in this maze.
   * 
   * @param row size of row in maze
   * @param col size of columns in maze
   * @param remainingWallsarg specifies the walls to remain in the maze
   * @param startRowarg starting row position of player in maze
   * @param startColarg starting column position of player in maze
   */
  public RoomMaze(int row, int col, int remainingWallsarg, int startRowarg, int startColarg) {
    if (row < 0 || col < 0 || startRowarg < 0 || startColarg < 0) {
      throw new IllegalArgumentException("No negative values.");
    }
    if (startRowarg < 0 || startRowarg >= row || startColarg < 0 || startColarg >= col) {
      throw new IllegalArgumentException("Invalid starting entry.");
    }

    if (remainingWallsarg < 0) {
      throw new IllegalArgumentException("Cannot have negative remaining walls.");
    }

    this.row = row;
    this.col = col;
    int startRow = startRowarg;
    int startCol = startColarg;
    
    this.walls = new ArrayList<String>();
    Map<String, Set<String>> sets = new HashMap<String, Set<String>>();
    ArrayList<String> removedWalls = new ArrayList<String>();
    this.possibleMoves = new ArrayList<String>();

    this.array = insertCaves(this.array, this.row, this.col);
    this.walls = makeWalls(this.row, this.col, this.walls);
    this.doors = new HashMap<String, Integer>();
    this.neighbours = new HashMap<String, ArrayList<String>>();
    sets = makeSets(this.row, this.col, sets, this.walls);
    int remainingWalls = remainingWallsarg;

    if (remainingWalls >= this.walls.size() - this.row * this.col + 1) {
      throw new IllegalArgumentException("This is a Perfect Cave specification.");
    }

    this.mazeType = "room";
    buildMaze(this.walls, removedWalls, sets, this.mazeType, this.row, this.col, remainingWalls);

    System.out.println(this.walls);
    
    doorCount();
    buildTunnels();

    updatePlayerPosition(this.array, this.row, this.col, startRow, startCol);

  }
  
  @Override
  public String findPlayerPosition() { 
    return playerPosition(this.array, this.row, this.col);
  }

  @Override
  public String findPlayer() {
    return playerLocation(this.array, this.row, this.col);
  }

  

  @Override
  public Boolean atGoal() {
    // Np solution to dungeon maze.
    return null;
  }
  
  @Override
  public Cave currentCave() {
    return getCave(this.array, this.row, this.col);
  }

  @Override
  public Cave[] makeMove(String move, ArrayList<String> moves, Cave[] array2) {
    if (!moves.contains(move)) {
      throw new IllegalArgumentException("Please play a possible move next time.");
    }
    return playerMove(this.row, this.col, this.mazeType, array2, move);
  }
  
  @Override
  public ArrayList<String> getMoves() {
    ArrayList<String> moves = possibleMoves(this.mazeType, this.array, this.walls,
        this.possibleMoves, this.row, this.col);
    this.possibleMoves = new ArrayList<String>();
    return moves;
  }
  
  
  /**
   * countDoor counts all the doors per room in the maze. 
   */
  public void doorCount() { 
    int[][] boundaryArray = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    
    for (Cave room : this.array) {
      String cave = room.getName();
      int caveRow = java.lang.Character.getNumericValue(cave.charAt(0));
      int caveCol = java.lang.Character.getNumericValue(cave.charAt(1));
      int doorCount = 0;
      ArrayList<String> closeBys = new ArrayList<String>();
      
      for (int i = 0; i < boundaryArray.length; i++) {
        int nexRow = caveRow + boundaryArray[i][0];
        int nexCol = caveCol + boundaryArray[i][1];
        
        if (nexRow < this.row && nexRow >= 0 && nexCol < this.col && nexCol >= 0) {
          if (this.walls.contains(cave+"."+Integer.toString(nexRow)+Integer.toString(nexCol))) { 
            continue;
          }
          if (this.walls.contains(Integer.toString(nexRow)+Integer.toString(nexCol)+"."+cave)) { 
            continue;
          }
          doorCount++;
          closeBys.add(Integer.toString(nexRow)+Integer.toString(nexCol));
        }
      }
      this.doors.put(cave, doorCount);
      this.neighbours.put(cave, closeBys);
    }
    System.out.println(doors);
  }
  
  /**
   * builTunnels builds tunnels in the dungeon.
   */
  public void buildTunnels() { 
    for (String tunnel : this.doors.keySet()) {
      if (this.doors.get(tunnel) == 2) {
        for (Cave currCave : this.array) {
          if (currCave.getName().equals(tunnel)) {
            currCave.setSecondaryName("tunnel");
            currCave.setNeighbours(this.neighbours.get(currCave.getName()));
          }
        }
      }
    }

  }


  @Override
  public String toString() {
    return "A wall format is [row, column position in maze]."
        + "[row, column position in maze]. Example a wall "
        + "between cell 00 and 01 would be: 00.01. Thus, "
        + "the walls in the Cave maze are: "
        + showWalls(this.walls) + " these are the walls in the "
        + "Cave Maze.";
  }

  @Override
  public Boolean mazeSolved(Cave[] array, int mazeRow, int mazeCol, int goalRow, int goalCol) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Cave[] getCaves() {
    return this.array;
  }


}
