
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicMenuBarUI;

/**
 * Implementation of the view.
 * 
 * @author ugoslight
 *
 */
public class GameView extends JFrame implements IView {
  private static final long serialVersionUID = -7083924619099998893L;

  private JLabel display;
  private ArrayList<GridPosition> gridPositions;
  private int row, col, actualRow, actualCol;
  private String difficulty, mazeType;

  private JPanel panel;
  private JButton menuButton;
  private ControllerX control;

  /**
   * Constructor for view object.
   * 
   * @param caption of frame
   * @throws IOException
   */
  public GameView(String caption, ControllerX controller) throws IOException {
    super(caption);
    this.control = controller;
    this.gridPositions = new ArrayList<GridPosition>();
    this.panel = new JPanel();
    this.add(panel);
    JScrollPane scrollPane = new JScrollPane(this.panel,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    this.add(scrollPane);

    JMenuBar menuBar = new JMenuBar();
    menuButton = new JButton("GAME MENU");
    menuButton.setOpaque(true);
    menuButton.setContentAreaFilled(false);
    menuButton.setBorderPainted(false);
    menuButton.setFocusable(false);

    menuBar.add(menuButton);
    menuBar.setUI(new BasicMenuBarUI() {
      @Override
      public void paint(Graphics g, JComponent c) {
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
      }
    });
    this.setJMenuBar(menuBar);
    this.setLocation(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    pack();

  }

  @Override
  public void setFeatures(Features f) {
    this.menuButton.addActionListener(l -> f.openMenu(difficulty));
  }

  @Override
  public void display() {
    Icon wumpus = new ImageIcon(
        "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/wumpus.png");
    JLabel label = new JLabel(wumpus);
    label.setPreferredSize(new Dimension(120, 80));

    label.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        System.out.println(label.getX());
        System.out.println(label.getY());
      }
    });
    this.panel.add(label);
    this.panel.setVisible(true);
    this.setSize(300, 300);
    this.setVisible(true);

  }

  @Override
  public void setListener(ActionListener clicks, KeyListener keys) {
    // for (int i = 0; i < this.row * this.col; i++) {
    // this.gridPositions.get(i).getButton().addActionListener(clicks);
    // }
  }

  public void receiveConfig(String difficulty) {
    this.difficulty = difficulty;
  }

  public void buildMaze(int mazeRow, int mazeCol, String mazeType,  Map<String, Object> structure) throws IOException {

    BufferedImage hallway = ImageIO
        .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cavePath.png"));
    BufferedImage wumpus = ImageIO
        .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/wumpus.png"));
    BufferedImage bat = ImageIO
        .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/superbat.png"));
    BufferedImage pit = ImageIO
        .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/slime-pit.png"));
    BufferedImage player = ImageIO
        .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/player.png"));

    this.row = mazeRow;
    this.col = mazeCol;
    this.mazeType = mazeType; 
    this.panel.setLayout(new GridLayout(mazeRow, mazeCol));
    
    ArrayList<String> walls = (ArrayList<String>) structure.get("walls");
    
    for (Cave caves : (Cave[]) structure.get("caves")) {
      if (caves.getSecondaryName().equals("tunnel")) {
        JLabel hall = new JLabel(new ImageIcon(hallway));
        hall.setPreferredSize(new Dimension(120, 80));
        this.panel.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            JPanel p = (JPanel) e.getSource();
            JLabel l = (JLabel) p.getComponentAt(e.getX(), e.getY());
            try {
              movePlayer(l);
            } catch (IOException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }
          }
        });

        String row = caves.getName().substring(0, 1);
        String col = caves.getName().substring(1, 2);

        GridPosition pos = new GridPosition(Integer.parseInt(row), Integer.parseInt(col), hall);
        this.gridPositions.add(pos);
        this.panel.add(hall);

      } else {
        String currCave = caves.getName();
        String bottom = Integer.toString(this.col - 1);
        ArrayList<String> ways  = wayFinderX(walls, currCave);
        System.out.print(currCave);
        System.out.print(ways);
        

        BufferedImage cave = ImageIO
            .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cave.jpg"));
        Graphics2D g = cave.createGraphics();

        g.drawImage(cave, 0, 0, null);
        if (caves.hasPlayerIn()) {
          g.drawImage(player, 50, 30, null);
        }

        JLabel label = new JLabel(new ImageIcon(cave));
        label.setPreferredSize(new Dimension(120, 80));
        this.panel.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            JPanel p = (JPanel) e.getSource();
            JLabel l = (JLabel) p.getComponentAt(e.getX(), e.getY());
            try {
              movePlayer(l);
            } catch (IOException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }
          }
        });

        String row = caves.getName().substring(0, 1);
        String col = caves.getName().substring(1, 2);

        GridPosition pos = new GridPosition(Integer.parseInt(row), Integer.parseInt(col), label);
        this.gridPositions.add(pos);
        this.panel.add(label);
      }
    }

    this.panel.setVisible(true);
    this.setSize(mazeCol * 100, mazeRow * 100);
    this.setVisible(true);

  }

  public ArrayList<String> wayFinderX(ArrayList<String> walls, String currentCave) {
    ArrayList<String> ways = new ArrayList<String>();
    int currRow = Integer.parseInt(currentCave.substring(0,1));
    int currCol = Integer.parseInt(currentCave.substring(1,2));
    int north = 0;
    int south = 0;
    int east = 0;
    int west = 0;
    //North
    if (currRow  - 1 > 0) {
      String northNeighbour = Integer.toString(currRow - 1) + Integer.toString(currCol);
      if (walls.contains(northNeighbour + "." + currentCave)) { 
        north = 1;
      }
      if (walls.contains(currentCave + "." + northNeighbour)) { 
        north = 1;
      } 
    }
    if (currRow - 1 < 0 && north == 0 && this.mazeType == "room") {
      north = 1;
    }
    
    
    //South
    if (currRow  + 1 < this.row) {
      String southNeighbour = Integer.toString(currRow + 1) + Integer.toString(currCol);
      if (walls.contains(southNeighbour + "." + currentCave)) { 
        south = 1;
      }
      if (walls.contains(currentCave + "." + southNeighbour)) { 
        south = 1;
      } 
    }
    if (currRow + 1 >= this.row && south == 0 && this.mazeType == "room") {
      south = 1;
    }
    
    
    //East
    if (currCol  + 1 < this.col) {
      String eastNeighbour =Integer.toString(currRow) + Integer.toString(currCol + 1) ;
      if (walls.contains(eastNeighbour + "." + currentCave)) { 
        east = 1;
      }
      if (walls.contains(currentCave + "." + eastNeighbour)) { 
        east = 1;
      } 
    }
    if (currCol + 1 >= this.col && east == 0 && this.mazeType == "room") {
      east = 1;
    }
    
    
    //West
    if (currCol - 1 > 0) {
      String westNeighbour = Integer.toString(currRow) + Integer.toString(currCol - 1) ;
      if (walls.contains(westNeighbour + "." + currentCave)) { 
        west = 1;
      }
      if (walls.contains(currentCave + "." + westNeighbour)) { 
        west = 1;
      } 
    }
    if (currCol - 1 < 0 && west == 0 && this.mazeType == "room") {
      west = 1;
    }
    if (north == 0) { ways.add("N"); } 
    if (south == 0) { ways.add("S"); }
    if (east == 0) { ways.add("E"); }
    if (west == 0) { ways.add("W"); }
    return ways;
  }
  
  
  
  
  public void movePlayer(JLabel l) throws IOException {
    String playerPos = this.control.playerRowCol();
    int playerMazeRow = Integer.parseInt(playerPos.substring(0, 1));
    int playerMazeCol = Integer.parseInt(playerPos.substring(1, 2));

    ArrayList<String> possMoves = this.control.playerMoves();

    for (GridPosition cell : this.gridPositions) {
      JLabel currentLabel = cell.getLabel();
      if (currentLabel == l) {
        // North
        if (cell.getRow() == playerMazeRow - 1 && cell.getCol() == playerMazeCol) {
          if (possMoves.contains("North")) {
            BufferedImage cave = ImageIO
                .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cave.jpg"));
            BufferedImage player = ImageIO
                .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/player.png"));
            Graphics2D g = cave.createGraphics();
            g.drawImage(player, 50, 30, null);
            currentLabel.setIcon(new ImageIcon(cave));

          }
        }
        // South
        if (cell.getRow() == playerMazeRow + 1 && cell.getCol() == playerMazeCol) {
          if (possMoves.contains("South")) {
            BufferedImage cave = ImageIO
                .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cave.jpg"));
            BufferedImage player = ImageIO
                .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/player.png"));
            Graphics2D g = cave.createGraphics();
            g.drawImage(player, 50, 30, null);
            currentLabel.setIcon(new ImageIcon(cave));
          }
        }
        // West
        if (cell.getRow() == playerMazeRow && cell.getCol() == playerMazeCol - 1) {
          if (possMoves.contains("West")) {
            BufferedImage cave = ImageIO
                .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cave.jpg"));
            BufferedImage player = ImageIO
                .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/player.png"));
            Graphics2D g = cave.createGraphics();
            g.drawImage(player, 50, 30, null);
            currentLabel.setIcon(new ImageIcon(cave));
          }
        }
        // East
        if (cell.getRow() == playerMazeRow && cell.getCol() == playerMazeCol + 1) {
          if (possMoves.contains("East")) {
            BufferedImage cave = ImageIO
                .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cave.jpg"));
            BufferedImage player = ImageIO
                .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/player.png"));
            Graphics2D g = cave.createGraphics();
            g.drawImage(player, 50, 30, null);
            currentLabel.setIcon(new ImageIcon(cave));
          }
        }

      }

    }

  }


  @Override
  public void close() {
    this.dispose();
  }

  @Override
  public ArrayList<Integer> getGameConfig() {
    // TODO Auto-generated method stub
    return null;
  }

}
