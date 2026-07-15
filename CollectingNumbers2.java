

import java.util.*;
public class CollectingNumbers2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int count = 1;
        int[] pos = new int[n + 1];
        for(int i = 0; i < n; i++){
            pos[arr[i]] = i;
        }

        for(int i = 1; i < n; i++){
            if(pos[i] < pos[i-1]) count++;
        }
        System.out.println(count);

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            int num1 = arr[a-1];
            int num2 = arr[b-1];

            pos[num1-1] = b-1;
            pos[num2-1] = a-1;

            arr[a-1] = num2;
            arr[b-1] = num1;

            int aMinus = num1-2 >= 0 ? pos[num1-2] : -1;
            int bMinus = num2-2 >= 0 ? pos[num2-2] : -1;
            int aPlus = num1 < n ? pos[num1] : -1;
            int bPlus = num2 < n ? pos[num2] : -1;

            count -= 2;
            if(aMinus > pos[num1-1]) count++;
            if(aPlus < pos[num1-1]) count++;
            if(bMinus > pos[num2-1]) count++;
            if(bPlus < pos[num2-1]) count++;

        }
    }
}