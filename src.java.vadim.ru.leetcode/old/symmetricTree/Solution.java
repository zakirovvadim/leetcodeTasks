package old.symmetricTree;

import old.Utils.TreeNode;

/**
 * Так как дерево зеркальное, то левая часть одной стороны должна быть равна правой вершине другой
 */
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true; // если оба налл, значит все ок
        if (left == null || right == null) return false; // если один только налл, то уже разное дерево

        return (left.val == right.val // если значения равны
                && dfs(left.left, right.right) // и рекурсивно проваливаемся у левой вершины в левого потомка, у правого в правого потомка
                && dfs(left.right, right.left));// и рекурсивно входим в правого ребенка левой вершины и левого ребенка правой вершины
    }
}
