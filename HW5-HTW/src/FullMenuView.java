import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JTextField;

/**
 * The IntroView class represents the view of the first page users see when they
 * launch the Hunt The Wumpus game.
 * 
 * @author Ugo Nwachuku
 *
 */
public class FullMenuView extends JFrame implements IView {
  private static final long serialVersionUID = -7083924619099998893L;

  private Icon image;
  private JButton goBack, setupGame;
  private JPanel panel;
  private GridBagConstraints gbc;
  private String difficulty;

  /**
   * Constructor for view object.
   * 
   * @param caption of frame
   * @throws IOException
   */
  public FullMenuView(String caption, ControllerX controller) throws IOException {
    super(caption);
    this.panel = new JPanel();
    
    this.setLocation(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    GridBagLayout layout = new GridBagLayout();
    this.panel.setLayout(layout);
    this.gbc = new GridBagConstraints(); 
    
    this.goBack = new JButton("Go Back");
    this.setupGame = new JButton("Setup New Game!");


    pack();

  }

  @Override
  public void setFeatures(Features f) {
    this.goBack.addActionListener(l -> f.closeFullMenu()); 
    //this.setupGame.addActionListener(l -> f.startGame(this.difficulty, true));
  }
  
  @Override
  public void setListener(ActionListener clicks, KeyListener keys) {

  }

  @Override
  public void display() {
    image = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/bowArrow.png");

    gbc.gridx = 0;
    gbc.gridy = 0;
    JLabel arrow = new JLabel(image);
    this.panel.add(arrow, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 2;
    JLabel word = new JLabel("Fully Customize the Hunt the Wumpus experience. Right here, right now.");
    word.setFont(new Font("Serif", Font.HANGING_BASELINE, 14));
    this.panel.add(word, gbc);
    // add in game settings
    // number of playerd
    // screen resize 
    
    gbc.gridx = 0;
    gbc.gridy = 4;
    JLabel rowWord = new JLabel("Number of Rows in Dungeon, (max 8): ");
    this.panel.add(rowWord, gbc);
    gbc.gridx = 5;
    gbc.gridy = 4;
    JTextField inputRow = new JTextField(10);
    this.panel.add(inputRow, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 5;
    JLabel colWord = new JLabel("Number of Columns in Dungeon, (max 8): ");
    this.panel.add(colWord, gbc);
    gbc.gridx = 5;
    gbc.gridy = 5;
    JTextField inputCol = new JTextField(10);
    this.panel.add(inputCol, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 6;
    JLabel remWalls = new JLabel("Number of remaining walls in Dungeon: ");
    this.panel.add(remWalls, gbc);
    gbc.gridx = 5;
    gbc.gridy = 6;
    JTextField inputWalls = new JTextField(10);
    this.panel.add(inputWalls, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 7;
    JLabel mazeType = new JLabel("Type of Maze, (1: Room Maze, 2: Wrapping Maze): ");
    this.panel.add(mazeType, gbc);
    gbc.gridx = 5;
    gbc.gridy = 7;
    JTextField inputMaze = new JTextField(10);
    this.panel.add(inputMaze, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 8;
    JLabel pitNo = new JLabel("Number of pits: ");
    this.panel.add(pitNo, gbc);
    gbc.gridx = 5;
    gbc.gridy = 8;
    JTextField inputPits = new JTextField(10);
    this.panel.add(inputPits, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 9;
    JLabel batNo = new JLabel("Number of superbats: ");
    this.panel.add(batNo, gbc);
    gbc.gridx = 5;
    gbc.gridy = 9;
    JTextField inputBats = new JTextField(10);
    this.panel.add(inputBats, gbc);
    
    gbc.gridx = 2;
    gbc.gridy = 12;
    this.panel.add(this.goBack, gbc);
    
    gbc.gridx = 6;
    gbc.gridy = 12;
    this.panel.add(this.setupGame, gbc);
    
    this.panel.setBackground(Color.darkGray);
    this.panel.setOpaque(true);
    this.panel.setVisible(true);
    this.setSize(800, 400);
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