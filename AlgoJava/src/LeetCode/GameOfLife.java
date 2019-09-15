package LeetCode;

import java.util.Arrays;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        int[] prevRow = new int[board[0].length];
        for (int i = 0; i < board.length; ++i) {
            int[] currRow = Arrays.copyOf(board[i], board[i].length);
            for (int j = 0; j < board[i].length; ++j) {
                if (deadOrAlive(board, prevRow, currRow, i, j)) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
            prevRow = Arrays.copyOf(currRow, currRow.length);
        }
    }

    private static int countOnes(int[] arr, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; ++i) {
            if (i >= 0 && i < arr.length && arr[i] == 1)
                ++count;
        }
        return count;
    }

    private static boolean deadOrAlive(int[][] board, int[] prev, int[] curr, int i, int j) {
        int numOnes = countOnes(prev, j - 1, j + 1);
        numOnes += countOnes(curr, j - 1, j + 1);
        if (board[i][j] == 1) {
            --numOnes;
        }
        if (i < board.length - 1) {
            numOnes += countOnes(board[i + 1], j - 1, j + 1);
        }
        if (board[i][j] == 1) {
            return (numOnes >= 2 && numOnes < 4);
        } else {
            return (numOnes == 3);
        }
    }

    public static void printVec(int[][] v) {
        for (int[] r : v) {
            for (int num : r) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] input = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        GameOfLife.printVec(input);
        GameOfLife.gameOfLife(input);
        System.out.println();
        GameOfLife.printVec(input);
    }
}
