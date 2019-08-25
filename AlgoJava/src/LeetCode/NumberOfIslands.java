package LeetCode;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        return numIslandsUtil(grid);
    }
    
    public int numIslandsUtil(char[][] grid) {
        int[] indx = new int[2];
        int count = 0;
        findIsland(indx, grid);
        while (indx[0] != -1) {
            bfs(indx[0], indx[1], grid);
            ++count;
            findIsland(indx, grid);
        }
        return count;
    }
    
    void findIsland(int[] indx, char[][] grid) {
        for (int i=0; i<grid.length; ++i) {
            for (int j=0; j<grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    indx[0] = i;
                    indx[1] = j;
                    return;
                }
            }
        }
        indx[0] = -1;
        indx[1] = -1;
        return;
        
    }

    public void bfs(int x, int y, char[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        else if (grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        // left
        bfs(x, y-1, grid);
        // top
        bfs(x-1, y, grid);
        // right
        bfs(x, y+1, grid);
        // down
        bfs(x+1, y, grid);
    }
    
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','1'}
                };
        NumberOfIslands test = new NumberOfIslands();
        System.out.println(test.numIslands(grid));
    }
}
