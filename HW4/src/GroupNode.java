
/**
 * Interface the represents a node in the tree.
 * 
 */
public interface GroupNode {

  /**
   * Add the given node as a child to a node in this Group identified by the
   * predicate. If no node is identified by the predicate the Group remains
   * unchanged.
   * 
   * @return the resulting hierarchy starting at this node
   */
  GroupNode add(GroupNode nodeToAdd);

}
