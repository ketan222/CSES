// import java.util.*;

// public class FactoryMachines {
//     public static int[] machines;
//     public static void main(String[] args) {
//         Scanner sc =new Scanner(System.in);

//         int n = sc.nextInt();
//         int t = sc.nextInt();

//         int s = 1;
//         machines = new int[n];
//         for(int i = 0; i < n; i++){
//             int a = sc.nextInt();
//             machines[i] = a;
//         }
//         int e = (int)(1e9);

//         int sol = -1;
//         while(s <= e){
//             int m = s + (e-s)/2;
//             if(func(m, t)){
//                 sol = m;
//                 e = m-1;
//             }
//             else{
//                 s = m+1;
//             }
//         }

//         System.out.println(sol);

//     }
//     public static boolean func(int num, int t){
//         int curr = 0;
//         for(int i = 0; i < machines.length; i++){
//             curr += num / machines[i];
//         }

//         return curr >= t;
//     }
// }


import java.io.*;
import java.util.*;

public class FactoryMachines {

    static int[] machines;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        machines = new int[n];

        st = new StringTokenizer(br.readLine());

        long minMachine = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            machines[i] = Integer.parseInt(st.nextToken());
            minMachine = Math.min(minMachine, machines[i]);
        }

        long s = 1;
        long e = minMachine * t;
        long ans = e;

        while (s <= e) {

            long mid = s + (e - s) / 2;

            if (canProduce(mid, t)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean canProduce(long time, long target) {

        long produced = 0;

        for (int machine : machines) {

            produced += time / machine;

            if (produced >= target)
                return true;
        }

        return false;
    }
}