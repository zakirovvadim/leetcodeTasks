package twoSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Алгоритм: инициализируем хешМапу (значение и его индекс) и лист (индексов) для результатов. В один прогоно форича отнимаем у таргета значение по итерируемому индексу
 * и эту разницу ищем в качестве ключа в мапе,если находим, значит такое значение уже есть и берем его индекс и число итераци,
 * и кладем в резалт лист, после возвращаем этот результат. Если не находим, то кладем в мапу в ключ - значение массива, а значение мапы - индекс массива, т.е. итерации.
 */
public class Main {
    public static void main(String[] args) {
        int [] nums = new int[]{3,3};
        int[] ints = twoSum(nums, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int m = target - nums[i];
            if (map.containsKey(m)) {
                result.add(map.get(m));
                result.add(i);
            } else map.put(nums[i], i);
        }
        if (!result.isEmpty()) {
            return result.stream().mapToInt(i -> i).toArray();
        } else {
            throw new RuntimeException();
        }
    }
}
