package designpattern.singleton;

public class InnerClassSingleton {

  private InnerClassSingleton() {
  }

  private static class InnerClass {

    private static final InnerClassSingleton instance = new InnerClassSingleton();

    public static InnerClassSingleton getInstance() {
      return instance;
    }
  }

  public static void main(String[] args) {
    InnerClassSingleton singleton = InnerClassSingleton.InnerClass.getInstance();
  }
}
