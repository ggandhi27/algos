package designpattern.proxy;

interface Drivable {

  void drive();
}

class Driver {

  private int age;

  public Driver(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }
}

class Car implements Drivable {

  private Driver driver;

  public Car(Driver driver) {
    this.driver = driver;
  }

  @Override
  public void drive() {
    System.out.println("Driving @ " + driver.getAge());
  }
}

class CarProxy extends Car {

  private Driver driver;

  public CarProxy(Driver driver) {
    super(driver);
    this.driver = driver;
  }

  @Override
  public void drive() {
    if (driver.getAge() < 18) {
      System.out.println("not allowed to driver");
    } else {
      super.drive();
    }
  }
}

public class SafetyProxyDemo {

  public static void main(String[] args) {
    CarProxy carProxy = new CarProxy(new Driver(17));
    carProxy.drive();
    carProxy = new CarProxy(new Driver(19));
    carProxy.drive();
  }
}
