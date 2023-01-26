import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();

        String[] arr = new String[n*2];
        for (int i = 0; i < n*2; i++) {
            arr[i] = br.readLine();
        }

        for (int i=0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(arr[i], " ");
            StringTokenizer st3 = new StringTokenizer(arr[i+n], " ");
            for (int j = 0; j < m; j++) {
                sb.append(Integer.parseInt(st2.nextToken()) + Integer.parseInt(st3.nextToken())).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}