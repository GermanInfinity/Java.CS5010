import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * This abstract class represents the abstraction of a maze.
 * 
 * @author Ugo Nwachuku
 *
 */
public abstract class MazeImpl implements Maze {

  private Maze maze;
  private Player player;

  private int row;
  private int col;
  private int startRow;
  private int startCol;
  private int goalRow;
  private int goalCol;

  private Room[] array;
  private String mazeType;

  private ArrayList<String> possibleMoves;
  private String playerMove;

  private ArrayList<String> walls;
  private ArrayList<String> removedWalls;
  private Map<String, Set<String>> sets;

  public void insertRooms() {
    this.array = new Room[row * col];

    for (int i = 0; i < row * col; i++) {
      String name = Integer.toString(row) + Integer.toString(col);
      this.array[i] = new Room(name, false, 0);
    }

  }

  public void spreadGold() {
    HashSet<Integer> set = generateRandomSet(0.20);
    /** Put into maze **/
    for (int i = 0; i < set.size(); i++) {
      this.array[i].setGold(100);
    }
  }

  public void spreadThieves() {
    HashSet<Integer> set = generateRandomSet(0.10);
    /** Put into maze **/
    for (int i = 0; i < set.size(); i++) {
      this.array[i].placeThief(true);
    }
  }

  public String playerPosition() {
    return this.player.getPosition();
  }

  public void playerMove() {
    this.playerMove = player.pickMove(this.possibleMoves);
  }

  public void possibleMoves() {
    int[][] boundaryArray = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    char playerRow = this.player.getPosition().charAt(0);
    char playerCol = this.player.getPosition().charAt(0);
    int playerRowNum = Character.getNumericValue(playerRow);
    int playerColNum = Character.getNumericValue(playerCol);

    for (int i = 0; i < boundaryArray.length; i++) {
      int currRow = playerRowNum + boundaryArray[i][0];
      int currCol = playerColNum + boundaryArray[i][1];

      String neighbour = Integer.toString(currRow) + Integer.toString(currCol);
      String possibleWall = this.player.getPosition() + "." + neighbour;
      if (this.walls.contains(possibleWall)) {
        continue;
      }

      if (i == 0) {
        this.possibleMoves.add("South");
      }
      if (i == 1) {
        this.possibleMoves.add("North");
      }
      if (i == 2) {
        this.possibleMoves.add("East");
      }
      if (i == 3) {
        this.possibleMoves.add("West");
      }
    }

  }

  public Boolean mazeSolved() {
    String goal = Integer.toString(goalRow) + Integer.toString(goalCol);
    if (player.getPosition().equals(goal)) {
      return true;
    }
    return false;
  }

  public void Action() {
    for (int i = 0; i < this.array.length; i++) {
      Room currentRoom = this.array[i];
      if (this.player.getPosition().equals(currentRoom.getName())) {

        this.player.addGold(currentRoom.getGold());

        if (currentRoom.hasThief()) {
          this.player.addGold(-50);
        }
      }
    }
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
  }

  public void updateSets() {

    for (int row = 0; row < this.row; row++) {
      for (int col = 0; col < this.col; col++) {
        String room = Integer.toString(row) + Integer.toString(col);
        for (String wall : this.removedWalls) {
          String wallSide1 = wall.substring(0, 2);
          String wallSide2 = wall.substring(3, 5);
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

  public void updateSetsHelper() {

    /** Loop through sets **/
    for (Map.Entry<String, Set<String>> entry : this.sets.entrySet()) {
      String key = entry.getKey();
      Set<String> val = entry.getValue();

      if (val.size() == 0) {
        continue;
      }

      Set<String> setPairs = new HashSet<>();
      /** Current Key's value **/
      setPairs.addAll(val);

      /** Combining with paired keys values **/
      for (String ele : val) {
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

  /**
   * generateRandomSet generates a set of random non-repeating numbers in a
   * certain range.
   * 
   * @param amount is the percentage of numbers to generate.
   * @return set of random integer values.
   */
  public HashSet<Integer> generateRandomSet(double amount) {
    HashSet<Integer> set = new HashSet<Integer>();
    Random ran = new Random();
    double roomsWithGold = Math.ceil(amount * this.row * this.col);
    /** Generate random numbers **/
    while (set.size() < roomsWithGold) {
      int num = ran.nextInt((int) this.row * this.col);
      set.add(num);
    }
    return set;
  }

}
