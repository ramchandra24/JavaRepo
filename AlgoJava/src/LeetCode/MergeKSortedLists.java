package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(0);
        ListNode chead = head;
        PriorityQueue<ListNode> pq = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        while (!pq.isEmpty()) {
            chead.next = pq.poll();
            chead = chead.next;
            if (chead.next != null) {
                pq.offer(chead.next);
            }
        }
        return head.next;
    }
}
