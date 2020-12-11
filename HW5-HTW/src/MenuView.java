import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;
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

  private Icon image;
  private JButton keepPlaying, restartSame, restartNew, fullConfig;
  private JPanel panel;
  private GridBagConstraints gbc;
  private String difficulty;

  /**
   * Constructor for view object.
   * 
   * @param caption of frame
   * @throws IOException
   */
  public MenuView(String caption, ControllerX controller) throws IOException {
    super(caption);
    this.panel = new JPanel();
    
    this.setLocation(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
    this.restartNew.addActionListener(l -> f.startGame(this.difficulty, true));
  }
  
  @Override
  public void setListener(ActionListener clicks, KeyListener keys) {

  }

  @Override
  public void display() {
    image = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/ggrem.png");

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

  public void getInput(String diff) { 
    this.difficulty = diff; 
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