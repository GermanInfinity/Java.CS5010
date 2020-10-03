
/**
 * This interface represents the WearableGear interface. It is a concise
 * abstraction and declaration functions used by classes that extend the
 * interface.
 */

public interface WearableGear {

  /**
   * setName: This function sets the name of wearable gear.
   * 
   * @param: String name Returns: nothing
   */
  public void setName(String name);

  /**
   * getName: This function gets the name of wearable gear.
   * 
   * @param: No parameters Returns: String
   */
  public String getName();

  /**
   * getAdjective: This function gets the adjective of wearable gear.
   * 
   * @param: No parameters Returns: String
   */
  public String getAdjective();

  /**
   * toString: This function returns the string representation of a wearable
   * gear.
   * 
   * @param: No parameters Returns: String
   */
  public String toString();

}
