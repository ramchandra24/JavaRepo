package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class LockOrder {

    static int check_log_history(List<String> events) {
        int line = 0;
        Set<Integer> acquiredLocks = new HashSet<>();
        Stack<Integer> lockStack = new Stack<>();
        for (String event : events) {
            ++line;
            String type = event.split(" ")[0];
            int lock = Integer.parseInt(event.split(" ")[1]);
            
            if (type.compareTo("ACQUIRE") == 0 && !acquiredLocks.contains(lock)) {
                acquiredLocks.add(lock);
                lockStack.push(lock);
            } else if (type.compareTo("RELEASE") == 0 && acquiredLocks.contains(lock) && lockStack.peek() == lock) {
                lockStack.pop();
                acquiredLocks.remove(lock);
            } else {
                return line;
            }
        }
        if (!lockStack.isEmpty()) {
            return line+1;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(check_log_history(Arrays.asList(
                "ACQUIRE 364",
                "ACQUIRE 80",
                "RELEASE 364",
                "ACQUIRE 80",
                "RELEASE 364"
                )));
    }
}
