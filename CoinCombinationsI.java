// import java.util.*;
// class CoinCombinationsI{
//     public static int[] dp;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int x = sc.nextInt();
        
//         int[] arr = new int[n];
//         for(int i = 0; i < arr.length; i++){
//             int a = sc.nextInt();
//             arr[i] = a;
//         }
//         dp = new int[x+1];
//         Arrays.sort(arr);

//         for(int i = 0; i <= arr.length; i++){
//             dp[0] = 1;
//         }

//         for(int j = 1; j <= x; j++){
//             for(int i = 0; i < arr.length; i++){
//                 if(arr[i] <= j){
//                     int req=j-arr[i];
//                     if(dp[req]!=0){
//                         dp[j] += dp[req];
//                     }
//                 }else{
//                     break;
//                 }
                
//             }
//         }
        
//         System.out.println(dp[x]);

//     }
// }








import java.io.*;
import java.util.*;

class CoinCombinationsI {
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

        Arrays.sort(arr);

        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int sum = 1; sum <= x; sum++) {
            for (int coin : arr) {
                if (coin > sum) break;

                dp[sum] = (dp[sum] + dp[sum - coin]) % MOD;
            }
        }

        System.out.println(dp[x]);
    }
}