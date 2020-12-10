
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import java.io.IOException;
import java.util.ArrayList;

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

  /**
   * Constructor for view object.
   * 
   * @param caption of frame
   * @throws IOException
   */
  public GameView(String caption) throws IOException {
    super(caption);
    this.gridPositions = new ArrayList<GridPosition>();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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


  public void startGame() {
    // this.add(comp)
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

    Icon cave = new ImageIcon("/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/circle-cropped.png");
    Icon hallway = new ImageIcon(
        "/Users/ugoslight/eclipse-workspace/cs5010/HW5-HTW/images/cavePath.png");
    String imSwitch = "Cave";
    // place caves, hallways, walls.tunnels, wumpus, superbats

    // PLACE CAVE
    for (int i = 0; i < actualRow; i++) {
      for (int y = 0; y < actualCol; y++) {
         
        JButton gridPlace = new JButton(cave);
        gridPlace.setVisible(true);
        gridPlace.setActionCommand("Move");

        GridPosition elementGrid = new GridPosition(i, y, gridPlace);
        this.add(gridPlace);
        this.gridPositions.add(elementGrid);

      }
    }

    // PLACE HALLWAYS
    // for (int i = 1; i < this.actualRow * this.actualCol; i++) {
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

    this.setLayout(new GridLayout(actualRow, actualCol));
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

  public Boolean playable(int row, int col, ArrayList<String> direc) {
    System.out.println("EHEE");
    return true;
  }

  @Override
  public ArrayList<Integer> getGameConfig() {
    // TODO Auto-generated method stub
    return null;
  }

}
