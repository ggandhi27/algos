package algorithms.codechef.snackdown2019A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question1 {

  public static void main(String[] args) throws Exception {
    Set<Character> rightHand = new HashSet<>();
    rightHand.add('j');
    rightHand.add('k');

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int noOfTestCases = Integer.parseInt(br.readLine());

    for (int i = 0; i < noOfTestCases; i++) {
      Map<String, BigDecimal> consumedWords = new HashMap<>();
      BigDecimal totalTime = BigDecimal.ZERO;
      int noOfWords = Integer.parseInt(br.readLine());

      for (int j = 0; j < noOfWords; j++) {
        Boolean currentHand = null;
        BigDecimal subTime = BigDecimal.ZERO;
        String word = br.readLine();
        BigDecimal time = consumedWords.get(word);
        if (time == null) {
          char[] wordArr = word.toCharArray();
          for (int k = 0; k < wordArr.length; k++) {
            if (rightHand.contains(wordArr[k])) {
              if (currentHand == null || !currentHand) {
                subTime = subTime.add(new BigDecimal(0.2));
              } else {
                subTime = subTime.add(new BigDecimal(0.4));
              }
              currentHand = true;
            } else {
              if (currentHand == null || currentHand) {
                subTime = subTime.add(new BigDecimal(0.2));
              } else {
                subTime = subTime.add(new BigDecimal(0.4));
              }
              currentHand = false;
            }
          }
          consumedWords.put(word, subTime);
        } else {
          subTime = subTime.add(time.divide(new BigDecimal(2)));
        }
        totalTime = totalTime.add(subTime);
      }
      System.out.println(totalTime.multiply(new BigDecimal(10)).intValue());
    }
  }
}
