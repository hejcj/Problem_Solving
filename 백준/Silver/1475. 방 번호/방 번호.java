import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        int cnt = 0;
        while (n > 0) {
            int i = n % 10;
            n /= 10;
            arr[i]++;
            if (i == 6 || i == 9) {
                if (arr[6] + arr[9] > cnt * 2) cnt++;
            } else {
                if (arr[i] > cnt) cnt++;
            }
        }
        System.out.println(cnt);
    }
}