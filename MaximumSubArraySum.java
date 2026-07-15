import java.io.*;

public class MaximumSubArraySum {

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

    public static void main(String[] args) throws Exception {

        FastReader sc = new FastReader();

        int n = sc.nextInt();

        long sum = 0;
        long sol = Long.MIN_VALUE;

        for(int i = 0; i < n; i++){

            int num = sc.nextInt();

            sum = Math.max(num, sum + num);

            sol = Math.max(sol, sum);
        }

        System.out.println(sol);
    }
}