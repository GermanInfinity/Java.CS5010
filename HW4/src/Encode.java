import java.util.ArrayList;
import java.util.HashMap;
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
  private String type;

  /**
   * Constructor for encoding without a dictionary.
   * 
   * @param message the message to encode
   * @param codeLength the length of the code for encoding
   */
  public Encode(String message, int codeLength) {
    if (codeLength < 2 || codeLength > 79) {
      throw new IllegalArgumentException("Cannot construct a code with length specified.");
    }

    this.message = message;
    this.codeLen = codeLength;
    this.frequencyTable = new HashMap<String, Integer>();
    this.encodingTable = new HashMap<String, String>();

    if (codeLength == 16) {
      this.type = "HEX";
    } else {
      this.type = "BINARY OR CUSTOM";
    }
  }

  /**
   * Constructor for encoding with dictionary.
   * 
   * @param message the message to encode
   * @param symbolSet the dictionary to encode with
   */
  public Encode(String message, Map<String, String> symbolSet) {
    this.message = message;
    this.symbolSet = symbolSet;
  }

  /**
   * This function encodes a message.
   * 
   * @return codeMessage the message encoded
   */
  public String encodeMessage() {
    if (this.symbolSet == null) {
      throw new IllegalArgumentException("No symbol set provided.");
    }

    String store = "";
    String codedMessage = "";
    for (int i = 0; i < this.message.length(); i++) {
      store = Character.toString(this.message.charAt(i));

      if (!this.symbolSet.containsKey(store)) {
        throw new IllegalArgumentException(
            "Every character in the message must be in the code set.");
      }

      for (String key : this.symbolSet.keySet()) {
        if (key.equals(store)) {
          codedMessage += this.symbolSet.get(key);
        }
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
   * createPriorityQueue makes a priority queue of all the elements.
   */
  public void createPriorityQueue() {
    this.queue = new PriorityQueue<SymbolNode>(new SymbolComparator());

    for (String key : this.frequencyTable.keySet()) {
      SymbolNode sym = new SymbolNode(key, this.frequencyTable.get(key));
      this.queue.add(sym);
    }
  }

  /**
   * encodedMessage returns the coded message.
   */
  public String getEncodedMessage() {
    String value = "";
    for (int i = 0; i < this.message.length(); i++) {
      String messageChar = Character.toString(this.message.charAt(i));
      value += this.encodingTable.get(messageChar);
    }

    return value;
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
   * 
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
   * 
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

        if (this.encodingTable.get(key) == null) {
          if (this.type == "HEX") {
            String value = Integer.toHexString(i);
            this.encodingTable.put(key, value);
          } else {
            int asciiNum = 48 + i;
            String asciiSymbolVal = Character.toString((char) asciiNum);
            this.encodingTable.put(key, asciiSymbolVal);
          }

        } else {
          if (this.type == "HEX") {
            String value = this.encodingTable.get(key);
            value += Integer.toHexString(i);
            this.encodingTable.put(key, value);
          } else {
            int asciiNum = 48 + i;
            String value = this.encodingTable.get(key);
            value += Character.toString((char) asciiNum);
            this.encodingTable.put(key, value);
          }

        }
      }
    }

  }

  /**
   * This function determines if the encoding table is done being built.
   * 
   * @return
   */
  public Boolean stillEncoding() {

    if (this.queue.size() == 1) {
      // Reverse encoding table here
      for (String key : this.encodingTable.keySet()) {
        String value = new StringBuilder(this.encodingTable.get(key)).reverse().toString();
        this.encodingTable.put(key, value);
      }
      System.out.println(this.encodingTable);
      return false;
    }
    return true;
  }

  /**
   * build function builds the encoding table, by popping and adding to the
   * priorityQueue.
   */
  public void build() {
    ArrayList<SymbolNode> popped = popQueue();

    updateEncodingTable(popped);
    addToQueue(popped);

  }

}
