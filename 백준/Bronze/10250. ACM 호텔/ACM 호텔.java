import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 층수 , 방수 ,몇번째
        // 나머지 구하기 문제 몫+1 호수
        // 나누어 떨어지면 제일 위에 층 6층

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int x = n / h;
            x++;

            int y = n % h;
            if (y == 0) {
                y = h;
                x--;
            }
            if(x < 10) sb.append(y).append("0").append(x).append("\n");
            else sb.append(y).append(x).append("\n");
        }
        System.out.println(sb);
    }
}
