// import java.util.*;
// class MinimalGridPath{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         char[][] arr = new char[n][n];
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < n; j++){
//                 char ch = sc.next().charAt(0);
//                 arr[i][j] = ch;
//             }
//         }

//         List<List<Integer>> dp = new ArrayList<>();
//         dp.add(new ArrayList<>());
//         dp.get(0).add(arr[0][0] - 'A');
//         Queue<Integer> que = new LinkedList<>();
//         que.add(0);
//         HashSet<Integer> set = new HashSet<>();
//         set.add(0);
//         while(!que.isEmpty()){
//             int num = que.size();
//             dp.add(new ArrayList<>());
//             int idx = dp.size() - 1;
//             for(int z = 0; z < num; z++){
//                 int rc = que.remove();
//                 int r = rc / n;
//                 int c = rc % n;
//                 if(r+1 < n && !set.contains((r+1)*n + c)){
//                     set.add((r+1)*n + c);
//                     if(dp.get(idx).size() <= 0) dp.get(idx).add((r+1)*n + c);
//                     else  if(arr[dp.get(idx).get(0) / n][dp.get(idx).get(0) % n] > arr[r+1][c]){
//                         dp.get(idx).clear();
//                         dp.get(idx).add((r+1)*n + c);
//                     }
//                     else if(arr[dp.get(idx).get(0) / n][dp.get(idx).get(0) % n] == arr[r+1][c]){
//                         dp.get(idx).add((r+1) * n + c);
//                     }
//                 }
//                 if(c+1 < n && !set.contains(r*n + c+1)){
//                     set.add(r*n + c + 1);
//                     if(dp.get(idx).size() <= 0) dp.get(idx).add(r*n + c+1);
//                     else  if(arr[dp.get(idx).get(0) / n][dp.get(idx).get(0) % n] > arr[r][c+1]){
//                         dp.get(idx).clear();
//                         dp.get(idx).add(r*n + c + 1);
//                     }
//                     else if(arr[dp.get(idx).get(0) / n][dp.get(idx).get(0) % n] == arr[r][c+1]){
//                         dp.get(idx).add(r * n + c + 1);
//                     }
//                 }
//             }

//             for(int i = 0; i < dp.get(idx).size(); i++){
//                 que.add(dp.get(idx).get(i));
//             }
//         }
        
//         StringBuilder str = new StringBuilder();
//         for(int i = 0; i < dp.size(); i++){
//             str.append(dp.get(i).size() > 0 ? arr[dp.get(i).get(0) / n][dp.get(i).get(0) % n] : "");
//         }

//         System.out.println(str.toString());
//     }
// }

















import java.io.*;
import java.util.*;

class MinimalGridPath {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        dp.get(0).add(0);

        Queue<Integer> que = new ArrayDeque<>();
        que.add(0);

        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        while (!que.isEmpty()) {
            int num = que.size();

            dp.add(new ArrayList<>());
            int idx = dp.size() - 1;

            for (int z = 0; z < num; z++) {
                int rc = que.remove();

                int r = rc / n;
                int c = rc % n;

                if (r + 1 < n && !set.contains((r + 1) * n + c)) {
                    int next = (r + 1) * n + c;
                    set.add(next);

                    if (dp.get(idx).isEmpty()) {
                        dp.get(idx).add(next);
                    }
                    else if (arr[dp.get(idx).get(0) / n]
                              [dp.get(idx).get(0) % n] > arr[r + 1][c]) {

                        dp.get(idx).clear();
                        dp.get(idx).add(next);
                    }
                    else if (arr[dp.get(idx).get(0) / n]
                             [dp.get(idx).get(0) % n] == arr[r + 1][c]) {

                        dp.get(idx).add(next);
                    }
                }

                if (c + 1 < n && !set.contains(r * n + c + 1)) {
                    int next = r * n + c + 1;
                    set.add(next);

                    if (dp.get(idx).isEmpty()) {
                        dp.get(idx).add(next);
                    }
                    else if (arr[dp.get(idx).get(0) / n]
                              [dp.get(idx).get(0) % n] > arr[r][c + 1]) {

                        dp.get(idx).clear();
                        dp.get(idx).add(next);
                    }
                    else if (arr[dp.get(idx).get(0) / n]
                             [dp.get(idx).get(0) % n] == arr[r][c + 1]) {

                        dp.get(idx).add(next);
                    }
                }
            }

            for (int pos : dp.get(idx)) {
                que.add(pos);
            }
        }

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < dp.size(); i++) {
            if (!dp.get(i).isEmpty()) {
                int pos = dp.get(i).get(0);
                str.append(arr[pos / n][pos % n]);
            }
        }

        System.out.println(str);
    }
}