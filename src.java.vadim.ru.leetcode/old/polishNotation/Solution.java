package old.polishNotation;

import java.util.Stack;

/**
 * Алгоритм. Используем стек. В фориче проверяем если число добавляем в стек, если оператор, делаем pop два раза и у первого по
 * порядку массива применяем оператор ко второму, оператор выбераем в свитч.
 * Так как два числа из стека удалились, помещаем туда результат операции и идем дальше.
 */
public class Solution {
    public static void main(String[] args) {
//        String[] nums = new String[]{"2", "1", "+", "3", "*"};
//        String[] nums = new String[]{"4", "13", "5", "/", "+"};
        String[] nums = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(nums));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-")
                    || tokens[i].equals("*") || tokens[i].equals("/")) {

                if (stack.size() < 2) {
                    return stack.pop();
                } else {
                    Integer second = stack.pop();
                    Integer first = stack.pop();
                    int result = 0;
                    switch (tokens[i]) {
                        case "-" -> result = first - second;
                        case "+" -> result = first + second;
                        case "*" -> result = first * second;
                        case "/" -> result = first / second;
                        default -> result = 0;
                    }
                    stack.push(result);
                }
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
