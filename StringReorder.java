import java.util.*;

public class StringReorder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int[] arr = new int[26];

        for(int i = 0; i< str.length(); i++){
            arr[str.charAt(i) - 'A']++;
        }

        StringBuilder str1 = new StringBuilder("");

        for(int i = 1; i <= str.length(); i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == 0 || (str1.length() > 0 && str1.charAt(i-2) - 'A' == j)){
                    continue;
                }   
                int m = -1;
                for(int k = 0; k< arr.length; k++){
                    if(arr[k] > 0){
                        m = k;
                        break;
                    }
                }
                arr[j]--;
                for(int k = 0; k < arr.length; k++){

                    if(arr[m] <= arr[k]){
                        m = k;
                    }
                }

                // System.out.println(i + " " + j + " " + m + " " + arr[m]+ " " + str1.toString() + " " + Arrays.toString(arr)) ;

                if( j == m && (str.length() - i) / 2 >= arr[m] ){
                    str1.append((char)(65 + j));
                    break;
                }
                else if ( j!=m && (str.length() - i + 1) / 2 >= arr[m]){
                    str1.append((char)(65 + j));
                    break;
                }
                arr[j]++;
            }

            if(str1.length() != i){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(str1.toString());

    }
    
}
