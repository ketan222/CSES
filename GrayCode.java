import java.util.*;

public class GrayCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<String> result = solve(n);

        for (String s : result) {
            System.out.println(s);
        }
    }

    // to find the ith gray code this the formulae
    // gray(i) = i ^ (i >> 1)

    public static List<String> solve(int n) {

        if (n == 1) {
            return new ArrayList<>(List.of("0", "1"));
        }

        List<String> prev = solve(n - 1);
        List<String> result = new ArrayList<>();

        // Prefix 0
        for (String s : prev) {
            result.add("0" + s);
        }

        // Prefix 1 in reverse order
        for (int i = prev.size() - 1; i >= 0; i--) {
            result.add("1" + prev.get(i));
        }

        return result;

    }

    
}
