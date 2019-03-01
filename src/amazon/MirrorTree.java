package amazon;

import java.util.LinkedList;

/**
 * Mirror of a tree can be obtained by swapping the the nodes in BFS format.
 */
class Node5 {

  int data;
  Node5 left, right;

  Node5(int item) {
    data = item;
    left = right = null;
  }
}

public class MirrorTree {

  public static void mirror(Node5 node) {
    if (node == null) {
      return;
    }
    LinkedList<Node5> list = new LinkedList<>();
    list.add(node);
    while (list.size() > 0) {
      Node5 tmp = list.removeFirst();
      Node5 tmp2 = tmp.left;
      tmp.left = tmp.right;
      tmp.right = tmp2;
      if (tmp.left != null) {
        list.add(tmp.left);
      }
      if (tmp.right != null) {
        list.add(tmp.right);
      }
    }
  }

  public static void main(String[] args) {

  }
}
