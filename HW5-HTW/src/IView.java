import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * The interface for the view class. 
 */
public interface IView {
  
  /**
   * Set the label that is showing what the model stores.
   * 
   * @param s the value for the label
   */
  void setDisp(String s);

  /**
   * Set the listener for any actions.
   * 
   * @param listener the listener to use
   */
  void setListener(ActionListener clicks, KeyListener keys) ;

  /**
   * Display this view.
   */
  void display();
  
  /**
   * Close this view.
   */
  void close();
  
  
  /**
   * Returns current game settings. 
   */
  ArrayList<Integer> getGameConfig();
}