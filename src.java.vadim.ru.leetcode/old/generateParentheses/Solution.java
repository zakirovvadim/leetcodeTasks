package old.generateParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


/**
 * Алгоритм следующий. Из-за рекурсии сложно понять.
 * По сути нам надо обойти дерево в глубину для поиска всех возможных вариантов скобок.
 * Создаем результирующий лист и стек куда будем собирать вариации скобок.
 * создаем метод бекТрек (с тремя аргументами, количества n, int open, int close), где три иф условия.
 * open - это количество открытых скобок, клоуз - закрытых. Т.е. вся логика строится на том, что мы не можем создать
 * больше закрытых скобок чем открытых, иначе будет невалидно.
 *
 *
 * 1. если опен равен n и равен клоуз, значит мы равны условию задачи - n и можем заджойнить скобки внутри стека и добавить в резалт лист.
 * 2. иф опен меньше n, значит что мы еще не выходим за рамки условия и можем открыть новую пару скобок, добавив открытую скобку в стек.
 * и вызвав метод рекурсивно с инкерментом у опен.
 * Делаем поп у стека после вызова рекурсии.
 * 3. Если клоуз меньше опен, значит мы еще можем добавить закрытую скобку, добавляем ее встек и рекурсивно вызываем метод с
 * инкрементом клоуз.
 * Делаем поп у стека после вызова рекурсии.
 */
public class Solution {

    static List<String> result = new ArrayList<>();
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        backTrack(n, 0, 0);
        return result;
    }

    private static void backTrack(int n, int open, int close) {
        if (open == close && open == n) {
            String collect = stack.stream().collect(Collectors.joining());
            result.add(collect);
        }

        if (open < n) {
            stack.push("(");
            backTrack(n, open + 1, close);
            stack.pop();
        }
        if (close < open) {
            stack.push(")");
            backTrack(n, open, close + 1);
            stack.pop();
        }
    }
}
