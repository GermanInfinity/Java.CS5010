import java.util.Map;
import java.util.HashMap;

public class TreeTest {

  public TreeTest() {

  }

  public static void main(String[] args) {
    HashMap<String, String> test = new HashMap<String, String>();
    test.put("a", "100");
    test.put("b", "00");
    test.put("c", "01");
    test.put("d", "11");
    test.put("e", "101");

    //Tree testTree = new Tree(test);
    // testTree.buildTree();
    
    

    Node root = new Node(3);
    Node c = new Node("1", 3);
 
    
//    root.addChild(c);
//    
//    root.getChild(0).addChild("0");
//    root.getChild(0).getChild(0).addChild("0");
//    root.getChild(0).getChild(0).addChild("1");
//    root.addChild("1");
//    Node.print(root);
    
    Tree abc = new Tree(test);
    abc.callAdd();
    abc.print();
  }

}
