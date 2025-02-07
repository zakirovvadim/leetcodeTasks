package old.longestConsecutiveSeqquence;

import java.util.*;

/**
 * Для поиска мы добавляем массив в хешСет, после повторная итерация с проверкой текущего числа.
 * Если Текущее числа мину 1 есть в сете, значит это не начало последовательности и можно пропустить итерацию, если нету, значит это начало последовательносьти
 * и можно посмотреть его длину, для этого отдельным циклом while, инкрементируем на один и считаем длину, после окончания, если
 * длина больше существующей maxLongest, значит перезаписываем эту переменную.
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }


    public static int longestConsecutive(int[] nums) {
        int macLongest = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int j : nums) {
            set.add(j);
        }

        for (int num : nums) {
            int previous = num - 1;
            if (!set.contains(previous)) {
                boolean b = true;
                int k = 1;
                while (b) {
                    int post = num + k;
                    if (set.contains(post)) {
                        k++;
                    } else {
                        b = false;
                    }
                }
                macLongest = Math.max(k, macLongest);
            }
        }
        return macLongest;
    }
}
