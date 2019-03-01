package designpattern.composite;

import java.util.ArrayList;
import java.util.List;

class GraphObject {

  private String shape;
  private String color;
  private List<GraphObject> childs;

  public GraphObject(String shape, String color) {
    this.shape = shape;
    this.color = color;
  }

  public String getShape() {
    return shape;
  }

  public void setShape(String shape) {
    this.shape = shape;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public List<GraphObject> getChilds() {
    return childs;
  }

  public void setChilds(List<GraphObject> childs) {
    this.childs = childs;
  }

  @Override
  public String toString() {
    return "GraphObject{" +
        "shape='" + shape + '\'' +
        ", color='" + color + '\'' +
        '}';
  }
}

public class Demo1 {

  public static void print(GraphObject graphObject, int level) {
    System.out.println(level + " --> " + graphObject.toString());
    if (graphObject.getChilds() != null) {
      for (GraphObject child : graphObject.getChilds()) {
        print(child, level + 1);
      }
    }
  }

  public static void main(String[] args) {
    GraphObject graphObject = new GraphObject("Blue", "Circle");
    List<GraphObject> childs = new ArrayList<>();
    childs.add(new GraphObject("Purple", "Pyramid"));
    childs.add(new GraphObject("Yellow", "Viper"));
    graphObject.setChilds(childs);
    print(graphObject, 1);
  }

}
