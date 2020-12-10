
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.*;

/**
 * Implementation of the view.
 * 
 * @author ugoslight
 *
 */
public class TestView extends JFrame implements IView {
  private static final long serialVersionUID = -7083924619099998893L;

  private JLabel display;
  JButton submit;
  private JPanel panel;
  private ArrayList<GridPosition> gridPositions;
  private int row, col, actualRow, actualCol;
  private JTextField inputRow, inputCol, inputRem, inputType, inputPits, inputSB;

  /**
   * Constructor for view object.
   * 
   * @param caption of frame
   * @throws IOException
   */
  public TestView() throws IOException {
    this.gridPositions = new ArrayList<GridPosition>();
    this.panel = new JPanel();
    this.add(panel);
    JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    //scrollPane.setPreferredSize(new Dimension(600, 600));
    this.add(scrollPane);
    
    JMenuBar menuBar = new JMenuBar();

    JMenu howToPlay = new JMenu("How To Play");
    JMenu setting = new JMenu("Settings");
    
    JLabel rowInfo = new JLabel("Number of Rows in Dungeon, (max 8):");
    this.inputRow = new JTextField(10);
    
    JLabel colInfo = new JLabel("Number of Columns in Dungeon, (max 8):");
    this.inputCol = new JTextField(10);
    
    JLabel remWalls = new JLabel("Number of Remaining walls in Dungeon, (max 8):");
    this.inputRem = new JTextField(10);
    
    JLabel mazeType = new JLabel("Type of Maze [Room (1), Wrapping Room(2)]:");
    this.inputType = new JTextField(10);

    JLabel  pitsNo = new JLabel("Number of Pits:");
    this.inputPits = new JTextField(10);
    
    JLabel  sbNo = new JLabel("Number of Superbats:");
    this.inputSB = new JTextField(10);
    
    this.submit = new JButton("Create Maze");
    submit.setActionCommand("Restart");
    
    setting.add(rowInfo);
    setting.add(inputRow);
    setting.add(colInfo);
    setting.add(inputCol);
    setting.add(remWalls);
    setting.add(inputRem);
    setting.add(mazeType);
    setting.add(inputType);
    setting.add(pitsNo);
    setting.add(inputPits);
    setting.add(sbNo);
    setting.add(inputSB);
    setting.add(submit);
    
    menuBar.add(howToPlay);
    menuBar.add(setting);
    
    menuBar.setBackground(Color.GREEN);
    menuBar.setOpaque(true);
    this.setJMenuBar(menuBar);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();

  }
  
  @Override
  public void setListener(ActionListener clicks, KeyListener keys) {
    for (int i = 0; i < this.row * this.col; i++) {
      this.gridPositions.get(i).getButton().addActionListener(clicks);
    }
    this.submit.addActionListener(clicks);
  }

  @Override
  public void display() {
   Icon cave = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cave.jpg");
   Icon player = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/player.png");
   
   
   JButton button = new JButton(cave);
   JLabel label = new JLabel(player);
   
   button.setLayout(new GridBagLayout());
   button.add(label, new GridBagConstraints());
   panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
   panel.setLayout(new BorderLayout());
   this.panel.add(button, BorderLayout.CENTER);
   this.panel.setVisible(true);
   

   this.setSize(300,300);
   this.setVisible(true);
   
  }

  @Override
  public void setDisp(String s) {
    display.setText(s);
  }
  
  /**
   * setupGame uses the information from the controller to create a maze view
   * for the game.
   * 
   * @param settings arraylist of configurations
   */
  public void buildMaze(int mazeRow, int mazeCol, Cave[] allCaves) {


    Icon cave = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cave.jpg");
    Icon hallway = new ImageIcon(
        "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cavePath.png");
    Icon wumpus = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/wumpus.png");
    Icon bat = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/superbat.png");
    Icon pit = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/slime-pit.png");
    Icon player = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/player.png");
    
    for (Cave caves : allCaves) { 
      if (caves.getSecondaryName().equals("tunnel")) { 
        JButton gridPlace = new JButton(hallway);
        gridPlace.setPreferredSize(new Dimension(120, 80));
        gridPlace.setBackground(Color.CYAN);
        gridPlace.setOpaque(true);
        gridPlace.setVisible(true);
        gridPlace.setActionCommand("Move");
        
        String row = caves.getName().substring(0,1);
        String col = caves.getName().substring(1,2);
        GridPosition elementGrid = new GridPosition(Integer.parseInt(row), Integer.parseInt(col), gridPlace, null);
        this.panel.add(gridPlace);
        this.gridPositions.add(elementGrid);
      }
      else { 
        JButton gridPlace = new JButton(cave);
        gridPlace.setPreferredSize(new Dimension(120, 80));
        
        if (caves.getWumpus()) {
          gridPlace.setLayout(new GridBagLayout());
          JLabel label = new JLabel(wumpus);
          gridPlace.add(label, new GridBagConstraints());
          panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
          panel.setLayout(new BorderLayout());
          panel.add(gridPlace, BorderLayout.CENTER);
        }
        
        if (caves.getPit()) {
          gridPlace.setLayout(new GridBagLayout());
          JLabel label = new JLabel(pit);
          gridPlace.add(label, new GridBagConstraints());
          panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
          panel.setLayout(new BorderLayout());
          panel.add(gridPlace, BorderLayout.CENTER);
        }
        
        if (caves.isSuperbatIn()) {
          gridPlace.setLayout(new GridBagLayout());
          JLabel label = new JLabel(bat);
          gridPlace.add(label, new GridBagConstraints());
          panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
          panel.setLayout(new BorderLayout());
          panel.add(gridPlace, BorderLayout.CENTER);
        }
        
        if (caves.hasPlayerIn()) {
          gridPlace.setLayout(new GridBagLayout());
          JLabel label = new JLabel(player);
          gridPlace.add(label, new GridBagConstraints());
          panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
          panel.setLayout(new BorderLayout());
          panel.add(gridPlace, BorderLayout.CENTER);
        }
        
        
        gridPlace.setBackground(Color.CYAN);
        gridPlace.setOpaque(true);
        gridPlace.setVisible(true);
        gridPlace.setActionCommand("Move");
        
        String row = caves.getName().substring(0,1);
        String col = caves.getName().substring(1,2);
        GridPosition elementGrid = new GridPosition(Integer.parseInt(row), Integer.parseInt(col), gridPlace, null);
        this.panel.add(gridPlace);
        this.gridPositions.add(elementGrid);
        

        this.panel.setVisible(true);
      }
      
    }
    
    this.panel.setLayout(new GridLayout(mazeRow, mazeCol));
    this.panel.setVisible(true);


    this.setSize(mazeCol * 130, mazeRow * 130);
    this.setVisible(true);
    
  }

  /**
   * setupGame uses the information from the controller to create a maze view
   * for the game.
   * 
   * @param settings arraylist of configurations
   */
  public void setupGame(ArrayList<Integer> settings, ArrayList<String> mazeInfo)
      throws IOException {
    this.row = settings.get(0);
    this.col = settings.get(1);
    this.actualRow = this.row + this.row - 1;
    this.actualCol = this.col + this.col - 1;

    Icon cave = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cave.jpg");
    Icon hallway = new ImageIcon(
        "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cavePath.png");
    String imSwitch = "Cave";
    // place caves, hallways, walls.tunnels, wumpus, superbats

    // PLACE CAVE
    for (int i = 0; i < actualRow; i++) {
      for (int y = 0; y < actualCol; y++) {
         
        JButton gridPlace = new JButton(cave);
        gridPlace.setPreferredSize(new Dimension(120, 80));
        gridPlace.setBackground(Color.CYAN);
        gridPlace.setOpaque(true);
        gridPlace.setVisible(true);
        gridPlace.setActionCommand("Move");

        GridPosition elementGrid = new GridPosition(i, y, gridPlace, null);
        this.panel.add(gridPlace);
        this.gridPositions.add(elementGrid);

      }
    }

    // PLACE HALLWAYS
    int count = 0;
    for (int i = 0; i < actualRow; i++) {
      for (int y = 0; y < actualCol; y++) {
        if (imSwitch.equals("Cave")) {
          this.gridPositions.get(count).getButton().setIcon(cave);
          imSwitch = "Hallway";
          count++;
          continue;
        }
        if (imSwitch.equals("Hallway")) {
          this.gridPositions.get(count).getButton().setIcon(hallway);
          imSwitch = "Cave";
          count++;
          continue;
        }
      }

    }
    
    this.panel.setLayout(new GridLayout(actualRow, actualCol));
    this.panel.setVisible(true);
    

    this.setSize(actualCol * 100, actualRow * 100);
    this.setVisible(true);
  }

  public void movePlayer(String playerPos, ArrayList<String> possibleMoves) {
    // loops through data streucture of rooms, based on the
    // checks if its current room is a valid room to reveal.
    // actual names. from primary names
    // with that determine north south east wwest coordinatres
    // use players location
    // label.setVisisble(true);
    // if you can
    int idx = 0;
    for (int i = 0; i < this.row; i++) {
      for (int y = 0; y < this.col; y++) {
        if (this.gridPositions.get(idx).getRow() == i
            && this.gridPositions.get(idx).getCol() == y) {

          if (playerPos.equals(Integer.toString(i) + Integer.toString(y))) {
            this.gridPositions.get(idx).getButton().setVisible(false);
          }
        }

        idx++;
      }
    }

  }

  @Override
  public void close() {
    this.dispose();
  }

  @Override
  public ArrayList<Integer> getGameConfig() {
    ArrayList<Integer> gameConf = new ArrayList<Integer>();
    gameConf.add(Integer.parseInt(inputRow.getText()));
    gameConf.add(Integer.parseInt(inputCol.getText()));
    gameConf.add(Integer.parseInt(inputRem.getText()));
    gameConf.add(Integer.parseInt(inputType.getText()));
    gameConf.add(Integer.parseInt(inputPits.getText()));
    gameConf.add(Integer.parseInt(inputSB.getText()));
    
    return gameConf;
  }

}
