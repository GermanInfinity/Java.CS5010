import java.util.Comparator;

/**
 * This class represents the comparator used in a priority queue.
 * 
 * @author Ugo Nwachuku
 *
 */
public class SymbolComparator implements Comparator<SymbolNode> {

  @Override
  public int compare(SymbolNode o1, SymbolNode o2) {
    if (o1.getValue() == o2.getValue()) {
      return o1.compareTo(o2);
    }

    if (o1.getValue() < o2.getValue()) {
      return -1;
    } else if (o1.getValue() > o2.getValue()) {
      return 1;
    }

    return 0;
  }

}
