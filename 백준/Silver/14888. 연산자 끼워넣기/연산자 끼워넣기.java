import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] nums;
    static int[] cnt = new int[4];
    static int min = 1000000001;
    static int max = -1000000001;

    static void operation(int n , int cal) {

        if(n == N) {
            min = min < cal ? min : cal;
            max = max > cal ? max : cal;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(cnt[i] == 0) continue;
            int temp = cal;
            if(i == 0) temp += nums[n];
            else if(i == 1) temp -= nums[n];
            else if(i == 2) temp *= nums[n];
            else temp /= nums[n];

            cnt[i]--;
            operation(n+1,temp);
            cnt[i]++;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }
        // 입력 끝

        operation(1, nums[0]);


        System.out.println(max);
        System.out.println(min);
    }

}