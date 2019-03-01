package tree;

public class ConvertTreeToDLL {

  static Node ptr = null;

  public static void convert(Node node) {
    if (node == null) {
      return;
    }
    convert(node.left);
    if (ptr != null) {
      node.left = ptr;
      ptr.right = node;
    }
    ptr = node;
    convert(node.right);
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
    convert(tree.root);

    Node ptr = tree.root;
    while (ptr.left != null) {
      ptr = ptr.left;
    }
    while (ptr!=null) {
      System.out.println(ptr.data);
      ptr = ptr.right;
    }
  }
}
