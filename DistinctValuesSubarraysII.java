// import java.util.*;


// public class DistinctValuesSubarraysII {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
        
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int n = sc.nextInt();
//         int k = sc.nextInt();

//         int[] arr = new int[n];
//         for(int i = 0; i< arr.length;i++){
//             int a = sc.nextInt();
//             arr[i] = a;
//         }
//         int count = 0;
//         int s = 0;
//         int e = 0;
//         while(s <= e && e < arr.length){
//             map.put(arr[e], map.getOrDefault(arr[e], 0) + 1);


//             while(s < e && map.size() > k){
//                 map.put(arr[s], map.get(arr[s]) - 1);
//                 if(map.get(arr[s]) <= 0) map.remove(arr[s]);
//                 s++;
//             }
//             count += (e-s+1);
//             e++;
//         }

//         System.out.println(count);
//     }
// }




import java.io.*;
import java.util.*;

public class DistinctValuesSubarraysII {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        long count = 0;
        int s = 0;
        int e = 0;

        while (s <= e && e < n) {

            map.put(arr[e], map.getOrDefault(arr[e], 0) + 1);

            while (s < e && map.size() > k) {
                map.put(arr[s], map.get(arr[s]) - 1);

                if (map.get(arr[s]) <= 0) {
                    map.remove(arr[s]);
                }

                s++;
            }

            count += (e - s + 1);
            e++;
        }

        System.out.println(count);
    }
}