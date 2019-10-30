package LeetCode;

public class CircularQueue {
    int head;
    int rear;
    int[] elem;
    int capacity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public CircularQueue(int k) {
        elem = new int[k];
        head = rear = -1;
        capacity = k;
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
            ++head;
            ++rear;
            elem[head] = value;
        } else {
            incRear();
            elem[rear] = value;
        }
        return true;
    }

    private void incRear() {
        rear = ((rear + 1) % capacity);
    }

    private void incHead() {
        head = ((head + 1) % capacity);
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        // 1 element remaining in the list
        if (head == rear) {
            head = rear = -1;
        } else {
            incHead();
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elem[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return elem[rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (head == -1);
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ((rear + 1) % capacity == head);
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
