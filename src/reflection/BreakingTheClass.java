package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class SolidClass {

  private Integer data;

  public SolidClass() {
  }

  private SolidClass(Integer data) {
    this.data = data;
  }

  private void PlayOnData(Integer data) {
    System.out.println(data.toString());
  }
}

class SolidGenericClass<T> {

  private T data;

  public SolidGenericClass() {
  }

  private SolidGenericClass(T data) {
    this.data = data;
  }

  private <T> void PlayOnData(T data) {
    System.out.println(data.toString());
  }
}

public class BreakingTheClass {

  public static void main(String[] args) throws Exception {

    SolidGenericClass<Integer> solidClass = new SolidGenericClass<>();
    Class<?> reflectSolidClass = solidClass.getClass();

    System.out.println(reflectSolidClass.getName());
    System.out.println(reflectSolidClass.getSuperclass().getName());
    System.out.println(reflectSolidClass.getModifiers());

//    reflectSolidClass = Class.forName("reflection.SolidClass");

    Constructor[] constructors = reflectSolidClass.getConstructors();
    for(Constructor constructor:constructors) {
      System.out.println(constructor.getName());
    }

    Method method = reflectSolidClass.getMethod("PlayOnData", Object.class);

    Constructor constructor = reflectSolidClass.getConstructor(method.getGenericParameterTypes()[0].getClass());
    return;
  }
}
