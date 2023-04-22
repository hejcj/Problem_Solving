import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        m += time;
        if(m < 60) System.out.println(h + " " + m);
        else {
            h += m / 60;
            m %= 60;
            if(h <24) System.out.println(h + " " + m);
            else {
                System.out.println(h-24 + " " + m);
            }
        }
    }
}