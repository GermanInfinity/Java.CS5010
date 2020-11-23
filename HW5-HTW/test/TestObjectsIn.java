import java.util.ArrayList;
import java.util.Scanner;

public class TestObjectsIn {

  public TestObjectsIn() {
    // TODO Auto-generated constructor stub
  }
  
  public static void pitTest() { 
    Scanner in = new Scanner(System.in);
    Dungeon home = new Dungeon(4, 4, "room", 8, 5, 3);
    Player player = new Player("John",12);
    
    while (home.wumpusAlive()) {
      
      // GET PLAYER MOVES
      System.out.println(player.getType() + " is in " + home.playerLocation());
      ArrayList<String> moves = home.getMoves();
      System.out.println("Player has these possible moves: " + moves);
      System.out.println(
          "Please choose values in parenthesis for direction, (1) North, (2) South,"
          + " (3) East, (4) West: ");
      
      int posMove = in.nextInt();
      
      String move = player.pickMove(posMove);
      System.out.println("Player chose: " + move);
      System.out.println("");
      home.makeMove(move, moves);
      

      
    }
  }
  
  public static void wumpusTest() { 
    Scanner in = new Scanner(System.in);
    Dungeon home = new Dungeon(4, 4, "room", 8, 5, 3);
    Player player = new Player("John",12);
    
    while (home.wumpusAlive()) {
      
      // GET PLAYER MOVES
      System.out.println(player.getType() + " is in " + home.playerLocation());
      ArrayList<String> moves = home.getMoves();
      System.out.println("Player has these possible moves: " + moves);
      System.out.println(
          "Please choose values in parenthesis for direction, (1) North, (2) South,"
          + " (3) East, (4) West: ");
      
      int posMove = in.nextInt();
      
      String move = player.pickMove(posMove);
      System.out.println("Player chose: " + move);
      System.out.println("");
      home.makeMove(move, moves);
      
      
    }
  }
  
  public static void superbatTest() { 
    Scanner in = new Scanner(System.in);
    Dungeon home = new Dungeon(4, 4, "room", 8, 5, 3);
    Player player = new Player("John",12);
    
    while (home.wumpusAlive()) {
      
      // GET PLAYER MOVES
      System.out.println(player.getType() + " is in " + home.playerLocation());
      ArrayList<String> moves = home.getMoves();
      System.out.println("Player has these possible moves: " + moves);
      System.out.println(
          "Please choose values in parenthesis for direction, (1) North, (2) South,"
          + " (3) East, (4) West: ");
      
      int posMove = in.nextInt();
      
      String move = player.pickMove(posMove);
      System.out.println("Player chose: " + move);
      System.out.println("");
      home.makeMove(move, moves);
      

      
    }
  }
  
  public static void killWumpusTest() { 
    Scanner in = new Scanner(System.in);
    Dungeon home = new Dungeon(4, 4, "room", 8, 5, 3);
    Player player = new Player("John",12);
    System.out.println("Please select a location to start from the list: " + home.locations());
    int location = in.nextInt();
    if (!home.locations().contains(Integer.toString(location))) { 
      throw new IllegalArgumentException("Sorry cannot start there.");
    }
    home.startAt(location);
    
    while (home.wumpusAlive()) {
      
      // GET PLAYER MOVES
      System.out.println("You are in cave " + home.playerLocation());
      
      ArrayList<String> moves = home.getMoves();
      System.out.println("Tunnels lead to " + moves);
      
      System.out.println("(1) Shoot - (2) Move)? ");
      int resp = in.nextInt();
      
      System.out.println("Where to?");
      System.out.println(
          "Please choose values in parenthesis for direction, (1) North, (2) South,"
          + " (3) East, (4) West: ");
      
      int posMove = in.nextInt();
      String move = player.pickMove(posMove);
      home.makeMove(move, moves);
      
      
//      if (resp.equals("M")) { 
//        
//        
//      }
//      
//      if (resp.equals("S")) {
//        
//      }
      

      
    }
  }
  
  public static void main(String []args) { 
    //superbatTest();
    killWumpusTest();
  }
    
   
}
