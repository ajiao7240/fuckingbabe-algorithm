package com.ajiao.leetcode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 *
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        diameterOfBinaryTree(node1);
    }
    public static int diameter;
    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        traverse(root);
        return diameter;
    }
    public static int traverse(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = traverse(root.left); // 左子树的深度
        int right = traverse(root.right); // 右子树的深度
        // 直接访问全局变量
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }
}
