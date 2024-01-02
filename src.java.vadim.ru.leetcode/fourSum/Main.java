package fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Алгоритм тот же что и в 3Сум, только теперь нам нужен дополнительный цикл для второго числа.
 * Сортируем массив
 * Первый цикл - пока и мнеьше длина - 3, так как после первого числа вычислаюттся следующие три и нам не надо идти до конца массива
 * Второй цикл - пока джей меньше длина - 2, так как у нас 4 элеменат и после 2 числа, коим является джей, нужно, чтобы оставалось еще 2 числа.
 * Скалдываем значения из индексов i и j;
 * Далее применяем логику 2Сум, а именно два первых числа есть, ищем комбинациии для двух других, выставляя офсеты левый и правый и сравнвиаем с таргетом. Левый офсет это джей + 1, а правый - последний элемент массива.
 * Если число совпадает с таргет нужно сохранить комбинацию, свдинуть левый офсет на +1 и правый на -1, а также посдвигать эти же офссеты в проверках на дубликаты - while.
 * Также есть проверка на выпадение чисел за ограничение int, возвращается пустой массив.
 *
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        List<List<Integer>> lists = fourSum(nums, 0);
        System.out.println(lists);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        nums = Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int ab = nums[i] + nums[j];
                int leftOffset = j + 1;
                int rightOffset = nums.length - 1;
                while (leftOffset < rightOffset) {
                    long fourSum = (long) ab + (long) nums[leftOffset] + (long) nums[rightOffset];
                    if (fourSum < Integer.MIN_VALUE || fourSum > Integer.MAX_VALUE) break;
                    if (fourSum > target) {
                        rightOffset = rightOffset - 1;
                    } else if (fourSum < target) {
                        leftOffset = leftOffset + 1;
                    } else {
                        resultList.add(List.of(nums[i], nums[j], nums[leftOffset], nums[rightOffset]));
                        leftOffset++; rightOffset--;
                        while (nums[leftOffset] == nums[leftOffset - 1] && leftOffset < rightOffset) {
                            leftOffset++;
                        }
                        while (nums[rightOffset] == nums[rightOffset + 1] && leftOffset < rightOffset) {
                            rightOffset--;
                        }
                    }
                }
            }
        }
        return resultList;
    }
}
