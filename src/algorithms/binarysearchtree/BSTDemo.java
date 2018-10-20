package algorithms.binarysearchtree;

interface Operations<T extends Comparable<T>> {

  void insert(T data);

  void findMax();

  void findMin();

  void inOrderTraversal();

  void preOrderTraversal();

  void postOrderTraversal();

  void remove(T value);
}

class BST<T extends Comparable<T>> implements Comparable<T> {

  private T data;
  private BST<T> leftChild;
  private BST<T> rightChild;

  public BST() {
  }

  public BST(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public BST<T> getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(BST<T> leftChild) {
    this.leftChild = leftChild;
  }

  public BST<T> getRightChild() {
    return rightChild;
  }

  public void setRightChild(BST<T> rightChild) {
    this.rightChild = rightChild;
  }

  @Override
  public int compareTo(T o) {
    return this.data.compareTo(o);
  }
}

class OperationImpl<T extends Comparable<T>> implements Operations<T> {

  private BST<T> root;

  @Override
  public void insert(T data) {
    if (root == null) {
      root = new BST<>(data);
    } else {
      insertHelper(data, root);
    }
  }

  @Override
  public void findMax() {
    if (root == null) {
      System.out.println("MAX: NULL");
    } else {
      findMaxHelper(root);
    }
  }

  public BST<T> findMax(BST<T> node) {
    if (node == null) {
      return null;
    } else {
      return findMaxHelper(node);
    }
  }

  @Override
  public void findMin() {
    if (root == null) {
      System.out.println("MIN: NULL");
    } else {
      findMinHelper(root);
    }
  }

  @Override
  public void inOrderTraversal() {
    System.out.println();
    inOrderTraversalHelper(root);
  }

  @Override
  public void preOrderTraversal() {
    System.out.println();
    preOrderTraversalHelper(root);
  }

  @Override
  public void postOrderTraversal() {
    System.out.println();
    postOrderTraversalHelper(root);
  }

  @Override
  public void remove(T value) {
    removeHelper(root, value);
  }

  private void insertHelper(T data, BST<T> currentNode) {
    if (currentNode.compareTo(data) < 0) {
      if (currentNode.getRightChild() == null) {
        currentNode.setRightChild(new BST<>(data));
      } else {
        insertHelper(data, currentNode.getRightChild());
      }
    } else {
      if (currentNode.getLeftChild() == null) {
        currentNode.setLeftChild(new BST<>(data));
      } else {
        insertHelper(data, currentNode.getLeftChild());
      }
    }
  }

  private BST<T> findMaxHelper(BST<T> currentNode) {
    if (currentNode.getRightChild() == null) {
      System.out.println("MAX: " + currentNode.getData());
      return currentNode;
    } else {
      return findMaxHelper(currentNode.getRightChild());
    }
  }

  private void findMinHelper(BST<T> currentNode) {
    if (currentNode.getLeftChild() == null) {
      System.out.println("MIN: " + currentNode.getData());
    } else {
      findMinHelper(currentNode.getLeftChild());
    }
  }

  private void inOrderTraversalHelper(BST<T> currentNode) {
    if (currentNode != null) {
      inOrderTraversalHelper(currentNode.getLeftChild());
      System.out.print("--> " + currentNode.getData());
      inOrderTraversalHelper(currentNode.getRightChild());
    }
  }

  private void preOrderTraversalHelper(BST<T> currentNode) {
    if (currentNode != null) {
      System.out.print("--> " + currentNode.getData());
      preOrderTraversalHelper(currentNode.getLeftChild());
      preOrderTraversalHelper(currentNode.getRightChild());
    }
  }

  private void postOrderTraversalHelper(BST<T> currentNode) {
    if (currentNode != null) {
      postOrderTraversalHelper(currentNode.getLeftChild());
      postOrderTraversalHelper(currentNode.getRightChild());
      System.out.print("--> " + currentNode.getData());
    }
  }

  BST<T> removeHelper(BST<T> currentNode, T value) {
    if (currentNode == null) {
      return null;
    }
    int x = currentNode.compareTo(value);
    if (x < 0) {
      currentNode.setRightChild(removeHelper(currentNode.getRightChild(), value));
    } else if (x > 0) {
      currentNode.setLeftChild(removeHelper(currentNode.getLeftChild(), value));
    } else {
      if (currentNode.getRightChild() == null) {
        return currentNode.getLeftChild();
      } else if (currentNode.getLeftChild() == null) {
        return currentNode.getRightChild();
      }
      BST<T> temp = findMax(currentNode.getLeftChild());
      removeHelper(currentNode, temp.getData());
      temp.setRightChild(currentNode.getRightChild());
      temp.setLeftChild(currentNode.getLeftChild());
      return temp;
    }
    return currentNode;
  }
}

public class BSTDemo {

  public static void main(String[] args) {
    OperationImpl<Integer> operation = new OperationImpl<>();
    operation.insert(20);
    operation.insert(14);
    operation.insert(23);
    operation.insert(5);
    operation.insert(19);
    operation.insert(25);
    operation.insert(3);
    operation.insert(11);
    operation.insert(17);
    operation.insert(2);
    operation.insert(4);
    operation.findMax();
    operation.findMin();
    operation.inOrderTraversal();
    operation.preOrderTraversal();
    operation.postOrderTraversal();
    operation.remove(5);
    operation.inOrderTraversal();
    return;
  }
}