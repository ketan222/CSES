import java.util.*;
class TwoSetsII{
    public static Integer[][] dp;
    public static int solve(int i, int currSum){
        if(i <= 0){
            if(i == 0 && currSum == 0) return 1;
            return 0;
        }
        // if(dp[i][currSum] != null) return dp[i][currSum];

        // int ans = currSum >= i ? solve(i-1, currSum-i) : 0;
        int ans = solve(i-1, currSum-i);
        ans += solve(i-1, currSum+i);

        // return dp[i][currSum] = ans;
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int maxSum = n*(n+1)/2;
        if(maxSum % 2 != 0){
            System.out.println(0);
            return;
        }
        
        dp = new Integer[n+1][maxSum + 1];
        System.out.println(solve(n, 0));
    }
}