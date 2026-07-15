import java.io.*;
import java.util.*;

public class Towers {

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

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int num = 0;
            while (c > ' ') {
                num = num * 10 + (c - '0');
                c = read();
            }

            return num * sign;
        }
    }

    public static void binarySearch(List<Integer> arr, int a) {

        if (arr.isEmpty() || arr.get(arr.size() - 1) <= a) {
            arr.add(a);
            return;
        }

        int s = 0;
        int e = arr.size() - 1;
        int target = -1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (arr.get(m) > a) {
                target = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        arr.set(target, a);
    }

    public static void main(String[] args) throws Exception {

        FastReader sc = new FastReader();

        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            binarySearch(arr, a);
        }

        System.out.println(arr.size());
    }
}