import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 666;
        int nCnt = 0;

        while (true) {
            int temp = num;
            int cnt = 0;

            while (temp > 0) {
                if (temp % 10 == 6) {
                    cnt++;
                    if (cnt == 3) {
                        nCnt++;
                        break;
                    }
                } else cnt = 0;
                temp /= 10;
            }
            if (nCnt == N) {
                System.out.println(num);
                break;
            }
            num++;
        }
    }
}
