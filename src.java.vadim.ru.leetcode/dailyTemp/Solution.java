package dailyTemp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *  Мы должны содержать убывающе монотонный стек. Код получился излишним, короткую версию можно посомтреть на
 * канале ниткод.
 */
public class Solution {
    public static void main(String[] args) {
//        int[] nums = new int[]{73,74,75,71,69,72,76,73};
        int[] nums = new int[]{89,62,70,58,47,47,46,76,100,70};
        int[] ints = dailyTemperatures(nums);
    }
    public static int[] dailyTemperatures(int[] temperatures) {
//        Stack<Integer> stack = new Stack<>();
//        Map<Integer, Stack<Integer>> index = new HashMap<>();
//        int[] res = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length; i++) {
//            if (index.containsKey(temperatures[i])) {
//                index.get(temperatures[i]).push(i);
//            } else {
//                Stack<Integer> indexes = new Stack<>();
//                indexes.push(i);
//                index.put(temperatures[i], indexes);
//            }
//            if (stack.isEmpty()) {
//                stack.push(temperatures[i]);
//            } else {
//                if (stack.peek() < temperatures[i]) {
//                    while (stack.peek() < temperatures[i]) {
//                        Integer indexPosition = stack.pop();
//                        Integer popIndex = index.get(indexPosition).pop();
//                        if (index.get(indexPosition).isEmpty()) index.remove(indexPosition);
//                        int pathSize = i - popIndex;
//                        res[popIndex] = pathSize;
//                        if (stack.isEmpty() || stack.peek() >= temperatures[i]) {
//                            stack.push(temperatures[i]);
//                        }
//                    }
//                } else {
//                      stack.push(temperatures[i]);
//                }
//            }
//        }
//        index.clear();
//        return res;
        Stack<Integer> stack = new Stack<Integer>();
        int[] results = new int[temperatures.length];
        for(int x = 0; x <temperatures.length; x++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[x]) { // цикл, если значение из стека меньше текущей итерации
                int curr = stack.pop(); // то вытаскиваем значение из стека
                results[curr] = x-curr; // считаем разницу от текущей итерации индекса.
            }
            stack.add(x); //если не попадаем в цикл, то добавляем значение в стек.
        }
        return results;

    }
}
