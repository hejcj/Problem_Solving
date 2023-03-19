import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int S;
    static int N;
    static int[] nums;
    static int cnt;

    static void recur(int n, int sum, int a) {

        if (n != 0 && sum == S) cnt++;

        for (int i = a + 1; i < N; i++) {

            recur(n + 1, sum + nums[i], i);
        }
    }

    public static void main(String[] args) throws IOException {
        // N개의 정수로 이루어진 수열이 있을 때 크기가 양수인 부분수열 중에서 그 수열의 워소를 ㅏ 더한 값이 S가 되는 경우의 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }

        recur(0, 0, -1);
        System.out.println(cnt);
    }
}


// -7
// -7 -3
// -7 -3 -2
// -7 -3 -2 5
// -7 -3 -2 5 8
// -7 -3 -2 8