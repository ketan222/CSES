import java.io.*;
import java.util.*;

public class NestedRangesCheck {

    static class Range {
        int start;
        int end;
        int idx;

        Range(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        Range[] arr = new Range[num];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Range(start, end, i);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.start == b.start)
                return Integer.compare(b.end, a.end);
            return Integer.compare(a.start, b.start);
        });

        int[] first = new int[num];
        int[] second = new int[num];

        // contained by another
        int maxEnd = Integer.MIN_VALUE;
        for (int i = 0; i < num; i++) {
            if (maxEnd >= arr[i].end) {
                second[arr[i].idx] = 1;
            }
            maxEnd = Math.max(maxEnd, arr[i].end);
        }

        // contains another
        int minEnd = Integer.MAX_VALUE;
        for (int i = num - 1; i >= 0; i--) {
            if (minEnd <= arr[i].end) {
                first[arr[i].idx] = 1;
            }
            minEnd = Math.min(minEnd, arr[i].end);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            sb.append(first[i]).append(' ');
        }
        sb.append('\n');

        for (int i = 0; i < num; i++) {
            sb.append(second[i]).append(' ');
        }

        System.out.print(sb);
    }
}