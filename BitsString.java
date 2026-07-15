import java.util.*;

public class BitsString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long mod = 1000000007;

        int n = sc.nextInt();

        long ans = 1;

        for(int i = 1; i<=n; i++){
            ans =(ans * 2)%mod;
        }

        System.out.println(ans);
    }
}
