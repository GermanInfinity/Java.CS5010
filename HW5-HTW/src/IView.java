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