import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class acts as the entry point into the program. 
 *
 */
public class Driver {

  public static void main(String[] args) throws IOException {
    HTW model = new HTW();
    Readable reader = new InputStreamReader(System.in);
    Controller control = new Controller(reader, System.out);

    control.start(model);
  }

}
