package newStart.leetcode75.slidingWindow;

public class LongestSubarrayof1sAfterDeletingOneElement {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }

    public static int longestSubarray(int[] nums) {
        int l = 0;
        int counter = 1;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                counter--;
            }
            if (counter < 0) {
                l++;
                counter++;
            }
            maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;
    }
}
