package algorithms.hackerearth.septembercircuits2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Question1 {

  public static void main(String[] args) throws Exception {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int[] distanceTravelledExceptions = Arrays.stream(bufferedReader.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    int noOfDays = 0;
    int normalDistanceTravel = distanceTravelledExceptions[0] - distanceTravelledExceptions[2];
    if (normalDistanceTravel > 0) {
      noOfDays = normalDistanceTravel / distanceTravelledExceptions[1];
      if (normalDistanceTravel % distanceTravelledExceptions[1] != 0) {
        noOfDays++;
      }
    }
    noOfDays += distanceTravelledExceptions[2];
    int totalDistance = distanceTravelledExceptions[0];
    int actualNoOfDays = 0;

    Map<Integer, Integer> map = new TreeMap<>();
    for (int exceptions = 0; exceptions < distanceTravelledExceptions[2]; exceptions++) {
      int[] dayTravel = Arrays.stream(bufferedReader.readLine().split(" "))
          .mapToInt(Integer::parseInt).toArray();
      map.put(dayTravel[0], dayTravel[1]);
    }
    for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
      if (entry.getKey() <= noOfDays && totalDistance > 0) {
        totalDistance -= entry.getValue();
        actualNoOfDays++;
      } else {
        break;
      }
    }
    actualNoOfDays += totalDistance / distanceTravelledExceptions[1];
    if (totalDistance % distanceTravelledExceptions[1] != 0) {
      actualNoOfDays++;
    }
    System.out.println(actualNoOfDays);
  }
}