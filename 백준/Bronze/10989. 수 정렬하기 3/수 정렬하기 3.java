import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[10001];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            nums[n]++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
