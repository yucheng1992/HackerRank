import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BigFileSystemSearch {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer[]> file = new ArrayList<Integer[]>();
        for (int i = 0; i < N; i++) {
            int n = in.nextInt();
            Integer[] num = new Integer[n];
            for (int j = 0; j < n; j++) {
                num[j] = in.nextInt();
            }
            file.add(num);
        }
        int Q = in.nextInt();
        for (int i = 0; i < Q; i++) {
            int T = in.nextInt();
            int K = in.nextInt();
            int[] number = new int[K];
            for (int j = 0; j < K; j++) {
                number[j] = in.nextInt();
            }
            if (T == 1) {
                System.out.println(query_all(file, number));
            } else if (T == 2) {
                System.out.println(query_any(file, number));
            } else {
                System.out.println(query_some(file, number));
            }
            
        }
    }
    public static int query_all(List<Integer[]> file, int[] num) {
        List<Integer> res = new LinkedList<Integer>();
        for (int i = 0; i < file.size(); i++) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j < file.get(i).length; j++) {
                if (map.containsKey(file.get(i)[j])) {
                    map.put(file.get(i)[j], map.get(file.get(i)[j]) + 1);
                } else {
                    map.put(file.get(i)[j], 1);
                }
            }
            boolean satisfy = true;
            for (int k = 0; k < num.length; k++) {
                if (map.containsKey(num[k])) {
                    if (map.get(num[k]) <= 0) {
                        satisfy = false;
                        break;
                    } else {
                        map.put(num[k], map.get(num[k]) - 1);
                    }
                } else {
                    satisfy = false;
                    break;
                }
            }
            if (satisfy) {
                res.add(i);
            }
        }
        return res.size();
    }
    
    public static int query_any(List<Integer[]> file, int[] num) {
        List<Integer> res = new LinkedList<Integer>();
        for (int i = 0; i < file.size(); i++) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j < file.get(i).length; j++) {
                if (map.containsKey(file.get(i)[j])) {
                    map.put(file.get(i)[j], map.get(file.get(i)[j]) + 1);
                } else {
                    map.put(file.get(i)[j], 1);
                }
            }
            for (int k = 0; k < num.length; k++) {
                if (map.containsKey(num[k])) {
                    res.add(i);
                    break;
                }
            }
        }
        return res.size();
    }
    
    public static int query_some(List<Integer[]> file, int[] num) {
        List<Integer> res = new LinkedList<Integer>();
        for (int i = 0; i < file.size(); i++) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j < file.get(i).length; j++) {
                if (map.containsKey(file.get(i)[j])) {
                    map.put(file.get(i)[j], map.get(file.get(i)[j]) + 1);
                } else {
                    map.put(file.get(i)[j], 1);
                }
            }
            int count = 0;
            for (int k = 0; k < num.length; k++) {
                if (map.containsKey(num[k])) {
                    if (map.get(num[k]) > 0) {
                        map.put(num[k], map.get(num[k]) - 1);
                        count++;
                    }
                }
            }
            if (count >= 1 && count <= num.length - 1) {
                res.add(i);
            }
        }
        return res.size();
    }
}
