package amazon;

/**
 * Simple find max in an array
 */
class Height {
  int feet;
  int inches;
  public Height(int ft, int inc)
  {
    feet = ft;
    inches = inc;
  }
}

public class MaximumInStructArray {

  public static int findMax(Height arr[], int n)
  {
    int max = Integer.MIN_VALUE;
    for(int i=0;i<n;i++) {
      if(arr[i].feet*12 + arr[i].inches > max) {
        max = arr[i].feet*12 + arr[i].inches;
      }
    }
    return max;
  }

  public static void main(String[] args) {

  }
}
