import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * This class is responsible for encoding a provided message, with or without a
 * dictionary.
 * 
 * @author Ugo Nwachuku
 *
 */
public class Encode {

  private String message;
  private int codeLen;
  private Map<String, Integer> frequencyTable;
  private Map<String, String> encodingTable;
  private PriorityQueue<SymbolNode> queue;
  private Map<String, String> symbolSet;

  /**
   * This is the constructor for encoding without a dictionary. 
   * @param message the message to encode
   * @param codeLength the length of the code for encoding
   */
  public Encode(String message, int codeLength) {
    if (codeLength < 2) {
      throw new IllegalArgumentException("Cannot construct a code with length specified.");
    }
    this.message = message;
    this.codeLen = codeLength;
    this.frequencyTable = new HashMap<String, Integer>();
    this.encodingTable = new HashMap<String, String>();
  }
  
  /**
   * This constructor encodes based on dictionary provided by user.
   * @param message  the message to encode
   * @param symbolSet the dictionary to encode with 
   */
  public Encode(String message, Map<String, String> symbolSet) {
    this.message = message;
    this.symbolSet = symbolSet;
  }

  /**
   * THis function encodes a message. 
   * @return codeMessage the message encoded
   */
  public String encodeMessage() { 
    String store = "";
    String codedMessage = "";
    for (int i = 0; i < this.message.length(); i++) {
      store += Character.toString(this.message.charAt(i));
      
      
      if (this.symbolSet.containsValue(store)) { 
        // get key 
        for (String key : this.symbolSet.keySet()) { 
          if (store.equals(this.symbolSet.get(key))) {
            codedMessage += key;
          }
        }
        //reset store
        store = "";
      }
    }
    
    
    return codedMessage;
  }
  
  /**
   * createFrequencyTable makes a frequency table for the encoding.
   */
  public void createFrequencyTable() {
    int count;
    for (int i = 0; i < this.message.length(); i++) {
      count = 1;
      if (this.frequencyTable.containsKey(Character.toString(message.charAt(i)))) {
        continue;
      }

      for (int y = i + 1; y < this.message.length(); y++) {
        String a = Character.toString(message.charAt(i));
        String b = Character.toString(message.charAt(y));
        if (a.equals(b)) {
          count++;
        }
      }
      this.frequencyTable.put(Character.toString(message.charAt(i)), count);
    }
  }
  
  /**
   * This function creates an encoding table.
   */
  public void createEncodingTable() { 
    for (String ele : this.frequencyTable.keySet()) { 
      this.encodingTable.put(ele, "");
    }
  }

  /**
   * createPriorityQueue makes a priority queue of all the elements.
   */
  public void createPriorityQueue() {
    this.queue = new PriorityQueue<SymbolNode>(new symbolComparator());

    for (String key : this.frequencyTable.keySet()) {
      SymbolNode sym = new SymbolNode(key, this.frequencyTable.get(key));
      this.queue.add(sym);
    }
   
  }
  
  /**
   * This function determines if the encoding table is done being built.
   * @return
   */
  public Boolean stillEncoding() { 
    
    if (this.queue.size() == 1) {
      return false;
    }
    return true;
  }
  
  /**
   * encodedMessage returns the coded message.
   */
  public String encodedMessage() { 
    String value = "";
    for (int i = 0; i < this.message.length(); i++) { 
      String messageChar = Character.toString(this.message.charAt(i));
      value += this.encodingTable.get(messageChar);
    }
    
    return value; 
  }

  /**
   * build function builds the encoding table, by popping and adding to the
   * priorityQueue.
   */
  public void build() {
    ArrayList<SymbolNode> popped = popQueue();
    updateEncodingTable(popped);
    addToQueue(popped);
    
    System.out.println(this.queue);
    //System.out.println(this.encodingTable);
    
    
  }

  /**
   * popQueue pops symbol nodes from the queue.
   */
  public ArrayList<SymbolNode> popQueue() {
    ArrayList<SymbolNode> popped = new ArrayList<SymbolNode>();

    for (int i = 0; i < this.codeLen; i++) {
      popped.add(this.queue.poll());
    }
    return popped;
  }

  /**
   * addToQueue adds popped elements back into priority queue.
   * @param popped array list of popped elements
   */
  public void addToQueue(ArrayList<SymbolNode> popped) {
    String symbolName = "";
    int totalNum = 0;
    

    for (int i = 0; i < popped.size(); i++) {
      if (popped.get(i) == null) {
        continue;
      }
      symbolName += popped.get(i).getSymbol();
      totalNum += popped.get(i).getValue();
    }
    SymbolNode newSymbol = new SymbolNode(symbolName, totalNum);
    this.queue.add(newSymbol);

  }
  
  /**
   * This function updates the encoding table.
   * @param poppedSymbols are popped symbols from priority queue
   */
  public void updateEncodingTable(ArrayList<SymbolNode> poppedSymbols) {
  
    for (int i = 0; i < poppedSymbols.size(); i++) { 
      if (poppedSymbols.get(i) == null) { 
        continue; 
      }
      
      String symbol = poppedSymbols.get(i).getSymbol();
      
      for (int j = 0; j < symbol.length(); j++) {
        
        String key = Character.toString(symbol.charAt(j));
        String value = this.encodingTable.get(key);
        value += Integer.toString(i); //this needs to change
        this.encodingTable.put(key, value);  
      }
    }
    
    // Reverse Values
//    for (String key : this.encodingTable.keySet()) {
//      String value = new StringBuilder(this.encodingTable.get(key)).reverse().toString();
//      this.encodingTable.put(key, value);  
//    }
    
  }

  

}
