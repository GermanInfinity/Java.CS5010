
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * THis class represents a position in the view grid.
 * 
 * @author ugoslight
 *
 */
public class GridPosition {

  private JLabel occupant;
  private ImageIcon icon;
  private int row;
  private int col;
  private Boolean tunnel;
  private Boolean isVisible;

  /**
   * Constructs a view grid position object.
   */
  public GridPosition(int row, int col, JLabel label) {
    if (row < 0) {
      throw new IllegalArgumentException("Please provide a positive row number.");
    }
    if (col < 0) {
      throw new IllegalArgumentException("Please provide a positive column number.");
    }
    if (label == null) {
      throw new IllegalArgumentException("Please provide a JLabel.");
    }
    
    this.occupant = label;
    this.row = row;
    this.col = col;

  }

  /**
   * Returns row position of grid position.
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Returns column position of grid position.
   */
  public int getCol() {
    return this.col;
  }

  /**
   * getLabel returns label in grid position.
   */
  public JLabel getLabel() {
    return this.occupant;
  }

  /**
   * setLabel sets label in grid position.
   */
  public void setLabel(JLabel lab) {
    this.occupant = lab;
  }

  /**
   * addIcon stores an icon in this position.
   */
  public void addIcon(ImageIcon i) {
    this.icon = i;
  }

  /**
   * getIcon returns an icon storedin this position.
   */
  public ImageIcon getIcon() {
    return this.icon;
  }

  /**
   * setTunnel sets if a grid position is a tunnel.
   */
  public void setTunnel(Boolean isTunnel) {
    this.tunnel = isTunnel;
  }

  /**
   * Returns if a grid position is a tunnel or not.
   */
  public Boolean isTunnel() {
    return this.tunnel;
  }

  /**
   * Sets if a position is visible.
   */
  public void setIsVisible(Boolean t) {
    this.isVisible = t;
  }

  /**
   * Returns if visible.
   */
  public Boolean isVisible() {
    return this.isVisible;
  }

}
