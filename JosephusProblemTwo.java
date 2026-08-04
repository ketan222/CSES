import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JosephusProblemTwo {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            que.add(i);
        }
        boolean flag = false;
        StringBuilder str = new StringBuilder();
        int count = 0;
        while (!que.isEmpty()) {
            int num = que.remove();
            if (!flag) {
                count++;
                que.add(num);
                if (count == k)
                    flag = true;
            } else {
                str.append(num + " ");
                flag = false;
                count = 0;
            }
        }
        System.out.println(str);
    }
}
