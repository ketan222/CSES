import java.util.*;

public class DigitQueries {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        StringBuilder ans = new StringBuilder();

        while(t-- > 0){

            long k = sc.nextLong();

            long digit = 1;
            long count = 9;
            long start = 1;

            while(k > digit * count){
                k -= digit * count;
                digit++;
                count *= 10;
                start *= 10;
            }

            long number = start + (k - 1) / digit;

            String s = Long.toString(number);

            int idx = (int)((k - 1) % digit);

            ans.append(s.charAt(idx)).append("\n");
        }

        System.out.print(ans);
    }
}