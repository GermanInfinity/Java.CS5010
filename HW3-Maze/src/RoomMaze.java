import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * This class represents the room maze that extends the mazeImple abstract
 * class.
 * 
 * @author Ugo Nwachuku
 *
 */
public class RoomMaze extends MazeImpl {

  private int row;
  private int col;
  private int startRow;
  private int startCol;
  private int goalRow;
  private int goalCol;
  private int remainingWalls;

  private Room[] array;

  private ArrayList<String> possibleMoves;

  private ArrayList<String> walls;
  private ArrayList<String> removedWalls;
  private Map<String, Set<String>> sets;

  public RoomMaze(int row, int col, int remainingWalls, int startRow, int startCol, int goalRow,
      int goalCol) {
    if (row < 0 || col < 0 || startRow < 0 || goalRow < 0 || startCol < 0 || goalCol < 0) {
      throw new IllegalArgumentException("No negative values.");
    }
    if (startRow < 0 || startRow >= row || startCol < 0 || startCol >= col) {
      throw new IllegalArgumentException("Invalid starting entry.");
    }
    if (goalRow < 0 || goalRow >= row || goalCol < 0 || goalCol >= col) {
      throw new IllegalArgumentException("Invalid goal location.");
    }

    this.row = row;
    this.col = col;
    this.startRow = startRow;
    this.startCol = startCol;
    this.goalRow = goalRow;
    this.goalCol = goalCol;
    this.walls = new ArrayList<String>();
    this.sets = new HashMap<String, Set<String>>();
    this.removedWalls = new ArrayList<String>();
    this.possibleMoves = new ArrayList<String>();

    this.array = insertRooms(this.array, this.row, this.col);
    this.walls = makeWalls(this.row, this.col, this.walls);
    this.sets = makeSets(this.row, this.col, this.sets, this.walls);
    this.remainingWalls = remainingWalls;

    if (this.remainingWalls >= this.walls.size() - this.row * this.col + 1) {
      throw new IllegalArgumentException("This is a Perfect room specification.");
    }

    String mazeType = "room";
    buildMaze(this.walls, this.removedWalls, this.sets, mazeType, this.row, this.col, this.remainingWalls);

    spreadGold(this.array, this.row, this.col);
    spreadThieves(this.array, this.row, this.col);
    updatePlayerPosition(this.array, this.row, this.col, this.startRow, this.startCol);
    System.out.println(this.walls);
    System.out.println(this.walls.size());

  }

  @Override
  public String findPlayer() {
    return playerLocation(this.array, this.row, this.col);
  }

  @Override
  public void makeMove(String move) {
    playerMove(this.row, this.col, this.array, move);
  }

  @Override
  public Boolean atGoal() {
    return mazeSolved(this.array, this.row, this.col, this.goalRow, this.goalCol);
  }

  @Override
  public ArrayList<String> getMoves() {
    ArrayList<String> moves = possibleMoves(this.array, this.walls, this.possibleMoves, this.row,
        this.col);
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
  public int Event() {
    return Action(this.array, this.row, this.col);
  }

  @Override
  public String toString() {
    return "A wall format is [row, column position in maze].[row, column position in maze]. Example a wall "
        + "between cell 00 and 01 would be: 00.01. Thus, the walls in the room maze are: "
        + showWalls(this.walls);
  }

}
