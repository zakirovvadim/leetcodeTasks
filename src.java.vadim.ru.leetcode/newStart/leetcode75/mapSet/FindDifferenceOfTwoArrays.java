package newStart.leetcode75.mapSet;

import java.util.*;

public class FindDifferenceOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
        System.out.println(findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int j : nums1) { //сначала добавляем в сет первый массив
            set1.add(j);
        }
        for (int j : nums2) { // потом во второй сет второй массив
            set2.add(j);
        }
        for (int j : set1) { // итерируемся по первому сету
            if (!set2.contains(j)) { // если второй сет НЕ содержит уже элемент из первого сета, тогда добавялем в результирующий лист значение
                list1.add(j);
            }
        }

        for (int j : set2) { // итерируемся по второму сету
            if (!set1.contains(j)) { // если в первом сете НЕТ элемента из второго сета
                list2.add(j); // добавляем во второй результрующий лист элемент  второго сета
            }
        }

        return List.of(list1, list2);
    }
}
