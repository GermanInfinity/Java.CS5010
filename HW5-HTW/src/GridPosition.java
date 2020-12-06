import javax.swing.JButton;

/** 
 * THis class represents a position in the view grid. 
 * @author ugoslight
 *
 */
public class GridPosition {

  private JButton button; 
  private int row, col; 
  /**
   * Constructs a view grid position object.
   */
  public GridPosition(int row, int col, JButton button) {
    this.button = button; 
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
   * Returns button in grid position.
   */
  public JButton getButton() {
    return this.button;
  }

}
