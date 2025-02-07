package old.removeElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElements {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        int[] arr2 = {0,1,2,2,3,0,4,2};
        int i = removeElements(arr, 3);
    }


    public static int removeElements(int[] nums, int val) {
        Arrays.sort(nums);
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

        }
        return 0;
    }

}