import java.io.*;

public class BookShop {

    static class FastReader {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

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
            do {
                c = read();
            } while (c <= ' ');

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

        FastReader fr = new FastReader();

        int numOfBooks = fr.nextInt();
        int totalMoney = fr.nextInt();

        int[] bookPrices = new int[numOfBooks];
        int[] pages = new int[numOfBooks];

        for (int i = 0; i < numOfBooks; i++) {
            bookPrices[i] = fr.nextInt();
        }

        for (int i = 0; i < numOfBooks; i++) {
            pages[i] = fr.nextInt();
        }

        int[][] dp = new int[numOfBooks + 1][totalMoney + 1];

        for (int i = 1; i <= numOfBooks; i++) {

            int currPrice = bookPrices[i - 1];
            int currPages = pages[i - 1];

            for (int money = 0; money <= totalMoney; money++) {

                dp[i][money] = dp[i - 1][money];

                if (money >= currPrice) {
                    dp[i][money] = Math.max(
                        dp[i][money],
                        currPages + dp[i - 1][money - currPrice]
                    );
                }
            }
        }

        System.out.println(dp[numOfBooks][totalMoney]);
    }
}