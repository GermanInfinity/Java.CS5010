import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
  private final Readable in;
  private final Appendable out;
  private HTW model;

  public Controller(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
    this.model = null;
  }

  /**
   * Method starts the controllers control of the maze and player in in it.
   * 
   * @param modelto receive and give data
   * @throws IOException if something goes wrong.
   */
  public void start(HTW model) throws IOException {
    Scanner scan = new Scanner(this.in);
    this.model = model;
    setDifficulty();

    this.out.append("Welcome " + this.model.playerType()
        + " to the caves of destiny. Hunt the Wumpus, or be haunted!\n");
    this.out.append("Where shall I place you?: " + this.model.htwLocations());
    int location = scan.nextInt();
    if (!this.model.htwLocations().contains(Integer.toString(location))) {
      throw new IllegalArgumentException("I cannot start you there.");
    }

    this.model.placePlayer(location);
    this.out.append(
        "I have placed you in cave " + this.model.playerLocation() + ", happy hunting ^_^ \n");
    this.out.append(model.action());
    this.out.append("\n");

    while (this.model.running()) {
      this.out.append("(1) Move - (2) Shoot? ");
      int resp = scan.nextInt();
      if (resp != 1 && resp != 2) {
        throw new IllegalArgumentException("Please pick a valid option next time.");
      }
      this.out.append("You are in cave " + this.model.playerLocation() + "\n");
      if (resp == 1) {
        move();
      }

      if (resp == 2) {
        shoot();
      }
    }

  }

  /**
   * setDifficulty function sets the configuration of the maze.
   * 
   * @throws IOException
   */
  public void setDifficulty() throws IOException {
    Scanner scan = new Scanner(this.in);
    this.out.append("Welcome to Hunt the Wumpus. To start, set:\n");
    this.out.append("Number of dungeon rows: ");
    int rows = scan.nextInt();
    this.out.append("Number of dungeon columns: ");
    int col = scan.nextInt();
    this.out.append("Number of remaining walls in dungeon: ");
    int walls = scan.nextInt();
    this.out
        .append("Select between Room maze (1) or Wrapping room maze (2), please use the numbers: ");
    int mazeType = scan.nextInt();
    this.out.append("Number of pits in the dungeon: ");
    int pits = scan.nextInt();
    this.out.append("Number of super bats in the dungeon: ");
    int bats = scan.nextInt();
    this.out.append("Number of arrows player has: ");
    int arrows = scan.nextInt();

    this.model.setUp(rows, col, walls, mazeType, pits, bats, arrows);
  }

  /**
   * move function controls the player in the maze to move a certain direction.
   * 
   * @throws IOException
   */
  public void move() throws IOException {
    Scanner scan = new Scanner(this.in);

    ArrayList<String> moves = this.model.playerMoves();
    this.out.append("Tunnels lead to " + moves + "\n");

    this.out.append("Where to? \n");
    this.out.append("Please choose values in parenthesis for direction, (1) North, (2) South,"
        + " (3) East, (4) West: ");

    int posMove = scan.nextInt();
    this.out.append(this.model.movePlayer(posMove, moves));
    this.out.append("\n");

  }

  /**
   * shoot function controls the player in the maze to shoot an arrow.
   * 
   * @throws IOException
   */
  public void shoot() throws IOException {
    Scanner scan = new Scanner(this.in);
    this.out.append("How many caves deep? \n");
    int distance = scan.nextInt();

    this.out.append("In what direction, (1) North, (2) South," + " (3) East, (4) West: ");
    int direction = scan.nextInt();

    this.out.append(this.model.shootArrow(distance, direction));
    this.out.append("\n");
  }

}
