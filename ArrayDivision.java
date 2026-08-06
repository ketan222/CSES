// import java.util.Scanner;

// public class ArrayDivision {
//     public static int[] arr;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int k = sc.nextInt();

//         long total = 0;
//         arr = new int[n];
//         for(int i = 0; i< arr.length; i++){
//             int a = sc.nextInt();
//             arr[i] = a;
//             total += a;
//         }
//         long s = total/k - 1;
//         long e = total;
//         long target = -1;
//         while(s <= e){
//             long m = s + (e-s)/2;

//             if(chk(m, k)){
//                 target = m;
//                 e = m-1;
//             }
//             else {
//                 s = m+1;
//             }
//         }
//         System.out.println(target);
//     }
//     public static boolean chk(long maxSum, int k){
//         long currSum = 0;
//         for(int i = 0; i < arr.length; i++){
//             currSum += arr[i];
//             if(currSum > maxSum){
//                 if(k == 1) return false;
//                 currSum = arr[i];
//                 k--;
//             }
//         }
//         return true;
//     }
// }





import java.io.*;

public class ArrayDivision {

    static int[] arr;

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int k = fs.nextInt();

        arr = new int[n];

        long total = 0;
        long low = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
            total += arr[i];
            low = Math.max(low, arr[i]);
        }

        long high = total;
        long ans = high;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (can(mid, k)) {
                ans = mid;
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }


    static boolean can(long maxSum, int k) {

        long curr = 0;
        int groups = 1;

        for (int x : arr) {

            if (curr + x > maxSum) {
                groups++;
                curr = x;
            } 
            else {
                curr += x;
            }

            if (groups > k) {
                return false;
            }
        }

        return true;
    }


    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {

            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0)
                    return -1;
            }

            return buffer[ptr++];
        }


        int nextInt() throws IOException {

            int c;

            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val * sign;
        }
    }
}