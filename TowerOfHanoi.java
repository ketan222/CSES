import java.util.*;

public class TowerOfHanoi {
    public static List<List<Integer>> moves = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        System.out.println(solve(n, 1, 3, 2));

        for(int i = 0; i< moves.size(); i++){
            System.out.println(moves.get(i).get(0) + " " + moves.get(i).get(1));
        }
        
    }
    public static int solve(int n, int current, int target, int helper){
        if(n == 0) return 0;
        int count = 0;

        count += solve(n-1, current, helper, target);

        count += 1;

        // System.out.println(n + " went from " + current + " to " + target);
        moves.add(Arrays.asList(current, target));

        count += solve(n-1, helper, target, current);

        return count;
    }

    // so this is a deep logic question for me for now, you're given 2 conditions, 1's that you cannot move more than 1 discs at a time and 2's that you can place a disk on top of another disk only if the disk below is greater than one we gonna put on.
    // so the most important part of this is that for every "n" we'll first try to get the largest disk at the target first and all other to the spare rode.
    // there will be 3 steps in this process: 1. we move n-1 disks to the helper rod, 2. we move nth disk or we can say the largest disk to the target and 3. we move the n-1 disk that are currently in the helper rode to the target
    // minimum no. of moves of n number of disks is (2^n) - 1
}
