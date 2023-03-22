import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st2.nextToken());
        int q = Integer.parseInt(st2.nextToken());
        int t = Integer.parseInt(br.readLine());

        // O(1) 하나를 풀어봐야한다.

        // 상태를 4개로 나눠야 하나?

// W = 3 -> 7 7번 하지만 4번은위로 3번은 아래로 위로
        // 위로 아래로 위로 아래로
        // 몫이 0 몫이 1 몫이 2
        // 몫이 짝수 그대로 나머지
        // 홀수  h-q % h가 나머지
        // 7 이면 몫이 홀수
        // 나머지 3
        // 4 - 3 이 정답

        // 오른쪽 왼쪽 오른쪽 왼쪽
        // 몫이 짝수 홀수
        // 몫이 짝수 그대로 나머지
        // 몫이 홇수 w- (p % w)
        // 9 몫 1 나머지 3
        // 6 - 3 == 3

        if (((p + t) / w) % 2 == 0) {
            p = (p + t) % w;
        } else {
            p = w -  ((p + t) % w);
        }

        if (((q + t) / h) % 2 == 0) {
            q = (q + t) % h;
        } else {
            q = h - ((q + t) % h);
        }

        bw.write(String.valueOf(p));
        bw.write(" ");
        bw.write(String.valueOf(q));
        bw.flush();
        bw.close();
    }
}
