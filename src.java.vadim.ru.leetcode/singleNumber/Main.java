package singleNumber;

import java.util.*;

/**
 * В цикле по массиву кладем в мапу, ключ это элемент массива, занчение - лист значений.
 * Если ключ имеется в мапе - просто удаляем, если нет, кладем.
 * Далее возращаем ключи от мапы, останется один. Так как он униклаьный, кладется и не удалится.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(singleNumber(nums));
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
}
