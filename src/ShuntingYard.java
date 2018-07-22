import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ShuntingYard {

  /**
   * setting up the stack for operands.
   */
  private static Stack<Double> operands = new Stack<>();
  /**
   * setting up the stack for operators.
   */
  private static Stack<String> operators = new Stack<>();
  /**
   * setting up operators priority as poping of values depends upon it.
   */
  private static Map<String, Integer> operatorPriority = new HashMap<>();

  /*
    priority of the operators is being initialized.
   */
  static {
    operatorPriority.put("+", 1);
    operatorPriority.put("-", 1);
    operatorPriority.put("*", 2);
    operatorPriority.put("/", 2);
    operatorPriority.put("(", 3);
    operatorPriority.put(")", 0);
  }

  /**
   * @throws Exception main
   *                   <p>
   *                   function which is taking the input and calling sub-functions to calculate it.
   */
  public static void main(String[] args) throws Exception {
    Arrays.stream((new BufferedReader(new InputStreamReader(System.in)))
        .readLine()
        .split(" "))
        .forEach(ShuntingYard::performAction);
    calculateSubExpression();
    System.out.println(operands.pop());
  }

  /**
   * @param token String value is expression, might be operator or an operand.
   *              <p>
   *              this function decides if its an operand or operator, and if its an operator and operator stack is not
   *              empty it calls for decider function.
   */
  private static void performAction(String token) {
    if (operatorPriority.containsKey(token)) {
      if (operators.empty()) {
        operators.push(token);
      } else {
        calculateAndPushToStack(token);
      }
    } else {
      operands.push(Double.parseDouble(token));
    }
  }

  /**
   * @param operator value to operator that is coming to the stack.
   *                 this is the decider function which is called when an operator comes to a non-empty stack.
   */
  private static void calculateAndPushToStack(String operator) {
    if (")".equals(operator)) {
      calculateSubExpression();
    } else {
      if (!operators.peek().equals("(") && operatorPriority.get(operators.peek()) >= operatorPriority.get(operator)) {
        popAndCalculate(operators.pop());
      }
      operators.push(operator);
    }
  }

  /**
   * @param operator value of the incoming operator.
   *                 it pops up 2 operands and calculates the result on them and pushes the result back to stack.
   */
  private static void popAndCalculate(String operator) {
    Double j = operands.pop();
    Double i = operands.pop();
    switch (operator) {
      case "+":
        operands.push(i + j);
        break;
      case "-":
        operands.push(i - j);
        break;
      case "*":
        operands.push(i * j);
        break;
      case "/":
        operands.push(i / j);
        break;
    }
  }

  /**
   * the function is used to calculate expression when no more operands or operators can be pushed or the closing
   * bracket is observed which means we need to evaluate a sub-expression. Last statement is necessary as we might need
   * to pop "(" in case of sub-expression.
   */
  private static void calculateSubExpression() {
    while (!(operators.empty() || operators.peek().equals("("))) {
      popAndCalculate(operators.pop());
    }
    if (!operators.isEmpty()) {
      operators.pop();
    }
  }
}