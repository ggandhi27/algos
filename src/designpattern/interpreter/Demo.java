package designpattern.interpreter;

import designpattern.interpreter.Token.Type;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

interface EvaluateExpression {

  Integer eval();
}

class EvalInteger implements EvaluateExpression {

  Token token;

  public EvalInteger(Token token) {
    this.token = token;
  }

  @Override
  public Integer eval() {
    return Integer.parseInt(token.value);
  }
}

class EvalOperator implements EvaluateExpression {

  Token token;
  EvaluateExpression leftExpr;
  EvaluateExpression rightExpr;

  public void setRightExpr(EvaluateExpression rightExpr) {
    this.rightExpr = rightExpr;
  }

  public EvalOperator(Token token, EvaluateExpression leftExpr) {
    this.token = token;
    this.leftExpr = leftExpr;
  }

  @Override
  public Integer eval() {
    Type type = token.type;
    switch (type) {
      case ADD:
        return leftExpr.eval() + rightExpr.eval();
      case SUB:
        return leftExpr.eval() - rightExpr.eval();
      default:
        return 0;
    }
  }
}

class Token {

  enum Type {
    ADD,
    SUB,
    INT,
  }

  Type type;
  String value;

  public Token(Type type, String value) {
    this.type = type;
    this.value = value;
  }
}

public class Demo {

  public static void checkForInt(StringBuilder sb, List<Token> tokens) {
    if (StringUtils.isNotBlank(sb)) {
      tokens.add(new Token(Type.INT, sb.toString()));
    }
  }

  public static List<Token> convertToToken(String expr) {
    List<Token> tokens = new ArrayList<>();
    char[] arr = expr.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      switch (arr[i]) {
        case '+': {
          checkForInt(sb, tokens);
          sb = new StringBuilder();
          tokens.add(new Token(Type.ADD, "+"));
          break;
        }
        case '-': {
          checkForInt(sb, tokens);
          sb = new StringBuilder();
          tokens.add(new Token(Type.SUB, "-"));
          break;
        }
        default:
          sb = sb.append(arr[i]);
      }
    }
    if (StringUtils.isNotBlank(sb)) {
      tokens.add(new Token(Type.INT, sb.toString()));
    }
    return tokens;
  }

  public static EvaluateExpression parse(List<Token> tokens) {

    EvaluateExpression lft = null;
    EvaluateExpression right = null;
    EvalOperator operator = null;

    for (Token token : tokens) {
      Type type = token.type;
      switch (type) {
        case INT: {
          if (lft == null) {
            lft = new EvalInteger(token);
          } else {
            right = new EvalInteger(token);
            operator.setRightExpr(right);
            lft = operator;
          }
          break;
        }
        case ADD:
        case SUB: {
          operator = new EvalOperator(token, lft);
          break;
        }
      }
    }
    return lft;
  }

  public static void main(String[] args) {

    String expression = "13+4-12+1";
    List<Token> tokens = convertToToken(expression);
    EvaluateExpression evalutor = parse(tokens);
    System.out.println(evalutor.eval());
  }
}
