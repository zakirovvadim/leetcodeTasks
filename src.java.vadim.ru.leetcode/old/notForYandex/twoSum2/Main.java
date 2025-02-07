package old.notForYandex.twoSum2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0};
        twoSum(nums, -1);
    }

    public static int[] twoSum(int[] numbers, int target) {
        List<Integer> resultArray = new ArrayList<>();
        int left = 0;
        int right = numbers.length - 1;
        while (true) {
            int result = numbers[right] + numbers[left];
            if (result > target) {
                right--;
            } else if (result < target) {
                left++;
            } else {
                resultArray.add(left + 1);
                resultArray.add(right + 1);
                break;
            }
        }
        return new int[]{resultArray.get(0), resultArray.get(1)};
    }
}
