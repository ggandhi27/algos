package designpattern.decorator;

// Dynamic decorator
interface buildCar {

  void build();
}

class Car implements buildCar {

  private String name;
  private String bhp;

  public Car(String name, String bhp) {
    this.name = name;
    this.bhp = bhp;
  }

  @Override
  public void build() {
    System.out.println("Building normal car " + name + " with bhp " + bhp);
  }
}

class MuscleCar implements buildCar {

  private Car car;
  private String booster;

  public MuscleCar(Car car, String booster) {
    this.car = car;
    this.booster = booster;
  }

  @Override
  public void build() {
    car.build();
    System.out.println("Adding booster " + booster);
  }
}

public class Demo {

  public static void main(String[] args) {
    MuscleCar muscleCar = new MuscleCar(new Car("corolla","250"), "100");
    muscleCar.build();
  }
}
