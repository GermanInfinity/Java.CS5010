/**
 * This class represents a symbol node that goes into a priority queue.
 * @author Ugo Nwachuku
 *
 */
public class SymbolNode implements Comparable <SymbolNode> {

  private String symbol;
  private Integer value;
  
  /**
   * Constructor makes a symbol node. 
   * @param sym string value of node
   * @param num integer value of node
   */
  public SymbolNode(String sym, int num) {
    this.symbol = sym;
    this.value = num;
  }
  
  @Override
  public int compareTo(SymbolNode node) {
    return this.symbol.compareTo(node.symbol);
  }
  
  /**
   * Returns symbol of node.
   */
  public String getSymbol() { 
    return this.symbol;
  }
  
  /**
   * Returns value of node.
   */
  public int getValue() { 
    return this.value;
  }

  @Override
  public String toString() { 
    return symbol + " " + value;
  }

  
  
}



