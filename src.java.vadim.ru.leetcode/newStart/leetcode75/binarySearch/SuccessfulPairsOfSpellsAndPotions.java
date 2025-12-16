package newStart.leetcode75.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
LeetCode 2300 (Successful Pairs of Spells and Potions)

Идея: для каждого spell нужно посчитать, сколько potions дают “успешную” пару:
spell * potion >= success.

Делаем так:
1) Сортируем potions по возрастанию.
2) Для каждого spell бинарным поиском (lower_bound) находим первый индекс idx,
   где potion[idx] * spell >= success.
   - Всё, что левее idx, не подходит (слишком мало).
   - Всё, что начиная с idx, подходит (из-за сортировки).
3) Ответ для этого spell = n - idx (где n = potions.length).
   Если idx == n, значит подходящих нет => 0.

В бинарном поиске держим границы [l, r) (r = n), чтобы можно было вернуть n,
когда подходящих элементов нет.
Важно: умножение считать в long: (long)potion[mid] * spell, чтобы не было overflow.
 */
public class SuccessfulPairsOfSpellsAndPotions {

    public static void main(String[] args) {
        int[] ints = successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            int index = binarySearch(potions, spell, success);
            int number = potions.length - index;
            list.add(number);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private static int binarySearch(int[] potions, long spell, long success) {
        int l = 0;
        int r = potions.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (potions[mid] * spell < success) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
