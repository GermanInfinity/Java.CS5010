
public class SymbolNode implements Comparable<SymbolNode>{

  private String symbol;
  private Integer value;
  
  public SymbolNode(String sym, int num) {
    this.symbol = sym;
    this.value = num;
  }
  
  public int lexCompare(SymbolNode node) { 
    return this.symbol.compareTo(node.symbol);
  }
  
  @Override
  public int compareTo(SymbolNode node) {
    return this.value.compareTo(node.value);
  }
  
  public Boolean equalFrequency(SymbolNode node) { 
    if (this.getValue() == node.getValue()) { return true; } 
    return false;
  }
  
  public String getSymbol() { 
    return this.symbol;
  }

  
  public int getValue() { 
    return this.value;
  }

  @Override
  public String toString() { 
    return symbol + " " + value;
  }

}
