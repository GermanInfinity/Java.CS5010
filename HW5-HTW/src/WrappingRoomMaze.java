import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class represents the wrapping room maze that extends the mazeImpl
 * abstract class.
 * 
 * @author Ugo Nwachuku
 *
 */
public class WrappingRoomMaze extends MazeImpl {

  private int row;
  private int col;
  private String mazeType;

  private Cave[] array;

  private ArrayList<String> possibleMoves;

  private ArrayList<String> walls;
  private Map<String, Integer> doors;
  private Map<String, ArrayList<String>> neighbours;

  /**
   * WrappingRoomMaze constructor constructs a maze that has caves, tunnels and hallways,
   * multiple paths exist to the wumpus in this maze. A player in the maze can
   * also wrap around the edges of this maze.
   * 
   * @param row size of row in maze
   * @param col size of columns in maze
   * @param remainingWallsarg specifies the walls to remain in the maze
   */
  public WrappingRoomMaze(int row, int col, int remainingWallsarg) {
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
    this.doors = new HashMap<String, Integer>();
    this.neighbours = new HashMap<String, ArrayList<String>>();
    sets = makeSets(this.row, this.col, sets, this.walls);
    int remainingWalls = remainingWallsarg;

    if (remainingWalls >= this.walls.size() - this.row * this.col + 1) {
      throw new IllegalArgumentException("This is a Perfect cave specification.");
    }

    this.mazeType = "Wrapping room";
    String primaryMazeType = "wrapping room";
    buildMaze(this.walls, removedWalls, sets, primaryMazeType, this.row, this.col, remainingWalls);

    this.doors = doorCount(this.array, row, col, this.walls);
    this.neighbours = makeNeighbours(this.array, row, col, this.walls);

    buildTunnels(this.array, this.doors, this.neighbours);
    System.out.println(this.neighbours);

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
  
  @Override
  public String fire(int distance, int direction) {
    return shootArrow(this.array, this.walls, this.mazeType, this.row, this.col, distance,
        direction);
  }

  
  @Override
  public String toString() {
    return "A wall format is [row, column position in maze]."
        + "[row, column position in maze]. Example a wall "
        + "between cell 00 and 01 would be: 00.01. Thus, "
        + "the walls in the room maze are: "
        + showWalls(this.walls) + " these are the walls in the Wrapping room Maze.";
  }

  @Override
  public Cave[] getCaves() {
    return this.array;
  }


}
