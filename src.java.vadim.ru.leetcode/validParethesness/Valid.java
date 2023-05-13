package validParethesness;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Valid {
    public static void main(String[] args) {
        System.out.println(check(")(){}"));
    }

    public static boolean check(String start) {
        Stack<String> stack = new Stack<>();
        Map<String, String> map = Map.of(
                "}", "{",
                "]", "[",
                ")", "(");
        char[] charArray = start.toCharArray();
        if (charArray.length == 1) return false;
        for (char c : charArray) {
            if (String.valueOf(c).equals("(") || String.valueOf(c).equals("{") || String.valueOf(c).equals("[")) {
                stack.push(String.valueOf(c));
            } else if (!stack.isEmpty() && stack.peek().equals(map.get(String.valueOf(c)))) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
