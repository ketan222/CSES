import java.io.*;
import java.util.*;

public class CollectingNumbers {

    static class FastReader {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];

        private int ptr = 0;
        private int len = 0;

        private int read() throws IOException {

            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {

            int c;

            while ((c = read()) <= ' ') {
                if (c == -1) {
                    return -1;
                }
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

        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int prev = n;
        int count = 0;

        for(int i = 0; i < n; i++){

            if(prev > arr[i][1]){
                count++;
            }

            prev = arr[i][1];
        }

        System.out.println(count);
    }
}