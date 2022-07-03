import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2616 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int trains = Integer.parseInt(br.readLine());
        int[] pplInTrain = new int[trains];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < trains; i++) {
            pplInTrain[i] = Integer.parseInt(st.nextToken());
        }
        int small = Integer.parseInt(br.readLine());

        int[] prefixSum = new int[trains + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < trains; i++) {
            prefixSum[i + 1] = prefixSum[i] + pplInTrain[i];
        }

        int[][] dp = new int[4][trains + 1];
        for (int i = 1; i <= 3; i++) {
            for (int j = i * small; j <= trains; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - small] + prefixSum[j] - prefixSum[j - small]);
            }
        }
        System.out.println(dp[3][trains]);
    }

}
