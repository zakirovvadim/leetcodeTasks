package search_in_rotated_sorted_array_2;

public class Main {
    public static void main(String[] args) {

        int [] nums = new int[] {1,0,1,1,1};
        System.out.println(search(nums, 0));
    }

    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;
            if (mid < nums[high]) {
                if (target < nums[low] || target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (target > nums[high] || target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }
}
