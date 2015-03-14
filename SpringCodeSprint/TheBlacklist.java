import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TheBlacklist {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        int[][] price = new int[K][N];
        for (int k=0; k<K; k++) {
            for (int n=0; n<N; n++) {
                price[k][n] = input.nextInt();
            }
        }
        int limit = 1<<K;
        int[][] dp = new int[N+1][limit+1];
        for (int n=0; n<=N; n++) {
            for (int x=0; x<=limit; x++) {
                dp[n][x] = 1000000;
            }
        }
        dp[0][0] = 0;
        for (int n=1; n<=N; n++) {
            for (int k=0; k<K; k++) {
                int mask = 1 << k;
                for (int from=1; from<=n; from++) {
                    for (int x=0; x<limit; x++) {
                        if ((x&mask) == 0) {
                            int newMask = x|mask;
                            int newValue = dp[from-1][x];
                            for (int i=from; i<=n; i++) {
                                newValue += price[k][i-1];
                            }
                            if (dp[n][newMask] > newValue) {
                                dp[n][newMask] = newValue;
                            }
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int value : dp[N]) {
            min = Math.min(min, value);
        }
        System.out.println(min);      
    }
}
