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

  /**
   * WrappingRoomMaze constructor constructs a maze that has rooms and hallways,
   * multiple paths exist to the goal in this maze. A player in the maze can
   * also wrap around the edges of this maze.
   * 
   * @param row size of row in maze
   * @param col size of columns in maze
   * @param remainingWallsarg specifies the walls to remain in the maze
   * @param startRowarg starting row position of player in maze
   * @param startColarg starting column position of player in maze
   */
  public WrappingRoomMaze(int row, int col, int remainingWallsarg, int startRowarg, int startColarg) {
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
    sets = makeSets(this.row, this.col, sets, this.walls);
    int remainingWalls = remainingWallsarg;

    if (remainingWalls >= this.walls.size() - this.row * this.col + 1) {
      throw new IllegalArgumentException("This is a Perfect cave specification.");
    }

    this.mazeType = "Wrapping room";
    String primaryMazeType = "wrapping room";
    buildMaze(this.walls, removedWalls, sets, primaryMazeType, this.row, this.col, remainingWalls);

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
  public void makeMove(String move, ArrayList<String> moves) {
    if (!moves.contains(move)) {
      throw new IllegalArgumentException("Please play a possible move next time.");
    }
    playerMove(this.row, this.col, this.mazeType, this.array, move);
  }

  @Override
  public Boolean atGoal() {
    // Np solution to dungeon maze.
    return null;
  }

  @Override
  public ArrayList<String> getMoves() {
    ArrayList<String> moves = possibleMoves(this.mazeType, this.array, this.walls,
        this.possibleMoves, this.row, this.col);
    this.possibleMoves = new ArrayList<String>();
    return moves;
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
  public Boolean mazeSolved(Cave[] array, int mazeRow, int mazeCol, int goalRow, int goalCol) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Cave[] getCaves() {
    return this.array;
  }

}
