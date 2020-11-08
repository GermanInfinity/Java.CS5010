import java.util.ArrayList;
import java.util.Map;

/**
 * Representation of an internal node in the tree.
 * 
 * @param value value node holds
 * @param symbolSet symbol set of codes
 */
public class TreeNode implements GroupNode {

  private String value;
  private ArrayList<GroupNode> children;
  private Map<String, String> symbolSet;

  /**
   * Constructor for this internal node.
   * 
   * @param value the value stored in this node
   * @param the symbol set for decoing
   */
  public TreeNode(String value, Map<String, String> symbolSet) {
    this.value = value;
    this.children = new ArrayList<GroupNode>(symbolSet.size());
    this.symbolSet = symbolSet;

  }

  @Override
  public GroupNode add(GroupNode node) {
    this.children.add(node);
    return node;
  }

  @Override
  public String toString() {
    return "Value at Node: " + this.value;
  }

  /**
   * inOrder traversal traverses and views the tree in an in order fashion.
   * 
   * @param node starting node to traverse
   */
  public void inOrder(GroupNode node) {

    if (node.getClass().getSimpleName().equalsIgnoreCase("LeafNode")) {
      LeafNode leaf = (LeafNode) node;
      return;
    }
    TreeNode innerNode = (TreeNode) node;
    for (GroupNode child : innerNode.children) {
      inOrder(child);
      System.out.println(child.toString());
    }

  }

}
