package LeetCode;

import java.util.ArrayList;
import java.util.List;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class CandyCrush {

    void dfsUtil(int[][] board, int curr, int x, int y, boolean[][] visited, List<Point> spread) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return;
        if (board[x][y] != curr)
            return;
        if (visited[x][y] == true)
            return;
        visited[x][y] = true;
        spread.add(new Point(x, y));
        dfsUtil(board, curr, x, y - 1, visited, spread);
        dfsUtil(board, curr, x - 1, y, visited, spread);
        dfsUtil(board, curr, x, y + 1, visited, spread);
        dfsUtil(board, curr, x + 1, y, visited, spread);
    }

    Point findUnvisited(boolean[][] visited) {
        for (int i = 0; i < visited.length; ++i) {
            for (int j = 0; j < visited[0].length; ++j) {
                if (visited[i][j] == false) {
                    return new Point(i, j);
                }
            }
        }
        return new Point(-1, -1);
    }

    void updateBoard(int[][] board, List<Point> spread) {
        spread.sort((a, b) -> a.x - b.x);
        int xcount = 1;
        for (int i = 1; i < spread.size(); ++i) {
            int prevx = spread.get(i - 1).x;
            int currx = spread.get(i).x;
            if (prevx == currx) {
                ++xcount;
                continue;
            }
            if (xcount >= 3) {
                for (int tk = 0, ti = i - 1; tk < xcount; ++tk, --ti) {
                    board[spread.get(ti).x][spread.get(ti).y] = 0;
                }
            }
            xcount = 1;
        }
        if (xcount >= 3) {
            for (int tk = 0, ti = spread.size() - 1; tk < xcount; ++tk, --ti) {
                board[spread.get(ti).x][spread.get(ti).y] = 0;
            }
        }

        spread.sort((a, b) -> a.y - b.y);
        int ycount = 1;
        for (int i = 1; i < spread.size(); ++i) {
            int prevy = spread.get(i - 1).y;
            int curry = spread.get(i).y;
            if (prevy == curry) {
                ++ycount;
                continue;
            }
            if (ycount >= 3) {
                for (int tk = 0, ti = i - 1; tk < ycount; ++tk, --ti) {
                    board[spread.get(ti).x][spread.get(ti).y] = 0;
                }
            }
            ycount = 1;
        }
        if (ycount >= 3) {
            for (int tk = 0, ti = spread.size() - 1; tk < ycount; ++tk, --ti) {
                board[spread.get(ti).x][spread.get(ti).y] = 0;
            }
        }
    }

    void dropDownCandies(int[][] board) {
        for (int i = board.length - 1; i > 0; --i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 0) {
                    int ni = i - 1;
                    while (ni >= 0 && board[ni][j] == 0)
                        ni--;
                    if (ni >= 0) {
                        board[i][j] = board[ni][j];
                        board[ni][j] = 0;
                    }
                }
            }
        }
    }

    void dfs(int[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        Point toVisit = findUnvisited(visited);
        while (toVisit.x != -1) {
            List<Point> spread = new ArrayList<>();
            int currColor = board[toVisit.x][toVisit.y];
            dfsUtil(board, currColor, toVisit.x, toVisit.y, visited, spread);
            if (spread.size() >= 3) {
                updateBoard(board, spread);
                dropDownCandies(board);
            }
            spread.clear();
            toVisit = findUnvisited(visited);
        }
    }

    public int[][] candyCrush(int[][] board) {
        dfs(board);
        return board;
    }

    void printboard(int[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CandyCrush c = new CandyCrush();
        int[][] board = { { 1, 2, 3, 4, 1 }, { 1, 1, 3, 4, 1 }, { 1, 2, 3, 4, 1 }, { 1, 2, 3, 4, 1 },
                { 1, 2, 3, 4, 1 } };
//        List<Point> spreadlist = new ArrayList<>();
//        spreadlist.add(new Point(0, 0));
//        spreadlist.add(new Point(1, 0));
//        spreadlist.add(new Point(2, 0));
//
//        c.updateBoard(board, spreadlist);
        c.candyCrush(board);
        c.printboard(board);
    }
}
