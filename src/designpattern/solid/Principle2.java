package designpattern.solid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

enum Colour {
  RED, GREEN, BLUE
}

enum Size {
  XS, S, M, L, XL
}

enum Fabric {
  WOLLEN, COTTON, LINEN
}

class Product {

  private Colour colour;
  private Size size;
  private Fabric fabric;
  private String description;

  public Product(Colour colour, Size size, Fabric fabric, String description) {
    this.colour = colour;
    this.size = size;
    this.fabric = fabric;
    this.description = description;
  }

  public Colour getColour() {
    return colour;
  }

  public Size getSize() {
    return size;
  }

  public Fabric getFabric() {
    return fabric;
  }

  public String getDescription() {
    return description;
  }
}

interface Specification<T> {

  boolean isSatisfied(T item);

}

interface Filter<T> {

  List<T> filter(List<T> items, Specification<T> specification);
}

class ColorSpecification implements Specification<Product> {

  private Colour colour;

  public ColorSpecification(Colour colour) {
    this.colour = colour;
  }

  @Override
  public boolean isSatisfied(Product item) {
    return item.getColour().equals(colour);
  }

}

class AndSpecification implements Specification<Product> {

  List<Specification<Product>> specifications;

  public AndSpecification(List<Specification<Product>> specifications) {
    this.specifications = specifications;
  }

  @Override
  public boolean isSatisfied(Product item) {
    for (Specification<Product> specification : specifications) {
      if (!specification.isSatisfied(item)) {
        return false;
      }
    }
    return true;
  }
}

class ProductFilter implements Filter<Product> {

  @Override
  public List<Product> filter(List<Product> items, Specification<Product> specification) {
    return items.stream().filter(specification::isSatisfied).collect(Collectors.toList());
  }

}

public class Principle2 {

  public static void main(String[] args) {
    List<Product> products = new ArrayList<>();
    products.add(new Product(Colour.RED, Size.XS, Fabric.WOLLEN, "PRODUCT1"));
    products.add(new Product(Colour.RED, Size.XS, Fabric.WOLLEN, "PRODUCT1"));
    products.add(new Product(Colour.GREEN, Size.XS, Fabric.WOLLEN, "PRODUCT2"));

    products = new ProductFilter().filter(products, new AndSpecification(Collections.singletonList(new ColorSpecification(Colour.RED))));
    return;
  }
}
