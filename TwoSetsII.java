import java.util.*;
class TwoSetsII{
    public static Long[][] dp;
    public static final int MOD = 1000000007;
    public static long solve(int i, int currSum){
        if(currSum == 0) return 1;
        if(i == 0) return 0;

        if(dp[i][currSum] != null) return dp[i][currSum];
        
        if(currSum >= i){
            return dp[i][currSum] =
                (solve(i-1, currSum) + solve(i-1, currSum-i)) % MOD;
        }
        return dp[i][currSum] = solve(i-1, currSum);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int maxSum = n*(n+1)/2;
        if(maxSum % 2 != 0){
            System.out.println(0);
            return;
        }

        dp = new Long[n+1][maxSum/2 + 1];
    
        System.out.println(
            (int)((long) solve(n, maxSum/2) * 500000004 % MOD)
        );
    }
}