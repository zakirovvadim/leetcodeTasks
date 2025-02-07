package old.balancedTree;

import old.Utils.TreeNode;

/**
 * Алгоритм работает по с обходом в глубину
 * Мы проверяем является ли выота налл, если да то это валидное и возвращает 0
 * Далее рекурсивно вызываем этот же метод дфс для левой и правой ноды.
 * Ниже, после выхода из рекурсии проверка на то, что рекурсивный метод не вернул -1,
 * Минус один возвращается если левая сторона минус правая будет болше одного, тем самым по цепочке минус один пойдет вверх.
 * Если условие не прошло и левая высота минус правая меньше 1 или равно, возвращается максимальное значение между левым и правым + 1
 */
public class Solution {

    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(3);
//        treeNode1.left = new TreeNode(9);
//        treeNode1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        System.out.println(isBalanced(treeNode1));
    }
    public static boolean isBalanced(TreeNode root) {
        return dfs(root) >= 0;
    }

    public static int dfs(TreeNode root) {
        // Tree with no nodes has height 0.
        if (root == null) return 0;
        // Recursively find the height of the left and right subtrees.
        int left = dfs(root.left);
        int right = dfs(root.right);
        // Check if left or right subtree is unbalanced or if they differ in height by more than 1.
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        // Current node height is max of left and right subtree heights plus 1 (for the current node)
        return Math.max(left, right) + 1;
    }

}
