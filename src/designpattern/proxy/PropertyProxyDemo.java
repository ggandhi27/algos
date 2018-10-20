package designpattern.proxy;

class Property<T> {

  private T value;

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}

class Car2 {

  private Property<String> name;

  public Car2() {
    name = new Property<>();
    name.setValue("abhishek");
    System.out.println(name.getValue());
  }
}
public class PropertyProxyDemo {

  public static void main(String[] args) {
    Car2 car2 = new Car2();
  }
}
