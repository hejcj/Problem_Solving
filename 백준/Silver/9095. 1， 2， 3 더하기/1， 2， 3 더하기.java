import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        int max = 0;
        int[] n = new int[t];

        for (int i = 0; i < t; i++) {
            n[i] = Integer.parseInt(br.readLine());
            max = Math.max(n[i], max);
        }

        int[] dp = new int[max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        for (int i = 0; i < t; i++) {
            sb.append(dp[n[i]]).append("\n");
        }
        System.out.println(sb);
    }
}