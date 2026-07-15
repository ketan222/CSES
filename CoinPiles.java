import java.util.*;

public class CoinPiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfTest = sc.nextInt();

        List<Boolean> arr = new ArrayList<>();

        for (int i = 0; i < numOfTest; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if ((a + b) % 3 == 0) {
                arr.add(true);
            } else
                arr.add(false);
        }

        // System.out.println(arr);

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
