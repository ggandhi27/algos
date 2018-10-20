package designpattern.solid;

class Rectangle {

  Integer length;
  Integer breadth;

  public Rectangle(Integer length, Integer breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public void setBreadth(Integer breadth) {
    this.breadth = breadth;
  }

  public Integer getLength() {
    return length;
  }

  public Integer getBreadth() {
    return breadth;
  }

  public Integer getArea() {
    return this.breadth * this.length;
  }
}

class Square extends Rectangle {

  Integer side;

  public Square(Integer side) {
    super(side, side);
    this.side = side;
  }

}

class ExtraFunctionality {

  public Integer expandTheArea(Rectangle rectangle) {
    rectangle.setLength(rectangle.getLength() * 2);
    return rectangle.getArea();
  }

}

public class Principle3 {

  public static void main(String[] args) {
    ExtraFunctionality extraFunctionality = new ExtraFunctionality();
    Rectangle rectangle = new Rectangle(10, 20);
    System.out.println("Area Calculated to be " + extraFunctionality.expandTheArea(rectangle));
    Rectangle rectangle1 = new Square(10);
    System.out.println("Area Calculated to be " + extraFunctionality.expandTheArea(rectangle1));
  }
}
