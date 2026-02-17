import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class ChessboardAndQueens {
    public static HashSet<Integer> dai = new HashSet<>();
    public static HashSet<Integer> revDai = new HashSet<>();

    int cols = 10;

    public static void main(String[] args){
        int[][] arr = new int[9][9];

        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 8; i++){
            String str = sc.nextLine();

            for(int j = 1; j <= 8; j++){
                if(str.charAt(j-1) == '*'){
                    arr[i][j] = 1;
                }
            }
        }

        // for(int i = 0; i< arr.length; i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }

        System.out.println(solve(arr, 1, 8));

    }
    public static int solve(int[][] arr, int idx, int queenCount){
        if(queenCount <= 0) return 1;
        
        int count = 0;
        for(int i = 1; i < 9; i++){
            if(arr[idx][i] != 0) continue;
            boolean flag = true;
            
            int a1 = idx > i? idx - i: 0;
            int a2 = idx > i? 0: i-idx;
            
            int b1 = idx + i > 9?  9: idx+i;
            int b2 = idx + i > 9? idx+i-9: 0;
            
            if(arr[idx][0] == 2 || arr[0][i] == 2) flag = false;
            if(dai.contains(a1*10 + a2)) flag = false;
            if(revDai.contains(b1*10 + b2)) flag = false;
            
            if(flag){
                arr[idx][0] = 2;
                arr[0][i] = 2;
                dai.add(a1*10 + a2);
                revDai.add(b1*10 + b2);
                
                // System.out.println("yes");
                count+=solve(arr, idx+1, queenCount-1);
                
                dai.remove(a1*10 + a2);
                revDai.remove(b1*10 + b2);
                arr[idx][0] = 0;
                arr[0][i] = 0;
            }

        }

        return count;
    }
}
