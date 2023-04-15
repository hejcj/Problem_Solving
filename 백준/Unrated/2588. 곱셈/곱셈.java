import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sb.append((b % 10) * a).append("\n");
            int temp = ((b % 10) * a);
            for (int j = 0; j < i; j++) {
                temp *=10;
            }
            sum += temp;
            b /= 10;
        }
        sb.append(sum);
        System.out.println(sb);
    }
}