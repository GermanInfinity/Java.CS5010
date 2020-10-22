import java.util.Scanner;

public class Driver {

  public static void main(String args[]) {
    Communication program;
    
    System.out.println(
        "Please enter the size of maze, type of maze, starting point of player and goal location.");

    Scanner in = new Scanner(System.in);
    System.out.println("Please enter the number of rows in the maze: ");
    int row = in.nextInt();

    System.out.println("Please enter the number of columns in the maze: ");
    int col = in.nextInt();

    System.out.println(
        "Please enter the type of maze, choose from: Perfect maze, Room maze or Non-perfect maze, Wrapping room maze:");
    String maze = in.nextLine();

    maze = maze.toLowerCase();
    int remainingWalls = 0;
    if (maze.equals("room maze") || maze.equals("non-perfect maze")) {
      System.out.println("Please specify the number of walls to remain:");
      remainingWalls = in.nextInt();
    }

    System.out.println("Please enter the starting row position of the player: ");
    int startRow = in.nextInt();

    System.out.println("Please enter the starting column position of the player: ");
    int startCol = in.nextInt();

    System.out.println("Please enter the row position of the goal: ");
    int goalRow = in.nextInt();

    System.out.println("Please enter the column position of the goal: ");
    int goalCol = in.nextInt();

    System.out.println("Rows in Maze " + row);
    System.out.println("Columns in Maze " + col);
    System.out.println("Player starting row " + startRow);
    System.out.println("Player starting column " + startCol);
    System.out.println("Goal location row " + goalRow);
    System.out.println("Goal location column " + goalCol);


    program = new Communication(row, col, maze, remainingWalls, startRow, startCol, goalRow, goalCol); 
    

  }

}
