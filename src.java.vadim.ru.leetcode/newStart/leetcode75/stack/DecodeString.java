package newStart.leetcode75.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
/*
Алгоритм следующий
в цикле по строчке проходим по символам
если это НЕ закрывающая скобка то добавляем стек, иначе нам нужно из стека вытащить все символы до
открывающей скобки. Для этого делаем цикл до открывающей скобки и билдим строку из этих символов.
После у нас остается в стеке число, которое добавилось перед открывающей скобки в стек, его тоже достаем через второй цикл по стеку
Парсим число и доабвляем в стек сбилденную строку дубликатом по количеству полученного числа.
Далее результат из стека получаем в обратном порядке и билим результат.
P.s. на пайтоне все намног компактнее, лучше там
 */
public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    public static String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> digits = Set.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(String.valueOf(s.charAt(i))); // если не закрывающая скобка доабвялем с тек
            } else { // иначе
                String substr = ""; // билдим тсрочку из стека
                while (!stack.isEmpty() && !stack.peek().equals("[")) { // циклом пока не вернемся к открывающей скобке
                   substr = stack.pop() + substr; // конкатенируем
                }
                stack.pop(); // убираем открывающую скобку из стека, так как выше по циклу остановились до нее
                String k = ""; // подготовка для числа
                while (!stack.isEmpty() && digits.contains(stack.peek())) { // предполагается что до открывающей скобки цифра
                    k = stack.pop() + k; // конкатериуем числа
                }
                int number = Integer.parseInt(k);
                stack.push(substr.repeat(number)); // добавляем копии строк
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res += stack.pollLast();
        }
        return res;
    }
}
