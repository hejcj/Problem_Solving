import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        // Map을 써보자
        // Key 값
        // value 빈도수
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (map.containsKey(a)) {
                Integer integer = map.get(a);
                int aa = integer.intValue();
                map.put(a, ++aa);
            } else map.put(a, 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int b = Integer.parseInt(st2.nextToken());

            if (map.containsKey(b)) {
                sb.append(map.get(b)).append(" ");
            } else {
                sb.append("0").append(" ");
            }
        }
        System.out.println(sb);
    }
}