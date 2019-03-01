package tree;

import java.util.LinkedList;
import java.util.ListIterator;

public class TraverseTreeInSpiralForm {

  public static void traversal(Node root) {
    int direction = 0;
    LinkedList<Node> list1 = new LinkedList<>();
    LinkedList<Node> list2 = new LinkedList<>();
    list1.add(root);
    while (true) {
      if (list1.size() == 0 && list2.size() == 0) {
        break;
      }
      if (direction == 0) {
        ListIterator<Node> itr = list1.listIterator(list1.size());
        while (itr.hasPrevious()) {
          Node node = itr.previous();
          System.out.println(node.data);
          if (node.right != null) {
            list2.add(node.right);
          }
          if (node.left != null) {
            list2.add(node.left);
          }
        }
        list1.clear();
        direction = 1;
      } else if (direction == 1) {
        ListIterator<Node> itr = list2.listIterator(list2.size());
        while (itr.hasPrevious()) {
          Node node = itr.previous();
          System.out.println(node.data);
          if (node.left != null) {
            list1.add(node.left);
          }
          if (node.right != null) {
            list1.add(node.right);
          }
        }
        list2.clear();
        direction = 0;
      }
    }
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(7);
    tree.root.left.right = new Node(6);
    tree.root.right.left = new Node(5);
    tree.root.right.right = new Node(4);
    System.out.println("Spiral Order traversal of Binary Tree is ");
    traversal(tree.root);
  }
}
