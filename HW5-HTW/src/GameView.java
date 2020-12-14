
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

  private ArrayList<GridPosition> gridPositions, labelPositions;
  private ArrayList<String> playerPositions;
  private String difficulty, mazeType;
  private int row, col, walls, pits, bats, playerNum;
  private Map<String, ArrayList<String>> tunnelInfo;

  private JPanel panel;
  private JButton options, exitGame;
  private ControllerX control;
  private Boolean canPlay;
  private ArrayList<Integer> gameInfo;
  private Cave[] caves;
  private Integer turn;
  private String turnStr;

  /**
   * Constructor for view object.
   * 
   * @param caption of frame
   * @throws IOException
   */
  public GameView(String caption, ControllerX controller) throws IOException {
    super(caption);
    
    if (caption == null) {
      caption = "Game View";
    }
    if (controller == null) {
      throw new IllegalArgumentException("Please provide this view a controller.");
    }
    
    this.control = controller;
    this.canPlay = true;
    this.gridPositions = new ArrayList<GridPosition>();
    this.labelPositions = new ArrayList<GridPosition>();
    this.tunnelInfo = new HashMap<String, ArrayList<String>>();
    this.panel = new JPanel();
    this.gameInfo = new ArrayList<Integer>();
    this.turn = 0;
    this.playerPositions = new ArrayList<String>();

    this.add(panel);
    JScrollPane scrollPane = new JScrollPane(this.panel,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    this.add(scrollPane);

    JMenuBar menuBar = new JMenuBar();
    options = new JButton("Options");
    exitGame = new JButton("Exit game");

    options.setOpaque(true);
    options.setContentAreaFilled(false);
    options.setBorderPainted(false);
    options.setFocusable(false);

    exitGame.setOpaque(true);
    exitGame.setContentAreaFilled(false);
    exitGame.setBorderPainted(false);
    exitGame.setFocusable(false);

    menuBar.add(options);
    menuBar.add(exitGame);
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
    this.options.addActionListener(l -> f.openMenu(this.gameInfo));
    this.exitGame.addActionListener(l -> f.closeGame());
  }

  @Override
  public void display() {

  }



  /**
   * Receive configuration from full menus.
   */
  public void receiveConfig(ArrayList<Integer> info) {
    this.gameInfo = info;

    if (info.get(8) == 1) {
      this.difficulty = "Easy";
    }

    if (info.get(8) == 2) {
      this.difficulty = "Medium";
    }

    if (info.get(8) == 3) {
      this.difficulty = "Realistic";
    }
    if (info.get(8) == 4) {
      this.difficulty = "Custom";
    }

    this.row = info.get(1);
    this.col = info.get(2);
    this.playerNum = info.get(0);
    this.mazeType = "room";

  }

  /**
   * buildMaze builds visual representation of the maze.
   * 
   * @param structural information of maze to be built
   */
  public void buildMaze(Map<String, Object> structure) throws IOException {

    BufferedImage player = ImageIO
        .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));

    this.panel.setLayout(new GridLayout(this.row, this.col));

    ArrayList<String> walls = (ArrayList<String>) structure.get("walls");
    this.caves = (Cave[]) structure.get("caves");
    int count = 0;

    for (Cave caves : (Cave[]) structure.get("caves")) {
      String rowHall = caves.getName().substring(0, 1);
      String colHall = caves.getName().substring(1, 2);
      BufferedImage hallway;
      ImageIcon iconH = new ImageIcon(
          "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cavePath.png");
      hallway = ImageIO
          .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cavePath.png"));

      if (caves.getSecondaryName().equals("tunnel")) {

        String firstNeigh = caves.getNeighbours().get(0);
        String secNeigh = caves.getNeighbours().get(1);

        if (firstNeigh.substring(0, 1).equals(secNeigh.substring(0, 1))) {
          hallway = ImageIO.read(
              new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/hallwayH2.jpg"));
          iconH = new ImageIcon(
              "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/hallwayH2.jpg");
        }
        if (firstNeigh.substring(1, 2).equals(secNeigh.substring(1, 2))) {
          hallway = ImageIO.read(
              new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/hallwayV2.jpg"));
          iconH = new ImageIcon(
              "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/hallwayV2.jpg");
        }

        int firstNeighbourRow = Integer.parseInt(firstNeigh.substring(0, 1));
        int firstNeighbourCol = Integer.parseInt(firstNeigh.substring(1, 2));
        int secondNeighbourRow = Integer.parseInt(secNeigh.substring(0, 1));
        int secondNeighbourCol = Integer.parseInt(secNeigh.substring(1, 2));

        if (firstNeighbourRow - secondNeighbourRow == 1
            && firstNeighbourCol - secondNeighbourCol == 1) {
          hallway = ImageIO.read(
              new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/hallLL2.jpg"));
          iconH = new ImageIcon(
              "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/hallLL2.jpg");
        }

        if (firstNeighbourRow - secondNeighbourRow == -1
            && firstNeighbourCol - secondNeighbourCol == -1) {
          hallway = ImageIO.read(
              new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/hallRL2.jpg"));
          iconH = new ImageIcon(
              "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/hallRL2.jpg");
        }
        if (firstNeighbourRow - secondNeighbourRow == 1
            && firstNeighbourCol - secondNeighbourCol == -1) {
          hallway = ImageIO.read(
              new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/hallRU2.jpg"));
          iconH = new ImageIcon(
              "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/hallRU2.jpg");
        }
        if (firstNeighbourRow - secondNeighbourRow == -1
            && firstNeighbourCol - secondNeighbourCol == 1) {
          hallway = ImageIO.read(
              new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/hallLU2.jpg"));
          iconH = new ImageIcon(
              "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/hallLU2.jpg");
        }

        /** Label management **/
        JLabel dispLabel = new JLabel(new ImageIcon(hallway));
        dispLabel.setPreferredSize(new Dimension(200, 200));
        GridPosition labHall = new GridPosition(Integer.parseInt(rowHall),
            Integer.parseInt(colHall), dispLabel);
        labHall.addIcon(iconH);

        JLabel hall = new JLabel(new ImageIcon(hallway));
        hall.setVisible(false);
        hall.setPreferredSize(new Dimension(200, 200));
        this.panel.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            JPanel p = (JPanel) e.getSource();
            JLabel l = (JLabel) p.getComponentAt(e.getX(), e.getY());
            showTunnel(l);
          }
        });

        String row = caves.getName().substring(0, 1);
        String col = caves.getName().substring(1, 2);

        GridPosition tPos = new GridPosition(Integer.parseInt(row), Integer.parseInt(col), hall);
        GridPosition lab = new GridPosition(Integer.parseInt(row), Integer.parseInt(col), hall);
        tPos.setTunnel(true);
        tPos.setIsVisible(false);

        this.gridPositions.add(tPos);
        this.labelPositions.add(labHall);
        this.panel.add(hall);
   

      } else {
        String currCave = caves.getName();
        String row = caves.getName().substring(0, 1);
        String col = caves.getName().substring(1, 2);

        ArrayList<String> ways = wayFinder(walls, currCave);
        String choice = "";
        for (String way : ways) {
          choice += way;
        }

        BufferedImage cave = ImageIO
            .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/room2.jpg"));
        ImageIcon iconL = new ImageIcon(
            "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/room2.jpg");

        if (choice.length() == 1) {
          cave = ImageIO.read(new File(
              "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/room" + choice + "2.jpg"));
          iconL = new ImageIcon(
              "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/room" + choice + "2.jpg");
        }

        if (choice.length() == 4) {
          cave = ImageIO.read(
              new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/roombase-42.jpg"));
          iconL = new ImageIcon(
              "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/roombase-42.jpg");
        }

        if (choice.equals("NSE")) {
          cave = ImageIO.read(
              new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/roomNSE2.jpg"));
          iconL = new ImageIcon(
              "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/roomNSE2.jpg");
        }
        if (choice.equals("NSW")) {
          cave = ImageIO.read(
              new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/roomNSW2.jpg"));
          iconL = new ImageIcon(
              "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/roomNSW2.jpg");
        }
        if (choice.equals("NEW")) {
          cave = ImageIO.read(
              new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/roomNEW2.jpg"));
          iconL = new ImageIcon(
              "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/roomNEW2.jpg");
        }
        if (choice.equals("SEW")) {
          cave = ImageIO.read(
              new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/roomSEW2.jpg"));
          iconL = new ImageIcon(
              "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/roomSEW2.jpg");
        }

        Graphics2D g = cave.createGraphics();

        /** Label management **/
        JLabel dispLabel = new JLabel(new ImageIcon(cave));
        dispLabel.setPreferredSize(new Dimension(200, 200));
        GridPosition lab = new GridPosition(Integer.parseInt(row), Integer.parseInt(col),
            dispLabel);
        lab.addIcon(iconL);

        g.drawImage(cave, 0, 0, null);
        if (caves.hasPlayerIn()) {
          g.drawImage(player, 50, 50, null);

          if (count < this.gameInfo.get(0)) {
            this.playerPositions.add(caves.getName());
          }
          count++;
        }

        JLabel label = new JLabel(new ImageIcon(cave));
        label.setVisible(false);
        if (caves.hasPlayerIn()) {
          label.setVisible(true);
        }
        label.setPreferredSize(new Dimension(200, 200));
        this.panel.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            JPanel p = (JPanel) e.getSource();
            JLabel l = (JLabel) p.getComponentAt(e.getX(), e.getY());
            try {
              movePlayer(l);
              return;
            } catch (IOException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }
          }
        });
        label.addKeyListener(new KeyListener() {
          @Override
          public void keyTyped(KeyEvent e) {

          }

          @Override
          public void keyPressed(KeyEvent e) {

          }

          @Override
          public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
            case KeyEvent.VK_UP:
              try {
                keyMovePlayer("North");
              } catch (IOException e1) {
                System.out.println("You cannot move there.");
              }
              break;
            case KeyEvent.VK_DOWN:
              try {
                keyMovePlayer("South");
              } catch (IOException e1) {
                System.out.println("You cannot move there.");
              }
              break;
            case KeyEvent.VK_LEFT:
              try {
                keyMovePlayer("West");

              } catch (IOException e1) {
                System.out.println("You cannot move there.");
              }
              break;
            case KeyEvent.VK_RIGHT:
              try {
                keyMovePlayer("East");
              } catch (IOException e1) {
                System.out.println("You cannot move there.");
              }
              break;
            }
          }

        });
        label.setFocusable(true);
        label.requestFocus();
        label.requestFocusInWindow();

        GridPosition pos = new GridPosition(Integer.parseInt(row), Integer.parseInt(col), label);
        pos.setTunnel(false);
        pos.setIsVisible(false);

        this.gridPositions.add(pos);
        this.labelPositions.add(lab);
        this.panel.add(label);
      }

    }

    this.turn = 0;

    this.panel.setVisible(true);
    this.setSize(this.col * 200, this.row * 200);
    this.setVisible(true);

    if (this.turn == 0) {
      playArrowPlayer1();
    }
    if (this.turn == 1) {
      playArrowPlayer2();
    }
    
    String actionResponse = this.control.action(this.turn);
    if (actionResponse.equals("You've been whisked away by a super bat!")) {
      for (int i = 0; i < this.labelPositions.size(); i++) {
        ImageIcon newImage = this.labelPositions.get(i).getIcon();
        this.gridPositions.get(i).getLabel().setIcon(newImage);

      }

      String newPos = this.control.playerRowCol(this.turn);
      int newRow = Integer.parseInt(newPos.substring(0, 1));
      int newCol = Integer.parseInt(newPos.substring(1, 2));

      for (int i = 0; i < this.labelPositions.size(); i++) {
        if (this.labelPositions.get(i).getRow() == newRow
            && this.labelPositions.get(i).getCol() == newCol) {
          JLabel newLabel = this.gridPositions.get(i).getLabel();
          ImageIcon prevImage = (ImageIcon) newLabel.getIcon();
          Image image = prevImage.getImage();
          BufferedImage cave = (BufferedImage) convertToBufferedImage(image);
          BufferedImage player2 = ImageIO
              .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
          Graphics2D g2 = cave.createGraphics();
          g2.drawImage(player2, 50, 30, null);
          newLabel.setIcon(new ImageIcon(cave));
        }
      }
      actionResponse = this.control.action(this.turn);
    }

    viewResponse(actionResponse);
  }

  /**
   * Provide arrow shooting option for player 1.
   */
  public void playArrowPlayer1() {

    JTextField direction = new JTextField();
    JTextField distance = new JTextField();
    Object[] input = { "Direction:", direction, "Distance:", distance };
    int option = JOptionPane.showConfirmDialog(null, input, "Shoot An Arrow - PLAYER 1",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (direction.getText().equals("") || distance.getText().equals("")) {
      return;
    }
    this.control.shootArrow(Integer.parseInt(direction.getText()),
        Integer.parseInt(distance.getText()), this.turn);

  }

  /**
   * Provide arrow shooting option for player 2.
   */
  public void playArrowPlayer2() {
    JTextField direction1 = new JTextField();
    JTextField distance1 = new JTextField();
    Object[] input1 = { "Direction:", direction1, "Distance:", distance1 };
    int option1 = JOptionPane.showConfirmDialog(null, input1, "Shoot An Arrow - PLAYER 2",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (direction1.getText().equals("") || distance1.getText().equals("")) {

      return;
    }
    this.control.shootArrow(Integer.parseInt(direction1.getText()),
        Integer.parseInt(distance1.getText()), this.turn);

  }

  /**
   * showTunnel reveals tunnel clicked by player.
   * 
   * @param l label clicked
   */
  public void showTunnel(JLabel l) {

    String playerPos = this.control.playerRowCol(this.turn);

    int playerMazeRow = Integer.parseInt(playerPos.substring(0, 1));
    int playerMazeCol = Integer.parseInt(playerPos.substring(1, 2));

    for (GridPosition cell : this.gridPositions) {
      JLabel currentLabel = cell.getLabel();
      if (currentLabel == l) {
        // North
        if (cell.getRow() == playerMazeRow - 1 && cell.getCol() == playerMazeCol) {
          currentLabel.setVisible(true);
          cell.setIsVisible(true);
        }
        // South
        if (cell.getRow() == playerMazeRow + 1 && cell.getCol() == playerMazeCol) {
          currentLabel.setVisible(true);
          cell.setIsVisible(true);
        }
        // East
        if (cell.getRow() == playerMazeRow && cell.getCol() == playerMazeCol + 1) {
          currentLabel.setVisible(true);
          cell.setIsVisible(true);
        }
        // West
        if (cell.getRow() == playerMazeRow && cell.getCol() == playerMazeCol - 1) {
          currentLabel.setVisible(true);
          cell.setIsVisible(true);
        }

      }
    }

  }

  /**
   * movePLayer moves player responds to mouse clicks on labels.
   * 
   * @param l label clicked
   */
  public void movePlayer(JLabel l) throws IOException {
    String actionResponse = "";
    String playerPos = this.control.playerRowCol(this.turn);

    int playerMazeRow = Integer.parseInt(playerPos.substring(0, 1));
    int playerMazeCol = Integer.parseInt(playerPos.substring(1, 2));

    ArrayList<String> possMoves = this.control.playerMoves(this.turn);

    if (!this.canPlay) {
      return;
    }

    for (GridPosition cell : this.gridPositions) {
      JLabel currentLabel = cell.getLabel(); // clicked label
      if (currentLabel == l) {
        if (cell.isTunnel()) {
          return;
        }
        // North
        if (cell.getRow() == playerMazeRow - 1 && cell.getCol() == playerMazeCol) { 

          if (!(cell.getRow() == playerMazeRow - 1 && cell.getCol() == playerMazeCol)) {
            System.out.println("Bad turn");
            return;
          }
          if (possMoves.contains("North")) {

            ImageIcon prevImage = (ImageIcon) currentLabel.getIcon();
            cell.getLabel().setVisible(true);
            cell.setIsVisible(true);
            Image image = prevImage.getImage();
            BufferedImage cave = (BufferedImage) convertToBufferedImage(image);
            BufferedImage player = ImageIO.read(
                new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
            Graphics2D g = cave.createGraphics();
            g.drawImage(player, 50, 30, null);
            currentLabel.setIcon(new ImageIcon(cave));

            for (int i = 0; i < this.gridPositions.size(); i++) {
              GridPosition cellPosition = this.gridPositions.get(i);
              GridPosition labelPosition = this.labelPositions.get(i);

              if (cellPosition.getRow() == playerMazeRow
                  && cellPosition.getCol() == playerMazeCol) {
                cellPosition.getLabel().setIcon(labelPosition.getIcon());

              }
            }

            actionResponse = this.control.movePlayer(1, possMoves, this.turn, this.playerNum);
            System.out.println(actionResponse);
            if (this.playerNum == 2) {
              if (this.turn == 1) {
                this.turn = 0;
                break;
              }
              if (this.turn == 0) {
                this.turn = 1;
                break;
              }
            }

          }
        }
        // South
        if (cell.getRow() == playerMazeRow + 1 && cell.getCol() == playerMazeCol) {

          if (!(cell.getRow() == playerMazeRow + 1 && cell.getCol() == playerMazeCol)) {
            System.out.println("Bad turn");
            return;
          }
          if (possMoves.contains("South")) {
            cell.getLabel().setVisible(true);
            cell.setIsVisible(true);
            ImageIcon prevImage = (ImageIcon) currentLabel.getIcon();
            Image image = prevImage.getImage();
            BufferedImage cave = (BufferedImage) convertToBufferedImage(image);
            BufferedImage player = ImageIO.read(
                new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
            Graphics2D g = cave.createGraphics();
            g.drawImage(player, 50, 30, null);
            currentLabel.setIcon(new ImageIcon(cave));

            for (int i = 0; i < this.gridPositions.size(); i++) {
              GridPosition cellPosition = this.gridPositions.get(i);
              GridPosition labelPosition = this.labelPositions.get(i);

              if (cellPosition.getRow() == playerMazeRow
                  && cellPosition.getCol() == playerMazeCol) {
                cellPosition.getLabel().setIcon(labelPosition.getIcon());

              }
            }

            actionResponse = this.control.movePlayer(2, possMoves, this.turn, this.playerNum);
            System.out.println(actionResponse);

            if (this.playerNum == 2) {
              if (this.turn == 1) {
                this.turn = 0;
                break;
              }
              if (this.turn == 0) {
                this.turn = 1;
                System.out.println("South just finished: " + this.turn);
                break;
              }
            }
          }

        }

        // East
        if (cell.getRow() == playerMazeRow && cell.getCol() == playerMazeCol + 1) {
          if (!(cell.getRow() == playerMazeRow && cell.getCol() == playerMazeCol + 1)) {
            System.out.println("Bad turn");
            return;
          }
          if (possMoves.contains("East")) {
            cell.getLabel().setVisible(true);
            cell.setIsVisible(true);
            ImageIcon prevImage = (ImageIcon) currentLabel.getIcon();
            Image image = prevImage.getImage();
            BufferedImage cave = (BufferedImage) convertToBufferedImage(image);
            BufferedImage player = ImageIO.read(
                new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
            Graphics2D g = cave.createGraphics();
            g.drawImage(player, 50, 30, null);
            currentLabel.setIcon(new ImageIcon(cave));

            for (int i = 0; i < this.gridPositions.size(); i++) {
              GridPosition cellPosition = this.gridPositions.get(i);
              GridPosition labelPosition = this.labelPositions.get(i);

              if (cellPosition.getRow() == playerMazeRow
                  && cellPosition.getCol() == playerMazeCol) {
                cellPosition.getLabel().setIcon(labelPosition.getIcon());
              }
            }

            actionResponse = this.control.movePlayer(3, possMoves, this.turn, this.playerNum);
            System.out.println(actionResponse);
            if (this.playerNum == 2) {
              if (this.turn == 1) {
                this.turn = 0;
                break;
              }
              if (this.turn == 0) {
                this.turn = 1;
                break;
              }
            }
          }
        }

        // West
        if (cell.getRow() == playerMazeRow && cell.getCol() == playerMazeCol - 1) {

          if (!(cell.getRow() == playerMazeRow && cell.getCol() == playerMazeCol - 1)) {
            System.out.println("Bad turn");
            return;
          }
          if (possMoves.contains("West")) {
            cell.getLabel().setVisible(true);
            cell.setIsVisible(true);
            ImageIcon prevImage = (ImageIcon) currentLabel.getIcon();
            Image image = prevImage.getImage();
            BufferedImage cave = (BufferedImage) convertToBufferedImage(image);
            BufferedImage player = ImageIO.read(
                new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
            Graphics2D g = cave.createGraphics();
            g.drawImage(player, 50, 30, null);
            currentLabel.setIcon(new ImageIcon(cave));

            for (int i = 0; i < this.gridPositions.size(); i++) {
              GridPosition cellPosition = this.gridPositions.get(i);
              GridPosition labelPosition = this.labelPositions.get(i);

              if (cellPosition.getRow() == playerMazeRow
                  && cellPosition.getCol() == playerMazeCol) {
                cellPosition.getLabel().setIcon(labelPosition.getIcon());
              }
            }

            actionResponse = this.control.movePlayer(4, possMoves, this.turn, this.playerNum);
            System.out.println(actionResponse);
            if (this.playerNum == 2) {
              if (this.turn == 1) {
                this.turn = 0;
                break;
              }
              if (this.turn == 0) {
                this.turn = 1;
                break;
              }
            }

          }
        }

      }

    }

    if (actionResponse.equals("You've been whisked away by a super bat!")) {
      for (int i = 0; i < this.labelPositions.size(); i++) {
        ImageIcon newImage = this.labelPositions.get(i).getIcon();
        this.gridPositions.get(i).getLabel().setIcon(newImage);

      }

      String newPos = this.control.playerRowCol(this.turn);
      int newRow = Integer.parseInt(newPos.substring(0, 1));
      int newCol = Integer.parseInt(newPos.substring(1, 2));

      for (int i = 0; i < this.labelPositions.size(); i++) {
        if (this.labelPositions.get(i).getRow() == newRow
            && this.labelPositions.get(i).getCol() == newCol) {
          JLabel newLabel = this.gridPositions.get(i).getLabel();
          ImageIcon prevImage = (ImageIcon) newLabel.getIcon();
          Image image = prevImage.getImage();
          BufferedImage cave = (BufferedImage) convertToBufferedImage(image);
          BufferedImage player2 = ImageIO
              .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
          Graphics2D g2 = cave.createGraphics();
          g2.drawImage(player2, 50, 30, null);
          newLabel.setIcon(new ImageIcon(cave));
        }
      }
      actionResponse = this.control.action(this.turn);
    }

    viewResponse(actionResponse);

  }

  /**
   * keyMovePlayer moves player based on arrow key clicked.
   * 
   * @param direc direction of keyboard input
   * @throws IOException
   */
  public void keyMovePlayer(String direc) throws IOException {
    String actionResponse = "";
    String playerPos = this.control.playerRowCol(this.turn);
    int playerMazeRow = Integer.parseInt(playerPos.substring(0, 1));
    int playerMazeCol = Integer.parseInt(playerPos.substring(1, 2));
    JLabel currentLabel = new JLabel();
    ArrayList<String> possMoves = this.control.playerMoves(this.turn);

    // North
    if (direc.equals("North")) {

      if (possMoves.contains("North")) {

        for (GridPosition cell : this.gridPositions) {

          if (cell.getRow() == playerMazeRow - 1 && cell.getCol() == playerMazeCol) {
            currentLabel = cell.getLabel();
            if (cell.isTunnel()) {

              if (!cell.isVisible()) {
                System.out.println(cell.isVisible());
                return;
              }
            }
            cell.setIsVisible(true);
            currentLabel.setVisible(true);
          }

        } // get Label player is going to


        ImageIcon prevImage = (ImageIcon) currentLabel.getIcon();
        Image image = prevImage.getImage();
        BufferedImage cave = (BufferedImage) convertToBufferedImage(image);
        BufferedImage player = ImageIO
            .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
        Graphics2D g = cave.createGraphics();
        g.drawImage(player, 50, 30, null);

        Boolean paint = true;
        // if current label place is a tunnel
        for (GridPosition cell : this.gridPositions) {
          if (cell.getRow() == playerMazeRow - 1 && cell.getCol() == playerMazeCol) {
            if (cell.isTunnel()) {
              paint = false;
              break;
            }
          }
        }
        // dont paint
        // find new location of player and paint

        if (paint) {
          currentLabel.setIcon(new ImageIcon(cave)); // painting new place
        }

        // unpainting the old spot.
        for (int i = 0; i < this.gridPositions.size(); i++) {
          GridPosition cellPosition = this.gridPositions.get(i);
          GridPosition labelPosition = this.labelPositions.get(i);

          if (cellPosition.getRow() == playerMazeRow && cellPosition.getCol() == playerMazeCol) {
            cellPosition.getLabel().setIcon(labelPosition.getIcon());
          }
        }

        actionResponse = this.control.movePlayer(1, possMoves, this.turn, this.playerNum);

        // If didn't paint, paint the current cell you are in.
        if (!paint) {
          JLabel newCell = new JLabel();
          String playerPos2 = this.control.playerRowCol(this.turn);
          int playerMazeRow2 = Integer.parseInt(playerPos2.substring(0, 1));
          int playerMazeCol2 = Integer.parseInt(playerPos2.substring(1, 2));
          for (GridPosition cell : this.gridPositions) {
            if (cell.getRow() == playerMazeRow2 && cell.getCol() == playerMazeCol2) {
              newCell = cell.getLabel();
              cell.setIsVisible(true);
              newCell.setVisible(true);
              ImageIcon prevImage2 = (ImageIcon) newCell.getIcon();
              Image image2 = prevImage2.getImage();
              BufferedImage cave2 = (BufferedImage) convertToBufferedImage(image2);
              BufferedImage player2 = ImageIO.read(
                  new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
              Graphics2D g2 = cave2.createGraphics();
              g2.drawImage(player2, 50, 30, null);
              newCell.setIcon(new ImageIcon(cave2));
            }
          }
        }

      }
    }

    // South
    if (direc.equals("South")) {
      if (possMoves.contains("South")) {

        for (GridPosition cell : this.gridPositions) {

          if (cell.getRow() == playerMazeRow + 1 && cell.getCol() == playerMazeCol) {
            currentLabel = cell.getLabel();
            if (cell.isTunnel()) {

              if (!cell.isVisible()) {
                System.out.println(cell.isVisible());
                return;
              }
            }
            cell.setIsVisible(true);
            currentLabel.setVisible(true);
          }

        } // get Label player is going to


        ImageIcon prevImage = (ImageIcon) currentLabel.getIcon();
        Image image = prevImage.getImage();
        BufferedImage cave = (BufferedImage) convertToBufferedImage(image);
        BufferedImage player = ImageIO
            .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
        Graphics2D g = cave.createGraphics();
        g.drawImage(player, 50, 30, null);

        Boolean paint = true;
        // if current label place is a tunnel
        for (GridPosition cell : this.gridPositions) {
          if (cell.getRow() == playerMazeRow + 1 && cell.getCol() == playerMazeCol) {
            if (cell.isTunnel()) {
              paint = false;
              break;
            }
          }
        }
        // dont paint
        // find new location of player and paint

        if (paint) {
          currentLabel.setIcon(new ImageIcon(cave)); // painting new place
        }

        // unpainting the old spot
        for (int i = 0; i < this.gridPositions.size(); i++) {
          GridPosition cellPosition = this.gridPositions.get(i);
          GridPosition labelPosition = this.labelPositions.get(i);

          if (cellPosition.getRow() == playerMazeRow && cellPosition.getCol() == playerMazeCol) {
            cellPosition.getLabel().setIcon(labelPosition.getIcon());
          }
        }

        actionResponse = this.control.movePlayer(2, possMoves, this.turn, this.playerNum);

        // If didn't paint, paint the current cell you are in.
        if (!paint) {
          JLabel newCell = new JLabel();
          String playerPos2 = this.control.playerRowCol(this.turn);
          int playerMazeRow2 = Integer.parseInt(playerPos2.substring(0, 1));
          int playerMazeCol2 = Integer.parseInt(playerPos2.substring(1, 2));
          for (GridPosition cell : this.gridPositions) {
            if (cell.getRow() == playerMazeRow2 && cell.getCol() == playerMazeCol2) {
              newCell = cell.getLabel();
              cell.setIsVisible(true);
              newCell.setVisible(true);
              ImageIcon prevImage2 = (ImageIcon) newCell.getIcon();
              Image image2 = prevImage2.getImage();
              BufferedImage cave2 = (BufferedImage) convertToBufferedImage(image2);
              BufferedImage player2 = ImageIO.read(
                  new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
              Graphics2D g2 = cave2.createGraphics();
              g2.drawImage(player2, 50, 30, null);
              newCell.setIcon(new ImageIcon(cave2));
            }
          }
        }

      }
    }

    // East
    if (direc.equals("East")) {
      if (possMoves.contains("East")) {

        for (GridPosition cell : this.gridPositions) {

          if (cell.getRow() == playerMazeRow && cell.getCol() == playerMazeCol + 1) {
            currentLabel = cell.getLabel();
            if (cell.isTunnel()) {

              if (!cell.isVisible()) {
                System.out.println(cell.isVisible());
                return;
              }
            }
            cell.setIsVisible(true);
            currentLabel.setVisible(true);
          }

        } // get Label player is going to

        System.out.println("Before move");
        System.out.println(playerMazeRow);
        System.out.println(playerMazeCol + 1);

        ImageIcon prevImage = (ImageIcon) currentLabel.getIcon();
        Image image = prevImage.getImage();
        BufferedImage cave = (BufferedImage) convertToBufferedImage(image);
        BufferedImage player = ImageIO
            .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
        Graphics2D g = cave.createGraphics();
        g.drawImage(player, 50, 30, null);

        Boolean paint = true;
        // if current label place is a tunnel
        for (GridPosition cell : this.gridPositions) {
          if (cell.getRow() == playerMazeRow && cell.getCol() == playerMazeCol + 1) {
            if (cell.isTunnel()) {
              paint = false;
              break;
            }
          }
        }
        // dont paint
        // find new location of player and paint

        if (paint) {
          currentLabel.setIcon(new ImageIcon(cave)); // painting new place
        }

        // unpainting the old spot
        for (int i = 0; i < this.gridPositions.size(); i++) {
          GridPosition cellPosition = this.gridPositions.get(i);
          GridPosition labelPosition = this.labelPositions.get(i);

          if (cellPosition.getRow() == playerMazeRow && cellPosition.getCol() == playerMazeCol) {
            cellPosition.getLabel().setIcon(labelPosition.getIcon());
          }
        }

        actionResponse = this.control.movePlayer(3, possMoves, this.turn, this.playerNum);
        System.out.println("After move.");
        System.out.println(this.control.playerRowCol(1));
        // If didn't paint, paint the current cell you are in.
        if (!paint) {
          JLabel newCell = new JLabel();
          String playerPos2 = this.control.playerRowCol(this.turn);
          int playerMazeRow2 = Integer.parseInt(playerPos2.substring(0, 1));
          int playerMazeCol2 = Integer.parseInt(playerPos2.substring(1, 2));
          for (GridPosition cell : this.gridPositions) {
            if (cell.getRow() == playerMazeRow2 && cell.getCol() == playerMazeCol2) {
              newCell = cell.getLabel();
              cell.setIsVisible(true);
              newCell.setVisible(true);
              ImageIcon prevImage2 = (ImageIcon) newCell.getIcon();
              Image image2 = prevImage2.getImage();
              BufferedImage cave2 = (BufferedImage) convertToBufferedImage(image2);
              BufferedImage player2 = ImageIO.read(
                  new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
              Graphics2D g2 = cave2.createGraphics();
              g2.drawImage(player2, 50, 30, null);
              newCell.setIcon(new ImageIcon(cave2));
            }
          }
        }
      }
    }

    // West
    if (direc.equals("West")) {
      if (possMoves.contains("West")) {

        for (GridPosition cell : this.gridPositions) {

          if (cell.getRow() == playerMazeRow && cell.getCol() == playerMazeCol - 1) {
            currentLabel = cell.getLabel();
            if (cell.isTunnel()) {

              if (!cell.isVisible()) {
                System.out.println(cell.isVisible());
                return;
              }
            }
            cell.setIsVisible(true);
            currentLabel.setVisible(true);
          }

        } // get Label player is going to

        ImageIcon prevImage = (ImageIcon) currentLabel.getIcon();
        Image image = prevImage.getImage();
        BufferedImage cave = (BufferedImage) convertToBufferedImage(image);
        BufferedImage player = ImageIO
            .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
        Graphics2D g = cave.createGraphics();
        g.drawImage(player, 50, 30, null);

        Boolean paint = true;
        // if current label place is a tunnel
        for (GridPosition cell : this.gridPositions) {
          if (cell.getRow() == playerMazeRow && cell.getCol() == playerMazeCol - 1) {
            if (cell.isTunnel()) {
              paint = false;
              break;
            }
          }
        }
        // dont paint
        // find new location of player and paint

        if (paint) {
          currentLabel.setIcon(new ImageIcon(cave)); // painting new place
        }

        // unpainting the old spot
        for (int i = 0; i < this.gridPositions.size(); i++) {
          GridPosition cellPosition = this.gridPositions.get(i);
          GridPosition labelPosition = this.labelPositions.get(i);

          if (cellPosition.getRow() == playerMazeRow && cellPosition.getCol() == playerMazeCol) {
            cellPosition.getLabel().setIcon(labelPosition.getIcon());
          }
        }

        actionResponse = this.control.movePlayer(4, possMoves, this.turn, this.playerNum);
        System.out.println("After move.");
        System.out.println(this.control.playerRowCol(1));
        // If didn't paint, paint the current cell you are in.
        if (!paint) {
          JLabel newCell = new JLabel();
          String playerPos2 = this.control.playerRowCol(this.turn);
          int playerMazeRow2 = Integer.parseInt(playerPos2.substring(0, 1));
          int playerMazeCol2 = Integer.parseInt(playerPos2.substring(1, 2));
          for (GridPosition cell : this.gridPositions) {
            if (cell.getRow() == playerMazeRow2 && cell.getCol() == playerMazeCol2) {
              newCell = cell.getLabel();
              cell.setIsVisible(true);
              newCell.setVisible(true);
              ImageIcon prevImage2 = (ImageIcon) newCell.getIcon();
              Image image2 = prevImage2.getImage();
              BufferedImage cave2 = (BufferedImage) convertToBufferedImage(image2);
              BufferedImage player2 = ImageIO.read(
                  new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
              Graphics2D g2 = cave2.createGraphics();
              g2.drawImage(player2, 50, 30, null);
              newCell.setIcon(new ImageIcon(cave2));
            }
          }
        }
      }
    }
    if (actionResponse.equals("You've been whisked away by a super bat!")) {
      for (int i = 0; i < this.labelPositions.size(); i++) {
        ImageIcon newImage = this.labelPositions.get(i).getIcon();
        this.gridPositions.get(i).getLabel().setIcon(newImage);

      }

      String newPos = this.control.playerRowCol(this.turn);
      int newRow = Integer.parseInt(newPos.substring(0, 1));
      int newCol = Integer.parseInt(newPos.substring(1, 2));

      for (int i = 0; i < this.labelPositions.size(); i++) {
        if (this.labelPositions.get(i).getRow() == newRow
            && this.labelPositions.get(i).getCol() == newCol) {
          this.gridPositions.get(i).setIsVisible(true);
          this.gridPositions.get(i).getLabel().setVisible(true);
          JLabel newLabel = this.gridPositions.get(i).getLabel();
          ImageIcon prevImage = (ImageIcon) newLabel.getIcon();
          Image image = prevImage.getImage();
          BufferedImage cave = (BufferedImage) convertToBufferedImage(image);
          BufferedImage player2 = ImageIO
              .read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/test.png"));
          Graphics2D g2 = cave.createGraphics();
          g2.drawImage(player2, 50, 30, null);
          newLabel.setIcon(new ImageIcon(cave));
        }
      }
      actionResponse = this.control.action(this.turn);
    }

    viewResponse(actionResponse);

  }

  /**
   * viewResponse produces a response based on maze event to the player.
   * 
   * @param details of events in the maze.
   */
  public void viewResponse(String details) {

    if (details.equals("You've been whisked away by a super bat!")) {
      ImageIcon image = new ImageIcon(
          "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/bat2.gif");
      JOptionPane.showMessageDialog(null,
          new JLabel("You've been whisked away by a super bat!", image, JLabel.LEFT), "",
          JOptionPane.PLAIN_MESSAGE);
    }
    if (details.equals("The bat whisked you away to a pit, better luck next time!")) {
      ImageIcon image = new ImageIcon(
          "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/ggrem.png");
      JOptionPane.showMessageDialog(null,
          new JLabel("The bat whisked you away to the Wumpus, better luck next time!", image,
              JLabel.LEFT),
          "", JOptionPane.PLAIN_MESSAGE);
      this.control.gameEnd();
    }
   
    if (details.equals("You smell a Wumpus!")) {
      ImageIcon image = new ImageIcon(
          "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/wumpus-nearby.png");
      JOptionPane.showMessageDialog(null, new JLabel("You smell a wumpus!!!", image, JLabel.LEFT),
          "", JOptionPane.PLAIN_MESSAGE);
    }

    if (details.equals("You feel a draft!")) {
      ImageIcon image = new ImageIcon(
          "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/slime-pit-nearby.png");
      JOptionPane.showMessageDialog(null, new JLabel("You feel a draft!", image, JLabel.LEFT), "",
          JOptionPane.PLAIN_MESSAGE);
    }
    if (details.equals("You've been made meat by the Wumpus. Try again!")) {
      canPlay = false;
      ImageIcon image = new ImageIcon(
          "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/ggrem.png");
      JOptionPane.showMessageDialog(null,
          new JLabel("Looks like I got the better of you this time. Get out of my dungeon!!!",
              image, JLabel.LEFT),
          "", JOptionPane.PLAIN_MESSAGE);
      this.control.gameEnd();
    }
    if (details.equals("Game over: 5250 FALL Damage!")) {
      canPlay = false;
      ImageIcon image = new ImageIcon(
          "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/pit2.png");
      JOptionPane.showMessageDialog(null,
          new JLabel("Looks like you don't know your way around. You fell in a pit!!!", image,
              JLabel.LEFT),
          "", JOptionPane.PLAIN_MESSAGE);
      this.control.gameEnd();
    }
  }

  /**
   * wayFinder is a method used to determine the possible channels caves in the
   * dungeon have access to.
   * 
   * @param walls in the dungeon
   * @param currentCave being investigated
   */
  public ArrayList<String> wayFinder(ArrayList<String> walls, String currentCave) {
    ArrayList<String> ways = new ArrayList<String>();
    int currRow = Integer.parseInt(currentCave.substring(0, 1));
    int currCol = Integer.parseInt(currentCave.substring(1, 2));
    int north = 0;
    int south = 0;
    int east = 0;
    int west = 0;

    // North
    if (currRow - 1 >= 0) {
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

    // South
    if (currRow + 1 < this.row) {
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

    // East
    if (currCol + 1 < this.col) {
      String eastNeighbour = Integer.toString(currRow) + Integer.toString(currCol + 1);
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

    // West
    if (currCol - 1 >= 0) {
      String westNeighbour = Integer.toString(currRow) + Integer.toString(currCol - 1);
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
    if (north == 0) {
      ways.add("N");
    }
    if (south == 0) {
      ways.add("S");
    }
    if (east == 0) {
      ways.add("E");
    }
    if (west == 0) {
      ways.add("W");
    }
    return ways;
  }

  /**
   * convertBufferedImage converts buffered image to an image icon.
   * 
   * @param image image to be converted
   */
  public static BufferedImage convertToBufferedImage(Image image) {
    BufferedImage newImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
        BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = newImage.createGraphics();
    g.drawImage(image, 0, 0, null);
    g.dispose();
    return newImage;
  }

  @Override
  public void close() {
    this.panel.removeAll();
    this.dispose();
  }

  @Override
  public ArrayList<Integer> getGameConfig() {
    // TODO Auto-generated method stub
    return null;
  }

}
