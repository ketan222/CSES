import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NumberSpiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int z = 0; z < testCases; z++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long r = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long arrRzero = r % 2 == 0 ? r * r : (r - 1) * (r - 1) + 1;
            long arrCzero = c % 2 == 0 ? (c - 1) * (c - 1) + 1 : c * c;


            long ans = 0;
            if(r > c){
                ans = r%2 == 0 ? arrRzero - c + 1: arrRzero + c - 1;
            }
            else{
                ans = c%2 == 0 ? arrCzero + r - 1: arrCzero - r + 1;

            }
            sb.append(ans).append("\n");          
        }
        System.out.print(sb);
    }
}
