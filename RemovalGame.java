import java.util.*;
class RemovalGame{
    public static Long[][] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new Long[n+1][n+1];

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(0, arr.length-1, arr));

    }
    public static long solve(int s, int e, int[] arr){
        if(s == e) return (long)arr[s];
        if(dp[s][e] != null) return dp[s][e];
        long takeS = arr[s] + Math.min(
            s+2 <= e ? solve(s+2, e, arr) : 0, 
            e-1 >= s+1? solve(s+1, e-1, arr) : 0
        );
        long takeE = arr[e] + Math.min(
            e-2 >= s ? solve(s, e-2, arr) : 0, 
            e-1 >= s+1? solve(s+1, e-1, arr) : 0
        );

        return dp[s][e] = (long)Math.max(takeS, takeE);
    }
}