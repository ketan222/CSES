import java.util.*;

public class Set {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int s = 0;
        int e = n;
        HashSet<Integer> visited = new HashSet<>();

        long sum = (long) n * (n + 1) / 2;

        if (sum % 2 != 0) {
            System.out.print("NO");
            return ;
        }

        sum = sum/2;

        int arr1 = 0;
        StringBuilder sb1 = new StringBuilder();

        int arr2 = 0;
        StringBuilder sb2 = new StringBuilder();




        for(int i = n; i>=1; i--){
            if(sum >= i){
                arr1++;
                sb1.append(i + " ");
                sum = sum - i;
            }
            else{
                arr2++;
                sb2.append(i + " ");
            }
        }
        
        System.out.println("YES\n" + arr1 + "\n" + sb1 + "\n" + arr2 +"\n" + sb2);

    }    
}
