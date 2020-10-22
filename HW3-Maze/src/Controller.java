import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

  private Communication program;

  public Controller(int row, int col, String mazeType, int remainingWalls, int startRow, int startCol, int goalRow, int goalCol) {

    this.program = new Communication(row, col, mazeType,  remainingWalls, startRow, startCol, goalRow, goalCol); 
  
  }

  

  public void startProgram() {
    Scanner input = new Scanner(System.in);
    
    while (true) { 
      ArrayList<String> moves = this.program.getMoves();
      //send moves to Views
      //this.view.receive(moves);
      String userInput = input.nextLine();
      this.program.playMove(userInput);
      
    }
  }

}
