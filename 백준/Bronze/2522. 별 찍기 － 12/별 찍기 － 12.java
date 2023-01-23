import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        boolean flag = false;
        int count = 1;
        for (int i = 0; i < 2*n-1; i++) {

            for (int j = 0; j < n -count; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < count; j++) {
                sb.append("*");
            }
            if(flag) count--;
            else count++;
            if(count == n) flag = true;
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}