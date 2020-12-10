import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;


/**
 * The interface for the view class. 
 */
public interface IView {
  
  /**
   * Get the set of feature callbacks that the view can use.
   * 
   * @param f the set of feature callbacks as a Features object
   */
  void setFeatures(Features f);
  
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