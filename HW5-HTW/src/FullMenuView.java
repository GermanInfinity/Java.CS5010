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
import javax.swing.JOptionPane;
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
  private ArrayList<Integer> info;
  private JTextField inputNumPlayer, inputRow, inputCol, inputWalls, inputMaze, inputPits, inputBats, inputArrows;
  private int pNum;
  
  /**
   * Constructor for view object.
   * 
   * @param caption of frame
   * @throws IOException
   */
  public FullMenuView(String caption, ControllerX controller) {
    super(caption);
    this.panel = new JPanel();
    
    this.setLocation(500, 500);
    this.info = new ArrayList<Integer>();
    
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
    this.setupGame.addActionListener(l -> f.startGame(mazeInfo(), true, false));
  }
  
  @Override
  public void setListener(ActionListener clicks, KeyListener keys) {

  }
  
  public void validatePlayer(int a) {
    if (a <= 0 || a > 2) { 
      throw new IllegalArgumentException("Please enter players between 1 and 2.");
    }
    info.add(a);
  }
  
  public void validateRows(int a) {
    if (a <= 0 || a > 9) {
      throw new IllegalArgumentException("Please enter rows between 3 and 10.");
    }
    info.add(a);
  }
  
  public void validateCol(int a) {
    if (a <= 0 || a > 9) {
      throw new IllegalArgumentException("Please enter columns between 3 and 10.");
    }
    info.add(a);
  }
  
  public void validateWalls(int a) {
    if (a < 0 || a > 8) {
      throw new IllegalArgumentException("Please enter walls between 0 and 8.");
    }
    info.add(a);
  }
  
  public void validateMaze(int a) {
    if (a <= 0 || a > 2) {
      throw new IllegalArgumentException("Please enter a valid maze.");
    }
    info.add(a);
  }
  
  public void validatePits(int a, int b, int c) {
    if (a <= 0 || a > 2) {
      throw new IllegalArgumentException("Please enter a valid number of pit.");
    }
    info.add(a);
  }
  public void validateBats(int a, int b,  int c) {
    if (a < 0 || a > b * c) {
      throw new IllegalArgumentException("Please enter a valid number of bats.");
    }
    info.add(a);
  }
  public void validateArrows(int a) {
    if (a <= 0) {
      throw new IllegalArgumentException("Please enter a valid arrow numbers.");
    }
    info.add(a);
  }
  
  public ArrayList<Integer> mazeInfo() { 
   
    try { 
      validatePlayer(Integer.parseInt(this.inputNumPlayer.getText()));
    }
    catch (NumberFormatException e1) { // empty number
      JOptionPane.showMessageDialog(this.panel, "Please enter a correct input for number of players.");
    }
    catch (IllegalArgumentException e1) { // empty number
      JOptionPane.showMessageDialog(this.panel, e1.getMessage());
    }

    
    try { 
      validateRows(Integer.parseInt(this.inputRow.getText()));
    }
    catch (NumberFormatException e1) { // empty number
      JOptionPane.showMessageDialog(this.panel, "Please enter a correct input for number of rows.");
    }
    catch (IllegalArgumentException e1) { // empty number
      JOptionPane.showMessageDialog(this.panel, e1.getMessage());
    }

    
    try { 
      validateCol(Integer.parseInt(this.inputCol.getText()));
    }
    catch (NumberFormatException e1) { // empty number
      JOptionPane.showMessageDialog(this.panel, "Please enter a correct input for number of columns.");
    }
    catch (IllegalArgumentException e1) { // empty number
      JOptionPane.showMessageDialog(this.panel, e1.getMessage());
    }

    
    try { 
      validateWalls(Integer.parseInt(this.inputWalls.getText()));
    }
    catch (NumberFormatException e1) { // empty number
      JOptionPane.showMessageDialog(this.panel, "Please enter a correct input for number of walls.");
    }
    catch (IllegalArgumentException e1) { // empty number
      JOptionPane.showMessageDialog(this.panel, e1.getMessage());
    }

    
    try { 
      validateMaze(Integer.parseInt(this.inputMaze.getText()));
    }
    catch (NumberFormatException e1) {
      JOptionPane.showMessageDialog(this.panel, "Please a valid maze type.");
    }
    catch (IllegalArgumentException e1) { // empty number
      JOptionPane.showMessageDialog(this.panel, e1.getMessage());
    }
    
    try { 
      validatePits(Integer.parseInt(this.inputPits.getText()), Integer.parseInt(this.inputRow.getText()), Integer.parseInt(this.inputCol.getText()));
    }
    catch (NumberFormatException e1) {
      JOptionPane.showMessageDialog(this.panel, "Please a valid number of input pits.");
    }
    catch (IllegalArgumentException e1) { // empty number
      JOptionPane.showMessageDialog(this.panel, e1.getMessage());
    }
    
    try { 
      validateBats(Integer.parseInt(this.inputBats.getText()), Integer.parseInt(this.inputRow.getText()), Integer.parseInt(this.inputCol.getText()));
    }
    catch (NumberFormatException e1) {
      JOptionPane.showMessageDialog(this.panel, "Please a valid number of input bats.");
    }
    catch (IllegalArgumentException e1) { // empty number
      JOptionPane.showMessageDialog(this.panel, e1.getMessage());
    }
    
    try { 
      validateArrows(Integer.parseInt(this.inputArrows.getText()));
    }
    catch (NumberFormatException e1) {
      JOptionPane.showMessageDialog(this.panel, "Please a valid number of input arrows.");
    }
    catch (IllegalArgumentException e1) { // empty number
      JOptionPane.showMessageDialog(this.panel, e1.getMessage());
    }
    
    
    info.add(4);
    
    return this.info;
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

    
    gbc.gridx = 0;
    gbc.gridy = 5;
    JLabel playerWord = new JLabel("Number of Players in Dungeon, (max 2): ");
    this.panel.add(playerWord, gbc);
    gbc.gridx = 5;
    gbc.gridy = 5;
    this.inputNumPlayer = new JTextField(10);
    this.panel.add(this.inputNumPlayer, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 6;
    JLabel rowWord = new JLabel("Number of Rows in Dungeon, (max 9): ");
    this.panel.add(rowWord, gbc);
    gbc.gridx = 5;
    gbc.gridy = 6;
    this.inputRow = new JTextField(10);
    this.panel.add(this.inputRow, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 7;
    JLabel colWord = new JLabel("Number of Columns in Dungeon, (max 9): ");
    this.panel.add(colWord, gbc);
    gbc.gridx = 5;
    gbc.gridy = 7;
    this.inputCol = new JTextField(10);
    this.panel.add(this.inputCol, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 8;
    JLabel remWalls = new JLabel("Number of remaining walls in Dungeon: ");
    this.panel.add(remWalls, gbc);
    gbc.gridx = 5;
    gbc.gridy = 8;
    this.inputWalls = new JTextField(10);
    this.panel.add(this.inputWalls, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 9;
    JLabel mazeType = new JLabel("Type of Maze, (1: Room Maze, 2: Wrapping Maze): ");
    this.panel.add(mazeType, gbc);
    gbc.gridx = 5;
    gbc.gridy = 9;
    this.inputMaze = new JTextField(10);
    this.panel.add(this.inputMaze, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 10;
    JLabel pitNo = new JLabel("Number of pits: ");
    this.panel.add(pitNo, gbc);
    gbc.gridx = 5;
    gbc.gridy = 10;
    this.inputPits = new JTextField(10);
    this.panel.add(this.inputPits, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 11;
    JLabel batNo = new JLabel("Number of superbats: ");
    this.panel.add(batNo, gbc);
    gbc.gridx = 5;
    gbc.gridy = 11;
    this.inputBats = new JTextField(10);
    this.panel.add(this.inputBats, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 12;
    JLabel arrowNo = new JLabel("Number of arrows: ");
    this.panel.add(arrowNo, gbc);
    gbc.gridx = 5;
    gbc.gridy = 12;
    this.inputArrows = new JTextField(10);
    this.panel.add(this.inputArrows, gbc);
    
    gbc.gridx = 2;
    gbc.gridy = 15;
    this.panel.add(this.goBack, gbc);
    
    gbc.gridx = 6;
    gbc.gridy = 15;
    this.panel.add(this.setupGame, gbc);
    
    this.panel.setBackground(Color.darkGray);
    this.panel.setOpaque(true);
    this.panel.setVisible(true);
    this.setSize(950, 600);
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