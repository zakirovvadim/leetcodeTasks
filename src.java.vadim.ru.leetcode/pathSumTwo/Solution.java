package pathSumTwo;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Алгоритм кратко: идет в глубину и передает стек с текущим значением.
 * На каждом этапе проверяется не последняя ли вершина, если эьто так стек суммируется и проверяется на таргет, если верно, доавбляем стек в результирующий лист.
 * Далее если это условие прошло и у текущей вершины есть левый потомок, рекурсивно вызываем его, кладем левого потомка, таргет и стек. Также и с правым.
 * После в конце убираем из стека элемент положенный на текущей итерации.
 * Метод обхода в глуибну ничего не возвращает, а только суммирует стек при достижении дна и при соблюдении условия таргета и суммы добавляет в результрующий лист
 * далее просто возвращается обратно рекурсивно.
 */
public class Solution {

    public static  List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
//        TreeNode node = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
//                new TreeNode(8, new TreeNode(13), new TreeNode(4,new TreeNode(5),new TreeNode(1))));
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(pathSum(node, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return Collections.emptyList();
        dfs(root, targetSum, new Stack<>());
        return result;
    }

    public static void dfs(TreeNode root, int sum, Stack<Integer> stack) {
        stack.add(root.val);
        if (root.left == null && root.right == null) {
            if (stack.stream().mapToInt(i -> i).sum() == sum) {
                result.add(stack.stream().toList());
            }
        }
        if (root.left != null) {
            dfs(root.left, sum, stack);
        }
        if (root.right != null) {
            dfs(root.right, sum, stack);
        }
        stack.pop();
    }

}
