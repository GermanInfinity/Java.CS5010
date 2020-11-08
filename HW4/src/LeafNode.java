/**
 * This class represents a node at height 1 in the tree. These are the leaf
 * nodes, or nodes with no children.
 * 
 * @author Ugo Nwachuku
 *
 */
public class LeafNode implements GroupNode {

  private String value;

  /**
   * This constructor constructs a leaf node in the tree, with a value stored in
   * it.
   * 
   * @param val
   */
  public LeafNode(String val) {
    this.value = val;
  }

  @Override
  public String toString() {
    return "Value at Leaf: " + this.value;
  }

  @Override
  public GroupNode add(GroupNode nodeToAdd) {
    return null;
  }

}
