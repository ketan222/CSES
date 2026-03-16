import java.util.*;

public class GridColoringOne{
    
    public static void main(String[] args){
        Scanner sc = new  Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();

        char[][] arr = new char[r][c];

        for(int i = 0; i< arr.length; i++){
            String str = sc.nextLine();
            arr[i] = str.toCharArray();
            // System.out.println(Arrays.toString(arr[i]));
        }

        // System.out.println("++++++++++++++++++++++++++++++++++");

        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j<arr[i].length; j++){
                int[] chars = new int[4];
                if(j>0){
                    int idx = arr[i][j-1] - 'A';
                    chars[idx] = 1;
                }
                if(i > 0){
                    int idx = arr[i-1][j] - 'A';
                    chars[idx] = 1;
                }
                chars[arr[i][j] - 'A'] = 1;

                // System.out.println(Arrays.toString(chars));


                for(int k = 0; k < chars.length; k++){
                    if(chars[k] == 0){
                        if( k == 0 ){
                            arr[i][j] = 'A';
                        }
                        else if( k == 1){
                            arr[i][j] = 'B';
                        }
                        else if( k == 2){
                            arr[i][j] = 'C';
                        }
                        else if( k == 3){
                            arr[i][j] = 'D';
                        }
                    }
                }
            }
        }

        StringBuilder str = new StringBuilder("");

        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j< arr[i].length; j++){
                str.append(arr[i][j]);
            }
            str.append("\n");
        }

        System.out.println(str.toString());

    


    }
}