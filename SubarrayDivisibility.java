// import java.util.*;
// import java.io.*;

// public class SubarrayDivisibility {
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);

//         HashMap<Integer, Integer> map = new HashMap<>();

//         int n = sc.nextInt();
        
//         long sum = 0;
//         long count = 0;
//         map.put(0, 1);
        
//         for(int i = 0; i< n; i++){
//             int a = sc.nextInt();

//             sum += a;

//             long rem = ((sum % n) + n) % n;

//             map.putIfAbsent((int)(rem), 0);
//             count += (long)(map.get((int)(rem)));                   // in java -3 % 5 = -3 but mathematically -3 % 5 = 2, so we fix this bug via this method
//             // if(map.get((int)(rem) - n) != null) count += map.get((int)(rem) - n);

//             map.put((int)(rem), map.get((int)(rem)) + 1);
//         }

//         System.out.println(count);
//     }
// }




import java.io.*;
import java.util.*;

public class SubarrayDivisibility {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        long count = 0;

        map.put(0, 1);

        for (int i = 0; i < n; i++) {

            int a = Integer.parseInt(st.nextToken());

            sum += a;

            long rem = ((sum % n) + n) % n;

            map.putIfAbsent((int) rem, 0);

            count += map.get((int) rem);

            map.put((int) rem, map.get((int) rem) + 1);
        }

        System.out.println(count);
    }
}