import java.io.*;
import java.util.*;

public class PalindromeReorder {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int oddCount = 0;
        char oddChar = 0;

        for (char ch : map.keySet()) {
            if (map.get(ch) % 2 != 0) {
                oddChar = ch;
                oddCount++;
            }
            if (oddCount > 1) {
                System.out.println("NO SOLUTION");
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder rev = new StringBuilder();

        if (oddCount == 1) {
            sb.append(oddChar);
            map.put(oddChar, map.get(oddChar) - 1);
        }

        for (char ch : map.keySet()) {
            int cnt = map.get(ch);
            while (cnt > 0) {
                rev.append(ch);
                sb.append(ch);
                cnt -= 2;
            }
        }

        System.out.println(rev.reverse() + sb.toString());
    }
}
