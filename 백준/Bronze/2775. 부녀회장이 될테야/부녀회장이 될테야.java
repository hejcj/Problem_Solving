import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        int[][] apart = new int[15][15];
        for (int i = 1; i <= 14 ; i++) {
            apart[0][i] = i;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                apart[i][j] = apart[i][j - 1] + apart[i - 1][j];
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(apart[k][n]).append("\n");
        }
        System.out.println(sb);
    }
}
