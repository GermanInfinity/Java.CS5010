import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

  private Communication program;
  public Controller(int row, int col, int startRow, int startCol, int goalRow, int goalCol) {
    
    //this.program = new Communication(row, col, startRow, startCol, goalRow, goalCol);
    startProgram();
  }
  
  public void startProgram() {
    Scanner input = new Scanner(System.in);
    
    while (true) { 
      ArrayList<String> moves = this.program.getMoves();
      //send moves to Views
      String userInput = input.nextLine();
      this.program.playMove(userInput);
      
    }
  }

}
