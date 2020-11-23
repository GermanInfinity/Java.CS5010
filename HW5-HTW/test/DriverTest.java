import java.util.ArrayList;
import java.util.Scanner;

public class DriverTest {

  public DriverTest() {
    // TODO Auto-generated constructor stub
  }
  
  public static void main(String [] args) { 
    Scanner in = new Scanner(System.in);
    Dungeon home = new Dungeon(4, 4, 0, 0, "room", 8, 5, 3);
    Player player = new Player("John",12);
    
    while (home.wumpusAlive()) {
      
      // GET PLAYER MOVES
      System.out.println(player.getType() + " is in " + home.playerLocation());
      ArrayList<String> moves = home.getMoves();
      System.out.println("Player has these possible moves: " + moves);

      
      System.out.println("Shoot or Move (S-M)?");
      String choice = in.nextLine();
      if (choice.equals("M") || choice.equals("m")) {

        
        int posMove = in.nextInt();
        
        String move = player.pickMove(posMove);
        System.out.println("Player chose: " + move);
        home.makeMove(move, moves);
        
      }
      if (choice.equals("S")) {
        
      }

      
      
      
    }
  }
    
   
}
