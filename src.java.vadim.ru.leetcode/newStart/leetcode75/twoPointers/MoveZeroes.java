package newStart.leetcode75.twoPointers;

public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[] { 0, 1, 0, 3, 12 });
    }

    public static void moveZeroes(int[] nums) {
        int l = 0; // создаем левый указатель

        for (int r = 0; r < nums.length; r++) { // делаем обычный форич, r - будет правм указателем
            if (nums[r] != 0) { // если текущее число не ноль
                int temp = nums[l]; // делаем обычный свом, т.е. меняем местами значения под левым и правым указателем
                nums[l] = nums[r];
                nums[r] = temp;
                l++;// двигаем левый указатель
            }
        }
        System.out.println(nums);
    }
}
                                                                              