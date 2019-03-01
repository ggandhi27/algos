package designpattern.flyweight;

import java.util.ArrayList;
import java.util.List;

class TextFormatter {

  String textValue;
  List<Format> formats = new ArrayList<>();

  public TextFormatter(String textValue) {
    this.textValue = textValue;
  }

  public Format getFormat(int start, int end, boolean capitalize) {
    return new Format(start, end, capitalize);
  }

  public class Format {

    private int start, end;
    private boolean capitalize;

    public Format(int start, int end, boolean capitalize) {
      this.start = start;
      this.end = end;
      this.capitalize = capitalize;
    }

    public boolean covers(int currentPosition) {
      return currentPosition >= start && currentPosition <= end;
    }
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("");
    char[] chars = textValue.toCharArray();
    for (int i = 0; i < textValue.length(); i++) {
      boolean flag = false;
      for (Format format : formats) {
        if (format.covers(i) && format.capitalize) {
          stringBuilder.append(String.valueOf(chars[i]).toUpperCase());
          flag = true;
        }
      }
      if(!flag) {
        stringBuilder.append(chars[i]);
      }
    }
    return stringBuilder.toString();
  }
}

public class Demo {

  public static void main(String[] args) {
    TextFormatter textFormatter = new TextFormatter(
        "I am the resurrection of the evil known by the name of abhishek.");
    textFormatter.formats.add(textFormatter.getFormat(4, 8, true));
    textFormatter.formats.add(textFormatter.getFormat(11, 17, true));
    System.out.println(textFormatter.toString());
  }
}
