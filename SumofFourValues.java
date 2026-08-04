// import java.util.*;
// public class SumofFourValues {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int x = sc.nextInt();

//         HashMap<Integer, List<Integer>> map = new HashMap<>();
//         int[] arr = new int[n];
//         for(int i = 0; i< arr.length; i++){
//             int a = sc.nextInt();
//             arr[i] = a;
//         }
//         for(int i = 0; i< arr.length; i++){
//             for(int j = i+1; j< arr.length; j++){
//                 map.put((arr[i]+arr[j]), Arrays.asList(i, j));
//             }
//         }

//         for(int i = 0; i < arr.length; i++){
//             for(int j = i+1; j< arr.length; j++){
//                 int sum1 = arr[i] + arr[j];
//                 int sum2 = x - sum1;

//                 if(map.get(sum2) == null) continue;

//                 List<Integer> lst = map.get(sum2);
//                 if(lst.get(0) > j) {
//                     System.out.println((i+1) + " " + (j+1) + " " + (lst.get(0) + 1) + " " + (lst.get(1) + 1));
//                     return;
//                 }
//             }
//         }

//         System.out.println("IMPOSSIBLE");
//     }
// }


import java.io.*;
import java.util.*;

public class SumofFourValues {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                map.put(arr[i] + arr[j], Arrays.asList(i, j));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                int sum1 = arr[i] + arr[j];
                int sum2 = x - sum1;

                if (map.get(sum2) == null) continue;

                List<Integer> lst = map.get(sum2);

                if (lst.get(0) > j) {
                    System.out.println((i + 1) + " " + (j + 1) + " " +
                                       (lst.get(0) + 1) + " " + (lst.get(1) + 1));
                    return;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}