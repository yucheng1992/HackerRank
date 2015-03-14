import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class KaprekarNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int q = in.nextInt();
        int count = 0;
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                count++;
                System.out.print(i + " ");
            }
        }
        if (count == 0) {
            System.out.println("INVALID RANGE");
        }
    }
    public static boolean isKaprekar(int n) {
        long nSquare = (long)Math.pow(n, 2);
        long digit = (long)Math.log10(nSquare) + 1;
        if (digit % 2 == 0) {
            long right = nSquare % (long)Math.pow(10, digit / 2);
            long left = nSquare / (long)Math.pow(10, digit / 2);
            if (left + right == n) {
                return true;
            } else {
                return false;
            }
        } else {
            long right = nSquare % (long)Math.pow(10, digit / 2 + 1);
            long left = nSquare / (long)Math.pow(10, digit / 2 + 1);
            if (right + left == n) {
                return true;
            } else {
                return false;
            }
        }
    }
}
