package com.test2.getit.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: CreateData
 * @Description: for create these data structures conveniently
 * @Author Chen Gavin
 * @Date 2021/12/4
 * @Version 1.0
 */


public class CreateData {

    public ListNode createNodeByList(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        return head;
    }

    public void showNode(ListNode head) {
        if (null == head) {
            return ;
        }
        ListNode node = head;
        while (null != node) {
            System.out.print(node.val);
            System.out.println("-");
            node = node.next;
        }
        System.out.print("\n");
    }

    public TreeNode createTreeNodeByList(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> newQueue = new LinkedList<>();
        queue.offer(head);
        int i = 1;
        boolean jugde = true;
        while (i < arr.length) {
            while (!queue.isEmpty() && i < arr.length) {
                TreeNode theNode = queue.poll();
                if (jugde) {
                    if (null != arr[i]) {
                        theNode.left = new TreeNode(arr[i]);
                        newQueue.offer(theNode.left);
                    }
                    i++;
                    jugde = !jugde;
                }
                if (i == arr.length) {
                    return head;
                }
                if (!jugde) {
                    if (null != arr[i]) {
                        theNode.right = new TreeNode(arr[i]);
                        newQueue.offer(theNode.right);
                    }
                    i++;
                    jugde = !jugde;
                }
            }
            while (!newQueue.isEmpty()) {
                queue.offer(newQueue.poll());
            }
        }
        return head;
    }

}
