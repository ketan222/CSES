import java.util.*;

public class CreatingStrings {
    public static List<String> strs = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int[] arr = new int[26];

        for(int i = 0; i<str.length(); i++){
            int idx = str.charAt(i) - 'a';
            arr[idx]++;
        }

        // System.out.println((int)('a') + " " + (char)(97+1));

        // System.out.println(Arrays.toString(arr));

        solve(arr, "");

        System.out.println(strs.size());
        for(int i = 0; i< strs.size() ; i++){
            System.out.println(strs.get(i));
        }
    }   

    public static void solve(int[] arr, String str){

        boolean flag = true;
        for(int i= 0; i< 26; i++){
            if(arr[i] > 0){
                flag = false;
                arr[i]--;
                solve(arr, str+(char)(i+97));
                arr[i]++;
            }
        }
        if(flag) strs.add(str);
    }
}
