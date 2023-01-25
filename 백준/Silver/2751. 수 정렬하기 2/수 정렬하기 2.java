import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        boolean[] count = new boolean[2000001];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            count[a+1000000] = true;
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i] == true) {
                sb.append(i-1000000).append("\n");
                cnt++;
            }
            if(cnt == n) break;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
