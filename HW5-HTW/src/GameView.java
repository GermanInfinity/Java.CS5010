
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Implementation of the view. 
 * @author ugoslight
 *
 */
public class GameView extends JFrame implements IView {
  private static final long serialVersionUID = -7083924619099998893L;

  private JLabel display, image;
  private ArrayList<GridPosition> gridPositions;
  private int row, col; 

  
  /**
   * Constructor for view object. 
   * 
   * @param caption of frame
   * @throws IOException 
   */
  public GameView(String caption) throws IOException {
    super(caption);
    this.gridPositions = new ArrayList<GridPosition>();
//    setSize(200, 200);
//    setLocation(100,100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //ImageIcon icon = new ImageIcon("/Users/ugoslight/Downloads/res/white.jpg");

    //image = new JLabel(new ImageIcon("/Users/ugoslight/Downloads/res/hallway.png"));
    
    //JButton button = new JButton(icon); 
//    button.setOpaque(false);
//    button.setContentAreaFilled(false);
//    button.setBorderPainted(false);
//    this.add(button);
    
//      JButton b1 = new JButton(icon);
//      b1.setActionCommand("Button click");
//      this.add(b1);
//    
//    
//
//    echoButton = new JButton("NextPage");
//    echoButton.setActionCommand("Button click");
//    this.add(echoButton);

    
    
//    
    
//    this.label7.setVisible(true); // works!


    pack();
    
  }

  @Override
  public void display() {
    setVisible(true);
  }

  @Override
  public void setDisp(String s) {
    display.setText(s);
  }

  @Override
  public void setListener(ActionListener clicks, KeyListener keys) {
    for (int i = 0; i < this.row * this.col; i++) {
      
      this.gridPositions.get(i).getButton().addActionListener(clicks);
    }
 
  }
  
//  public void show() { 
//    //System.out.println("HEY");
//  }

  public void revealPic() { 
    
    ImageIcon icon2 = new ImageIcon("/Users/ugoslight/Downloads/res/hallway.png");


  }
  
  public void startGame() { 
    //this.add(comp)
  }


  /** 
   * setupGame uses the information from the controller to create a maze view for the game.
   * @param settings arraylist of configurations
   */
  public void setupGame(ArrayList<Integer> settings, ArrayList<String> mazeInfo) throws IOException {
    this.row = settings.get(0);
    this.col = settings.get(1);
    

    for (int i = 0; i < row; i++) { 
      for (int y = 0; y < col; y++) { 
        Icon icon = new ImageIcon(imageDecider(row, col, mazeInfo));
        JButton gridPlace = new JButton(icon);
        gridPlace.setActionCommand("Move");
        
        GridPosition elementGrid = new GridPosition(i, y, gridPlace);
        this.add(gridPlace);
        this.gridPositions.add(elementGrid);
      }
    }
    
    this.setLayout(new GridLayout(row, col));
    this.setSize(col * 100, row * 100);
    this.setVisible(true);
  }
  
  
  public String imageDecider(int row, int rol, ArrayList<String> info) { 
    return "/Users/ugoslight/Downloads/res/hallway.png";
  }
  
  public void movePlayer(String playerPos, ArrayList<String> possibleMoves) { 
    // loops through data streucture of rooms, based on the 
    // checks if its current room is a valid room to reveal. 
    // actual names. from primary names
    // with that determine north south east wwest coordinatres
    // use players location 
    //label.setVisisble(true);
    // if you can 
    int idx = 0;
    for (int i = 0; i < this.row; i++) { 
      for (int y = 0; y < this.col; y++) { 
        if (this.gridPositions.get(idx).getRow() == i && this.gridPositions.get(idx).getCol() == y) { 
          
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
  
  public Boolean playable(int row, int col, ArrayList<String> direc) { 
    System.out.println("EHEE");
    return true;
  }


}
