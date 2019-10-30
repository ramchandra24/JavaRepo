package LeetCode;

public class CircularQueue {
    int capacity;
    int size;
    Node head;
    Node rear;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
            this.next = this.prev = null;
        }
    }

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public CircularQueue(int k) {
        size = 0;
        capacity = k;
    }

    Node newNode(int value) {
        return new Node(value);
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is
     * successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = rear = newNode(value);
        } else {
            rear.next = newNode(value);
            rear.next.prev = rear;
            rear = rear.next;
        }
        ++size;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head.next != null) {
            head.next.prev = null;
        }
        if (head == rear) {
            head.next = null;
            rear.next = null;
        } else {
            head = head.next;
        }
        --size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return head.value;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return rear.value;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
     * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
     * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(8); // set the size to be 3
        System.out.println(circularQueue.enQueue(3)); // return true
        System.out.println(circularQueue.enQueue(9)); // return true
        System.out.println(circularQueue.enQueue(5)); // return true
        System.out.println(circularQueue.enQueue(0)); // return true
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.Rear()); // return true
        System.out.println(circularQueue.Rear()); // return true
        System.out.println(circularQueue.deQueue()); // return true
    }
}
