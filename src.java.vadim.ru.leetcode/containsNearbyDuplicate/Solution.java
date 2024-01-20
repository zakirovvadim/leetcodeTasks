package containsNearbyDuplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Используется алгоритм скользящего окна, так как по условиям задачи, нужно чтобы дубликаты были внутри окна размером k.
 * Тем самым проверяем если длина между ш минус левый больше размера k, значит нам надо удалить из хешСета левый элемент
 * и инкрементировать левый счетчик, таким образом бы убираем из сета число, выпадающее из окна.
 * Следующее условие: если добавление в сет выдало фолс, значит элемент уже был и нам надо вернуть тру, так как это попытка добавление дубликата.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - left > k) {
                set.remove(nums[left]);
                left++;
            }
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
