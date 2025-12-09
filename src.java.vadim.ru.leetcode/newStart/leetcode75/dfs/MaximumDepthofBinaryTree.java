package newStart.leetcode75.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthofBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        TreeNode node2 = new TreeNode(1, null, new TreeNode(2, null, null));
//        int i = maxDepth(node);
        int i2 = maxDepth(node2);
//        System.out.println(i);
        System.out.println(i2);
    }

    public static int maxDepth(TreeNode root) {
        Deque<Integer> depth = new ArrayDeque<>();
        Deque<TreeNode> nodes = new ArrayDeque<>();
        depth.push(1);
        nodes.push(root);
        int max = 1;
        while (!depth.isEmpty()) {
            Integer deep = depth.pop();
            TreeNode node = nodes.pop();
            max = Math.max(max, deep);
            if (node.left != null) {
                nodes.push(node.left);
                Integer i = deep+ 1;
                depth.push(i);
            }
            if (node.right != null) {
                nodes.push(node.right);
                Integer i = deep + 1;
                depth.push(i);
            }
        }
        return max;
    }
}

