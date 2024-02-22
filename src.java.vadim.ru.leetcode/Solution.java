import java.util.*;

/**
 * Использовал алгоритм с одним стеком. Создаем переменную с мин значением. Инициализация ее макс интеджер необходима
 * лишь для кейса литкода. В мете пуш мы сравниваем является ли значение меньше или равно минимального, если да, это наш
 * новый минимум и мы сохраняем его в стек, а потом перезаписываем в переменную мин. После условия делаем второй пуш, но уже пришедшей переменной.
 * Поп мы также делаем два раза, снача в условии иф если стек.поп равен мин, таким образом мы сразу вытащим одно значение.
 * Если оно равно с миним, значит мы попадали в условие в пуш и добавили два занчения прошлый минимум и пришедшее на тот момент значение.
 * Далее мы делаем еще один поп и присваиваем его значению минимум, так как оно хранится перед каждыйм вложенным значением которое меньше
 * минимума.
 */
public class Solution {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }

    static class MinStack {
        private Stack<Integer> stack;
        int min = Integer.MAX_VALUE;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (val <= min) {
                stack.push(min);
                min = val;
            }
            stack.push(val);
        }

        public void pop() {
            if (stack.pop() == min) {
                min=stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}