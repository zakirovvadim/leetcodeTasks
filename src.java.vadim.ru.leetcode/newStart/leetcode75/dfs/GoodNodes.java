//package newStart.leetcode75.dfs;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.Map;
//
//public class GoodNodes {
//
//    public static void main(String[] args) {
//        System.out.println(goodNodes(getNode()));
//    }
//
//    private static class Pair {
//        TreeNode node;
//        int max;
//
//        public Pair(TreeNode node, int max) {
//            this.node = node;
//            this.max = max;
//        }
//    }
//
//    public static int goodNodes(TreeNode root) {
//        Deque<Pair> nodes = new ArrayDeque<>();
//        nodes.push(new Pair(root, root.val));
//
//        while (!nodes.isEmpty()) {
//            TreeNode node = nodes.pop().node;
//            int goodMax = nodes.pop().max;
//            if (node.val >= goodMax) {
//                nodes. = node.val;
//                res++;
//            }
//
//            if (node.left != null) {
//                nodes.push(node.left);
//            }
//            if (node.right != null) {
//                nodes.push(node.right);
//            }
//        }
//        return res;
//    }
//
//    private static TreeNode getNode() {
//        return new TreeNode(3,
//                new TreeNode(1,
//                        new TreeNode(3),
//                        null
//                ),
//                new TreeNode(4,
//                        new TreeNode(1),
//                        new TreeNode(5)
//                )
//        );
//    }
//}
