import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

  public static void main(String args[]) {
    
    System.out.println(
        "Please enter the size of maze, type of maze, starting point of player and goal location.");

    Scanner in = new Scanner(System.in);
    System.out.println("Please enter the number of rows in the maze: ");
    int row = 7;//in.nextInt();

    System.out.println("Please enter the number of columns in the maze: ");
    int col = 7;//in.nextInt();

//    System.out.println(
//        "Please enter the type of maze, choose from: Perfect maze, Room maze or Non-perfect maze, Wrapping room maze:");
//    String maze = in.nextLine();
//
//    maze = maze.toLowerCase();
//    int remainingWalls = 0;
//    if (maze.equals("room maze") || maze.equals("non-perfect maze")) {
//      System.out.println("Please specify the number of walls to remain:");
//      remainingWalls = in.nextInt();
//    }

    System.out.println("Please enter the starting row position of the player: ");
    int startRow = 0;//in.nextInt();

    System.out.println("Please enter the starting column position of the player: ");
    int startCol = 0;//in.nextInt();

    System.out.println("Please enter the row position of the goal: ");
    int goalRow = 6;//in.nextInt();

    System.out.println("Please enter the column position of the goal: ");
    int goalCol = 5;//in.nextInt();
    
    Maze perfectMaze = new PerfectMaze(row, col, startRow, startCol, goalRow, goalCol);
    Player player = new Player("John", 0);
        
    
    while (perfectMaze.atGoal() == false) { 
      ArrayList<String> moves = perfectMaze.getMoves();
      System.out.println("Player has these possible moves: " + moves);
      
      String move = player.pickMove(moves);
      System.out.println("Player chose: " + move);
      
      perfectMaze.makeMove(move);
      int goldValue = perfectMaze.Event();
      
      player.addGold(goldValue);
      System.out.println(player.toString());
    }
    
    
    
//    if (maze.equals("room maze")) {
//      Maze perfectMaze = new PerfectMaze(row, col, startRow, startCol, goalRow, goalCol);
//      
//      while (perfectMaze.mazeSolved() == false) { 
//        perfectMaze.possibleMoves();
//        perfectMaze.playerMove();
//        perfectMaze.Action();
//      }
//    }
//    

//    if (maze.equals("room maze")) {
//      Maze roomMaze = new RoomMaze(row, col, remainingWalls, startRow, startCol, goalRow, goalCol);
//    }

    
    
    

  }

}
