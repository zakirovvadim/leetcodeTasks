package newStart.leetcode75.slidingWindow;

import java.util.*;
/*
Алгоритм следующий, первый раз проходим циклом k элемнетов и собираем первый резьультат среднего и сумму(окно)
Потом снова итерируемся уже от k и прибавляем к окну-сумме К элементов  значение текущей итерации и вычитаем крайне левое
 (его получаем как текущий индекс минус k).
 */
public class MaximumAverageSubarray {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
//        System.out.println(findMaxAverage(new int[]{5}, 1));
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxAverage = (double) sum / k;
        for (int i = k; i < nums.length; i++) {
            sum = sum +  nums[i] - nums[i - k]; // сумму окна(2) прибавили к текущей(50) и вычли крайний левый - индекс 0 т.е. 1
            maxAverage = Math.max(maxAverage, (double) sum / k); // получили максимум из имеющегося и новой средней
        }

        return maxAverage;
    }
}
