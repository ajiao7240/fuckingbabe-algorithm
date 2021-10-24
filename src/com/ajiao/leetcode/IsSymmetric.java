package com.ajiao.leetcode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode3 node1 = new TreeNode3(1);
        TreeNode3 node2 = new TreeNode3(2);
        TreeNode3 node3 = new TreeNode3(2);
        TreeNode3 node4 = new TreeNode3(3);
        TreeNode3 node5 = new TreeNode3(4);
        TreeNode3 node6 = new TreeNode3(4);
        TreeNode3 node7 = new TreeNode3(3);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        boolean mirror = isMirror(node1, node1);
        System.out.println(mirror);
    }
    public static boolean isMirror(TreeNode3 t1, TreeNode3 t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}

class TreeNode3 {
      int val;
      TreeNode3 left;
      TreeNode3 right;
      TreeNode3(int x) { val = x; }
  }
