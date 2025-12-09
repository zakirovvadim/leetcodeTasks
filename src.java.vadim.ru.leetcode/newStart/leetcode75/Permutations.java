package newStart.leetcode75;

import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }


    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            ArrayList<List<Integer>> list = new ArrayList<>();
            list.add(Collections.emptyList());
            return list;
        }

        int first = nums[0];
        int[] rest = new int[nums.length - 1];
        System.arraycopy(nums, 1, rest, 0, nums.length - 1);
        List<List<Integer>> permute = permute(rest);
        ArrayList<List<Integer>> res = new ArrayList<>();

        for (List<Integer> permutation : permute) {
            for (int i = 0; i < permutation.size(); i++) {
                ArrayList<Integer> copy = new ArrayList<>(permutation);
                copy.add(i, first);
                res.add(copy);
            }
        }
        return res;
    }
}
