package amazon;

/**
 * Minimum element of a BST is extreme left child.
 */
class Node4
{
  int data;
  Node4 left,right;

  Node4(int d)
  {
    data = d;
    left = right = null;
  }
}

public class MinimumElementInBst {

  int minValue(Node4 node)
  {
    if(node == null) {
      return -1;
    }
    int min = Integer.MAX_VALUE;
    while (node != null) {
      min = node.data;
      node = node.left;
    }
    return min;
  }

  public static void main(String[] args) {

  }
}
