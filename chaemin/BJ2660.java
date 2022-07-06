import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2660 {

    public static int n;
    public static int min = Integer.MAX_VALUE;
    public static int[][] graph;
    public static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        dist = new int[n + 1][n + 1];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == -1)
                break;
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else if (graph[i][j] == 1)
                    dist[i][j] = graph[i][j];
                else
                    dist[i][j] = 100;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int[] maxArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= n; j++) {
                if (max < dist[i][j]) {
                    max = dist[i][j];
                }
            }
            maxArr[i] = max;
        }
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            if (min > maxArr[i]) {
                min = maxArr[i];
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (maxArr[i] == min) {
                list.add(i);
            }
        }

        System.out.println(min + " " + list.size());
        for (int a : list) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}
