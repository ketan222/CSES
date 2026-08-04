import java.io.*;
import java.util.*;

class ReadingBooks{
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long maxEle = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            long curr = Long.parseLong(st.nextToken());

            sum += curr;
            maxEle = Math.max(maxEle, curr);
        }

        System.out.println(Math.max(sum, 2L * maxEle));
    }
}
