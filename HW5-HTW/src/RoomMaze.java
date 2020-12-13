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


  /**
   * RoomMaze constructor constructs a maze that has Caves, hallways and
   * tunnels, multiple paths exist to the wumpus in this maze.
   * 
   * @param row size of row in maze
   * @param col size of columns in maze
   * @param remainingWallsarg specifies the walls to remain in the maze
   */
  public RoomMaze(int row, int col, Boolean seed, int remainingWallsarg) {
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException("No negative values.");
    }
    if (remainingWallsarg < 0) {
      throw new IllegalArgumentException("Cannot have negative remaining walls.");
    }

    this.row = row;
    this.col = col;

    this.walls = new ArrayList<String>();
    Map<String, Set<String>> sets = new HashMap<String, Set<String>>();
    ArrayList<String> removedWalls = new ArrayList<String>();
    this.possibleMoves = new ArrayList<String>();

    this.array = insertCaves(this.array, this.row, this.col);
    this.walls = makeWalls(this.row, this.col, this.walls);
    Map<String, Integer> doors = new HashMap<String, Integer>();
    Map<String, ArrayList<String>> neighbours = new HashMap<String, ArrayList<String>>();
    sets = makeSets(this.row, this.col, sets, this.walls);
    int remainingWalls = remainingWallsarg;

    if (remainingWalls >= this.walls.size() - this.row * this.col + 1) {
      throw new IllegalArgumentException("This is a Perfect Cave specification.");
    }

    this.mazeType = "room";
    buildMaze(this.walls, removedWalls, sets, this.mazeType, this.row, this.col, remainingWalls, seed);

    doors = doorCount(this.array, row, col, this.walls);
    neighbours = makeNeighbours(this.array, row, col, this.walls);
    
    buildTunnels(this.array, doors, neighbours);

  }

  @Override
  public String findPlayerPosition(int pNum) {
    return playerPosition(pNum, this.array, this.row, this.col);
  }

  @Override
  public String findPlayer(int pNum) {
    return playerLocation(pNum, this.array, this.row, this.col);
  }

  @Override
  public Cave currentCave() {
    return getCave(this.array, this.row, this.col);
  }

  @Override
  public Cave[] makeMove(String move, ArrayList<String> moves, Cave[] array2, int p) {
    if (!moves.contains(move)) {
      throw new IllegalArgumentException("Please play a possible move next time.");
    }
    return playerMove(this.row, this.col, this.mazeType, array2, move, p);
  }

  @Override
  public ArrayList<String> getMoves(int p) {
    ArrayList<String> moves = possibleMoves(this.mazeType, this.array, this.walls,
        this.possibleMoves, this.row, this.col, p);
    this.possibleMoves = new ArrayList<String>();
    return moves;
  }

  @Override
  public String fire(int distance, int direction) {
    return shootArrow(this.array, this.walls, this.mazeType, this.row, this.col, distance,
        direction);
  }

  @Override
  public String toString() {
    return "A wall format is [row, column position in maze]."
        + "[row, column position in maze]. Example a wall "
        + "between cell 00 and 01 would be: 00.01. Thus, " + "the walls in the Cave maze are: "
        + showWalls(this.walls) + " these are the walls in the " + "Cave Maze.";
  }

  @Override
  public Cave[] getCaves() {
    return this.array;
  }
  
  @Override 
  public ArrayList<String> getWalls() { 
    return this.walls;
  }



}
