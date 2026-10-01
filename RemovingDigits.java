import java.util.*;
public class RemovingDigits {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Integer[] dp = new Integer[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int k = i;
            int minStep = Integer.MAX_VALUE;
            while(k > 0){
                int digit = k % 10;
                if(i - digit >= 0 && dp[i-digit] != -1) minStep = Math.min(minStep, dp[i-digit] + 1);
                k = k / 10;
            }
            dp[i] = minStep == Integer.MAX_VALUE ? -1 : minStep;
        }   

        System.out.println(dp[n]);
    }

}
