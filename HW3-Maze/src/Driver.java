import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Driver class represents an execution of a player traversing various
 * mazes.
 * 
 * @author Ugo Nwachuku
 *
 */
public class Driver {

  /**
   * main method, runs the different traversals of a player in various mazes.
   * 
   * @param args
   */
  public static void main(String args[]) {

    System.out.println("Please enter the size of maze, type of maze, starting point "
        + "of player and goal location.");

    Scanner in = new Scanner(System.in);
    System.out.println("Please enter the number of rows in the maze: ");
    int row = in.nextInt();

    System.out.println("Please enter the number of columns in the maze: ");
    int col = in.nextInt();

    System.out.println("Please input values in brackets for type of maze: (1) for Perfect maze, "
        + "(2) for Room maze or Non-perfect maze and (3) for Wrapping room maze:");
    int maze = in.nextInt();
    if (maze < 1 || maze > 3) { 
      throw new IllegalArgumentException("Please enter a valid maze type.");
    }

    System.out.println("Please enter the starting row position of the player: ");
    int startRow = in.nextInt();

    System.out.println("Please enter the starting column position of the player: ");
    int startCol = in.nextInt();

    System.out.println("Please enter the row position of the goal: ");
    int goalRow = in.nextInt();

    System.out.println("Please enter the column position of the goal: ");
    int goalCol = in.nextInt();

    if (maze == 1) {

      Maze perfectMaze = new PerfectMaze(row, col, startRow, startCol, goalRow, goalCol);
      
      Player player = new Player("John", 0);

      while (perfectMaze.atGoal() == false) {
        ArrayList<String> moves = perfectMaze.getMoves();
        System.out.println("Player has these possible moves: " + moves);

        System.out.println("Please choose values in parenthesis for direction, (1) North, (2) South, (3) East, (4) West: ");
        int choice = in.nextInt();
        String move = player.pickMove(choice);
        System.out.println("Player chose: " + move);

        perfectMaze.makeMove(move, moves);
        System.out.println(perfectMaze.gotGold()); 
        System.out.println(perfectMaze.wasAttacked()); 
        int goldValue = perfectMaze.Event();

        player.addGold(goldValue);
        System.out.println("Player: " + player.toString());
        String position = perfectMaze.findPlayer();
        System.out.println("Player row position: " + position.substring(0, 1)
            + " Player column position: " + position.substring(1, 2));
        System.out.println("\n");
      }
      if (perfectMaze.atGoal() == true) { 
        System.out.println("Player reached goal.");
      }
    }

    if (maze == 2) {
      System.out.println("Please enter the remaining walls in the maze: ");
      int remainingWalls = in.nextInt();

      Maze roomMaze = new RoomMaze(row, col, remainingWalls, startRow, startCol, goalRow, goalCol);
      Player player = new Player("John", 0);

      while (roomMaze.atGoal() == false) {
        ArrayList<String> moves = roomMaze.getMoves();
        System.out.println("Player has these possible moves: " + moves);

        System.out.println("Please choose values in parenthesis for direction, (1) North, (2) South, (3) East, (4) West: ");
        int choice = in.nextInt();
        String move = player.pickMove(choice);
        System.out.println("Player chose: " + move);

        roomMaze.makeMove(move, moves);
        System.out.println(roomMaze.gotGold()); 
        System.out.println(roomMaze.wasAttacked()); 
        int goldValue = roomMaze.Event();

        player.addGold(goldValue);
        System.out.println(player.toString());
        String position = roomMaze.findPlayer();
        System.out.println("Player row position: " + position.substring(0, 1)
            + " Player column position: " + position.substring(1, 2));
        System.out.println("\n");
      }
      if (roomMaze.atGoal() == true) { 
        System.out.println("Player reached goal.");
      }
    }
    
    if (maze == 3) {
      System.out.println("Please enter the remaining walls in the maze: ");
      int remainingWalls = in.nextInt();

      Maze WrappingroomMaze = new WrappingRoomMaze(row, col, remainingWalls, startRow, startCol, goalRow, goalCol);
      Player player = new Player("John", 0);

      while (WrappingroomMaze.atGoal() == false) {
        ArrayList<String> moves = WrappingroomMaze.getMoves();
        System.out.println("Player has these possible moves: " + moves);

        System.out.println("Please choose values in parenthesis for direction, (1) North, (2) South, (3) East, (4) West: ");
        int choice = in.nextInt();
        String move = player.pickMove(choice);
        System.out.println("Player chose: " + move);

        WrappingroomMaze.makeMove(move, moves);
        System.out.println(WrappingroomMaze.gotGold()); 
        System.out.println(WrappingroomMaze.wasAttacked()); 
        int goldValue = WrappingroomMaze.Event();

        player.addGold(goldValue);
        System.out.println(player.toString());
        String position = WrappingroomMaze.findPlayer();
        System.out.println("Player row position: " + position.substring(0, 1)
            + " Player column position: " + position.substring(1, 2));
        System.out.println("\n");
      }
      if (WrappingroomMaze.atGoal() == true) { 
        System.out.println("Player reached goal.");
      }
    }

  }

}
