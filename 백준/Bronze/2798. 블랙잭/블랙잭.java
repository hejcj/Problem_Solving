import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }
        int min = 300000;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 1; j < n - 1; j++) {
                for (int k = 2; k < n; k++) {
                    if(i != j && i != k && j !=k) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if(m == sum) {
                            System.out.println(m);
                            return;
                        } else if (m > sum) {
                            min = Math.min(min, m - sum);
                        }
                    }
                }
            }
        }
        System.out.println(m-min);
    }
}
