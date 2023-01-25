import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        boolean[] count_plus = new boolean[1000001];
        boolean[] count_minus = new boolean[1000001];
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a>=0) count_plus[a] = true;
            else count_minus[-a] = true;
        }
        for(int i =count_minus.length-1; i > 0; i--){

            if(count_minus[i] == true) {
                sb.append(-i).append("\n");
                cnt++;
            }
            if(cnt == n) break;
        }
        for (int i = 0; i < count_plus.length; i++) {
            if(count_plus[i] == true) {
                sb.append(i).append("\n");
                cnt++;
            }
            if(cnt == n) break;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}