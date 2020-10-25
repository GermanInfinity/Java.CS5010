import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class represents the perfect maze that extends the mazeImple abstract
 * class.
 * 
 * @author Ugo Nwachuku
 *
 */
public class PerfectMaze extends MazeImpl {

  private int row;
  private int col;
  private int goalRow;
  private int goalCol;
  private int perfectMazeGoal;
  private String mazeType;

  private Room[] array;

  private ArrayList<String> possibleMoves;

  private ArrayList<String> walls;

  /**
   * PerfectMaze constructor constructs a maze that has only hallways, and one
   * path leading to goal.
   * 
   * @param row size of row in maze
   * @param col size of columns in maze
   * @param startRowarg starting row position of player in maze
   * @param startColarg starting column position of player in maze
   * @param goalRow row position of goal in maze
   * @param goalCol column position of goal in maze
   */
  public PerfectMaze(int row, int col, int startRowarg, int startColarg, int goalRow, int goalCol) {
    if (row < 0 || col < 0 || startRowarg < 0 || goalRow < 0 || startColarg < 0 || goalCol < 0) {
      throw new IllegalArgumentException("No negative values.");
    }
    if (startRowarg < 0 || startRowarg >= row || startColarg < 0 || startColarg >= col) {
      throw new IllegalArgumentException("Invalid starting entry.");
    }
    if (goalRow < 0 || goalRow >= row || goalCol < 0 || goalCol >= col) {
      throw new IllegalArgumentException("Invalid goal location.");
    }
    this.row = row;
    this.col = col;
    int startRow = startRowarg;
    int startCol = startColarg;
    this.goalRow = goalRow;
    this.goalCol = goalCol;
    this.walls = new ArrayList<String>();

    Map<String, Set<String>> sets = new HashMap<String, Set<String>>();
    ArrayList<String> removedWalls = new ArrayList<String>();
    this.possibleMoves = new ArrayList<String>();

    this.array = insertRooms(this.array, this.row, this.col);
    this.walls = makeWalls(this.row, this.col, this.walls);
    sets = makeSets(this.row, this.col, sets, this.walls);
    this.perfectMazeGoal = this.walls.size() - this.row * this.col + 1;

    this.mazeType = "perfect";
    buildMaze(this.walls, removedWalls, sets, this.mazeType, this.row, this.col,
        this.perfectMazeGoal);

    spreadGold(this.array, this.row, this.col);
    spreadThieves(this.array, this.row, this.col);
    updatePlayerPosition(this.array, this.row, this.col, startRow, startCol);

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
    return mazeSolved(this.array, this.row, this.col, this.goalRow, this.goalCol);
  }

  @Override
  public ArrayList<String> getMoves() {
    ArrayList<String> moves = possibleMoves(this.mazeType, this.array, this.walls,
        this.possibleMoves, this.row, this.col);
    this.possibleMoves = new ArrayList<String>();
    return moves;
  }

  @Override
  public String gotGold() {
    return checkGotGold(this.array, this.row, this.col);
  }

  @Override
  public String wasAttacked() {
    return checkWasAttacked(this.array, this.row, this.col);
  }

  @Override
  public double event(double goal) {
    return action(this.array, this.row, this.col, goal);
  }

  @Override
  public String toString() {
    return "A wall format is [row, column position in maze]."
        + "[row, column position in maze]. Example a wall "
        + "between cell 00 and 01 would be: 00.01. Thus, "
        + "the walls in the room maze are: "
        + showWalls(this.walls) + " these are the walls in the "
        + "Perfect Maze.";
  }

}
