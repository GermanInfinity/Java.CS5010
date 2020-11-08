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

    
    Tree treeTest = new Tree(test);
    
    
  }

}
