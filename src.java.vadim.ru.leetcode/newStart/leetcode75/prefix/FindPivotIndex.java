package newStart.leetcode75.prefix;
/*
Оптимизация вычислений:

Сначала вычисляем общую сумму массива (totalSum).

Затем проходим по массиву, поддерживая текущую leftSum.

Сумма справа от текущего индекса вычисляется как totalSum - leftSum - nums[i].

Правильное сравнение:

Проверяем условие leftSum == rightSum (где rightSum = totalSum - leftSum - nums[i]).

Возврат результата:

Как только находим pivot index, сразу возвращаем его.

Если не нашли, возвращаем -1.
 */
public class FindPivotIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[] {1,2,3}));
        System.out.println(pivotIndex(new int[] {2,1,-1}));
    }

    public static int pivotIndex(int[] nums) {
        int totalSum = 0; //Сначала вычисляем общую сумму массива (totalSum).
        for (int num : nums) {
            totalSum = totalSum + num;
        }

        int leftSum = 0;
        for (int i =0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i]; // сразу же высчитываем правую сумму как общая сумма минус левая и текущая в итерации
            if (leftSum == rightSum) { // сравнвиаем, если они одинаковые, значит возвращаем результат в виде индекса
                return i;
            }
            leftSum = leftSum + nums[i]; // сразу высчитываем левую сумму
        }
        return -1;
    }
}
