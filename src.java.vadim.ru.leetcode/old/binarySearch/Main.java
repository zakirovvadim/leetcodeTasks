package old.binarySearch;

/**
 * Обычный бинарный поиск, делаем три переменный левый офсет, правый и середина, и двигаем их в зависимости от того, меньше таргет или нет середины.
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,3,5,9,12};
        System.out.println(search(nums, 9));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
