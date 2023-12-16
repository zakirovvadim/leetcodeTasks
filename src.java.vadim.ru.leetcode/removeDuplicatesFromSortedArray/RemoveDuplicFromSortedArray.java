package removeDuplicatesFromSortedArray;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] arr2 = {1, 1, 2};
        int countOfUnique = removeDublicate(arr);
        System.out.println(countOfUnique);
    }

    private static int removeDublicate(int[] nums) {
        int currentPosition = 1;
        int numberOfUniq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == currentPosition) {
                currentPosition++;
                continue;
            } else {
                nums[i] = currentPosition;
                currentPosition++;
                numberOfUniq++;
            }
        }
        return currentPosition;
    }
}
