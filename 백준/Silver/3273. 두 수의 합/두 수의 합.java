import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        boolean[] is_sum = new boolean[x+1];

        for (int i : arr) {
            if(i <= x) is_sum[i] = true;
        }
        int cnt =0;
        for (int i = 1; i < (x + 1) / 2; i++) {
            if((is_sum[i]) && is_sum[x-i]) cnt++;
        }
        System.out.println(cnt);
    }
}