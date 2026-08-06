// import java.util.*;

// class SubarraySums {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int x = sc.nextInt();

//         int[] arr = new int[n];

//         for(int i = 0; i < n; i++){
//             int a = sc.nextInt();
            
//             arr[i] = a;
//         }
//         HashMap<Integer, Integer> map = new HashMap<>();

//         int[] prefix = new int[n+1];
//         prefix[0] = 0;
//         map.put(0, 1);
//         int count = 0;

//         for(int i = 0; i < arr.length; i++){
//             prefix[i+1] += (prefix[i] + arr[i]);
//             int diff = prefix[i+1] - x;

//             count += (map.get(diff) == null ? 0 : map.get(diff));

//             map.putIfAbsent(prefix[i+1], 0);            
//             map.put(prefix[i+1], map.get(prefix[i+1]) + 1);
//         }

//         System.out.println(count);

//     }
// }





import java.io.*;
import java.util.*;

public class SubarraySums {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        HashMap<Long, Integer> map = new HashMap<>();

        long[] prefix = new long[n + 1];
        map.put(0L, 1);

        long count = 0;

        for (int i = 0; i < n; i++) {

            prefix[i + 1] = prefix[i] + arr[i];

            long diff = prefix[i + 1] - x;

            count += map.getOrDefault(diff, 0);

            map.put(prefix[i + 1], map.getOrDefault(prefix[i + 1], 0) + 1);
        }

        System.out.println(count);
    }
}