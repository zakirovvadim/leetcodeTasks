package singleNumber;

import java.util.*;

/**
 * В цикле по массиву кладем в мапу, ключ это элемент массива, занчение - лист значений.
 * Если ключ имеется в мапе - просто удаляем, если нет, кладем.
 * Далее возращаем ключи от мапы, останется один. Так как он униклаьный, кладется и не удалится.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber2(nums));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                List<Integer> numbers = new ArrayList<>();
                numbers.add(num);
                map.put(num, numbers);
            }
        }
        return map.keySet().stream().findAny().get();
    }

    public static int singleNumber2(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            x = x ^ num;
            System.out.println();
        }
        return x;
    }
}
