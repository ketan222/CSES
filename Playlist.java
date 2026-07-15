import java.io.*;
import java.util.*;

public class Playlist {

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
                if (c == -1) return -1;
            }

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int num = 0;

            while (c > ' ') {
                num = num * 10 + (c - '0');
                c = read();
            }

            return num * sign;
        }
    }

    public static void main(String[] args) throws Exception {

        FastReader sc = new FastReader();

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int s = 0;
        int e = 0;

        HashSet<Integer> visited = new HashSet<>();

        int maxLength = 0;

        while(s <= e && e < n){

            int num = arr[e];

            while(visited.contains(num)){
                visited.remove(arr[s]);
                s++;
            }

            
            visited.add(num);
            maxLength = Math.max(maxLength, e - s + 1);
            e++;
        }

        System.out.println(maxLength);
    }
}