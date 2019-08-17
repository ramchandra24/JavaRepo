package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    Map<Integer, Node> mp;
    Node head;
    Node tail;
    private boolean isFull() {
        return mp.size() >= this.capacity;
    }
    public class Node {
        int key;
        int value;
        Node next;
        Node prev;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        mp = new HashMap<Integer, Node>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (!mp.containsKey(key) ) {
            return -1;
        }
        Node curr = mp.get(key);
        if (curr == head) {
            // do nothing
            return curr.value;
        }
        // update tail
        if (curr == tail) {
            tail = tail.prev;
        }
        else {
            curr.next.prev = curr.prev;
        }
        // make curr head
        curr.prev.next = curr.next;
        head.prev = curr;
        // make curr the head node
        curr.next = head;
        curr.prev = null;
        head = curr;
        return curr.value;
    }
    
    public void put(int key, int value) {
        if (head == null) {
            Node curr = new Node(key, value);
            head = tail = curr;
            mp.put(key, curr);
        }
        else if (mp.containsKey(key)) {
            Node curr = mp.get(key);
            curr.value = value;
            if (curr == head) {
                // do nothing
                return;
            }
            // update tail
            if (curr == tail) {
                tail = tail.prev;
            } 
            else {
                curr.next.prev = curr.prev;
            }
            curr.prev.next = curr.next;
            head.prev = curr;
            // update curr and make curr the head node
            curr.next = head;
            curr.prev = null;
            head = curr;
        }
        else if (isFull()) {
            Node curr = new Node(key, value);
            // remove tail key from map
            mp.remove(tail.key);
            if (head == tail) {
                mp.put(key, curr);
                tail = head = curr;
            }
            else {
                tail = tail.prev;
                curr.next = head;
                head.prev = curr;
                head = curr;
                mp.put(key, curr);
            }
        }
        else {
            Node curr = new Node(key, value);
            head.prev = curr;
            curr.next = head;
            mp.put(key, curr);
            head = curr;
        }
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));       // returns 1
        cache.put(1, 1);    // evicts key 2
        cache.put(4, 1);    // evicts key 1
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
