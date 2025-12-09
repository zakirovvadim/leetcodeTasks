package newStart.leetcode75.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
/*
      Задача: Maximum Depth of Binary Tree (LeetCode 104)
      Дано корень бинарного дерева, нужно вернуть его максимальную глубину
      (количество уровней от корня до самого глубокого листа).

      Идея:
      - Используем итеративный DFS через стек.
      - В стеке храним пары (узел, его глубина).
      - Обходим дерево в глубину: для каждого узла обновляем максимум глубины
        и кладём в стек его детей с глубиной +1.

      Алгоритм:
      1) Если root == null → глубина 0.
      2) Кладём (root, 1) в стек.
      3) Пока стек не пуст:
         - достаём (node, depth);
         - обновляем maxDepth = max(maxDepth, depth);
         - если есть левый ребёнок → кладём (left, depth + 1);
         - если есть правый ребёнок → кладём (right, depth + 1).
      4) Возвращаем maxDepth.

      Сложность:
      - Время: O(n), каждый узел посещаем ровно один раз.
      - Память: O(h) для стека, где h — высота дерева (в худшем случае O(n)).
 */
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
        if (root == null) {
            return 0;
        }
        Deque<Integer> depth = new ArrayDeque<>();
        Deque<TreeNode> nodes = new ArrayDeque<>();
        depth.push(1);
        nodes.push(root);
        int max = 1;
        while (!depth.isEmpty()) {
            int deep = depth.pop();
            TreeNode node = nodes.pop();
            max = Math.max(max, deep);
            if (node.left != null) {
                nodes.push(node.left);
                Integer i = deep + 1;
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

