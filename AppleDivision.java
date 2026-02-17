import java.util.*;
public class AppleDivision {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        long sum = 0;

        
        for(int k = 0; k < n; k++){
            int num = sc.nextInt();
            arr.add(num);
            sum += num;
        }
        Collections.sort(arr);

        System.out.println(solve(arr, 0, sum, 0));

        

    }

    public static long solve(List<Integer> arr,  int idx, long sum, long curr){

        if(idx >= arr.size()) return Math.abs((sum - 2*curr));

        return Math.min(
            solve(arr, idx+1, sum, curr+arr.get(idx))
            ,
            solve(arr, idx+1, sum, curr)
        );
    }
    
}
