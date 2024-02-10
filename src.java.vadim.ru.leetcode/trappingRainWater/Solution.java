package trappingRainWater;

import java.util.ArrayList;
import java.util.List;

/**
 * Используется алгоритм двух точек. Создается правый офсет = конец массива, и левый, начало.
 * Также создаются две перменные, максимум правого и левого и результирующий массив.
 * В цикле офсеты идут друг к другу.
 * Внутри цикла условия
 * Первое условие, если значение левого офсета меньше или равно, или значение правого офсета больше чем левого.
 * В зависимости от этого сдвигаем офсеты.
 * Внутри также условие, если максимальное значение левой стороны, или правой, в зависимости от того в какой части,
 * мы вычитаем из нее текущее значение под левым\правым офсетом и если оно меньше или равно 0 добавляем в результирующий лист, если больше, то результат вычисления.
 * Далее назначем переменной максимального значения новое число текущей итерации, если оно больше имеющегося макса.
 *
 * Так как мы двигаем офсеты если они минимальные, например левый, то нам по сути не важно, что справо есть числа большие чем правый офсет
 * так как заполненность "чаши" будет зависеть от ее минимального края.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        List<Integer> list = new ArrayList<>();

        int maxLeft = 0;
        int maxRight = 0;

        while(left != right) {
            if (height[right] >= height[left]) {
                if (maxLeft - height[left] <= 0) {
                    list.add(0);
                } else {
                    list.add(maxLeft - height[left]);
                }
                maxLeft = Math.max(maxLeft, height[left]);
                left++;
            } else {
                if (maxRight - height[right] <= 0) {
                    list.add(0);
                } else {
                    list.add(maxRight - height[right]);
                }
                maxRight = Math.max(maxRight, height[right]);
                right--;
            }
        }
        return list.stream().mapToInt(i -> i).sum();
    }
}
