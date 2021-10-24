package com.ajiao.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7,
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);TreeNode node5 = new TreeNode(7);
        node1.left=node2;node1.right=node3;node3.left=node4;node3.right=node5;
        levelOrder(node1);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}

