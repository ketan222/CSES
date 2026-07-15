import java.util.*;

public class TrailingZeros {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long num = sc.nextLong();

        int count = 0;
        int fives = 5;
        while (fives <= num) {
            count += num / fives;
            // System.out.println("fives: " + fives + " count: " + count);
            fives = fives * 5;
        }

        System.out.println(count);

    }
}