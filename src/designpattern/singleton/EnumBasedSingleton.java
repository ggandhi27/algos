package designpattern.singleton;

enum Singleton1 {
  INSTANCE;

  Integer value;

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }
}

public class EnumBasedSingleton {

  public static void main(String[] args) {
    Singleton1 singleton1 = Singleton1.INSTANCE;
    singleton1.setValue(5);
  }
}
