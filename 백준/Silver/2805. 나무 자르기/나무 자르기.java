import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 상근이 나무 자르기
        // 나무를 필요한 만큼만
        // M미터 최대값
        // 이분 탐색
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
            max = Math.max(max, arr[i]);
        }

        long front = 1;
        long back = max;
        long mid = 0;
        long cnt = 0;
        long result = 0;
        while (front <= back) {
            cnt = 0;
            mid = (back + front) / 2;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    cnt += (arr[i] - mid);
                }
            }

            if (cnt >= M) {
                if (mid > result) {
                    result = mid;
                }
                front = mid + 1;
            } else {
                back = mid - 1;
            }
        }
        System.out.println(result);
    }
}
