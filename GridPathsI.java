import java.io.*;

class GridPathsI {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        int MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                grid[i][j] = (str.charAt(j) == '*') ? 1 : 0;
            }
        }

        int[][] dp = new int[n][n];

        if (grid[n - 1][n - 1] != 0 || grid[0][0] != 0) {
            System.out.println(0);
            return;
        }

        dp[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (grid[i][j] == 0) {
                    if (i + 1 < n)
                        dp[i][j] = (dp[i][j] + dp[i + 1][j])%MOD;

                    if (j + 1 < n)
                        dp[i][j] = (dp[i][j] + dp[i][j + 1])%MOD;
                }
            }
        }

        System.out.println(dp[0][0]);
    }
}