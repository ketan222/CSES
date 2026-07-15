import java.io.*;
import java.util.*;

public class ArrayDescription {

    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n][m + 2];

        // Base case
        if (arr[0] == 0) {
            for (int val = 1; val <= m; val++) {
                dp[0][val] = 1;
            }
        } else {
            dp[0][arr[0]] = 1;
        }

        // DP
        for (int i = 1; i < n; i++) {

            if (arr[i] == 0) {

                for (int val = 1; val <= m; val++) {
                    dp[i][val] =
                            (dp[i - 1][val - 1]
                            + dp[i - 1][val]
                            + dp[i - 1][val + 1]) % MOD;
                }

            } else {

                int val = arr[i];

                dp[i][val] =
                        (dp[i - 1][val - 1]
                        + dp[i - 1][val]
                        + dp[i - 1][val + 1]) % MOD;
            }
        }

        long ans = 0;

        for (int val = 1; val <= m; val++) {
            ans = (ans + dp[n - 1][val]) % MOD;
        }

        System.out.println(ans);
    }
}