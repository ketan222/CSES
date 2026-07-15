public class zzzzzz {
    public static void main(String[] args){
        
        return;
    }
    public static int towerOfHanoiWithKPegs(int n, int curr, int target, int helper1, int helper2){

        if(n == 0) return 0;

        towerOfHanoiWithKPegs(n/2, curr, helper1, target, helper2);
        towerOfHanoiWithKPegs(n - n/2, curr, helper2, helper1, target);

        System.out.println("disk " + n + " target ");

        towerOfHanoiWithKPegs(n/2, helper1, target, curr, helper2);
        towerOfHanoiWithKPegs(n - n/2, helper2, target, helper1, curr);



        return 0;
    }
}
