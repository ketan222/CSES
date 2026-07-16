
/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class JosephusProblemOne {

    public static void main(String[] args) {
        System.out.println("Hello World");
        Queue<Integer> que = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            que.add(i);
        }
        boolean flag = false;
        StringBuilder str = new StringBuilder();
        while (!que.isEmpty()) {
            int num = que.remove();
            if (!flag) {
                que.add(num);
                flag = true;
            } else {
                str.append(num + " ");
                flag = false;
            }
        }
        System.out.println(str);
    }
}