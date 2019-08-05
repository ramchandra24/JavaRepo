package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListToBST {
    public static Map<Integer, Integer> valMap = new HashMap<>();
    public static TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        int index = 0;
        while (temp != null) {
            valMap.put(index, temp.val);
            temp = temp.next;
            ++index;
        }
        return listToBSTUtil(0, index);
    }
    
    public static TreeNode listToBSTUtil(int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = (start + end) / 2;
        int val = valMap.get(mid);
        TreeNode root = new TreeNode(val);
        root.left = listToBSTUtil(start, mid);
        root.right = listToBSTUtil(mid+1, end);
        return root;
    }
    
    public static int listLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(-10);
        ListNode a = new ListNode(-3);
        ListNode b = new ListNode(-0);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(9);

        root.next = a;
        a.next = b;
        b.next = c;
        c.next = d;

        TreeNode head = LinkedListToBST.sortedListToBST(root);
        LinkedListToBST.inorder(head);
    }

}
