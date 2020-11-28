import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This class is responsible for testing the controller.
 *
 */
public class testController {

  /**
   * Tests general flow of the game with the controller.
   * 
   * @throws IOException
   */
  public static void testController() throws IOException {

    HTW model = new HTW();
    Readable reader = new InputStreamReader(System.in);
    Controller control = new Controller(reader, System.out);

    control.start(model);

  }

  public static void main(String[] args) throws IOException {
    testController();

  }

}
