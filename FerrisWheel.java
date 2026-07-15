import java.io.*;
import java.util.*;

public class FerrisWheel {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int s = 0, e = n - 1;
        int count = 0;

        while(s <= e){
            if(arr[s] + arr[e] <= maxWeight){
                s++;
                e--;
            } else {
                e--;
            }
            count++;
        }

        System.out.println(count);
    }
}