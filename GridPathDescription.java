import java.util.*;

public class GridPathDescription{

    public static boolean[][] arr = new boolean[7][7];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        arr[0][0] = true;

        System.out.println(solve(0, 0, 0, str));
        
    }

    public static int solve(int idx, int r, int c, String str){
        boolean up = r-1 >= 0 ? arr[r-1][c] : true;
        boolean down = r+1 <= 6 ? arr[r+1][c] : true;
        boolean right = c+1 <= 6 ? arr[r][c+1] : true;
        boolean left = c-1 >= 0? arr[r][c-1] : true;

        if(r == 6 && c == 0 && idx != str.length()){
            return 0;
        }
        if(r == 6 && c == 0 && idx == str.length()) return 1;

        if(idx == str.length()) return 0;

        if((!up && !down) && (right && left)) return 0;
        if((!right && !left) && (up && down)) return 0;

        int num = 0;
        char ch = str.charAt(idx);

        if(r + 1 <= 6 && !arr[r+1][c] && (ch == '?' || ch == 'D')){  
            arr[r+1][c] = true; 
            num += solve(idx+1, r+1, c, str);
            arr[r+1][c] = false; 
        }
        if(r - 1 >= 0 && !arr[r-1][c] && (ch == '?' || ch == 'U')){
            arr[r-1][c] = true; 
            num += solve(idx+1, r-1, c, str);
            arr[r-1][c] = false; 
        }

        if(c + 1 <= 6 && !arr[r][c+1] && (ch == '?' || ch == 'R')){   
            arr[r][c+1] = true; 
            num += solve(idx+1, r, c+1, str);
            arr[r][c+1] = false;             
        }
        if(c - 1 >= 0 && !arr[r][c-1] && (ch == '?' || ch == 'L')){
            arr[r][c-1] = true; 
            num += solve(idx+1, r, c-1, str);
            arr[r][c-1] = false; 
        }

        return num;
    }
}