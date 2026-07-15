package concepts;
import java.util.*;

public class SegmentTree {
    static class Node{
        int idx;
        int low;
        int val;
        int high;
        Node left;
        Node right;

        Node(int idx, int low, int high){
            this.idx = idx;
            this.low = low;
            this.high = high;


            left = null;
            right = null;
        }

    }

    public static int querySegmentTree(int low, int high, Node currNode){

        if(currNode == null || low > currNode.high || high < currNode.low){
            return Integer.MIN_VALUE;
        }

        if(low <= currNode.low && currNode.high <= high){
            return segmentTree[currNode.idx];
        }

        return Math.max(querySegmentTree(low, high, currNode.left), querySegmentTree(low, high, currNode.right));

    }

    public static int[] segmentTree = new int[4*10];

    public static Node createSegmentTree(int idx, int low, int high, int[] arr){
        if(low == high){
            Node n1 = new Node(idx, low, high); 
            n1.val = arr[low];
            segmentTree[idx] = n1.val;
            return n1;
        }

        int idxLeft = 2*idx+1;
        int idxRight = 2*idx+2;

        int leftHigh = (low+high)/2;;
        int rightLow = leftHigh+1;

        Node nLeft = createSegmentTree(idxLeft, low, leftHigh, arr);
        Node nRight= createSegmentTree(idxRight, rightLow, high, arr);

        Node n = new Node(idx, low, high);
        n.left = nLeft;
        n.right = nRight;

        n.val = Math.max(nLeft.val, nRight.val);
        segmentTree[idx] = n.val;

        return n;
    }
    public static void main(String[] args){
        int[] arr = {8,2,5,1,4,5,3,9,6,10};
        

        Node n = createSegmentTree(0, 0, 9, arr);

        System.out.println(n.val);
        System.out.println(Arrays.toString(segmentTree));

        System.out.println(querySegmentTree(5, 7, n));

    }
}
