// import java.util.Scanner;

// class CoinCombinationsII{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int x = sc.nextInt();

//         int[] arr = new int[n];
//         for(int i = 0; i< arr.length; i++)
//         {
//             int a = sc.nextInt();
//             arr[i] = a;
//         }


//         int[] dp = new int[x+1];
//         dp[0] = 1;
       
//         for(int i = 0; i<n; i++){
//             for(int j = 1; j <= x; j++){
//                 if(arr[i] <= j) dp[j] += dp[j-arr[i]];
//             }
//         }

        

//         System.out.println(dp[x]);
//     }
// }












import java.io.*;
import java.util.*;

class CoinCombinationsII {
    static final int MOD = 1_000_000_007;

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

        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= x; j++) {
                dp[j] = (dp[j] + dp[j - arr[i]]) % MOD;
            }
        }

        System.out.println(dp[x]);
    }
}