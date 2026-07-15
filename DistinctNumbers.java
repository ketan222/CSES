import java.io.*;
import java.util.*;

public class DistinctNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(set.size());
    }
}