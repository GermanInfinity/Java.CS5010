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

  public Room[] insertRooms(Room[] array, int row, int col) {
    array = new Room[row * col];
    int idxCount = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        String name = Integer.toString(i) + Integer.toString(j);
        name = name.substring(0,1) + name.substring(1,2);
        array[idxCount] = new Room(name, false, false, 0);
        idxCount += 1;
      }
    }
    return array;
  }

  public String playerLocation(Room[] array, int row, int col) {
    for (int i = 0; i < row * col; i++) {
      if (array[i].hasPlayer()) {
        return array[i].getName();
      }
    }
    return "No player in maze.";
  }

  public void updatePlayerPosition(Room[] array, int row, int col, int newPosRow, int newPosCol) {
    for (int i = 0; i < row * col; i++) {
      
      String name = Integer.toString(newPosRow) + Integer.toString(newPosCol);
      name = name.substring(0,1) + name.substring(name.length()-1,name.length());

      
      if (array[i].getName().equals(name)) { 
        array[i].setPlayerIn(true);
        continue;
      }
      
      array[i].setPlayerIn(false);
    }
    
    
    
  }

  public abstract void makeMove(String move);

  public void playerMove(int row, int col, Room[] array, String move) {
    char playerRow = playerLocation(array, row, col).charAt(0);
    char playerCol = playerLocation(array, row, col).charAt(1);

    int playerRowNum = Character.getNumericValue(playerRow);
    int playerColNum = Character.getNumericValue(playerCol);

    if (move == "East") {
      int playRow = playerRowNum + 0;
      int playCol = playerColNum + 1;

      updatePlayerPosition(array, row, col, playRow, playCol);
    }
    if (move == "West") {
      int playRow = playerRowNum + 0;
      int playCol = playerColNum - 1;
      updatePlayerPosition(array, row, col, playRow, playCol);
    }
    if (move == "North") {
      int playRow = playerRowNum - 1;
      int playCol = playerColNum + 0;
      updatePlayerPosition(array, row, col, playRow, playCol);
    }
    if (move == "South") {
      int playRow = playerRowNum + 1;
      int playCol = playerColNum + 0;

      updatePlayerPosition(array, row, col, playRow, playCol);
    }
    

  }

  public void spreadGold(Room[] array, int row, int col) {
    HashSet<Integer> set = generateRandomSet(row, col, 0.20);
    /** Put into maze **/
    for (int i = 0; i < set.size(); i++) {
      array[i].setGold(100);
    }
  }

  public void spreadThieves(Room[] array, int row, int col) {
    HashSet<Integer> set = generateRandomSet(row, col, 0.10);
    /** Put into maze **/
    for (int i = 0; i < set.size(); i++) {
      array[i].placeThief(true);
    }
  }

  public abstract int Event();

  public int Action(Room[] array, int row, int col) {
    int score = 0;
    for (int i = 0; i < row * col; i++) {

      if (array[i].hasPlayer()) {
        score += array[i].getGold();
        if (array[i].hasThief()) { score += array[i].thiefAttack(); } 
        array[i].setGold(0);
        //System.out.println(score);
      }
    }
    return score;
  }

  public abstract ArrayList<String> getMoves();

  public ArrayList<String> possibleMoves(Room[] array, ArrayList<String> walls,
      ArrayList<String> possibleMoves, int mazeRow, int mazeCol) {
    
    int[][] boundaryArray = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    char playerRow = playerLocation(array, mazeRow, mazeCol).charAt(0);
    char playerCol = playerLocation(array, mazeRow, mazeCol).charAt(1);
    
    int playerRowNum = Character.getNumericValue(playerRow);
    int playerColNum = Character.getNumericValue(playerCol);

    
    for (int i = 0; i < boundaryArray.length; i++) {
      int currRow = playerRowNum + boundaryArray[i][0];
      int currCol = playerColNum + boundaryArray[i][1];


      if (currRow >= mazeRow || currRow < 0) {
        continue;
      }
      if (currCol >= mazeCol || currCol < 0) {
        continue;
      }
      
      String neighbour = Integer.toString(currRow) + Integer.toString(currCol);
      neighbour = neighbour.substring(0,1) + neighbour.substring(1,2);
      String possibleWall = playerLocation(array, mazeRow, mazeCol) + "." + neighbour;

      if (walls.contains(possibleWall)) {
        continue;
      }

      if (i == 0) {
        possibleMoves.add("South");
      }
      if (i == 1) {
        possibleMoves.add("North");
      }
      if (i == 2) {
        possibleMoves.add("East");
      }
      if (i == 3) {
        possibleMoves.add("West");
      }
    }
    return possibleMoves;

  }

  public abstract Boolean atGoal();

  public Boolean mazeSolved(Room[] array, int row, int col, int goalRow, int goalCol) {
    String goal = Integer.toString(goalRow) + Integer.toString(goalCol);
    goal = goal.substring(0,1) + goal.substring(1,2);
    if (playerLocation(array, row, col).equals(goal)) {
      System.out.println("Solved.");
      return true;
    }
    return false;
  }

  public ArrayList<String> makeWalls(int row, int col, ArrayList<String> walls) {

    int[][] boundaryArray = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {

        for (int[] ele : boundaryArray) {
          int neighborRow = ele[0] + i;
          int neighborCol = ele[1] + j;

          if (neighborRow >= row || neighborRow < 0) {
            continue;
          }
          if (neighborCol >= col || neighborCol < 0) {
            continue;
          }

          String currentRowPosition = String.valueOf(i);
          String currentColPosition = String.valueOf(j);
          String position = currentRowPosition + currentColPosition;
          String neighbor = String.valueOf(neighborRow) + String.valueOf(neighborCol);

          if (walls.contains(neighbor + "." + position)) {
            continue;
          }
          walls.add(position + "." + neighbor);
        }
      }
    }
    return walls;
  }

  public ArrayList<String> showWalls(ArrayList<String> walls) {
    return walls;
  }

  public Map<String, Set<String>> makeSets(int row, int col, Map<String, Set<String>> sets,
      ArrayList<String> walls) {
    int[][] boundaryArray = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        Set<String> addInSet = new HashSet<>();

        for (int[] ele : boundaryArray) {
          int neighborRow = ele[0] + i;
          int neighborCol = ele[1] + j;

          if (neighborRow >= row || neighborRow < 0) {
            continue;
          }
          if (neighborCol >= col || neighborCol < 0) {
            continue;
          }
          String currentRowPosition = String.valueOf(i);
          String currentColPosition = String.valueOf(j);
          String position = currentRowPosition + currentColPosition;
          String neighbor = String.valueOf(neighborRow) + String.valueOf(neighborCol);

          if (walls.contains(position + "." + neighbor) == false) {
            if (walls.contains(neighbor + "." + position) == false) {
              addInSet.add(neighbor);
            }
          }

          sets.put(String.valueOf(i) + String.valueOf(j), addInSet);

        }
      }
    }
    return sets;
  }

  public Map<String, Set<String>> updateSets(int row, int col, Map<String, Set<String>> sets,
      ArrayList<String> removedWalls) {

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        String room = Integer.toString(i) + Integer.toString(j);
        room = room.substring(0,1) + room.substring(1,2);
        for (String wall : removedWalls) {
          String wallSide1 = wall.substring(0, 2);
          String wallSide2 = wall.substring(3, 5);
          Set<String> addInSet = new HashSet<>();

          if (room.equals(wallSide1)) {
            addInSet.addAll(sets.get(room));
            addInSet.add(wallSide2);
            sets.put(room, addInSet);
          }
          if (room.equals(wallSide2)) {
            addInSet.addAll(sets.get(room));
            addInSet.add(wallSide1);
            sets.put(room, addInSet);
          }

        }
      }
    }
    updateSetsHelper(sets);
    return sets;
  }

  public void updateSetsHelper(Map<String, Set<String>> sets) {

    /** Loop through sets **/
    for (Map.Entry<String, Set<String>> entry : sets.entrySet()) {
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
        Set<String> pairedEle = sets.get(ele);
        setPairs.addAll(pairedEle);
      }
      /** Remove duplicate key in value list **/
      setPairs.remove(key);

      /** Replace new value to current key value **/
      sets.put(key, setPairs);

    }

  }

  public Boolean canBreakWall(String breakWall, Map<String, Set<String>> sets,
      ArrayList<String> walls) {
    String[] rooms = breakWall.split("\\.");
    String room1 = rooms[0];
    String room2 = rooms[1];

    if (walls.contains(breakWall) == false) {
      throw new IllegalArgumentException("That is not a real wall.");
    }

    Set<String> inSet = sets.get(room1);

    if (inSet.contains(room2)) {
      return false;
    }
    return true;
  }

  public ArrayList<String> breakWall(String breakWall, ArrayList<String> walls,
      ArrayList<String> removedWalls) {
    String[] rooms = breakWall.split("\\.");
    String room1 = rooms[0];
    String room2 = rooms[1];
    int idx = walls.indexOf(room1 + "." + room2);
    removedWalls.add(breakWall);
    walls.remove(idx);
    return walls;
  }


  /**
   * generateRandomSet generates a set of random non-repeating numbers in a
   * certain range. Function is a helper to spreadGold and spreadThieves.
   * 
   * @param amount is the percentage of numbers to generate.
   * @return set of random integer values.
   */
  public HashSet<Integer> generateRandomSet(int row, int col, double amount) {
    HashSet<Integer> set = new HashSet<Integer>();
    Random ran = new Random();
    double roomsWithGold = Math.ceil(amount * row * col);
    /** Generate random numbers **/
    while (set.size() < roomsWithGold) {
      int num = ran.nextInt((int) row * col);
      set.add(num);
    }
    return set;
  }

}
