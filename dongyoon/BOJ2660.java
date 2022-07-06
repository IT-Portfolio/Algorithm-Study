package dongyoon;

import java.util.*;
import java.io.*;

public class BOJ2660 {
    private static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] adj = new int[n + 1][n + 1]; // 인접행렬
        int[][] dist = new int[n + 1][n + 1]; // 거리

        // 플로이드 워셜 초기화
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (u == -1 && v == -1) break;

            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else if (adj[i][j] == 1) dist[i][j] = adj[i][j];
                else dist[i][j] = INF;
            }
        }

        // 플로이드 워셜 로직 수행
        for (int k = 1; k <= n; k++) 
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++) 
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        // 각 행별 최대 거리 계산
        int[] rowMax = new int[n + 1];

        int candidateScore = INF;
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = 1; j <= n; j++) 
                max = Math.max(max, dist[i][j]);
            
            rowMax[i] = max;
            candidateScore = Math.min(candidateScore, max);
        }

        int candidateCount = 0;
        for (int i = 1; i <= n; i++)
            if (candidateScore == rowMax[i])
                candidateCount++;
        
        System.out.println(candidateScore + " " + candidateCount);

        for (int i = 1; i <= n; i++)
            if (candidateScore == rowMax[i])
                System.out.print(i + " ");

        br.close();
    }
}
