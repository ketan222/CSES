import java.io.*;
import java.util.*;

public class MovieFestivalII {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] movies = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            movies[i][0] = Integer.parseInt(st.nextToken());
            movies[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(movies, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        TreeMap<Integer, Integer> people = new TreeMap<>();

        // initially all k members are free at time 0
        people.put(0, k);

        int count = 0;

        for (int i = 0; i < n; i++) {

            int start = movies[i][0];
            int end = movies[i][1];

            Integer freeTime = people.floorKey(start);

            if (freeTime == null)
                continue;

            // remove one member from this free time
            if (people.get(freeTime) == 1)
                people.remove(freeTime);
            else
                people.put(freeTime, people.get(freeTime) - 1);

            // this member is now free at 'end'
            people.put(end, people.getOrDefault(end, 0) + 1);

            count++;
        }

        System.out.println(count);
    }
}