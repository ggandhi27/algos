package leetcode;

import java.util.HashSet;

public class Q929 {

  public static int numUniqueEmails(String[] emails) {
    HashSet<String> hashSet = new HashSet<>();
    for (String email : emails) {
      StringBuilder sb = new StringBuilder();
      char[] chrs = email.toCharArray();
      boolean flag1 = false, flag2 = false;
      for (char ch : chrs) {
        if (ch == '.' && !flag2) {
        } else if (ch == '+') {
          flag1 = true;
        } else if (ch == '@') {
          flag1 = false;
          flag2 = true;
          sb.append(ch);
        } else if (!flag1 || flag2) {
          sb.append(ch);
        }
      }
      hashSet.add(sb.toString());
    }
    return hashSet.size();
  }

  public static void main(String[] args) {
    System.out.println(numUniqueEmails(
        new String[]{"test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"}));
  }
}
