import java.io.*;
import java.util.*;

public class Main {

    static class FastReader {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];

        private int ptr = 0;
        private int len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) return -1;
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {

            int c;

            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }

            int num = 0;

            while (c > ' ') {
                num = num * 10 + (c - '0');
                c = read();
            }

            return num;
        }
    }

    public static void main(String[] args) throws Exception {

        FastReader sc = new FastReader();

        int m = sc.nextInt();
        int n = sc.nextInt();

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();

            treeMap.put(a, treeMap.getOrDefault(a, 0) + 1);
        }

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int a = sc.nextInt();

            Integer key = treeMap.floorKey(a);

            if (key == null) {
                str.append(-1).append('\n');
            }
            else {

                str.append(key).append('\n');

                int freq = treeMap.get(key);

                if (freq == 1) {
                    treeMap.remove(key);
                }
                else {
                    treeMap.put(key, freq - 1);
                }
            }
        }

        System.out.print(str);
    }
}