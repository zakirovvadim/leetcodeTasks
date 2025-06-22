package newStart.leetcode75.slidingWindow;
/*
Ключевые идеи алгоритма:

Скользящее окно (Two Pointers)
Используем два указателя: left (начало окна) и right (конец окна).
Окно [left, right] всегда содержит не более k нулей.
Счётчик нулей
zero_count — количество нулей в текущем окне.
Расширение окна
Двигаем right вправо, пока zero_count <= k.
Если встречаем 0, увеличиваем zero_count.
Сужение окна
Если zero_count > k, двигаем left вправо, пока не удалим лишний ноль.
Обновление максимума
На каждом шаге вычисляем длину окна (right - left + 1) и сохраняем максимум.
 */
public class MaxConsecutiveOnesThree {

    public static void main(String[] args) {
        int i = longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
        int i2 = longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
        System.out.println(i);
        System.out.println(i2);
    }

    public static int longestOnes(int[] nums, int k) {
        int l = 0;
        int zeroCount = 0;
        int maxLen = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) { // увеличение окна
                zeroCount++;
            }
            while (zeroCount > k) { // сужение окна
                if (nums[l] == 0) {
                    zeroCount--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
