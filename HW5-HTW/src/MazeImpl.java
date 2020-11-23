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
        array[idxCount] = new Cave(name, Integer.toString(idxCount), false);
        idxCount += 1;
      }
    }
    return array;
  }

  public abstract String findPlayerPosition();
  public abstract String findPlayer();
  public abstract Cave currentCave(); 
  
  
  /**
   * playerPosition returns location of player in a numeric format.
   * @param array Caves in maze
   * @param row number of rows in maze
   * @param col number of columns in maze
   */
  public Cave getCave(Cave[] array, int row, int col) {
    for (int i = 0; i < row * col; i++) {
      if (array[i].hasPlayerIn()) {
        return array[i];
      }
    }
    return null;
  }
  
  /**
   * playerPosition returns location of player in a numeric format.
   * @param array Caves in maze
   * @param row number of rows in maze
   * @param col number of columns in maze
   */
  public String playerPosition(Cave[] array, int row, int col) {
    for (int i = 0; i < row * col; i++) {
      if (array[i].hasPlayerIn()) {
        return array[i].getSecondaryName();
      }
    }
    return "No player in maze.";
  }

  /**
   * playerLocation returns location of player.
   * @param array Caves in maze
   * @param row number of rows in maze
   * @param col number of columns in maze
   */
  public String playerLocation(Cave[] array, int row, int col) {
    for (int i = 0; i < row * col; i++) {
      if (array[i].hasPlayerIn()) {
        return array[i].getName();
      }
    }
    return "No player in maze.";
  }
  
  /**
   * pritnLocations returns all possible locations in maze. 
   */
  public ArrayList<String> printLocations(Cave[] array, int row, int col) { 
    ArrayList<String> locations = new ArrayList<String>(); 
    for (int i = 0; i < row * col; i++) {
      if (array[i].getSecondaryName().equals("tunnel")) {
        continue;
      }
      locations.add(array[i].getSecondaryName());
    }
    return locations;
  }
  
  public Cave findCave(Cave[]array, int row, int col, int posRow, int posCol) {
    for (int i = 0; i < row * col; i++) {
      if (array[i].getName().equals(Integer.toString(posRow) + Integer.toString(posCol))) { 
        return array[i];
      }
    }
    return null;
  }

  /**
   * updatePlayerPosition updates player position after moving.
   * @param array rooms in maze
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

  public Boolean ifTunnel(Cave[] array, int row, int col, int playRow, int playCol) { 
    
    for (int i = 0; i < row * col; i++) { 
      String rowStr = Integer.toString(playRow); 
      String column = Integer.toString(playCol); 
      
      
      if (array[i].getName().equals(rowStr+column)) {
        
        if (array[i].getSecondaryName().equals("tunnel")) {

          return true;
        }
      }
    }
    return false;
  }
  
  public abstract Cave[] makeMove(String move, ArrayList<String> moves, Cave[] cav);

  /**
   * playerMove moves player in maze.
   * @param row number of rows in maze
   * @param col number of columns in maze
   * @param mazeType type of maze
   * @param array rooms in maze
   * @param move direction to move
   */
  public Cave[] playerMove(int row, int col, String mazeType, Cave[] array, String move) {
    char playerRow = playerLocation(array, row, col).charAt(0);
    char playerCol = playerLocation(array, row, col).charAt(1);


    int playerRowNum = java.lang.Character.getNumericValue(playerRow);
    int playerColNum = java.lang.Character.getNumericValue(playerCol);

    if (move.equals("East")) {
      int playRow = playerRowNum + 0;
      int playCol = playerColNum + 1;
      int[] positions = boundaryHelper(playRow, playCol, row, col);

      if (mazeType.equals("perfect") || mazeType.equals("room")) {
        if (ifTunnel(array, row, col, playRow, playCol)) { 
          Cave tunnelCave = findCave(array, row, col, playRow, playCol);
          String correctDirection = tunnelCave.findNext(playerRowNum, playerColNum);
          
          updatePlayerPosition(array, row, col, playRow, playCol);
          playerMove(row, col, mazeType, array, correctDirection);
          return array;
        }
        updatePlayerPosition(array, row, col, playRow, playCol);

        return array;

      } else {
        if (ifTunnel(array, row, col, playRow, playCol)) {
          updatePlayerPosition(array, row, col, positions[0], positions[1]);
          playerMove(row, col, mazeType, array, move);
          return array;
        }
        updatePlayerPosition(array, row, col, positions[0], positions[1]);
      }
    }

    if (move.equals("West")) {
      int playRow = playerRowNum + 0;
      int playCol = playerColNum - 1;
      int[] positions = boundaryHelper(playRow, playCol, row, col);

      if (mazeType.equals("perfect") || mazeType.equals("room")) {
        if (ifTunnel(array, row, col, playRow, playCol)) { 
          Cave tunnelCave = findCave(array, row, col, playRow, playCol);
          String correctDirection = tunnelCave.findNext(playerRowNum, playerColNum);
          
          updatePlayerPosition(array, row, col, playRow, playCol);
          playerMove(row, col, mazeType, array, correctDirection);
          return array;
        }
        updatePlayerPosition(array, row, col, playRow, playCol);

        return array;

      } else {
        if (ifTunnel(array, row, col, playRow, playCol)) {
          updatePlayerPosition(array, row, col, positions[0], positions[1]);
          playerMove(row, col, mazeType, array, move);
        }
        updatePlayerPosition(array, row, col, positions[0], positions[1]);
      }
    }
    if (move.equals("North")) {
      int playRow = playerRowNum - 1;
      int playCol = playerColNum + 0;
      int[] positions = boundaryHelper(playRow, playCol, row, col);

      if (mazeType.equals("perfect") || mazeType.equals("room")) {
        if (ifTunnel(array, row, col, playRow, playCol)) { 
          Cave tunnelCave = findCave(array, row, col, playRow, playCol);
          String correctDirection = tunnelCave.findNext(playerRowNum, playerColNum);
          
          updatePlayerPosition(array, row, col, playRow, playCol);
          playerMove(row, col, mazeType, array, correctDirection);
          return array;
        }
        updatePlayerPosition(array, row, col, playRow, playCol);

        return array;

      } else {
        if (ifTunnel(array, row, col, playRow, playCol)) {
          updatePlayerPosition(array, row, col, positions[0], positions[1]);
          playerMove(row, col, mazeType, array, move);
          return array;
        }
        updatePlayerPosition(array, row, col, positions[0], positions[1]);
      }
    }
    if (move.equals("South")) {
      int playRow = playerRowNum + 1;
      int playCol = playerColNum + 0;
      int[] positions = boundaryHelper(playRow, playCol, row, col);

      if (mazeType.equals("perfect") || mazeType.equals("room")) {
        if (ifTunnel(array, row, col, playRow, playCol)) { 
          Cave tunnelCave = findCave(array, row, col, playRow, playCol);
          String correctDirection = tunnelCave.findNext(playerRowNum, playerColNum);
          
          updatePlayerPosition(array, row, col, playRow, playCol);
          playerMove(row, col, mazeType, array, correctDirection);
          return array;
        }
        
        updatePlayerPosition(array, row, col, playRow, playCol);

        return array;

      } else {
        if (ifTunnel(array, row, col, playRow, playCol)) {
          updatePlayerPosition(array, row, col, positions[0], positions[1]);
          playerMove(row, col, mazeType, array, move);
          return array;
        }
        updatePlayerPosition(array, row, col, positions[0], positions[1]);
      }
    }

    return array;

  }

  /**
   * BoundaryHelper, updates the row and columns of a wrapping room maze
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




  public abstract ArrayList<String> getMoves();

  /**
   * possibleMoves returns the possible moves a player can make.
   * @param mazeType type of maze
   * @param array of rooms in maze
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

    int playerRowNum = java.lang.Character.getNumericValue(playerRow);
    int playerColNum = java.lang.Character.getNumericValue(playerCol);

    for (int i = 0; i < boundaryArray.length; i++) {
      int currRow = playerRowNum + boundaryArray[i][0];
      int currCol = playerColNum + boundaryArray[i][1];

      if (currRow >= mazeRow || currRow < 0) {

        if (mazeType.equals("perfect") || mazeType.equals("room")) {
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

        if (mazeType.equals("perfect") || mazeType.equals("room")) {
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
   * makeSets makes the initial sets in the maze. Sets represent rooms that are
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
        String room = Integer.toString(i) + Integer.toString(j);
        room = room.substring(0, 1) + room.substring(1, 2);
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
    String[] rooms = breakWall.split("\\.");
    String room1 = rooms[0];
    String room2 = rooms[1];

    if (!walls.contains(breakWall)) {
      throw new IllegalArgumentException("That is not a real wall.");
    }

    Set<String> inSet = sets.get(room1);

    if (inSet.contains(room2)) {
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
    String[] rooms = breakWall.split("\\.");
    String room1 = rooms[0];
    String room2 = rooms[1];
    int idx = walls.indexOf(room1 + "." + room2);
    //System.out.println(room1 + "." + room2);
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
    Boolean madeCycle = false; 
    
    while (walls.size() > goal) {
      int wallToBreak = ran.nextInt(walls.size()) + 0;

      if (mazeType.equals("perfect")) {
        if (canBreakWall(walls.get(wallToBreak), sets, walls)) {
          walls = breakWall(walls.get(wallToBreak), walls, removedWalls);
          sets = updateSets(row, col, sets, removedWalls);
        }
      }
      
      else if (mazeType.equals("room")) {
        if (!madeCycle) { 
          makeCycle(walls, removedWalls, sets, row, col);
          madeCycle = true;
          continue;
        }
        
        if (canBreakWall(walls.get(wallToBreak), sets, walls)) {
          walls = breakWall(walls.get(wallToBreak), walls, removedWalls);
          sets = updateSets(row, col, sets, removedWalls);      
        }
      }

      else if (mazeType.equals("wrapping room")) {
        walls = breakWall(walls.get(wallToBreak), walls, removedWalls);
        sets = updateSets(row, col, sets, removedWalls);
      }

    }
  }
  
  /**
   * makeCycle makes a cycle of rooms in a room maze.
   */
  public void makeCycle(ArrayList<String> walls, ArrayList<String> removedWalls,  
                                Map<String, Set<String>> sets, int row, int col) { 
    Random ran = new Random();
    int ranRow = ran.nextInt(row);
    int ranCol = ran.nextInt(col);
    int diagRow = ranRow + 1;
    int diagCol = ranCol + 1;
    
    String rRow = Integer.toString(ranRow); 
    String rCol = Integer.toString(ranCol); 
    String dRow = Integer.toString(diagRow); 
    String dCol = Integer.toString(diagCol); 
   
    
    if (diagRow < row && diagCol < col) { 

      String wall1 = rRow+rCol+"."+rRow+dCol;
      String wall2 = rRow+rCol+"."+dRow+rCol;
      String wall3 = dRow+rCol+"."+dRow+dCol;
      String wall4 = rRow+dCol+"."+dRow+dCol;
      walls = breakWall(wall1, walls, removedWalls);
      sets = updateSets(row, col, sets, removedWalls);
      walls = breakWall(wall2, walls, removedWalls);
      sets = updateSets(row, col, sets, removedWalls);
      walls = breakWall(wall3, walls, removedWalls);
      sets = updateSets(row, col, sets, removedWalls);
      walls = breakWall(wall4, walls, removedWalls);
      sets = updateSets(row, col, sets, removedWalls); 
    }
    else { 
      makeCycle(walls, removedWalls, sets, row, col);
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
    double roomsWithGold = Math.ceil(amount * row * col);
    // Generate random numbers 
    while (set.size() < roomsWithGold) {
      int num = ran.nextInt((int) row * col);
      set.add(num);
    }
    return set;
  }

}
