package old.removeDuplicates;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int [] arr = {1,3,5,6};
        int [] arr2 = {0,0,1,1,1,2,2,3,3,4};
        int i = searchInsert(arr, 7);
        System.out.println(i);

    }

    public static int searchInsert(int[] nums, int target) {
        int l = 1;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r - 1] != nums[r]) {
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }
}
