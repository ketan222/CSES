// import java.util.*;
// class MinimizingCoins {
//     public static Long[][] dp;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int x = sc.nextInt();
//         int[] arr = new int[n];
        
//         dp = new Long[n][x+1];
        
//         for(int i = 0; i < n; i++){
//             int a= sc.nextInt();
//             arr[i] = a;
//         }
//         Arrays.sort(arr);
//         // long a = solve(arr, x, 0);
//         long a = tabulation(arr, x);
//         if(a > Integer.MAX_VALUE) System.out.println(-1);
//         else System.out.println(a);


//     }
//     public static long tabulation(int[] arr, int x){
//         long ans = 0;
//         dp = new Long[arr.length+1][x+1];

//         for(int i = 0; i < arr.length; i++){
//             dp[i][0] = (long)0;
//         }
//         for(int i = 0; i <= x; i++){
//             dp[arr.length][i] = (long)(Integer.MAX_VALUE);
//         }
        
//         for(int i = arr.length-1; i >= 0; i--){
//             for(int j = 1; j <= x; j++){
//                 dp[i][j] = dp[i+1][j];
//                 if(j >= arr[i]) dp[i][j] = Math.min(1+dp[i][j-arr[i]], dp[i][j]);
//             }
//         }

//         return dp[0][x];
//     }
//     public static long solve(int[] arr, int x, int idx){
//         if(x == 0) return 0;
//         if(idx >= arr.length){
//             return Integer.MAX_VALUE;
//         }

//         if(dp[idx][x] != null) return dp[idx][x];

//         long ans = Integer.MAX_VALUE;

//         ans = Math.min(ans, solve(arr, x, idx+1));

//         if(x >= arr[idx]){
//             ans = Math.min(ans,1 + solve(arr, x - arr[idx], idx));
//         }

//         return dp[idx][x] = ans;
//     }
// }













import java.io.*;
import java.util.*;

class MinimizingCoins {
    public static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = tabulation(arr, x);

        if (ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    public static long tabulation(int[] arr, int x) {
        dp = new int[arr.length + 1][x + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 0;
        }

        Arrays.fill(dp[arr.length], Integer.MAX_VALUE);

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j <= x; j++) {
                dp[i][j] = dp[i + 1][j];

                if (j >= arr[i] && dp[i][j - arr[i]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        1 + dp[i][j - arr[i]]
                    );
                }
            }
        }

        return dp[0][x];
    }
}