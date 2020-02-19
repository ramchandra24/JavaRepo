package LeetCode;

/* 
import java.util.HashSet;
import java.util.List;

class NNode {
    int id1;
    int id2;
}

public class LtTest {
    
    private byte[] ranks;   
    private int[] sizes;    

    static int find(int parent[], int i) 
    { 
        if (parent[i] == -1)
            return i; 
        return find(parent, parent[i]); 
    }
  
    static void Union(int parent[], int x, int y) 
    { 
        int xset = find(parent, x); 
        int yset = find(parent, y); 
        parent[xset] = yset; 
    }
    
    
    public static boolean mergeSets(int[] parent, int elemIndex0, int elemIndex1) {
        // Get representatives
        int repr0 = find(parent, elemIndex0);
        int repr1 = find(parent, elemIndex1);
        if (repr0 == repr1)
            return false;
        int cmp = ranks[repr0] - ranks[repr1];
        if (cmp == 0)
            ranks[repr0]++;
        else if (cmp < 0) {
            int temp = repr0;
            repr0 = repr1;
            repr1 = temp;
        }
        return true;
    }
    
    public static List<List<NNode>> getDisjointSets(List<NNode> nodes) {
        
        HashSet<NNode> nnodes = new HashSet<NNode>(); 
        for (NNode n : nodes) {
            nnodes.add(n);
        }
        int numV = nnodes.size();
        int parent[] = new int[numV];
        for (int i = 0; i < numV; i++) {
            parent[i] = -1;
        }
        
        for (int i = 0; i < nodes.size(); ++i) 
        {
            int x = find(parent, nodes.get(i).id1);
            int y = find(parent, nodes.get(i).id1);
            
            Union(parent, x, y);
        }

    }

    public static void main(String[] args) {

    }
    
}
*/