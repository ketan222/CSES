import java.io.*;
import java.util.*;

public class Projects {

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

            int num = 0;
            while (c > ' ') {
                num = num * 10 + (c - '0');
                c = read();
            }
            return num;
        }
    }

    static long[][] projects;
    static long[] dp;

    public static void main(String[] args) throws Exception {

        FastReader fr = new FastReader();

        int n = fr.nextInt();

        projects = new long[n][3];

        for (int i = 0; i < n; i++) {
            projects[i][0] = fr.nextInt(); // start
            projects[i][1] = fr.nextInt(); // end
            projects[i][2] = fr.nextInt(); // reward
        }

        Arrays.sort(projects, (a, b) -> Long.compare(a[0], b[0]));

        dp = new long[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            int next = findNext(i + 1, n - 1, projects[i][1]);

            long take = projects[i][2];

            if (next != -1) {
                take += dp[next];
            }

            long skip = dp[i + 1];

            dp[i] = Math.max(take, skip);
        }

        System.out.println(dp[0]);
    }

    static int findNext(int left, int right, long endTime) {

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (projects[mid][0] > endTime) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}