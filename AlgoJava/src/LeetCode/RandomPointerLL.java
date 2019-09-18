package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class RandomPointerLL {
    public class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> rmap = new HashMap<>();
        Node nhead = new Node();
        Node ret = nhead;
        while (head != null) {
            nhead.val = head.val;
            nhead.random = null;
            nhead.next = null;
            if (head.random == head) {
                nhead.random = nhead;
            }
            if (rmap.containsKey(head)) {
                Node linknode = rmap.get(head);
                linknode.random = nhead;
                rmap.remove(head);
            } else {
                rmap.put(head.random, nhead);
            }
            head = head.next;
            if (head != null) {
                nhead.next = new Node();
                nhead = nhead.next;
            }
        }
        return ret;
    }
    
    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + "->" + (head.random != null ? head.random.val : "") + " :: ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        RandomPointerLL ll = new RandomPointerLL();
        RandomPointerLL.Node head = ll.new Node();
        RandomPointerLL.Node two = ll.new Node(2, null, null);
        head.val = 1;
        head.next = two;
        head.random = two;
        two.random = two;
        ll.printList(head);
        RandomPointerLL.Node newHead = ll.copyRandomList(head);
        ll.printList(newHead);
    }
}
