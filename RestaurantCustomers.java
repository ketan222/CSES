import java.io.*;
import java.util.*;

public class RestaurantCustomers {

    static class FastReader {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];

        private int ptr = 0;
        private int len = 0;

        private int read() throws IOException {

            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {

            int c;

            while ((c = read()) <= ' ') {
                if (c == -1) {
                    return -1;
                }
            }

            int num = 0;

            while (c > ' ') {
                num = num * 10 + (c - '0');
                c = read();
            }

            return num;
        }
    }

    public static void main(String[] args) throws Exception {

        FastReader sc = new FastReader();

        int n = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for(int z = 0; z < n; z++){

            int arrivalTime = sc.nextInt();
            int leavenTime = sc.nextInt();

            map.putIfAbsent(arrivalTime, 0);
            map.putIfAbsent(leavenTime, 0);

            map.put(arrivalTime, map.get(arrivalTime) + 1);
            map.put(leavenTime, map.get(leavenTime) - 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());

        Collections.sort(keys);

        int count = 0;
        int sol = 0;

        for(int i = 0; i < keys.size(); i++){

            count += map.get(keys.get(i));

            sol = Math.max(sol, count);
        }

        System.out.println(sol);
    }
}