import java.io.*;
import java.util.*;

public class SumofThreeValues {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int diff = x - arr[i] - arr[j];

                if (map.containsKey(diff)) {
                    System.out.println((i + 1) + " " + (map.get(diff) + 1) + " " + (j + 1));
                    return;
                }

                map.put(arr[j], j);
            }

            map.clear();
        }

        System.out.println("IMPOSSIBLE");
    }
}