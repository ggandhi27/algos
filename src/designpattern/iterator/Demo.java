package designpattern.iterator;

import java.util.Iterator;
import java.util.Stack;

class Node<T extends Comparable<T>> {

  private T data;
  private Node<T> left, right;

  public Node(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public Node<T> getLeft() {
    return left;
  }

  public Node<T> getRight() {
    return right;
  }

  public void setLeft(Node<T> left) {
    this.left = left;
  }

  public void setRight(Node<T> right) {
    this.right = right;
  }

  public Iterator<T> iterator() {
    return new Itr<>(this);
  }
}

class Itr<T extends Comparable<T>> implements Iterator<T> {

  private Stack<Node<T>> stack = new Stack<>();

  public Itr(Node<T> node) {
    fillStack(node);
  }

  @Override
  public boolean hasNext() {
    return stack.size() > 0;
  }

  @Override
  public T next() {
    Node<T> temp = stack.pop();
    fillStack(temp.getRight());
    return temp.getData();
  }

  private void fillStack(Node<T> node) {
    if (node == null) {
      return;
    }
    stack.push(node);
    fillStack(node.getLeft());
  }
}

public class Demo {

  private static Node<Integer> rootNode = null;

  private static <T extends Comparable<T>> Node<T> insert(Node<T> node, T data) {
    if (node == null) {
      node = new Node<>(data);
      return node;
    } else if (data.compareTo(node.getData()) >= 0) {
      Node<T> tmp = insert(node.getRight(), data);
      if (node.getRight() == null) {
        node.setRight(tmp);
      }
      return node.getRight();
    } else {
      Node<T> tmp = insert(node.getLeft(), data);
      if (node.getLeft() == null) {
        node.setLeft(tmp);
      }
      return node.getLeft();
    }
  }

  public static void main(String[] args) {

    int[] arr = {38, 13, 51, 10, 12, 40, 84, 25, 89, 37, 66, 95};
    for (int i = 0; i < arr.length; i++) {
      if (rootNode == null) {
        rootNode = new Node<>(arr[i]);
      } else {
        insert(rootNode, arr[i]);
      }
    }
    Iterator<Integer> itr = rootNode.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }
}
