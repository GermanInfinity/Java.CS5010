import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class represents the tables involved in building a Huffman encoding.
 * This class is primarily concerned with maintaining and updating the state of
 * the encoding table.
 * 
 * @author Ugo Nwachuku
 *
 */
public class State {

  private Map<String, Integer> frequencyTable;
  private Map<String, String> encodingTable;
  private ArrayList<SymbolNode> priorityQueue;
  private int rangeOfSymbols;
  private String message;

  /**
   * Constructor for the state of the tables for the Huffman encoding.
   * 
   * @param num represents the range of symbols to code with.
   */
  public State(String message, int numOfSymbols) {
    if (numOfSymbols < 2) {
      throw new IllegalArgumentException(" You cannot code with anything less than 2 symbol.");
    }
    this.rangeOfSymbols = numOfSymbols;
    this.message = message;
    this.frequencyTable = new HashMap<String, Integer>();
    this.encodingTable = new HashMap<String, String>();
  }

  /**
   * This function creates the frequency table for the Huffman encoding
   * algorithm.
   * 
   * @return void
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
   * This function creates the priorty queeu
   */
  public void createPriorityQueue() { 
    ArrayList<SymbolNode> pQueue = new ArrayList<SymbolNode>();
    
    for (String key : this.frequencyTable.keySet()) {
      pQueue.add(new SymbolNode(key, this.frequencyTable.get(key)));
    }

    Collections.sort(pQueue);
    pQueue = lexHelper(pQueue);
    
    this.priorityQueue = pQueue;
  }
  
  /**
   * This function pops n number of elements from the priority queue.
   */
  public ArrayList<SymbolNode> popQueue() {
    ArrayList<SymbolNode> poppedSymbols = new ArrayList<SymbolNode>();
    for (int i = 0; i < this.rangeOfSymbols; i++) {
      poppedSymbols.add(this.priorityQueue.remove(0));
    }
   
    updatePriorityQueue(poppedSymbols);
    updateEncodingTable(poppedSymbols);
    for (SymbolNode ele : this.priorityQueue) {
      System.out.println(ele.toString());
    }
    System.out.println(this.encodingTable);
    
    return poppedSymbols;
  }
  
  /**
   * This function updates the priority queue after symbols are popped.
   */
  public void updatePriorityQueue(ArrayList<SymbolNode> poppedSymbols) {
    String symbolName = ""; 
    int totalNum = 0;
    for (int i = 0; i < poppedSymbols.size(); i++) { 
      symbolName += poppedSymbols.get(i).getSymbol(); 
      totalNum += poppedSymbols.get(i).getValue(); 
    }
    SymbolNode newSymbol = new SymbolNode(symbolName, totalNum); 
    this.priorityQueue.add(newSymbol);
    
    Collections.sort(this.priorityQueue);
    this.priorityQueue = lexHelper(this.priorityQueue);    
  }
  
  /**
   * This function updates the encoding table.
   */
  public void updateEncodingTable(ArrayList<SymbolNode> poppedSymbols) {
    // Grab all individual symbols
    ArrayList<String> symbolsToUpdate = new ArrayList<String>();
    for (int i = 0; i < poppedSymbols.size(); i++) { 
      String symbol = poppedSymbols.get(i).getSymbol();
      for (int j = 0; j < symbol.length(); j++) {
        String addStr = Character.toString(symbol.charAt(j));
        symbolsToUpdate.add(addStr);
      }
    }
    
    //Update encoding Table
    for (int i = 0; i < symbolsToUpdate.size(); i++) { 
      String key = symbolsToUpdate.get(i);
      String value = this.encodingTable.get(key);
      value += Integer.toString(i);
      this.encodingTable.put(key, value);
    }
  }
  
  /**
   * This function helps with lexicographical ordering of queue. 
   */
  public ArrayList<SymbolNode> lexHelper(ArrayList<SymbolNode> queue) {
    for (int i = 0; i < queue.size()-1; i++) {
      for (int j = i + 1; j < queue.size(); j++) {
        if (queue.get(i).equalFrequency(queue.get(j))) {
          if (queue.get(i).lexCompare(queue.get(j)) > 0) {
            SymbolNode temp = queue.get(i);
            queue.set(i, queue.get(j));
            queue.set(j, temp);
          }
        } 
      }
    }
    return queue;
  }

}
