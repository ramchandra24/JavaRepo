package LeetCode;

public class ReverseLinkedListRecursive {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode[] newHead = new ListNode[1];
        reverseListUtil(head, null, newHead);
        return newHead[0];
    }

    private static void reverseListUtil(ListNode head, ListNode prev, ListNode[] newHead) {
        if (head.next == null) {
            newHead[0] = head;
            head.next = prev;
            return;
        }
        reverseListUtil(head.next, head, newHead);
        head.next = prev;
    }

    private static void printList(ListNode head) {
        System.out.println();
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        printList(head);
        ListNode newHead = reverseList(head);
        printList(newHead);
    }
}
