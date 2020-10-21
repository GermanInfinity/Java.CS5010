import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * This MazeBuilder class represents the structure of a MazeBuilder with an Array.
 * 
 * @author ugoslight
 *
 */
public class MazeBuilder {
  
  private Maze maze;
  private int row;
  private int col;
  private int[] array1;
  private int[] array2;
  private ArrayList<String> walls;
  private ArrayList<String> removedWalls;
  private Map<String, Set<String>> sets;

  public MazeBuilder(int row, int col, int startRow, int startCol, int goalRow, int goalCol) {
    
    if (row < 0 || col < 0 || startRow < 0 || goalRow < 0 || startCol < 0 || goalCol < 0) {
      throw new IllegalArgumentException("No negative values.");
    }
    if (startRow < 0 || startRow >= row || startCol < 0 || startCol >= col) {
      throw new IllegalArgumentException("Invalid starting entry.");
    }
    if (goalRow < 0 || goalRow >= row || goalCol < 0 || goalCol >= col) {
      throw new IllegalArgumentException("Invalid goal locaion.");
    }
    
    this.row = row;
    this.col = col;
    this.array1 = new int[this.row];
    this.array2 = new int[this.col];
    
    makeWalls();
    this.sets = new HashMap<String, Set<String>>();
    this.removedWalls = new ArrayList<String>();
    this.maze = new Maze(row, col, startRow, startCol, goalRow, goalCol, this.walls, this.removedWalls);

  }

  public void makeWalls() {
    this.walls = new ArrayList<String>();
    int[][] boundaryArray = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    for (int row = 0; row < this.row; row++) {
      for (int col = 0; col < this.col; col++) {

        for (int[] ele : boundaryArray) {
          int neighborRow = ele[0] + row;
          int neighborCol = ele[1] + col;

          if (neighborRow >= this.row || neighborRow < 0) {
            continue;
          }
          if (neighborCol >= this.col || neighborCol < 0) {
            continue;
          }

          String currentRowPosition = String.valueOf(row);
          String currentColPosition = String.valueOf(col);
          String position = currentRowPosition + currentColPosition;
          String neighbor = String.valueOf(neighborRow) + String.valueOf(neighborCol);

          if (this.walls.contains(neighbor + "." + position)) {
            continue;
          }
          this.walls.add(position + "." + neighbor);
        }
      }
    }
  }

  public ArrayList<String> showWalls() { 
    return this.walls;
  }

  public void makeSets() {
    int[][] boundaryArray = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    for (int row = 0; row < this.row; row++) {
      for (int col = 0; col < this.col; col++) {
        Set<String> addInSet = new HashSet<>();
        for (int[] ele : boundaryArray) {
          int neighborRow = ele[0] + row;
          int neighborCol = ele[1] + col;

          if (neighborRow >= this.row || neighborRow < 0) {
            continue;
          }
          if (neighborCol >= this.col || neighborCol < 0) {
            continue;
          }
          String currentRowPosition = String.valueOf(row);
          String currentColPosition = String.valueOf(col);
          String position = currentRowPosition + currentColPosition;
          String neighbor = String.valueOf(neighborRow) + String.valueOf(neighborCol);

          if (this.walls.contains(position + "." + neighbor) == false) {
            if (this.walls.contains(neighbor + "." + position) == false) {
              addInSet.add(neighbor);
            }
          }
          this.sets.put(String.valueOf(row) + String.valueOf(col), addInSet);

        }
      }
    }
    System.out.println(this.sets);
  }
  
  public void updateSets(){ 
    
    for (int row = 0; row < this.row; row++) {
      for (int col = 0; col < this.col; col++) {
        String room = Integer.toString(row) + Integer.toString(col);
        for (String wall : this.removedWalls) { 
          String wallSide1 = wall.substring(0,2);
          String wallSide2 = wall.substring(3,5);
          Set<String> addInSet = new HashSet<>();

          if (room.equals(wallSide1)) {
            addInSet.addAll(this.sets.get(room));
            addInSet.add(wallSide2);
            this.sets.put(room, addInSet);
          }
          if (room.equals(wallSide2)) {
            addInSet.addAll(this.sets.get(room));
            addInSet.add(wallSide1);
            this.sets.put(room, addInSet);
          }
 
        }
      }
    }
    updateSetsHelper();
  }
  
  
  public void updateSetsHelper(){ 

    /** Loop through sets **/
    for (Map.Entry<String, Set<String>> entry : this.sets.entrySet()) {
      String key = entry.getKey();
      Set<String> val = entry.getValue();
      
      if (val.size() == 0) { continue; } 
      
      Set<String> setPairs = new HashSet<>();
      /** Current Key's value **/
      setPairs.addAll(val);
      
      /** Combining with paired keys values **/
      for (String ele: val) { 
        Set<String> pairedEle = this.sets.get(ele);
        setPairs.addAll(pairedEle);
      }
      /** Remove duplicate key in value list **/
      setPairs.remove(key);
      
      /** Replace new value to current key value **/
      this.sets.put(key, setPairs);
      
          
  }

  }
  
  


  public Boolean breakWall(String breakWall) {
    String[] rooms = breakWall.split("\\.");
    String room1 = rooms[0];
    String room2 = rooms[1];

    if (this.walls.contains(breakWall) == false) {
      throw new IllegalArgumentException("That is not a real wall.");
    }

    Set<String> inSet = this.sets.get(room1);
    
    if (inSet.contains(room2)) {
      return false;
    }
    
    int idx = this.walls.indexOf(room1 + "." + room2);

    this.removedWalls.add(breakWall);
    
    this.walls.remove(idx);
    return true;
  }
  

  public void perfect() {
    int goal = this.walls.size() - this.row * this.col + 1;
    Random ran = new Random();
    makeSets();

    while (this.walls.size() != goal) {

      int wallToBreak = ran.nextInt(this.walls.size()) + 0;
      
      if (breakWall(this.walls.get(wallToBreak))) {
       updateSets();
      }
      
    }
    
  }
  
  public Maze build () {
    return maze;
  }

  public static void main(String[] args) {
    // row, col, perfect...,0,0, 4,0
    // error check starting point and goal point could be in MazeBuilder
    // make MazeBuilder
    // make walls
    // make sets
    // array of room objects

    // MazeBuilder has all walls
    // a away to refer to wall-- 00.10
    // kruskals algo
    // randomly select wall, break if doesnt form cycle
    // update sets
    // function goes into every node, checks the wall list with names of nodes

    // break until we have nEdges-n+1 edges left
    MazeBuilder test = new MazeBuilder(4, 4, 0, 0, 1, 1);
    test.perfect();

    System.out.println(test.showWalls());
    System.out.println("Done");

  }

}
