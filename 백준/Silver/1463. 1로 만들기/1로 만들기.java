import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
                dp[i] = Math.min(dp[i/2]+i%2,dp[i/3]+i%3) +1;
        }
        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }
}