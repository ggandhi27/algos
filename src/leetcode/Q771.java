package leetcode;

import java.util.HashSet;

public class Q771 {

  public static int numJewelsInStones(String J, String S) {
    char[] jArray = J.toCharArray();
    char[] sArray = S.toCharArray();
    HashSet<Character> ch = new HashSet<>();
    int sum = 0;
    for (int i = 0; i < jArray.length; i++) {
      ch.add(jArray[i]);
    }
    for (int i = 0; i < sArray.length; i++) {
      if (ch.contains(sArray[i])) {
        sum++;
      }
    }
    return sum;
  }

  public static void main(String[] args) {

  }
}
