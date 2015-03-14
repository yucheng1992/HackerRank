import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConnectedCellInAGrid {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                bfs(board, i, k);
            }
        }
        System.out.println(max);
    }
    public static int max = 0;
    public static void bfs(int[][] board, int i, int j) {
        if (board[i][j] == 0 || board[i][j] == 2) {
            return;
        }
        board[i][j] = 2;
        Queue<Integer> queue = new LinkedList<Integer>();
        int num = i * board[0].length + j;
        queue.offer(num);
        int count = 1;
        while (!queue.isEmpty()) {
            int code = queue.poll();
            int row = code / board[0].length;
            int col = code % board[0].length;
            if (row - 1 >= 0) {
                if (board[row-1][col] == 1) {
                    board[row-1][col] = 2;
                    count++;
                    queue.offer((row-1) * board[0].length + col);
                }
            }
            if (row + 1 <= board.length - 1) {
                if (board[row+1][col] == 1) {
                    board[row+1][col] = 2;
                    count++;
                    queue.offer((row+1) * board[0].length + col);
                }
            }
            if (col - 1 >= 0) {
                if (board[row][col-1] == 1) {
                    board[row][col-1] = 2;
                    count++;
                    queue.offer(row * board[0].length + col - 1);
                }
            }
            if (col + 1 <= board[0].length - 1) {
                if (board[row][col+1] == 1) {
                    board[row][col+1] = 2;
                    count++;
                    queue.offer(row * board[0].length + col + 1);
                }
            }
            if (row - 1 >= 0 && col - 1 >= 0) {
                if (board[row-1][col-1] == 1) {
                    board[row-1][col-1] = 2;
                    count++;
                    queue.offer((row-1) * board[0].length + col - 1);
                }
            }
            if (row + 1 <= board.length - 1 && col + 1 <= board[0].length - 1) {
                if (board[row+1][col+1] == 1) {
                    board[row+1][col+1] = 2;
                    count++;
                    queue.offer((row+1) * board[0].length + col + 1);
                }
            }
            if (row - 1 >= 0 && col + 1 <= board[0].length - 1) {
                if (board[row-1][col+1] == 1) {
                    board[row-1][col+1] = 2;
                    count++;
                    queue.offer((row-1) * board[0].length + col + 1);
                }
            }
            if (row + 1 <= board.length - 1 && col - 1 >= 0) {
                if (board[row+1][col-1] == 1) {
                    board[row+1][col-1] = 2;
                    count++;
                    queue.offer((row+1) * board[0].length + col - 1);
                }
            }
        }
        if (count >= max) {
            max = count;
        }
    }
}
