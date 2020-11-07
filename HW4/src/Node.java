import java.util.ArrayList;

/**
 * This class represents a node in the tree.
 * 
 * @author ugoslight
 *
 */
public class Node {

  private String label;
  private int childrenNum;
  private final ArrayList<Node> children;

  public Node(int childrenNum) {
    this.label = "root";
    this.childrenNum = childrenNum;
    this.children = new ArrayList<Node>(childrenNum);
  }

  public Node(String value, int childrenNum) {
    this.label = value;
    this.childrenNum = childrenNum;
    this.children = new ArrayList<Node>(childrenNum);
  }

  public boolean addChild(Node node) {
    if (children.size() < childrenNum) {
      return children.add(node);
    }

    return false;
  }


  public ArrayList<Node> getChildren() {
    return this.children;
  }

  public Node getChild(int idx) {
    if (idx < this.childrenNum) {
      return this.children.get(idx);
    }
    return null;
  }
  
  public Node getChildFromObj(Node obj) {
    int idx = this.children.indexOf(obj);
    return this.children.get(idx);
  }

  public Boolean hasChild(Node obj) { 
    if (this.children.contains(obj)) { return true; }
    return false;
  }
  public String getLabel() {
    return this.label;
  }

  public String toString() {
    return getLabel();
  }

  public static void print(Node root) {
    printUtil(root, 0);
  }

  private static void printUtil(Node node, int depth) {
    for (int i = 0; i < depth; ++i) {
      System.out.print("   ");
    }

    System.out.println(node.label);

    for (Node child : node.getChildren()) {
      printUtil(child, depth + 1);
    }
  }

 

}
