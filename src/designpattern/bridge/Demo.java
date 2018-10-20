package designpattern.bridge;

interface BuildCar {

  void buildCar(String name);
}

class HandMadeCar implements BuildCar {

  @Override
  public void buildCar(String name) {
    System.out.println("Built by handmade processes " + name);
  }
}

class AssemblyLineCar implements BuildCar {

  @Override
  public void buildCar(String name) {
    System.out.println("Built by automated processes " + name);
  }
}

abstract class AddBooster {

  protected BuildCar buildCar;

  public AddBooster(BuildCar buildCar) {
    this.buildCar = buildCar;
  }

  abstract void increasePower(int x);
}

class Corolla extends AddBooster {

  public Corolla() {
    super(new HandMadeCar());
  }

  @Override
  void increasePower(int x) {
      buildCar.buildCar("corolla");
  }
}
public class Demo {

  public static void main(String[] args) {
    Corolla corolla = new Corolla();
    corolla.increasePower(90);
  }
}
