import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] nums = new int[8001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];

        double avg = 0.0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            avg += n;
            nums[n + 4000]++;
        }
        int max = 0;
        int mode = 0;
        boolean is_min = true;
        for (int i = 0; i <= 8000; i++) {

            if (nums[i] > 0) {
                if (nums[i] > max) {
                    max = nums[i];
                    mode = i-4000;
                    is_min = true;
                }
                else if (nums[i] == max && is_min) {
                    mode = i - 4000;
                    is_min = false;
                }
            }
        }
        int idx = 0;
        for (int i = 0; i <= 8000; i++) {
            while (nums[i] > 0) {
                numArr[idx] = i - 4000;
                nums[i]--;
                idx++;
            }
        }
        System.out.println(Math.round(avg / N));
        System.out.println(numArr[N/2]);
        System.out.println(mode);
        System.out.println(numArr[N-1] - numArr[0]);
    }
}