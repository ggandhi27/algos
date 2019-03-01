package amazon;

/**
 * Need to find the first index for 1 in a sorted array of 0 and 1. Binary search will be used for
 * it.
 */
public class FindTransitionPoint {

  public static int binarySearch(int arr[], int start, int end) {
    int x = end - start + 1;
    int mid = start + (x / 2);
    if (arr[mid] == 1) {
      return binarySearch(arr, start, mid - 1);
    } else {
      if (arr[mid + 1] == 1) {
        return mid;
      }
      return binarySearch(arr, mid + 1, end);
    }
  }

  public static int transitionPoint(int arr[], int n) {
    return binarySearch(arr, 0, n - 1);
  }

  public static void main(String[] args) {
    int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1};
    System.out.println(transitionPoint(a, a.length));
  }
}
