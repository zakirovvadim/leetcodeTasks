package old.topKFrequentElements;

import java.util.*;

/**
 * Алгоритм:
 * Создаем маппу где ключ это тип числа, а значение лист с этими числами, повторяемость определяется длинной листа
 * Далее в фориче если нет создаем кладем, если есть, достаем лист и добавляем число из итерации
 * Потом Достаем Лист листов, сортируем их по длине, сортирвока получается от меньшего к большему, а нам надо наиболее большие
 * Для этого делаем скип общее количество минус k, так остаются только нижние элемнетыю
 * Потом просто достаем первый элемент, так как они все внутри одного типа и возвращаем как массив.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] ints = topKFrequent2(nums, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> integers = map.get(nums[i]);
                integers.add(nums[i]);
                map.put(nums[i], integers);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                map.put(nums[i], list);
            }
        }
        return map.values().stream()
                .sorted(Comparator.comparingInt(List::size))
                .skip(map.size() - k)
                .mapToInt(el -> el.get(0))
                .toArray();
    }

    // O(n)
    public static int[] topKFrequent2(int[] nums, int k) {
        var count = new HashMap<Integer, Integer>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            freq[frequency].add(num);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = freq.length - 1; i >= 0 && res.size() < k; i--) {
            for (int num : freq[i]) {
                res.add(num);
                if (res.size() == k) {
                    break;
                }
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
