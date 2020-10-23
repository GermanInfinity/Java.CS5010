import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * This class represents the perfect maze that extends the mazeImple abstract
 * class.
 * 
 * @author Ugo Nwachuku
 *
 */
public class PerfectMaze extends MazeImpl {

  // private Player player;

  private int row;
  private int col;
  private int startRow;
  private int startCol;
  private int goalRow;
  private int goalCol;
  private int perfectMazeGoal;

  private Room[] array;

  private ArrayList<String> possibleMoves;

  private ArrayList<String> walls;
  private ArrayList<String> removedWalls;
  private Map<String, Set<String>> sets;

  public PerfectMaze(int row, int col, int startRow, int startCol, int goalRow, int goalCol) {
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
    this.perfectMazeGoal = this.walls.size() - this.row * this.col + 1;
    
    buildMaze();


    spreadGold(this.array, this.row, this.col);
    spreadThieves(this.array, this.row, this.col);
    updatePlayerPosition(this.array, this.row, this.col, this.startRow, this.startCol);
    
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
    ArrayList<String> moves =  possibleMoves(this.array, this.walls, this.possibleMoves, this.row, this.col);
    this.possibleMoves = new ArrayList<String>();
    return moves;
  }

  @Override
  public int Event() {
    return Action(this.array, this.row, this.col);
  }


  public void buildMaze() {
    Random ran = new Random();
    

    while (this.walls.size() != this.perfectMazeGoal) {

      int wallToBreak = ran.nextInt(this.walls.size()) + 0;

      if (canBreakWall(this.walls.get(wallToBreak), this.sets, this.walls)) {
        this.walls = breakWall(this.walls.get(wallToBreak), this.walls, this.removedWalls);
        this.sets = updateSets(this.row, this.col, this.sets, this.removedWalls);
      }
      
    }
  }

}
