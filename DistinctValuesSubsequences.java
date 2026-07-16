import java.io.*;
import java.util.*;

public class DistinctValuesSubsequences {

    public static void main(String[] args) throws Exception {

        final long MOD = 1_000_000_007L;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfEle = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numOfEle; i++) {
            int a = Integer.parseInt(st.nextToken());
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        long sum = 1;

        for (int freq : map.values()) {
            sum = (sum * (freq + 1)) % MOD;
        }

        sum = (sum - 1 + MOD) % MOD;

        System.out.println(sum);
    } 
}
