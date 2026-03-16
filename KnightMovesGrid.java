import java.util.*;

public class KnightMovesGrid {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dist = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        int[][] dir = {
            {2,1},{2,-1},{-2,1},{-2,-1},
            {1,2},{1,-2},{-1,2},{-1,-2}
        };

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()) {

            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nc>=0 && nr<n && nc<n && !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[r][c] + 1;

                    q.add(new int[]{nr,nc});
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}