package algorithms.codechef.snackdown2019B;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Ext {

  Integer x;

  public Ext(Integer x) {
    this.x = x;
  }
}

public class Demo3 {

  public static void main(String[] args) {
    List<Ext> extList = new ArrayList<>();
    extList.add(new Ext(12));
    extList.add(new Ext(34));
    extList.add(new Ext(34));

    Iterator<Ext> itr = extList.iterator();

    while (itr.hasNext()) {
      if(itr.next().x != null) {
        extList.remove(0);
      }
    }
  }
}
