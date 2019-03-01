package designpattern.bridge;

interface BuildCar {

  void buildCar(String name);
}

class Garage1 implements BuildCar {

  @Override
  public void buildCar(String name) {
    System.out.println("Garage1 done with " + name);
  }
}

class Garage2 implements BuildCar {

  @Override
  public void buildCar(String name) {
    System.out.println("Garage2 done with " + name);
  }
}

abstract class HandMadeCar implements BuildCar {

  protected BuildCar garage1;
  protected BuildCar garage2;

  public HandMadeCar(BuildCar garage1, BuildCar garage2) {
    this.garage1 = garage1;
    this.garage2 = garage2;
  }
}

class Toyota extends HandMadeCar {

  public Toyota(BuildCar garage1, BuildCar garage2) {
    super(garage1, garage2);
  }

  @Override
  public void buildCar(String name) {
    garage1.buildCar(name);
    garage2.buildCar(name);
  }
}

public class Demo {

  public static void main(String[] args) {
    Toyota corolla = new Toyota(new Garage1(), new Garage2());
    corolla.buildCar("corolla");
  }
}
