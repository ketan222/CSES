// import java.util.*;
// public class RoomAllocation {
//     public static void main(String[] args){

//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a,b) -> {
//             return Integer.compare(a.get(0), b.get(0));
//         });
//         StringBuilder str = new StringBuilder();

//         for(int i = 0; i< n; i++){
//             int arrivalTimeOfCurr = sc.nextInt();
//             int departureTimeOfCurr = sc.nextInt();

//             List<Integer> arr = minHeap.peek();
//             if(arr != null && arr.get(0) < arrivalTimeOfCurr){
//                 minHeap.remove();
//                 arr.set(0, departureTimeOfCurr);
//                 str.append(arr.get(1) + " ");
//                 minHeap.add(arr);
//             }
//             else{
//                 int currSize = minHeap.size();
//                 minHeap.add(Arrays.asList(departureTimeOfCurr, currSize+1));
//                 str.append(currSize+1 + " ");
//             }
//         }

//         System.out.println(minHeap.size() + "\n" + str.toString());
//     }   
// }

import java.io.*;
import java.util.*;

public class RoomAllocation {

    static class Customer implements Comparable<Customer> {
        int arrival, departure, idx;

        Customer(int arrival, int departure, int idx) {
            this.arrival = arrival;
            this.departure = departure;
            this.idx = idx;
        }

        @Override
        public int compareTo(Customer other) {
            if (this.arrival != other.arrival)
                return Integer.compare(this.arrival, other.arrival);
            return Integer.compare(this.departure, other.departure);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            customers[i] = new Customer(a, b, i);
        }

        Arrays.sort(customers);

        // {departure, roomNumber}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] ans = new int[n];
        int roomsUsed = 0;

        for (Customer c : customers) {

            if (!pq.isEmpty() && pq.peek()[0] < c.arrival) {

                int[] room = pq.poll();

                ans[c.idx] = room[1];

                room[0] = c.departure;

                pq.offer(room);

            } else {

                roomsUsed++;

                ans[c.idx] = roomsUsed;

                pq.offer(new int[]{c.departure, roomsUsed});
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(roomsUsed).append('\n');

        for (int room : ans) {
            sb.append(room).append(' ');
        }

        System.out.print(sb);
    }
}