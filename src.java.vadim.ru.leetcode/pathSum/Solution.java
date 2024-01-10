package pathSum;

import Utils.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4,null,new TreeNode(1))));
        System.out.println(hasPathSum(node, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }
    public static boolean dfs(TreeNode root, int currentSum, int target) {
        if (root == null) return false;

        currentSum += root.val;

        if (root.left == null && root.right == null) {
            return currentSum == target;
        }
        return (dfs(root.left, currentSum, target) || dfs(root.right, currentSum, target));
    }
}
