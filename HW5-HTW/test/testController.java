import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Test;

/**
 * This class is responsible for testing the controller.
 *
 */
public class TestController {

  /**
   * Tests general flow of the game with the controller.
   */
  // public static void controllerTest() throws IOException {
  //
  // Readable reader = new InputStreamReader(System.in);
  // Controller control = new Controller(reader, System.out);
  // Scanner scan = new Scanner(System.in);
  // System.out.println("Welcome to Hunt the Wumpus. To start, set:\n");
  // System.out.println("Number of dungeon rows: ");
  // int rows = scan.nextInt();
  // System.out.println("Number of dungeon columns: ");
  // int col = scan.nextInt();
  // System.out.println("Number of remaining walls in dungeon: ");
  // int walls = scan.nextInt();
  // System.out.println("Select between Room maze (1) or Wrapping room maze (2),
  // please use the numbers: ");
  // int mazeType = scan.nextInt();
  // System.out.println("Number of pits in the dungeon: ");
  // int pits = scan.nextInt();
  // System.out.println("Number of super bats in the dungeon: ");
  // int bats = scan.nextInt();
  // System.out.println("Number of arrows player has: ");
  // int arrows = scan.nextInt();
  // HTW model = new HTW(rows, col, walls, mazeType, pits, bats, arrows);
  //
  // control.start(model);
  //
  // }
  //
  @Test
  public void testMockAction() throws IOException {
    StringBuilder log = new StringBuilder();

    Model modelTest = new MockModel(log, "Solid Principles.");
    Readable reader = new InputStreamReader(System.in);
    Controller control = new Controller(reader, System.out, modelTest);
    control.action();

    assertEquals("Action taken", log.toString());

  }

  @Test
  public void testMockPlayerType() throws IOException {
    StringBuilder log = new StringBuilder();

    Model modelTest = new MockModel(log, "Solid Principles.");
    Readable reader = new InputStreamReader(System.in);
    Controller control = new Controller(reader, System.out, modelTest);
    control.playerType();

    assertEquals("Player is a character.", log.toString());

  }

  @Test
  public void testMockPlayerLocation() throws IOException {
    StringBuilder log = new StringBuilder();

    Model modelTest = new MockModel(log, "Solid Principles.");
    Readable reader = new InputStreamReader(System.in);
    Controller control = new Controller(reader, System.out, modelTest);
    control.playerLocation();

    assertEquals("Player is in maze.", log.toString());

  }

  @Test
  public void testMockPlayerMoves() throws IOException {
    StringBuilder log = new StringBuilder();

    Model modelTest = new MockModel(log, "Solid Principles.");
    Readable reader = new InputStreamReader(System.in);
    Controller control = new Controller(reader, System.out, modelTest);
    control.playerMoves();

    assertEquals("Player is a character.", log.toString());

  }

  @Test
  public void testMockHtwLocations() throws IOException {
    StringBuilder log = new StringBuilder();

    Model modelTest = new MockModel(log, "Solid Principles.");
    Readable reader = new InputStreamReader(System.in);
    Controller control = new Controller(reader, System.out, modelTest);

    control.htwLocations();

    assertEquals("Player is a winner.", log.toString());
    // assertEquals("Solid Principles.", out.toString());

  }

  @Test
  public void testMockPlacePlayer() throws IOException {
    StringBuilder log = new StringBuilder();

    Model modelTest = new MockModel(log, "Solid Principles.");
    Readable reader = new InputStreamReader(System.in);
    Controller control = new Controller(reader, System.out, modelTest);
    control.setLocation(3);

    assertEquals("Player is placed at: " + 3, log.toString());

  }

  @Test
  public void testMockGameRunning() throws IOException {
    StringBuilder log = new StringBuilder();

    Model modelTest = new MockModel(log, "Solid Principles.");
    Readable reader = new InputStreamReader(System.in);
    Controller control = new Controller(reader, System.out, modelTest);
    control.running();

    assertEquals("Game is running.", log.toString());

  }

  @Test
  public void testMockMovePlayer() throws IOException {
    StringBuilder log = new StringBuilder();

    Model modelTest = new MockModel(log, "Solid Principles.");
    Readable reader = new InputStreamReader(System.in);
    Controller control = new Controller(reader, System.out, modelTest);

    ArrayList<String> moves = new ArrayList<String>();
    moves.add("North");

    assertEquals("Player Move: " + control.playerMoves(), log.toString());

  }

  @Test
  public void testMockShotArrow() throws IOException {
    StringBuilder log = new StringBuilder();

    Model modelTest = new MockModel(log, "Solid Principles.");
    Readable reader = new InputStreamReader(System.in);
    Controller control = new Controller(reader, System.out, modelTest);
    control.shootArrow(3, 5);

    assertEquals("Arrow shot this far: " + 3 + " In this direction: " + 5 + "\n", log.toString());

  }

}
