import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * This abstract class represents an abstraction of a maze. This abstract class
 * is a construction of methods in the Maze interface.
 * 
 * @author Ugo Nwachuku
 *
 */
public abstract class MazeImpl implements Maze {

  /**
   * insertCaves fills every position in the maze with Cave objects.
   * @param array Caves in maze
   * @param row number of rows in maze
   * @param col number of columns in maze
   */
  public Cave[] insertCaves(Cave[] array, int row, int col) {
    array = new Cave[row * col];
    int idxCount = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        String name = Integer.toString(i) + Integer.toString(j);
        name = name.substring(0, 1) + name.substring(1, 2);
        array[idxCount] = new Cave(name, false, false, 0);
        idxCount += 1;
      }
    }
    return array;
  }

  public abstract String findPlayer();

  /**
   * playerLocation returns location of player.
   * @param array Caves in maze
   * @param row number of rows in maze
   * @param col number of columns in maze
   */
  public String playerLocation(Cave[] array, int row, int col) {
    for (int i = 0; i < row * col; i++) {
      if (array[i].hasPlayer()) {
        return array[i].getName();
      }
    }
    return "No player in maze.";
  }

  /**
   * updatePlayerPosition updates player position after moving.
   * @param array Caves in maze
   * @param row number of rows in maze
   * @param col number of columns in maze
   * @param newPosRow new position row in maze
   * @param newPosCol new position column in maze
   */
  public void updatePlayerPosition(Cave[] array, int row, int col, int newPosRow, int newPosCol) {
    for (int i = 0; i < row * col; i++) {

      String name = Integer.toString(newPosRow) + Integer.toString(newPosCol);
      name = name.substring(0, 1) + name.substring(name.length() - 1, name.length());

      if (array[i].getName().equals(name)) {
        array[i].setPlayerIn(true);
        continue;
      }

      array[i].setPlayerIn(false);
    }

  }

  public abstract void makeMove(String move, ArrayList<String> moves);

  /**
   * playerMove moves player in maze.
   * @param row number of rows in maze
   * @param col number of columns in maze
   * @param mazeType type of maze
   * @param array Caves in maze
   * @param move direction to move
   */
  public void playerMove(int row, int col, String mazeType, Cave[] array, String move) {
    char playerRow = playerLocation(array, row, col).charAt(0);
    char playerCol = playerLocation(array, row, col).charAt(1);

    int playerRowNum = Character.getNumericValue(playerRow);
    int playerColNum = Character.getNumericValue(playerCol);

    if (move.equals("East")) {
      int playRow = playerRowNum + 0;
      int playCol = playerColNum + 1;
      int[] positions = boundaryHelper(playRow, playCol, row, col);

      if (mazeType.equals("perfect") || mazeType.equals("Cave")) {
        updatePlayerPosition(array, row, col, playRow, playCol);
      } else {
        updatePlayerPosition(array, row, col, positions[0], positions[1]);
      }
    }

    if (move.equals("West")) {
      int playRow = playerRowNum + 0;
      int playCol = playerColNum - 1;
      int[] positions = boundaryHelper(playRow, playCol, row, col);

      if (mazeType.equals("perfect") || mazeType.equals("Cave")) {
        updatePlayerPosition(array, row, col, playRow, playCol);
      } else {
        updatePlayerPosition(array, row, col, positions[0], positions[1]);
      }
    }
    if (move.equals("North")) {
      int playRow = playerRowNum - 1;
      int playCol = playerColNum + 0;
      int[] positions = boundaryHelper(playRow, playCol, row, col);

      if (mazeType.equals("perfect") || mazeType.equals("Cave")) {
        updatePlayerPosition(array, row, col, playRow, playCol);
      } else {
        updatePlayerPosition(array, row, col, positions[0], positions[1]);
      }
    }
    if (move.equals("South")) {
      int playRow = playerRowNum + 1;
      int playCol = playerColNum + 0;
      int[] positions = boundaryHelper(playRow, playCol, row, col);

      if (mazeType.equals("perfect") || mazeType.equals("Cave")) {
        updatePlayerPosition(array, row, col, playRow, playCol);
      } else {
        updatePlayerPosition(array, row, col, positions[0], positions[1]);
      }
    }

  }

  /**
   * BoundaryHelper, updates the row and columns of a wrapping Cave maze
   * properly.
   * @param row row position of player in maze
   * @param col column position of player in maze
   * @param mazeRow rows in maze
   * @param mazeCol columns in maze
   */
  public int[] boundaryHelper(int row, int col, int mazeRow, int mazeCol) {
    int[] positions = new int[2];

    if (row >= mazeRow || row < 0) {
      if (row >= mazeRow) {
        row = row - mazeRow;
      }
      if (row < 0) {
        row = row + mazeRow;
      }
    }

    if (col >= mazeCol || col < 0) {
      if (col >= mazeCol) {
        col = col - mazeCol;
      }
      if (col < 0) {
        col = col + mazeCol;
      }
    }

    positions[0] = row;
    positions[1] = col;
    return positions;
  }

  /**
   * spreadGold spreads gold in 20% of the cells in the maze.
   * @param array Caves in maze
   * @param row number of rows in maze
   * @param col number of columns in maze
   */
  public void spreadGold(Cave[] array, int row, int col) {
    HashSet<Integer> set = generateRandomSet(row, col, 0.20);
    // Put into maze
    for (int i = 0; i < set.size(); i++) {
      array[i].setGold(100);
    }
  }

  /**
   * spreadThieves spreads thieves in 10% of the cells in the maze.
   * @param array Caves in maze
   * @param row number of rows in maze
   * @param col number of columns in maze
   */
  public void spreadThieves(Cave[] array, int row, int col) {
    HashSet<Integer> set = generateRandomSet(row, col, 0.10);
    // Put into maze
    for (int i = 0; i < set.size(); i++) {
      array[i].placeThief(true);
    }
  }

  public abstract String gotGold();

  public abstract String wasAttacked();

  public abstract double event(double gold);

  /**
   * checkGotGoldchecks if a player got gold.
   * @param array of Caves in maze
   * @param row rows in maze
   * @param col columns in maze
   */
  public String checkGotGold(Cave[] array, int row, int col) {
    for (int i = 0; i < row * col; i++) {
      if (array[i].hasPlayer()) {
        if (array[i].getGold() > 0) {
          return "Player picked up some Gold!";
        }
      }
    }
    return "Player didn't get any Gold.";
  }

  /**
   * checkWasAttacked checks if a player was attacked.
   * @param array of Caves in maze
   * @param row rows in maze
   * @param col columns in maze
   */
  public String checkWasAttacked(Cave[] array, int row, int col) {
    for (int i = 0; i < row * col; i++) {
      if (array[i].hasPlayer()) {
        if (array[i].hasThief()) {
          return "Player got Robbed";
        }
      }
    }
    return "Player didn't get attacked.";
  }

  /**
   * Action determines what happens to a player in the Cave. Depending on if a
   * thief or gold is in the Cave.
   * @param array of Caves in maze
   * @param row rows in maze
   * @param col columns in maze
   * @param gold value of gold
   */
  public double action(Cave[] array, int row, int col, double gold) {
    double score = 0;
    for (int i = 0; i < row * col; i++) {
      if (array[i].hasPlayer()) {
        score += array[i].getGold();
        score += gold;
        if (array[i].hasThief()) {
          score = array[i].thiefAttack(score);
        }
        array[i].setGold(0);
      }
    }
    return score;
  }

  public abstract ArrayList<String> getMoves();

  /**
   * possibleMoves returns the possible moves a player can make.
   * @param mazeType type of maze
   * @param array of Caves in maze
   * @param walls walls in maze
   * @param possibleMoves possible moves to take
   * @param mazeRow size of maze row
   * @param mazeCol size of maze column
   */
  public ArrayList<String> possibleMoves(String mazeType, Cave[] array, ArrayList<String> walls,
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

        if (mazeType.equals("perfect") || mazeType.equals("Cave")) {
          continue;
        }
        if (currRow >= mazeRow) {
          currRow = currRow - mazeRow;
        }
        if (currRow < 0) {
          currRow = currRow + mazeRow;
        }
      }
      if (currCol >= mazeCol || currCol < 0) {

        if (mazeType.equals("perfect") || mazeType.equals("Cave")) {
          continue;
        }
        if (currCol >= mazeCol) {
          currCol = currCol - mazeCol;
        }
        if (currCol < 0) {
          currCol = currCol + mazeCol;
        }
      }

      String neighbour = Integer.toString(currRow) + Integer.toString(currCol);
      neighbour = neighbour.substring(0, 1) + neighbour.substring(1, 2);

      String possibleWall1 = playerLocation(array, mazeRow, mazeCol) + "." + neighbour;
      if (walls.contains(possibleWall1)) {
        continue;
      }

      String possibleWall2 = neighbour + "." + playerLocation(array, mazeRow, mazeCol);
      if (walls.contains(possibleWall2)) {
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

  /**
   * mazeSolved returns if the maze has been solved or not.
   * @param array of Caves in maze
   * @param row rows in maze
   * @param col columns in maze
   * @param goalRow row of goal
   * @param goalCol column of goal
   */
  public Boolean mazeSolved(Cave[] array, int row, int col, int goalRow, int goalCol) {
    String goal = Integer.toString(goalRow) + Integer.toString(goalCol);
    goal = goal.substring(0, 1) + goal.substring(1, 2);
    if (playerLocation(array, row, col).equals(goal)) {
      return true;
    }
    return false;
  }

  /**
   * makeWalls makes the walls in the maze.
   * @param row rows in maze
   * @param col columns in maze
   * @param walls walls in maze
   */
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

  /**
   * makeSets makes the initial sets in the maze. Sets represent Caves that are
   * linked by a hallway.
   * @param row rows in maze
   * @param col columns in maze
   * @param sets hallways in maze
   * @param walls walls in maze
   * 
   */
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

          if (!walls.contains(position + "." + neighbor)) {
            if (!walls.contains(neighbor + "." + position)) {
              addInSet.add(neighbor);
            }
          }

          sets.put(String.valueOf(i) + String.valueOf(j), addInSet);

        }
      }
    }
    return sets;
  }
  
  /**
   * updateSets updates the sets in the maze after a wall has been broken.
   * @param row rows in maze
   * @param col columns in maze
   * @param sets hallways in maze
   * @param removedWalls walls removed from maze
   */
  public Map<String, Set<String>> updateSets(int row, int col, Map<String, Set<String>> sets,
      ArrayList<String> removedWalls) {

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        String Cave = Integer.toString(i) + Integer.toString(j);
        Cave = Cave.substring(0, 1) + Cave.substring(1, 2);
        for (String wall : removedWalls) {
          String wallSide1 = wall.substring(0, 2);
          String wallSide2 = wall.substring(3, 5);
          Set<String> addInSet = new HashSet<>();

          if (Cave.equals(wallSide1)) {
            addInSet.addAll(sets.get(Cave));
            addInSet.add(wallSide2);
            sets.put(Cave, addInSet);
          }
          if (Cave.equals(wallSide2)) {
            addInSet.addAll(sets.get(Cave));
            addInSet.add(wallSide1);
            sets.put(Cave, addInSet);
          }

        }
      }
    }
    updateSetsHelper(sets);
    return sets;
  }

  /**
   * updateSetsHelper calculates all the connections from other cells that are
   * linked to a certain cell have. Helps the updateSets method by doing this.
   * @param sets hallways in maze
   */
  public void updateSetsHelper(Map<String, Set<String>> sets) {

    // Loop through sets 
    for (Map.Entry<String, Set<String>> entry : sets.entrySet()) {
      String key = entry.getKey();
      Set<String> val = entry.getValue();

      if (val.size() == 0) {
        continue;
      }

      Set<String> setPairs = new HashSet<>();
      // Current Key's value 
      setPairs.addAll(val);

      // Combining with paired keys values 
      for (String ele : val) {
        Set<String> pairedEle = sets.get(ele);
        setPairs.addAll(pairedEle);
      }
      // Remove duplicate key in value list 
      setPairs.remove(key);

      // Replace new value to current key value 
      sets.put(key, setPairs);

    }

  }

  /**
   * canBreakWall determines if a wall can be broken.
   * @param breakWall string representation of wall to break
   * @param sets hallways in maze
   */
  public Boolean canBreakWall(String breakWall, Map<String, Set<String>> sets,
      ArrayList<String> walls) {
    String[] Caves = breakWall.split("\\.");
    String Cave1 = Caves[0];
    String Cave2 = Caves[1];

    if (!walls.contains(breakWall)) {
      throw new IllegalArgumentException("That is not a real wall.");
    }

    Set<String> inSet = sets.get(Cave1);

    if (inSet.contains(Cave2)) {
      return false;
    }
    return true;
  }

  /**
   * breakWall breaks a wall between two cells.
   * @param breakWall string representation of wall to break
   * @param walls the walls in the maze
   * @param removedWalls walls removed from maze
   */
  public ArrayList<String> breakWall(String breakWall, ArrayList<String> walls,
      ArrayList<String> removedWalls) {
    String[] Caves = breakWall.split("\\.");
    String Cave1 = Caves[0];
    String Cave2 = Caves[1];
    int idx = walls.indexOf(Cave1 + "." + Cave2);
    removedWalls.add(breakWall);
    walls.remove(idx);
    return walls;
  }

  /**
   * buildMaze builds the specified maze.
   * @param walls the walls in the maze
   * @param removedWalls walls removed from the maze
   * @param sets hallways in maze
   * @param mazeType type of maze
   * @param row row size of maze
   * @param col column size of maze
   */
  public void buildMaze(ArrayList<String> walls, ArrayList<String> removedWalls,
      Map<String, Set<String>> sets, String mazeType, int row, int col, int goal) {
    Random ran = new Random();

    while (walls.size() > goal) {
      int wallToBreak = ran.nextInt(walls.size()) + 0;

      if (mazeType.equals("perfect")) {
        if (canBreakWall(walls.get(wallToBreak), sets, walls)) {
          walls = breakWall(walls.get(wallToBreak), walls, removedWalls);
          sets = updateSets(row, col, sets, removedWalls);
        }
      }

      else if (mazeType.equals("Cave")) {
        walls = breakWall(walls.get(wallToBreak), walls, removedWalls);
        sets = updateSets(row, col, sets, removedWalls);
      }

    }
  }

  /**
   * generateRandomSet generates a set of random non-repeating numbers in a
   * certain range. Function is a helper to spreadGold and spreadThieves.
   * 
   * @param amount is the percentage of numbers to generate.
   * @param col the number of columns in the maze
   * @param row the number of rows in the maze
   * @return set of random integer values.
   */
  public HashSet<Integer> generateRandomSet(int row, int col, double amount) {
    HashSet<Integer> set = new HashSet<Integer>();
    Random ran = new Random();
    double CavesWithGold = Math.ceil(amount * row * col);
    // Generate random numbers 
    while (set.size() < CavesWithGold) {
      int num = ran.nextInt((int) row * col);
      set.add(num);
    }
    return set;
  }

}
