
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

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

  private JPanel panel;

  /**
   * Constructor for view object.
   * 
   * @param caption of frame
   * @throws IOException
   */
  public GameView(String caption, ControllerX controller) throws IOException {
    super(caption);
    this.gridPositions = new ArrayList<GridPosition>();
    this.panel = new JPanel();
    this.add(panel);
    JScrollPane scrollPane = new JScrollPane(this.panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    this.add(scrollPane);
    
    this.setLocation(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  
    pack();

  }
  
  @Override
  public void setFeatures(Features f) {
   
  }

  @Override
  public void display() {
    //Icon cave = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cave.jpg");
    BufferedImage player, cave;
    try {
      player = ImageIO.read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/player.png"));
      cave = ImageIO.read(new File("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cave.jpg"));
      Graphics2D g = cave.createGraphics();
      g.drawImage(cave, 0, 0, null);
      g.drawImage(player, 50, 30, null);
      JLabel label = new JLabel(new ImageIcon(cave));
     

      this.panel.add(label);
      this.add(panel);
      this.setVisible(true);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    
    
    
  }

  @Override
  public void setListener(ActionListener clicks, KeyListener keys) {
    for (int i = 0; i < this.row * this.col; i++) {
      this.gridPositions.get(i).getButton().addActionListener(clicks);
    }
  }
  
  public void buildMaze(int mazeRow, int mazeCol, Cave[] allCaves) {
    Icon cave = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cave.jpg");
    Icon hallway = new ImageIcon(
        "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cavePath.png");
    Icon wumpus = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/wumpus.png");
    Icon bat = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/superbat.png");
    Icon pit = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/slime-pit.png");
    Icon player = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/player.png");

    this.row = mazeRow; 
    this.col = mazeCol;
    this.panel.setLayout(new GridLayout(mazeRow, mazeCol));
    
   
    for (Cave caves : allCaves) { 
      if (caves.getSecondaryName().equals("tunnel")) { 
        JLabel hall = new JLabel(hallway);
        hall.setPreferredSize(new Dimension(120, 80));
        this.panel.add(hall);

      }
      else { 
        JLabel room = new JLabel(cave);
        room.setPreferredSize(new Dimension(120, 80));
        this.panel.add(room);
      }
      
    }

    this.panel.setVisible(true);
    this.setSize(mazeCol * 130, mazeRow * 130);
    this.setVisible(true);
    
  }

  public void movePlayer(String playerPos, ArrayList<String> possibleMoves) {
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
    // TODO Auto-generated method stub
    return null;
  }


}
