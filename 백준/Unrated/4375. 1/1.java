import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int idx = 1;
            long one = 0;
            while (true) {

                one *= 10;
                one++;
                one %= n;
                if(one == 0) break;
                idx++;
            }
            sb.append(idx).append("\n");
        }
        System.out.println(sb);
    }
}