import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 5개 숫자 각각 제곱한 수의 합을 10으로 나눈 나머지

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = 0;
        for (int i = 0; i < 5; i++) {
            int b = Integer.parseInt(st.nextToken());
            a += b * b % 10;
        }
        System.out.println(a%10);
    }
}