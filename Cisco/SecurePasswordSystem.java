import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SecurePasswordSystem {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] m = new int[T];
        int[] M = new int[T];
        for (int i = 0; i < T; i++) {
            m[i] = in.nextInt();
            M[i] = in.nextInt();
        }
        for (int i = 0; i < T; i++) {
            long num = securityNumber(m[i], M[i]);
            if (num > 1000000) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
       
    }
    public static long securityNumber(int m, int M) {
        long count = 0;
        for (int i = m; i <= M; i++) {
            count += (int)Math.pow(10, i);
        }
        return count;
    }
}
