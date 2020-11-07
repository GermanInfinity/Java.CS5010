import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Tree {
  private Node root;
  private HashMap<String, String> codingSet;
  private Node cursor;
  private int childLen;
  private Map<String, ArrayList<String>> trying;

  /**
   * This constructor prepares a tree for building more nodes.
   * 
   * @param codingSet to build tree with
   */
  public Tree(HashMap<String, String> codingSet) {
    this.codingSet = codingSet;
    this.childLen = getChildLength(this.codingSet);
    this.root = new Node(this.childLen);
    this.cursor = root;
  }
  
  

  /**
   * getChildLength get's the maximum number of unique characters in dictionary.
   * 
   * @param rootGroupNode
   * @return integer number of unique characters
   */
  public int getChildLength(HashMap<String, String> codingSet) {
    String uniqueChars = "";

    for (String key : codingSet.keySet()) {
      String strVal = codingSet.get(key);

      for (int i = 0; i < strVal.length(); i++) {
        String charVal = Character.toString(strVal.charAt(i));

        if (!uniqueChars.contains(charVal)) {
          uniqueChars += charVal;
        }
      }
    }
    return uniqueChars.length();
  }

  
  /**
   * Make LinkedList of Values in coding symbol set.
   */
  public void makeValItr() { 
    Map<String, ArrayList<String>> res = new HashMap<String, ArrayList<String>>();
    
    for (String key : codingSet.keySet()) {
      String strVal = codingSet.get(key);
      ArrayList itrVal = new ArrayList();
      for (int i = 0; i < strVal.length(); i++) {
        String charVal = Character.toString(strVal.charAt(i));
        itrVal.add(charVal);
      }
      res.put(key, itrVal);
    }
    this.trying = res;
  }
  
  public void callAdd() { 
    List dec = new ArrayList<String>();
    dec.add("1");
    dec.add("0");
    dec.add("1");
    add(this.root, dec);
    
//    List dec2 = new ArrayList<String>();
//    dec2.add("1");
//    dec2.add("0");
//    dec2.add("0");
//    dec2.add("1");
//    add(this.root, dec2);
  }
  
  public Boolean add(Node elementAt, List<String> itrVal) { 
    Node obj = new Node(itrVal.get(0), 2);
    
    if (elementAt.getChildren().size() == 0){
      //System.out.println("HEY");
      elementAt.addChild(obj);
      List<String> slicedList = itrVal.subList(1, itrVal.size());
      if (slicedList.size() == 0) { return true; } 
      add(this.root, slicedList); 
    }
    
    for (Node ele : elementAt.getChildren()) {
      if (ele.getLabel().equals(obj.getLabel())) {
        this.cursor = ele;
        List<String> slicedList = itrVal.subList(1, itrVal.size());
        add(this.cursor, slicedList);  
      }
      
      if (!ele.getLabel().equals(obj.getLabel())) {
        elementAt.addChild(obj);
        Iterator it = itrVal.iterator();
        
        if (it.hasNext()) {
          List<String> slicedList = itrVal.subList(1, itrVal.size());
          this.cursor = elementAt.getChildFromObj(obj);
          
          if (slicedList.size() == 0) { return true; } 
          add(this.cursor, slicedList);
        }
      }
      
      
    }
    
//    if (elementAt.hasChild(obj)) {
//      this.cursor = elementAt.getChildFromObj(obj);
//      //String next = (String) it.next();
//      
//      List<String> slicedList = itrVal.subList(1, itrVal.size());
//      add(this.cursor, slicedList);      
//    }
//    
//    if (!elementAt.hasChild(obj)) { 
//      
//      elementAt.addChild(obj);
//      Iterator it = itrVal.iterator();
//      
//      if (it.hasNext()) {
//        List<String> slicedList = itrVal.subList(1, itrVal.size());
//        this.cursor = elementAt.getChildFromObj(obj);
//        
//        if (slicedList.size() == 0) { return true; } 
//        add(this.cursor, slicedList);
//      }
//    }
    return true; 
  }
  
  public void print() {
    printUtil(this.root, 0);
  }

  private void printUtil(Node node, int depth) {
    for (int i = 0; i < depth; ++i) {
      System.out.print("   ");
    }

    System.out.println(node.getLabel());

    for (Node child : node.getChildren()) {
      printUtil(child, depth + 1);
    }
  }
  
//  public void addToTree() { 
//    
//    HashMap<String, String> test = new HashMap<String, String>();
//    test.put("a", "100");
//    test.put("b", "00");
//    test.put("c", "01");
//    test.put("d", "11");
//    test.put("e", "101");
//    
//    
//    for (String key : test.keySet()) { 
//      String strVal = test.get(key);
//      for (int i = 0; i < strVal.length(); i++) {
//        String charVal = Character.toString(strVal.charAt(i));
//        Node newNode = new Node(charval, 3);
//        if (root.hasChild()) { 
//          
//          
//        } 
//        
//        add(parent, newNode);
//        
//        
//      }
//      
//    }
//  }
//  
//  public Boolean add(Node parent, Node obj) { 
//    if (!parent.hasChild(obj)) { 
//      parent.addChild(obj);
//      return true;
//    }
//    Node newParent = parent.getChildFromObj(obj); 
//    Node findChild = new Node(str)
//    Node nextChild = child.getChild
//    add(child, )
//    
//  }
  /**
   * buildTree builds the tree.
   */
//  public void buildTree() {
//    for (String key : this.codingSet.keySet()) {
//      String val = this.codingSet.get(key); // pass into iterable object
//
//      for (int i = 0; i < val.length(); i++) {
//        // check if in tree
//        String charVal = Character.toString(val.charAt(i));
//        GroupNode node = new GroupNode(charVal, this.childLen);
//        // if in tree from curent location move to next val and move cursor
//        if (this.cursor.isContained(node)) {
//          this.cursor = this.cursor.move(node);
//          continue;
//        }
//        // if not in tree make node and to current node
//        this.cursor.addChild(node);
//        this.cursor = root;
//      }
//
//    }
//  }

  /**
   * toString method to see the tree.
   */
//  public String toString() {
//    while (this.cursor.hasNext()) {
//
//      if (this.cursor.next() == null) {
//        String ans = this.cursor.getValue();
//        return ans;
//      }
//      String ans = this.cursor.getValue();
//      ans += this.cursor.next().toString();
//
//      return ans;
//      break;
//    }
//
//  }

}