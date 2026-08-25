import java.util.*;
class MinimizingCoins {
    public static Long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        Arrays.sort(arr);

        dp = new Long[n][x+1];

        for(int i = 0; i < n; i++){
            int a= sc.nextInt();
            arr[i] = a;
        }
        long a = solve(arr, x, 0);
        if(a > Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(a);


    }
    public static long tabulation(int[] arr, int x){
        long ans = 0;
        dp = new Long[arr.length+1][x+1];

        for(int i = 0; i < arr.length; i++){
            dp[i][0] = (long)0;
        }
        for(int i = 0; i <= x; i++){
            dp[arr.length][i] = (long)0;
        }
        
        // for(int i = 0; i< )
        return ans;
    }
    public static long solve(int[] arr, int x, int idx){
        if(x == 0) return 0;
        if(idx >= arr.length){
            return Integer.MAX_VALUE;
        }

        if(dp[idx][x] != null) return dp[idx][x];

        long ans = Integer.MAX_VALUE;

        ans = Math.min(ans, solve(arr, x, idx+1));

        if(x >= arr[idx]){
            ans = Math.min(ans,1 + solve(arr, x - arr[idx], idx));
        }

        return ans;
    }
}