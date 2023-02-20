import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        // 5로 나누고 그 나머지가 3으로 나누어 떨어질 때 나눔
        // 3으로 나누어 떨어짐 // 안떨어지면 -1 출력

        // 5로 최대한을 나누어 보고 3으로 나누어 떨어진다면 나눔
        int max = N - N % 5;
        while (max > 0) {
            if ((N -max) % 3 == 0) {
                sum += max / 5;
                N = N - max;
                break;
            }
            max -= 5;
        }
        // 3으로 나누어 떨어지지 않는 다면 -1
        if (N % 3 != 0) {
            System.out.println(-1);
            return;
        }
        sum += N / 3;
        System.out.println(sum);
    }
}
