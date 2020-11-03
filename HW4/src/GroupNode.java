import java.util.ArrayList;
import java.util.Map;

/**
 * Representation of an internal node in the tree.
 *
 */
public class GroupNode {

  private int data;
  private ArrayList<LeafNode> children;

  /**
   * Constructor for the internal node of the tree. 
   * 
   * @param data the data stored in this node
   */
  public GroupNode(Map<String, Integer> poppedInQueue) {
    
    // Get the head of the sub-tree in Tree. 
    int sum = 0; 
    for (int val : poppedInQueue.values()) {
      sum += val;
    }
    this.data = sum;
    
    // Add to arrayList for all children. 
    for (String key : poppedInQueue.keySet()) {
      LeafNode child = new LeafNode(key);
      children.add(child);
    }
  }
  
  
  
}
