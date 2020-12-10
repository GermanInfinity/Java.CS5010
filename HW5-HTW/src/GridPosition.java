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

  private JButton button; 
  private JPanel panel;
  private JLabel occupant;
  private int row, col; 
  /**
   * Constructs a view grid position object.
   */
  public GridPosition(int row, int col, JButton button, JLabel label) {
    this.button = button; 
    this.occupant = label;
    this.row = row; 
    this.col = col; 
    this.panel = new JPanel();
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
  
  public void addPerson(JLabel visitor) { 
    button.setLayout(new GridBagLayout());
    button.add(visitor, new GridBagConstraints());
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.setLayout(new BorderLayout());
    this.panel.add(button, BorderLayout.CENTER);
    this.panel.setVisible(true);
  }

}
