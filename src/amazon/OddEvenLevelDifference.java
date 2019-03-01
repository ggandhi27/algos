package amazon;

import java.util.LinkedList;

/**
 * Do a BFS and maintain a flag that will tell you whether you are summing for even or odd and give
 * the difference.
 */
class Node3 {

  int data;
  Node3 left, right;

  Node3(int item) {
    data = item;
    left = right = null;
  }
}

public class OddEvenLevelDifference {

  public static int getLevelDiff(Node3 root) {
    if (root == null) {
      return 0;
    }
    int evenSum = 0;
    int oddSum = root.data;
    LinkedList<Node3> nodes = new LinkedList<>();
    LinkedList<Boolean> oddEven = new LinkedList<>();
    nodes.add(root);
    oddEven.add(false);
    while (nodes.size() != 0) {
      Node3 tNode = nodes.removeFirst();
      boolean tOddEven = oddEven.removeFirst();
      if (tOddEven) {
        evenSum += tNode.data;
      } else {
        oddSum += tNode.data;
      }
      if (tNode.left != null) {
        nodes.add(tNode.left);
        oddEven.add(!tOddEven);
      }
      if (tNode.right != null) {
        nodes.add(tNode.right);
        oddEven.add(!tOddEven);
      }
    }
    return oddSum - evenSum;
  }

  public static void main(String[] args) {

  }
}
