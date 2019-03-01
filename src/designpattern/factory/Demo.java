package designpattern.factory;

interface VehicleFactory<T> {

  T getMyVehicle(String type);
}

interface Car {

  void getMyCarInfo();
}

interface Bike {

  void getMyBikeInfo();
}

class Corolla implements Car {

  @Override
  public void getMyCarInfo() {
    System.out.println("In production from 1966");
  }
}

class Wrangler implements Car {

  @Override
  public void getMyCarInfo() {
    System.out.println("In production from 1987");
  }
}

class MultiStrada implements Bike {

  @Override
  public void getMyBikeInfo() {
    System.out.println("In production from 2011");
  }
}

class Avantura implements Bike {

  @Override
  public void getMyBikeInfo() {
    System.out.println("In production from 1988");
  }
}

class CarFactory implements VehicleFactory {

  @Override
  public Car getMyVehicle(String type) {
    switch (type) {
      case "SEDAN":
        return new Corolla();
      case "SUV":
        return new Wrangler();
    }
    return null;
  }
}

class BikeFactory implements VehicleFactory {

  @Override
  public Bike getMyVehicle(String type) {
    switch (type) {
      case "TOURING":
        return new MultiStrada();
      case "CHOPPER":
        return new Avantura();
    }
    return null;
  }
}

class FactoryProvider {

  public static VehicleFactory getFactory(String choice) {

    if ("Car".equalsIgnoreCase(choice)) {
      return new CarFactory();
    } else if ("Bike".equalsIgnoreCase(choice)) {
      return new BikeFactory();
    }
    return null;
  }
}

public class Demo {

  public static void main(String[] args) {

    CarFactory carFactory = (CarFactory) FactoryProvider.getFactory("Car");
    carFactory.getMyVehicle("SUV").getMyCarInfo();
  }
}
