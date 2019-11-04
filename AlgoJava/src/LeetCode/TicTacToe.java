package LeetCode;

public class TicTacToe {

    int size;
    int[] rows;
    int[] cols;
    int diagonal;
    int antidiagonal;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.size = n;
        rows = new int[n];
        cols = new int[n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     * 
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either: 0: No one wins. 1:
     *         Player 1 wins. 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        rows[row] += add;
        cols[col] += add;
        if (row == col) {
            diagonal += add;
        }
        if (row + col == size - 1) {
            antidiagonal += add;
        }
        int totalSum = size * add;
        if (rows[row] == totalSum ||
            cols[col] == totalSum ||
            diagonal == totalSum ||
            antidiagonal == totalSum) {
            return player;
        }
        return 0;
    }
}
