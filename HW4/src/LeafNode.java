/**
 * This class represents a node at height 1 in the tree. These are the leaf nodes, 
 * or nodes with no children. 
 * @author Ugo Nwachuku
 *
 */
public class LeafNode {

  private String value;
  
  /** 
   * This constructor constructs a leaf node in the tree, with a value 
   * stored in it. 
   * @param val
   */
  public LeafNode(String val) {
    this.value = val;
    
  }

}
