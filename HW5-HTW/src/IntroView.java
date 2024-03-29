import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The IntroView class represents the view of the first page users see when they
 * launch the Hunt The Wumpus game.
 * 
 * @author Ugo Nwachuku
 *
 */
public class IntroView extends JFrame implements IView {
  private static final long serialVersionUID = -7083924619099998893L;

  private JButton howToPlay;
  private JButton play;
  private JPanel panel;

  /**
   * Constructor for view object.
   * 
   * @param caption of frame
   */
  public IntroView(String caption, ControllerX controller) {
    super(caption);
    
    if (caption == null) {
      caption = "Intro View";
    }
    if (controller == null) {
      throw new IllegalArgumentException("Please provide this view a controller.");
    }
    
    this.panel = new JPanel();

    this.setLocation(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.panel.setLayout(new BorderLayout(1, 30));

    this.howToPlay = new JButton("How to Play!");
    this.play = new JButton("Play!");

    display();
    pack();

  }

  @Override
  public void setFeatures(Features f) {
    this.howToPlay.addActionListener(l -> f.openHowToPlay());
    this.play.addActionListener(l -> f.openConfig());
  }


  @Override
  public void display() {
    JLabel image = new JLabel(
        new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/HTWgif2.gif"));

    this.panel.add(image, BorderLayout.NORTH);
    this.panel.add(howToPlay, BorderLayout.WEST);
    this.panel.add(play, BorderLayout.EAST);

    this.panel.setBackground(Color.ORANGE);
    this.panel.setOpaque(true);
    this.panel.setVisible(true);
    this.add(panel);
    this.setVisible(true);
  }

  /**
   * This function returns the game configuration.
   */
  public ArrayList<Integer> getGameConfig() {
    return null;
  }

  @Override
  public void close() {
    this.dispose();
  }

}