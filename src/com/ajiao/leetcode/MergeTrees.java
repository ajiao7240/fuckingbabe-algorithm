package com.ajiao.leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 */
public class MergeTrees {
    public static void main(String[] args) throws InterruptedException {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(7);
        node5.left=node6;
        node5.right=node7;
        node6.right=node8;
        node7.right=node9;
        mergeTrees(node1,node5);
    }
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null||t2==null){
            return t1==null?t2:t1;
        }
        return dfs(t1,t2);
    }
    public static TreeNode dfs(TreeNode r1, TreeNode r2) {
        // 如果 r1和r2中，只要有一个是null，函数就直接返回
        if(r1==null || r2==null) {
            return r1==null? r2 : r1;
        }
        //让r1的值 等于  r1和r2的值累加，再递归的计算两颗树的左节点、右节点
        r1.val += r2.val;
        r1.left = dfs(r1.left,r2.left);
        r1.right = dfs(r1.right,r2.right);
        return r1;
    }
}
