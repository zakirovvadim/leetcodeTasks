package searchRotatedSortedArr;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,8,9,10,11,12,0,1,2};
        System.out.println(search(arr, 7));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else return -1;
        }
        Integer result = null;
        if (nums[0] != 0) {
            int mid = getMiddleIndex(nums);
            result = binarySearch(nums, target, low, high, mid);
        }
        if (result != null) return result;
        return -1;
    }

    private static Integer binarySearch(int[] nums, int target, int low, int high, int mid) {
        while (low <= high) {
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        return null;
    }

    private static int getMiddleIndex(int[] nums) {
        int afterPivot = nums[0];
        int startIndex = nums.length - afterPivot;
        int startValue = nums.length - startIndex;
        return startIndex;
    }
}
