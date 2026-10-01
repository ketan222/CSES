// import java.util.*;

// class RectangleCutting{
//     public static Integer[][] dp;
//     public static void main(String[] args){

//         Scanner sc = new Scanner(System.in);
//         int r = sc.nextInt();
//         int c = sc.nextInt();
//         dp = new Integer[r+1][c+1];

//         for(int i = 0; i <= Math.min(r, c); i++){
//             dp[i][i] = 0;
//         }

//         for(int i = 1; i <= r; i++){
//             for(int j = 1; j <= c; j++){
//                 if(i == j) continue;
//                 dp[i][j] = Integer.MAX_VALUE;
//                 for(int k = 1; k < i; k++){
//                     dp[i][j] = Math.min(dp[i][j], 1 + dp[k][j] + dp[i-k][j]);
//                 }
//                 for(int k = 1; k < j; k++){
//                     dp[i][j] = Math.min(dp[i][j] ,1 + dp[i][k] + dp[i][j-k]);
//                 }
//             }
//         }

//         // System.out.println(solve(r, c));
//         System.out.println(dp[r][c]);
//     }
//     public static int solve(int r, int c){
//         if(r == c) return 0;

//         if(dp[r][c] != null) return dp[r][c];
        
        
//         int ans = Integer.MAX_VALUE;
//         for(int i = 1; i < r; i++){
//             ans= Math.min(ans, 1 + solve( i, c)+solve( r-i, c));
//         }
//         for(int i = 1; i< c; i++){
//             ans = Math.min(ans,1 + solve(r, i) + solve(r, c-i));
//         }

//         return dp[r][c] = ans;

//     }
// }






import java.io.*;
import java.util.*;

class RectangleCutting {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] dp = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {

                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }

                int ans = Integer.MAX_VALUE;

                for (int k = 1; k < i; k++) {
                    ans = Math.min(ans,
                            dp[k][j] + dp[i - k][j] + 1);
                }

                for (int k = 1; k < j; k++) {
                    ans = Math.min(ans,
                            dp[i][k] + dp[i][j - k] + 1);
                }

                dp[i][j] = ans;
            }
        }

        System.out.println(dp[r][c]);
    }
}