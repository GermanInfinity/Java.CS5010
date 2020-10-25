import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the conceptual tests done on the constucted mazes and
 * it's operations.
 * 
 * @author Ugo Nwachuku
 *
 */
public class ConceptTests {

  /**
   * Constructor not required for testing.
   */
  public ConceptTests() {
    // TODO Auto-generated constructor stub
  }

  /**
   * testPerfectMaze: In this test, we perform a test to validate that the
   * perfect maze is constructed accurately. To validate a perfect maze, we go
   * to every position in the maze and verify that it is not possible to have
   * four possible locations to reach.
   */
  public static void testPerfectMaze(int row, int col, int startRow, int startCol, int goalRow,
      int goalCol) {
    Scanner in = new Scanner(System.in);
    Maze perfectMaze = new PerfectMaze(row, col, startRow, startCol, goalRow, goalCol);
    Player player = new Player("John", 0);

    while (!perfectMaze.atGoal()) {

      ArrayList<String> moves = perfectMaze.getMoves();
      System.out.println("Player has these possible moves: " + moves);

      System.out.println(
          "Please choose values in parenthesis for direction, (1) North, "
          + "(2) South, (3) East, (4) West: ");
      int choice = in.nextInt();
      String move = player.pickMove(choice);
      System.out.println("Player chose: " + move);

      perfectMaze.makeMove(move, moves);

      System.out.println(perfectMaze.gotGold());
      System.out.println(perfectMaze.wasAttacked());
      double playerGold = player.getGold();
      double goldValue = perfectMaze.event(playerGold);
      player.setGold(goldValue);

      System.out.println("Player: " + player.toString());
      String position = perfectMaze.findPlayer();
      System.out.println("Player row position: " + position.substring(0, 1)
          + " Player column position: " + position.substring(1, 2));
      System.out.println("\n");
    }
    if (perfectMaze.atGoal()) {
      System.out.println("Player reached goal.");
    }
  }

  /**
   * testWrappingRoomMaze: In this test, we perform a test to validate that the
   * wrapping room maze is constructed accurately. To validate a wrapping room
   * maze, we go to the corners of the maze and validate that we are able to go
   * outside of the maze to wrap to the other side of the maze
   * 
   */
  public static void testWrappingRoomMaze() {

    Scanner in = new Scanner(System.in);
    Maze wrappingroomMaze = new WrappingRoomMaze(5, 5, 2, 0, 0, 4, 4);

    Player player = new Player("Michelle", 0);

    while (!wrappingroomMaze.atGoal()) {

      ArrayList<String> moves = wrappingroomMaze.getMoves();
      System.out.println("Player has these possible moves: " + moves);

      System.out.println(
          "Please choose values in parenthesis for direction, (1) North,"
          + " (2) South, (3) East, (4) West: ");
      int choice = in.nextInt();
      String move = player.pickMove(choice);
      System.out.println("Player chose: " + move);

      wrappingroomMaze.makeMove(move, moves);

      System.out.println(wrappingroomMaze.gotGold());
      System.out.println(wrappingroomMaze.wasAttacked());
      double playerGold = player.getGold();
      double goldValue = wrappingroomMaze.event(playerGold);

      player.setGold(goldValue);
      System.out.println(player.toString());
      String position = wrappingroomMaze.findPlayer();
      System.out.println("Player row position: " + position.substring(0, 1)
          + " Player column position: " + position.substring(1, 2));
      System.out.println("\n");
    }
    if (wrappingroomMaze.atGoal()) {
      System.out.println("Player reached goal.");
    }
  }

  /**
   * testRoomMaze: In this test, we perform a test to validate that the room
   * maze is constructed accurately. To validate a room maze, we find a location
   * in the maze whereby the maze gives us four possible choices to pick as new
   * positions to move to.
   * 
   */
  public static void testRoomMaze() {

    Scanner in = new Scanner(System.in);
    Maze roomMaze = new RoomMaze(4, 4, 4, 1, 1, 3, 3);

    Player player = new Player("John", 0);

    while (!roomMaze.atGoal()) {

      ArrayList<String> moves = roomMaze.getMoves();
      System.out.println("Player has these possible moves: " + moves);

      System.out.println(
          "Please choose values in parenthesis for direction, (1) North, "
          + "(2) South, (3) East, (4) West: ");
      int choice = in.nextInt();
      String move = player.pickMove(choice);
      System.out.println("Player chose: " + move);

      roomMaze.makeMove(move, moves);

      System.out.println(roomMaze.gotGold());
      System.out.println(roomMaze.wasAttacked());
      double playerGold = player.getGold();
      double goldValue = roomMaze.event(playerGold);

      player.setGold(goldValue);
      System.out.println(player.toString());
      String position = roomMaze.findPlayer();
      System.out.println("Player row position: " + position.substring(0, 1)
          + " Player column position: " + position.substring(1, 2));
      System.out.println("\n");
    }
    if (roomMaze.atGoal()) {
      System.out.println("Player reached goal.");
    }
  }

  /**
   * testPlayerRobbed: In this test, we make a big enough maze for thieves to
   * exist. The player moves about, and we validate that the player gets robbed.
   * 
   */
  public static void testPlayerRobbed() {
    testPerfectMaze(8, 8, 0, 0, 7, 7);
  }

  /**
   * testPlayerGotGold: In this test, we make a big enough maze for the player
   * to pick gold. The player moves about, and we validate that the player picks
   * up gold.
   * 
   */
  public static void testPlayerGotGold() {
    testPerfectMaze(8, 8, 0, 0, 7, 7);
  }

  /**
   * main method that runs tests.
   */
  public static void main(String[] args) {
    // testPerfectMaze(4, 4, 0, 0, 3, 3);
    testWrappingRoomMaze();
    // testRoomMaze();
    // testPlayerRobbed();
    // testPlayerGotGold();

  }

}
