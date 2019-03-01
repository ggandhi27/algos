package designpattern.decorator;

// Static using generics.
interface BuildShape {

  void build();
}

class Circle implements BuildShape {

  private int radius;

  @Override
  public void build() {
    System.out.println("Build circle with a radius of " + radius);
  }
}

class Square implements BuildShape {

  private int side;

  public Square(int side) {
    this.side = side;
  }

  @Override
  public void build() {
    System.out.println("Build square with sides " + side);
  }
}

class GlowingShape<T extends BuildShape> implements BuildShape {

  private T t;
  private int glow;

  public GlowingShape(T t, int glow) {
    this.t = t;
    this.glow = glow;
  }

  @Override
  public void build() {
    t.build();
    System.out.println(glow);
  }
}

public class Demo1 {

  public static void main(String[] args) {
    GlowingShape<Square> glowingSquare = new GlowingShape<>(new Square(10), 5);
    glowingSquare.build();
  }
}
