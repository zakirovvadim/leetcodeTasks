package old.sameTree;


import old.Utils.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(2);

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(3);
        treeNode2.right = new TreeNode(2);

        System.out.println(isSameTree(treeNode, treeNode2));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
         if (p == null && q == null) return true;

         if (p == null || q == null || p.val != q.val) return false;

         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}
