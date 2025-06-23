package newStart.leetcode75.slidingWindow;

public class LongestSubarrayof1sAfterDeletingOneElement {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }

    public static int longestSubarray(int[] nums) {
        int l = 0;
        int maxLen = 0;
        int counter = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                counter++;
            }
            while (counter > 1) {
                if (nums[l] == 0) {
                    counter--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;
    }
}
