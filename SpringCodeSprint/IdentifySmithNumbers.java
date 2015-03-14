import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IdentifySmithNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();       
        int cur = 0;
        for (int item: primeFactors(N)) {
            while (item > 0) {
                cur += item % 10;
                item = item / 10;
            }
        }
        int res = 0;
        while (N > 0) {
            res += N % 10;
            N = N / 10;
        }
        if (res == cur) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    public static List<Integer> primeFactors(long number) {
        List<Integer> primefactors = new ArrayList<Integer>();
        long copyOfInput = number;
        for (int i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                primefactors.add(i);
                copyOfInput /= i;
                i--;
            }
        }
        return primefactors;
    }
}
