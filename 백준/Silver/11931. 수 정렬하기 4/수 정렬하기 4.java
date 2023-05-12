import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 빈도수 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[2000001];
        for (int i = 0; i < N; i++) {
            nums[Integer.parseInt(br.readLine()) + 1000000]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2000000; i >= 0; i--) {
            while (nums[i] > 0) {
                nums[i]--;
                sb.append(i-1000000).append("\n");
            }
        }

        System.out.println(sb);
    }
}