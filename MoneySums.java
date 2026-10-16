import java.util.*;

class MoneySums{
    public static Integer[][] dp;
    public static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coins = new int[n];

        dp = new Integer[n+1][2];
        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }

        dp[n][0] = 0;
        dp[n][1] = 0;
        for(int i = n-1; i >= 0; i--){
            dp[i][0] = dp[i+1][0];
            dp[i][1] = dp[i+1][1] + coins[i];
            set.add(dp[i][1]);
            set.add(dp[i][0]);
        }

        System.out.println(set.size() - 1);
        System.out.println(set.toString().replaceAll("[\\[\\]]", "").replaceAll(",", ""));

    }
}