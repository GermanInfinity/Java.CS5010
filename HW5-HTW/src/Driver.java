import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class acts as the entry point into the program.
 *
 */
public class Driver {

  /**
   * main method to run program.
   */
  public static void main(String[] args) throws IOException {

    Readable reader = new InputStreamReader(System.in);

    Model model = new HTW();
    ControllerX control = new ControllerX(reader, System.out, model);

    IView iView = new IntroView("Welcome to Hunt the Wumpus.", control);
    IView hView = new HowToPlayView("How to play: Hunt the Wumpus.", control);
    IView cView = new ConfigView("Hunt The Wumpus-Setup", control);
    IView gView = new GameView("Hunt The Wumpus-Game", control);
    IView mView = new MenuView("Hunt The Wumpus-Menu", control);
    IView fmView = new FullMenuView("Hunt The Wumpus-Full Menu", control);

    control.setIntroView(iView);
    control.setHTPView(hView);
    control.setConfigView(cView);
    control.setGameView(gView);
    control.setMenuView(mView);
    control.setFullMenuView(fmView);
  }

}
