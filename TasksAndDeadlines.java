// import java.util.*;

// class TasksAndDeadlines{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int[][] arr = new int[n][2];

//         for(int i = 0; i< n; i++){
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             arr[i][0] = a;
//             arr[i][1] = b;
//         }

//         Arrays.sort(arr, (a,b) -> {
//             return Integer.compare(a[0], b[0]);
//         });
//         int curr = 0;
//         int reward = 0;
//         for(int i = 0; i< n; i++){
//             curr += arr[i][0];
//             reward += (arr[i][1] - curr);
//         }
//         System.out.println(reward);

//         return;
//     }
// }


import java.io.*;
import java.util.*;

public class TasksAndDeadlines {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        long curr = 0;
        long reward = 0;

        for (int i = 0; i < n; i++) {
            curr += arr[i][0];
            reward += (long) arr[i][1] - curr;
        }

        System.out.println(reward);
    }
}