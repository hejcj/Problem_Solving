import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j< i) sb.append(" ");
                else sb.append("*");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}