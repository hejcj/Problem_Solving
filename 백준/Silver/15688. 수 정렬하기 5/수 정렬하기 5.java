import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] nums = new int[2000001];
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[Integer.parseInt(br.readLine())+1000000]++;
        }

        for (int i = 0; i < 2000001; i++) {
            while (nums[i] > 0) {
                nums[i]--;
                sb.append(i-1000000).append("\n");
            }
        }
        System.out.println(sb);
    }
}