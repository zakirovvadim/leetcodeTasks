package newStart;

import java.util.HashMap;
import java.util.Map;
/*
Идём слева направо, для каждого числа держим последний индекс, где оно встречалось.
Если встречаем повтор и i - lastIndex <= k → сразу true.
 */
public class ContainsDublicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(nums[i]);
            if (val != null && (i - val) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
