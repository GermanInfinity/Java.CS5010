import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is responsible for testing the performance of different objects in
 * the maze.
 * 
 * @author ugoslight
 *
 */
public class TestObjectsIn {

  public TestObjectsIn() {
    // TODO Auto-generated constructor stub
  }

  /**
   * Tests what happens when player encounters wumpus.
   */
  public static void wumpusWinTest() {
    Scanner in = new Scanner(System.in);
    Dungeon home = new Dungeon(4, 4, 12, "room", 8, 5, 3);
    Player player = new Player("John", 12);
    System.out.println("Please select a location to start from the list: " + home.locations());
    int location = in.nextInt();
    if (!home.locations().contains(Integer.toString(location))) {
      throw new IllegalArgumentException("Sorry cannot start there.");
    }
    home.startAt(location);
    System.out.println(home.action());

    while (home.gameOn()) {

      // GET PLAYER MOVES
      System.out.println("You are in cave " + home.playerLocation());

      ArrayList<String> moves = home.getMoves();
      System.out.println("Tunnels lead to " + moves);

      System.out.println("Where to?");
      System.out.println("Please choose values in parenthesis for direction, (1) North, (2) South,"
          + " (3) East, (4) West: ");

      int posMove = in.nextInt();
      String move = player.pickMove(posMove);
      home.makeMove(move, moves);
      System.out.println(home.action());

    }
  }

  /**
   * Tests what happens when player encounters pit.
   */
  public static void fallTest() {
    Scanner in = new Scanner(System.in);
    Dungeon home = new Dungeon(4, 4, 12, "room", 8, 5, 3);
    Player player = new Player("John", 12);
    System.out.println("Please select a location to start from the list: " + home.locations());
    int location = in.nextInt();
    if (!home.locations().contains(Integer.toString(location))) {
      throw new IllegalArgumentException("Sorry cannot start there.");
    }
    home.startAt(location);
    System.out.println(home.action());

    while (home.gameOn()) {

      // GET PLAYER MOVES
      System.out.println("You are in cave " + home.playerLocation());

      ArrayList<String> moves = home.getMoves();
      System.out.println("Tunnels lead to " + moves);

      System.out.println("Where to?");
      System.out.println("Please choose values in parenthesis for direction, (1) North, (2) South,"
          + " (3) East, (4) West: ");

      int posMove = in.nextInt();
      String move = player.pickMove(posMove);
      home.makeMove(move, moves);
      System.out.println(home.action());

    }
  }

  /**
   * Tests what happens when player encounters superbats.
   */
  public static void superbatTest() {
    Scanner in = new Scanner(System.in);
    Dungeon home = new Dungeon(4, 4, 12, "room", 8, 5, 3);
    Player player = new Player("John", 12);
    System.out.println("Please select a location to start from the list: " + home.locations());
    int location = in.nextInt();
    if (!home.locations().contains(Integer.toString(location))) {
      throw new IllegalArgumentException("Sorry cannot start there.");
    }
    home.startAt(location);
    System.out.println(home.action());

    while (home.gameOn()) {

      // GET PLAYER MOVES
      System.out.println("You are in cave " + home.playerLocation());

      ArrayList<String> moves = home.getMoves();
      System.out.println("Tunnels lead to " + moves);

      System.out.println("Where to?");
      System.out.println("Please choose values in parenthesis for direction, (1) North, (2) South,"
          + " (3) East, (4) West: ");

      int posMove = in.nextInt();
      String move = player.pickMove(posMove);
      home.makeMove(move, moves);
      System.out.println(home.action());

    }
  }

  /**
   * Tests what happens when player encounters superbat and pit in the same
   * location.
   */
  public static void batAndPitTest() {
    Scanner in = new Scanner(System.in);
    Dungeon home = new Dungeon(4, 4, 12, "room", 8, 5, 3);
    Player player = new Player("John", 12);
    System.out.println("Please select a location to start from the list: " + home.locations());
    int location = in.nextInt();
    if (!home.locations().contains(Integer.toString(location))) {
      throw new IllegalArgumentException("Sorry cannot start there.");
    }
    home.startAt(location);
    System.out.println(home.action());

    while (home.gameOn()) {

      // GET PLAYER MOVES
      System.out.println("You are in cave " + home.playerLocation());

      ArrayList<String> moves = home.getMoves();
      System.out.println("Tunnels lead to " + moves);

      System.out.println("Where to?");
      System.out.println("Please choose values in parenthesis for direction, (1) North, (2) South,"
          + " (3) East, (4) West: ");

      int posMove = in.nextInt();
      String move = player.pickMove(posMove);
      home.makeMove(move, moves);
      System.out.println(home.action());

    }
  }

  /**
   * Tests what happens when player shoots an arrow.
   */
  public static void shootArrowTest() {

    Scanner in = new Scanner(System.in);
    Dungeon home = new Dungeon(4, 4, 25, "room", 8, 0, 0);
    Player player = new Player("John", 12);
    System.out.println("Please select a location to start from the list: " + home.locations());
    int location = in.nextInt();
    if (!home.locations().contains(Integer.toString(location))) {
      throw new IllegalArgumentException("Sorry cannot start there.");
    }
    home.startAt(location);
    System.out.println(home.action());

    while (home.gameOn()) {

      // GET PLAYER MOVES
      System.out.println("You are in cave " + home.playerLocation());

      ArrayList<String> moves = home.getMoves();
      System.out.println("Tunnels lead to " + moves);

      System.out.println("How many caves deep?");
      int distance = in.nextInt();
      if (distance < 0) {
        throw new IllegalArgumentException("Arrows can't be shot at a negative distance.");
      }

      System.out.println("In what direction, (1) North, (2) South," + " (3) East, (4) West: ");
      int direction = in.nextInt();
      if (distance != 1 && distance != 2 && distance != 3 && distance != 4) {
        throw new IllegalArgumentException("Please pick a valid direction next time.");
      }
      System.out.println(home.arrowAction(distance, direction));

    }

  }

  /**
   * Tests what happens when player shoots an arrow at the wumpus.
   */
  public static void killWumpusTest() {
    Scanner in = new Scanner(System.in);
    Dungeon home = new Dungeon(4, 4, 12, "room", 8, 0, 0);
    Player player = new Player("Player", 12);
    System.out.println("Welcome " + player.getType()
        + " to the caves of destiny. Hunt the Wumpus, or be haunted!");

    System.out.println("Where shall I place you?: " + home.locations());
    int location = in.nextInt();
    if (!home.locations().contains(Integer.toString(location))) {
      throw new IllegalArgumentException("I cannot start you there.");
    }
    home.startAt(location);
    System.out
        .println("I have placed you in cave " + home.playerLocation() + ", happy hunting ^_^");
    System.out.println(home.action());

    while (home.gameOn()) {

      System.out.println("(1) Move - (2) Shoot? ");

      int resp = in.nextInt();
      if (resp != 1 && resp != 2) {
        throw new IllegalArgumentException("Please pick a valid option next time.");
      }

      if (resp == 1) {
        // GET PLAYER MOVES
        System.out.println("You are in cave " + home.playerLocation());

        ArrayList<String> moves = home.getMoves();
        System.out.println("Tunnels lead to " + moves);

        System.out.println("Where to?");
        System.out
            .println("Please choose values in parenthesis for direction, (1) North, (2) South,"
                + " (3) East, (4) West: ");

        int posMove = in.nextInt();
        String move = player.pickMove(posMove);
        home.makeMove(move, moves);
        System.out.println(home.action());

      }

      if (resp == 2) {

        System.out.println("How many caves deep?");
        int distance = in.nextInt();
        if (distance < 0) {
          throw new IllegalArgumentException("Arrows can't be shot at a negative distance.");
        }

        System.out.println("In what direction, (1) North, (2) South," + " (3) East, (4) West: ");
        int direction = in.nextInt();
        if (distance != 1 && distance != 2 && distance != 3 && distance != 4) {
          throw new IllegalArgumentException("Please pick a valid direction next time.");
        }
        System.out.println(home.arrowAction(distance, direction));

      }

    }
  }
  
  
  /**
   * Tests moving in a wrapping room maze, encountering objects and moving through
   * tunnels. 
   */
  public static void wrappingRoomTest() {
    Scanner in = new Scanner(System.in);
    Dungeon home = new Dungeon(4, 4, 12, "wrapping room", 6, 0, 1);
    Player player = new Player("John", 12);
    System.out.println("Please select a location to start from the list: " + home.locations());
    int location = in.nextInt();
    if (!home.locations().contains(Integer.toString(location))) {
      throw new IllegalArgumentException("Sorry cannot start there.");
    }
    home.startAt(location);
    System.out.println(home.action());

    while (home.gameOn()) {

      // GET PLAYER MOVES
      System.out.println("You are in cave " + home.playerLocation());

      ArrayList<String> moves = home.getMoves();
      System.out.println("Tunnels lead to " + moves);

      System.out.println("Where to?");
      System.out.println("Please choose values in parenthesis for direction, (1) North, (2) South,"
          + " (3) East, (4) West: ");

      int posMove = in.nextInt();
      String move = player.pickMove(posMove);
      home.makeMove(move, moves);
      System.out.println(home.action());

    }
  }

  public static void main(String[] args) {
    //wumpusWinTest();
    // fallTest();
    // superbatTest();
    // batAndPitTest();
    shootArrowTest();
    
    //wrappingRoomTest();
    //killWumpusTest();
    
    
  }

}
