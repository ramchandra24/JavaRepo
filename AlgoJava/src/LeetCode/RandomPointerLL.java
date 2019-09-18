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

    public Node getNode(Map<Node, Node> rmap, Node node) {
        if (node == null) {
            return null;
        }
        if (rmap.containsKey(node)) {
            return rmap.get(node);
        } else {
            Node n = new Node();
            n.val = node.val;
            n.next = n.random = null;
            rmap.put(node, n);
            return n;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> rmap = new HashMap<>();
        if (head == null) {
            return head;
        }
        Node nhead = new Node();
        Node ret = nhead;
        nhead.val = head.val;
        rmap.put(head, nhead);

        while (head != null) {
            nhead.random = getNode(rmap, head.random);
            nhead.next = getNode(rmap, head.next);
            head = head.next;
            nhead = nhead.next;
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
