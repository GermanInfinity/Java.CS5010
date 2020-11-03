import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class represents the tree structure of the Huffman Encoding.
 * 
 * @author Ugo Nwachuku
 *
 */
public class Tree {

  private ArrayList<GroupNode> symbolHeads;

  /**
   * This constructor constructs a starting tree for the encoding.
   */
  public Tree() {
    // TODO Auto-generated constructor stub
    this.symbolHeads = new ArrayList<GroupNode>();
  }

  /**
   * This function decides what to do with a incoming popped symbols.
   */
  public void subTreeAction(HashMap<String, Integer> poppedSymbols, int cutOff) {

    int count = 0;
    Map<String, Integer> popped = new HashMap<String, Integer>();
    for (Entry<String, Integer> entry : poppedSymbols.entrySet()) {
      String key = entry.getKey();
      Integer val = entry.getValue();

      popped.put(key, val);
      count++;

      if (count % cutOff == 0) {
        GroupNode node = new GroupNode(popped);
        if (!checkGroupNodes(node)) { 
          this.symbolHeads.add(node);
          popped = new HashMap<String, Integer>();
          continue;
        }
        
        if (checkGroupNodes(node)) {
          
        }
        
        
      }

    }
  }
  
  
  /**
   * Checks if a group node is in the tree.
   */
  public Boolean checkGroupNodes(GroupNode check) { 
    for (GroupNode in : this.symbolHeads) { 
      if (in.equals(check)) { return true; }
    }
    return false;
  }

}
