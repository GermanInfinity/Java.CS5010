import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Representation of a tree structure.
 * 
 * @param codingSet symbol set of codes
 */
public class Tree {

  private TreeNode root;
  private Map<String, String> codingSet;

  /**
   * Constructor for tree data structure.
   * 
   * @param codingSet to build tree with
   */
  public Tree(HashMap<String, String> codingSet) {
    this.root = new TreeNode("root", codingSet);
    this.codingSet = codingSet;

    Boolean abc = addToTree("100", this.root);
    Boolean abc3 = addToTree("010", this.root);

    inOrder();
  }

  /**
   * addToTree add's a node to the tree.
   * 
   * @param value of node to be added
   * @param node node to start adding from
   */
  public Boolean addToTree(String value, GroupNode node) {

    if (value.length() == 0) {
      node.add(new LeafNode("a"));
      return true;
    }

    String newVal = Character.toString(value.charAt(0));
    value = value.substring(1, value.length());

    TreeNode nodeToAdd = new TreeNode(newVal, codingSet);

    GroupNode newNode = node.add(nodeToAdd);
    addToTree(value, newNode);

    return true;

  }

  /**
   * inOrder traverses and views the tree in an i order fashion.
   */
  public void inOrder() {
    this.root.inOrder(this.root);
  }

}