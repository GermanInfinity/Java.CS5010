import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.Icon;
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
public class MenuView extends JFrame implements IView {
  private static final long serialVersionUID = -7083924619099998893L;

  private JButton keepPlaying, restartSame, restartNew, fullConfig;
  private JPanel panel;
  private GridBagConstraints gbc;
  private String difficulty;
  private ArrayList<Integer> gameInfo;

  /**
   * Constructor for menu view object.
   * 
   */
  public MenuView(String caption, ControllerX controller) {
    super(caption);
    
    if (caption == null) {
      caption = "Menu view";
    }
    if (controller == null) {
      throw new IllegalArgumentException("Please provide this view a controller.");
    }
    
    this.panel = new JPanel();
    this.gameInfo = new ArrayList<Integer>();
    
    this.setLocation(500, 500);


    GridBagLayout layout = new GridBagLayout();
    this.panel.setLayout(layout);
    this.gbc = new GridBagConstraints(); 
    
    this.keepPlaying = new JButton("Keep Playing!");
    this.fullConfig = new JButton("Game Settings");
    this.restartSame = new JButton("Restart");
    this.restartNew = new JButton("New game");

    pack();

  }

  @Override
  public void setFeatures(Features f) {
    this.keepPlaying.addActionListener(l -> f.closeMenu()); 
    this.fullConfig.addActionListener(l -> f.openFullMenu());
    this.restartNew.addActionListener(l -> f.startGame(this.gameInfo, true, false));
    this.restartSame.addActionListener(l -> f.startGame(this.gameInfo, true, true));
  }
  


  @Override
  public void display() {
    Icon image = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/ggrem.png");

    gbc.gridx = 0;
    gbc.gridy = 0;
    JLabel diff = new JLabel("Difficulty: " + this.difficulty);
    this.panel.add(diff, gbc);
    
    gbc.gridx = 2;
    gbc.gridy = 0;
    JLabel pic = new JLabel(image);
    this.panel.add(pic, gbc);
    
    gbc.gridx = 4;
    gbc.gridy = 0;
    JLabel word = new JLabel("I am still Alive...");
    this.panel.add(word, gbc);
    
    gbc.gridx = 4;
    gbc.gridy = 1;
    this.panel.add(this.keepPlaying, gbc);
    
    gbc.gridx = 2;
    gbc.gridy = 2;
    this.panel.add(this.fullConfig, gbc);
    
    gbc.gridx = 2;
    gbc.gridy = 3;
    this.panel.add(this.restartSame, gbc);
    
    gbc.gridx = 2;
    gbc.gridy = 4;
    this.panel.add(this.restartNew, gbc);
    
    
    
    this.panel.setOpaque(true);
    this.panel.setVisible(true);
    this.setSize(400, 400);
    this.add(panel);
    this.setVisible(true);
  }

  /**
   * getInput gets the input for the game configuration.
   */
  public void getInput(ArrayList<Integer> info) { 
    if (info.get(8) == 1) {
      this.difficulty = "Easy";
    }
    if (info.get(8) == 2) {
      this.difficulty = "Medium";
    }
    if (info.get(8) == 3) {
      this.difficulty = "Realistic";
    }
 
    this.gameInfo = info;

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