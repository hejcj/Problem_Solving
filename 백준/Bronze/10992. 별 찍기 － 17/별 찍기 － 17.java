import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if (i == n - 1)
                for (int j = 0; j < 2 * n - 1; j++) {
                    sb.append("*");
                }

            else if (i == 0) {
                for (int j = 0; j < n-1; j++) {
                    sb.append(" ");
                }
                sb.append("*");
            } else {
                for (int j = 0; j < n - i-1; j++) {
                    sb.append(" ");
                }
                sb.append("*");
                for (int j = 0; j < 2 * i-1; j++) {
                    sb.append(" ");
                }
                sb.append("*");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}