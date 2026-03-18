package concepts;

import java.util.Arrays;

public class SegmentTreeArrayBased {
    public static int[] segmentTree = new int[4*10];

    public static int createSegmentTree(int idx, int low, int high, int[] arr){
        // System.out.println(idx+ " " + low + "  "+ high + " " + Arrays.toString(arr));
        if(low == high){
            segmentTree[idx] = arr[low];
            return segmentTree[idx];
        }

        
        segmentTree[idx] = Math.max(
            createSegmentTree(2*idx+1, low, (low+high)/2, arr),
            createSegmentTree(2*idx+2, (low+high)/2+1, high, arr)
        );

        return segmentTree[idx];

    }

    public static int querySegmentTree(int idx, int queryLow, int queryHigh, int low, int high){
        
        if(low > queryHigh || high < queryLow){
            return Integer.MIN_VALUE;
        }

        if(queryLow <= low && queryHigh >= high){
            return segmentTree[idx];
        }

        return Math.max(
            querySegmentTree(2*idx+1, queryLow, queryHigh, low, (low + high)/2),
            querySegmentTree(2*idx+2, queryLow, queryHigh, (low+high)/2 + 1, high)
        );
    }

    public static void main(String[] args){
        int[] arr = {8,2,5,1,4,5,3,9,6,10};

        createSegmentTree(0, 0, 9, arr);

        System.out.println(Arrays.toString(segmentTree));

        System.out.println(querySegmentTree(0, 5, 7, 0, 9));

        System.out.println("Hello");

    }
}
