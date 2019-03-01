package amazon;

import java.util.LinkedList;

/**
 * BFS / DFS anything can be used to find the depth of the tree. Below solution implements BFS.
 */
class Node2 {

  int data;
  Node2 left, right;

  Node2(int item) {
    data = item;
    left = right = null;
  }
}

public class HeightOfBinaryTree {

  public static int height(Node2 node) {
    if (node == null) {
      return 0;
    }
    int maxHeight = 1;
    LinkedList<Node2> nodes = new LinkedList<>();
    LinkedList<Integer> heights = new LinkedList<>();
    nodes.add(node);
    heights.add(1);
    while (nodes.size() != 0) {
      Node2 tNode = nodes.removeFirst();
      int tHeight = heights.removeFirst();
      maxHeight = tHeight;
      if (tNode.left != null) {
        nodes.add(tNode.left);
        heights.add(tHeight + 1);
      }
      if (tNode.right != null) {
        nodes.add(tNode.right);
        heights.add(tHeight + 1);
      }
    }
    return maxHeight;
  }
}
