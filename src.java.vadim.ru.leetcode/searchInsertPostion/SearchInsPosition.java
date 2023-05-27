package searchInsertPostion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchInsPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        boolean flag = true;
        int number;
        List<int[]> firstAndSecondPart = getFirstAndSecondPart(nums);
        if (target >= firstAndSecondPart.get(0)[firstAndSecondPart.get(0).length - 1]) {
            if (firstAndSecondPart.get(0).length == 1) {
                number = Arrays
                return firstAndSecondPart.get(1)[0];
            } else {
                searchInsert(firstAndSecondPart.get(1), target);
            }
        } else {
            if (firstAndSecondPart.get(1).length == 1) {
                return firstAndSecondPart.get(1)[0];
            } else {
                searchInsert(firstAndSecondPart.get(0), target);
            }
        }
    }

    private static List<int[]> getFirstAndSecondPart(int[] nums) {
        List<int[]> list = new ArrayList<>();
        list.add(getFirstPart(nums));
        list.add(getSecondPart(nums));
        return list;
    }

    private static int[] getFirstPart(int[] nums) {
        int i = (nums.length + 1) / 2;
        return Arrays.copyOfRange(nums, 0, (nums.length + 1) / 2);
    }

    private static int[] getSecondPart(int[] nums) {
        return Arrays.copyOfRange(nums, (nums.length + 1) / 2, nums.length);
    }
}
