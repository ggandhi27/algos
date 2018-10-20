package designpattern.singleton;

public class DoubleLockSingleton {

  private static DoubleLockSingleton instance;

  private DoubleLockSingleton() {

  }

  public static DoubleLockSingleton getInstance() {
    if (instance == null) {
      synchronized (DoubleLockSingleton.class) {
        if (instance == null) {
          instance = new DoubleLockSingleton();
        }
      }
    }
    return instance;
  }

  public static void main(String[] args) {
    DoubleLockSingleton instance = DoubleLockSingleton.getInstance();
    System.out.println(instance);
  }

  @Override
  public String toString() {
    return "DoubleLockSingleton{}";
  }
}

