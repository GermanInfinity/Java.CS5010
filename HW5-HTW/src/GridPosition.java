import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * THis class represents a position in the view grid. 
 * @author ugoslight
 *
 */
public class GridPosition {

  private JLabel occupant;
  private int row, col;
  /**
   * Constructs a view grid position object.
   */
  public GridPosition(int row, int col, JLabel label) {
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
  

}
