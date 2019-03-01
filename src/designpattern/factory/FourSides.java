package designpattern.factory;

public class FourSides {

  private Double x;
  private Double y;

  private FourSides(Double x, Double y) {
    this.x = x;
    this.y = y;
  }

  static class FourSidesFactory {

    public static FourSides getCartesian(Double xDouble, Double yDouble) {
      return new FourSides(xDouble, yDouble);
    }

    public static FourSides getPolar(Double xDouble, Double yDouble) {
      return new FourSides(2 * xDouble, 2 * yDouble);
    }
  }

  public static void main(String[] args) {

    FourSides fourSides1 = FourSides.FourSidesFactory.getPolar(3.4, 4.4);
    FourSides fourSides2 = FourSides.FourSidesFactory.getCartesian(3.2, 1.2);
  }
}
