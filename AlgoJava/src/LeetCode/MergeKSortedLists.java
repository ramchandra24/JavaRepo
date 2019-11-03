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

    public class PQNode {
        ListNode node;
        int listNum;

        PQNode(ListNode node, int listNum) {
            this.node = node;
            this.listNum = listNum;
        }
    }

    public class PQNodeComparator implements Comparator<PQNode> {
        public int compare(PQNode a, PQNode b) {
            return a.node.val - b.node.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = null, chead = null;
        PriorityQueue<PQNode> pq = new PriorityQueue(new PQNodeComparator());
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                pq.offer(new PQNode(lists[i], i));
                lists[i] = lists[i].next;
            }
        }
        while (!pq.isEmpty()) {
            PQNode curr = pq.poll();
            int listNum = curr.listNum;
            if (head == null) {
                head = chead = curr.node;
            } else {
                chead.next = curr.node;
                chead = chead.next;
            }
            if (lists[listNum] != null) {
                pq.offer(new PQNode(lists[listNum], listNum));
                lists[listNum] = lists[listNum].next;
            }
        }
        return head;
    }
}
