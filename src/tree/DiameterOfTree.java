package tree;

// Recursive Java program to find the diameter of a
// Binary Tree

/* Class containing left and right child of current
node and key value*/
class Node {

  int data;
  Node left, right;

  public Node(int item) {
    data = item;
    left = right = null;
  }
}

/* Class to print the Diameter */
class BinaryTree {

  Node root;
}

public class DiameterOfTree {

  static int max = 0;

  public static int[] result(Node node) {
    if (node == null) {
      return new int[]{0, 0};
    }
    int lt[] = result(node.left);
    int rt[] = result(node.right);
    return new int[]{
        Math.max(rt[0], Math.max(1 + rt[1] + lt[1], lt[0])),
        1 + Math.max(lt[0], rt[0])};
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    System.out.println(result(tree.root)[0]);
    System.out.println(max);
  }
}

