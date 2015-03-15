import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindTheSeed {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int mod = 1000000007;
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        BigInteger[] f = new BigInteger[K+1];
        long[] c = new long[N + 1];
        for (int i = 0; i < N; i++) {
            f[K - i] = BigInteger.valueOf(in.nextInt());
        }
        for (int i = 1; i <= N; i++) {
            c[i] = in.nextInt();
        }
        for (int i = K - N; i >= 0; i--) {
            BigInteger cur = BigInteger.valueOf(0);
            for (int j = i + 1; j <= i + N - 1; j++) {
                BigInteger p = f[j].multiply(BigInteger.valueOf(c[i + N - j]));
                cur =cur.add(p);
            }        
            cur = cur.mod(BigInteger.valueOf(mod));
            BigInteger cur_f = f[N + i];
            cur_f = cur_f.mod(BigInteger.valueOf(mod));
            while (cur_f.compareTo(cur) < 0 || cur_f.subtract(cur).mod(BigInteger.valueOf(c[N])).intValue() != 0) {
               cur_f = cur_f.add(BigInteger.valueOf(mod));
            }
            f[i] = (cur_f.subtract(cur).divide(BigInteger.valueOf(c[N])));
        }
        for (int i = N - 1; i >= 0; i--) {
            System.out.print(f[i] + " ");
        }
    }
}
