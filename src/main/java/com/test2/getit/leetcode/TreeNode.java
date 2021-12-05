package com.test2.getit.leetcode;

/**
 * @ClassName: TreeNode
 * @Description: 数据结构——二叉树
 * @Author Chen Gavin
 * @Date 2021/12/4
 * @Version 1.0
 */


public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(){}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
