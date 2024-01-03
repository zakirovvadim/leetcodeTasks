package validParethesness;

import java.util.Map;
import java.util.Stack;

/**
 * Для проверки валидности при условии, что логика открытия и закрытия скобок сохраняется, т.е. после каждой открытой скобки будет
 * закрытая и проверка лишь на то, валидно ли закрытие скобок.
 * Используется стек для сложения открытой скобки и при следующей итерации сравненеия закрытой скобки с только что положившей туда скобки, без удаления,
 * если они равны то из стека удаляем.
 * Так же нужна мапа которая имеет ключ - закрытая скобка, значение открытая скобка того же типа, используется при сравнении если стек не пустой
 */
public class Valid {
    public static void main(String[] args) {
        System.out.println(check("{)(){}}"));
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
            if (String.valueOf(c).equals("(") || String.valueOf(c).equals("{") || String.valueOf(c).equals("[")) { // если скобка по итерации открытая, сохраняем в стек
                stack.push(String.valueOf(c));
            } else if (!stack.isEmpty() && stack.peek().equals(map.get(String.valueOf(c)))) { // сравниваем закрытую пришедшую по итерации скобку с открытой из значения мапы, если они совпадают, значит закрытие валидно
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
