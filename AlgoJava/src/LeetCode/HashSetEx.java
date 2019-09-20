package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashSetEx {

    public class test {
        int x;
        test(int x) {
            this.x = x;
        }
        
        @Override
        public boolean equals(Object obj) {
            //System.out.println("comparing");
            if (!(obj instanceof test))
                return false;
            if (obj == this)
                return true;
            return (this.x == ((test)obj).x);
        }
    }
    
    public void testfunction() {
        // TODO Auto-generated method stub
        Set<test> s = new HashSet<>();
        test a = new test(2);
        test b = new test(2);
        
        s.add(a);
        System.out.println(s.contains(a));
        System.out.println(s.contains(b));
    }
    
    public static void main(String[] args) {
        HashSetEx th = new HashSetEx();
        th.testfunction();
    }
}
