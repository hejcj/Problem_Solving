import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        int max = Integer.parseInt(st.nextToken());
        int mid = Integer.parseInt(st.nextToken());

        if (mid > max) {
            temp = max;
            max = mid;
            mid = temp;
        }
        int min = Integer.parseInt(st.nextToken());
        if (min > mid) {
            temp = mid;
            mid = min;
            min = temp;
            if(mid > max) {
                temp = max;
                max = mid;
                mid = temp;
            }
        }

        sb.append(min).append(" ").append(mid).append(" ").append(max);
        System.out.println(sb);
    }
}