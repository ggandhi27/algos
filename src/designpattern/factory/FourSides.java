package designpattern.factory;

public class FourSides {

  private Double x;
  private Double y;

  private FourSides(Double x, Double y) {
    this.x = x;
    this.y = y;
  }

  static class FourSidesFactory {

    public static FourSides getSquare(Double xDouble, Double yDouble) {
      return new FourSides(xDouble, xDouble);
    }

    public static FourSides getRectangle(Double xDouble, Double yDouble) {
      return new FourSides(xDouble, yDouble);
    }
  }

  public static void main(String[] args) {

    FourSides fourSides1 = FourSides.FourSidesFactory.getRectangle(3.4, 4.4);
  }
}
