import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 이분 탐색
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        int max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        long back = max;
        long front = 1;
        long cnt = 0;
        long mid = 0;
        long result = 0;
        while (front <= back) {
            cnt = 0;
            mid = (back + front) / 2;
            for (int i = 0; i < K; i++) {
                cnt += arr[i] / mid;
            }
            // 개수가 원하는 개수보다 많을 때 길이가 긴쪽으로 1/2
            if (cnt >= N) {
                front = mid + 1;
                if (mid > result) {
                    result = mid;
                }
            } else {
                back = mid - 1;

            }
        }

        System.out.println(result);
    }
}