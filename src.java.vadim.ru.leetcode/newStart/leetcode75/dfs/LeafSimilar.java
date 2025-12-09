package newStart.leetcode75.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class LeafSimilar {

    public static void main(String[] args) {
        System.out.println(leafSimilar(getOne(), getSecond()));
        System.out.println(leafSimilar(get3(), get4()));
    }

    private static TreeNode get3() {
        return new TreeNode(1,
                new TreeNode(2,
                        null,
                        null
                ),
                new TreeNode(3,
                        null, null
                )
        );
    }

    private static TreeNode get4() {
        return new TreeNode(1,
                new TreeNode(3,
                        null,
                        null
                ),
                new TreeNode(2,
                        null, null
                )
        );
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String dfs = dfs(root1);
        String dfs2 = dfs(root2);
        System.out.println(dfs);
        System.out.println(dfs2);
        return Objects.equals(dfs, dfs2);
    }

    private static String dfs(TreeNode treeNode) {
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> depth = new ArrayDeque<>();
        nodes.push(treeNode);
        depth.push(1);
        int max = 0;
        StringBuilder res = new StringBuilder();
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            Integer deep = depth.pop();
            max = Math.max(max, deep);
            if (node.right == null && node.left == null) {
                res.append(node.val);
                res.append(".");
                continue;
            }
            if (node.right != null) {
                nodes.push(node.right);
                int d = deep + 1;
                depth.push(d);
            }
            if (node.left != null) {
                nodes.push(node.left);
                int d = deep + 1;
                depth.push(d);
            }
        }
        return res.toString();
    }

    private static TreeNode getOne() {
        return new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(6),
                                new TreeNode(2,
                                        new TreeNode(7),
                                        new TreeNode(4)
                                )
                        ),
                        new TreeNode(1,
                                new TreeNode(9),
                                new TreeNode(8)
                        )
                );
    }

    private static TreeNode getSecond() {
       return new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(6),
                                new TreeNode(7)
                        ),
                        new TreeNode(1,
                                new TreeNode(4),
                                new TreeNode(2,
                                        new TreeNode(9),
                                        new TreeNode(8)
                                )
                        )
                );
    }
}
