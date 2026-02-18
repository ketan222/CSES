import java.util.*;
public class RaabGame1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int numOfTestCases = sc.nextInt();

        List<List<Integer>> ans = new ArrayList<>();

        for(int z = 0; z < numOfTestCases; z++){
            int numOfCards = sc.nextInt();
            int player1Score = sc.nextInt();
            int player2Score = sc.nextInt();

            if(player1Score + player2Score > numOfCards){
                System.out.println("NO");
                continue;
            }

            int diff = Math.abs(numOfCards - player1Score - player2Score);

            List<Integer> arr1 = new ArrayList<>();
            List<Integer> arr2 = new ArrayList<>();

            for(int i = 1; i<= numOfCards; i++){
                arr1.add(i);
                arr2.add(i);
            }
            
            int s = diff;
            List<Integer> arr12 = new ArrayList<>();
            int e = arr1.size() - player1Score;

            for(int i = 0; i< diff; i++){
                arr12.add(arr1.get(i));
            }
            for(int i = e; i< arr1.size(); i++){
                arr12.add(arr1.get(i));
            }

            for(int i = diff; i< e; i++){
                arr12.add(arr1.get(i));
            }

            // System.out.println(arr12);
            // System.out.println(arr2);

            for(int i = 0; i < arr12.size(); i++ ){
                // System.err.println(arr1 + "\n" + arr2 + "\n" + player1Score + " " + player2Score);
                if(arr12.get(i) > arr2.get(i)) player1Score--;
                else if(arr12.get(i) < arr2.get(i)) player2Score--;
            }

            if(player1Score == 0 && player2Score == 0){
                System.out.println("YES");
                for (int x : arr12) System.out.print(x + " ");
                System.out.println();

                for (int x : arr2) System.out.print(x + " ");
                System.out.println();
            }
            else{
                System.out.println("NO");
            }
        }
    }

}
