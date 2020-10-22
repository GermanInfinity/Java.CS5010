
public class Views {

  public Views() {
    
  }
  
  public void initialInfo(){
    System.out.println("Please enter the size of maze, type of maze, starting point of player and goal location.");
  }
  
  public void getRow() { 
    System.out.println("Please enter the number of rows in the maze: ");
  }
  
  public void getCol() { 
    System.out.println("Please enter the number of columns in the maze: ");
  }
  
  public void getTypeOfMaze() { 
    System.out.println("Please enter the type of maze, choose from: Perfect maze, Room maze, Wrapping room maze");
  }
  
  public void playerRowPos() { 
    System.out.println("Please enter the starting row position of the player: ");
  }
  
  public void playerColPos() { 
    System.out.println("Please enter the starting column position of the player: ");
  }
  
  public void getGoalRow() { 
    System.out.println("Please enter the row position of the goal: ");
  }
  
  public void getGoalCol() { 
    System.out.println("Please enter the column position of the goal: ");
  }
  

}
