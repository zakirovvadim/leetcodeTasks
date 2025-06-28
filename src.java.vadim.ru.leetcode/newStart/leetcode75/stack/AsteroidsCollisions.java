package newStart.leetcode75.stack;

import java.util.*;

public class AsteroidsCollisions {
    public static void main(String[] args) {
//        System.out.println(asteroidCollision(new int[]{5,10,-5}));
//        System.out.println(asteroidCollision(new int[]{8, -8}));
        System.out.println(asteroidCollision(new int[]{10, 2, -5}));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>(); // решаем задачу через стек
        for (int asteroid : asteroids) {
            boolean add = true; // флаг, который определяет, нужно ли добавлять текущий астероид в стек после проверки столкновений.
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) { // пока стек не пустой, и астеройды имеют тенденцию на столкновение
                if (stack.peek() < -asteroid) {// сначала проверяем нужно ли удалять имеющийся астеройд
                    stack.pop();
                    continue; // после удаления сразу след итерация
                } else if (stack.peek() == -asteroid) { // 2 проверка на равенство
                    stack.pop();
                }
                add = false; // текущий астероид уничтожается - не добавляем в стек
                break;
            }
            if (add) {
                stack.push(asteroid);
            }
        }
        int[] arr = new int[stack.size()]; // потом просто записываем в результирующий массив с конца
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}
