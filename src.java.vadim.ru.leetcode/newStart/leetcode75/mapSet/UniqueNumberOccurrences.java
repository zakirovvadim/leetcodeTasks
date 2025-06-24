package newStart.leetcode75.mapSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOccurrences {

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(uniqueOccurrences(new int[]{1,2}));
        System.out.println(uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
        System.out.println(uniqueOccurrences(new int[]{2,2}));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) { // итерируемся по массиву
            if (map.containsKey(arr[i])) { //  если мапа содержит значение массива
                map.compute(arr[i], (k, i1) -> i1 + 1); // тогда инкерментируем количество входов
            } else {
                map.put(arr[i], 1); // если в мапе нет, просто добавляем со значенеим входа 1
            }
        }
        Set<Integer> set = new HashSet<>(map.values()); // помещаем все вхождения в сет, чтобы удалились дубликаты
        return  map.values().size() == set.size(); // сравниваем, если длина мапы равна (со значениями из массива) равна длине сета, где удалены дубликаты, значит дубликатов нет во вхождениях и они уникальны
    }
}
