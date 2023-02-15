import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] list = new String[N];

        for (int i = 0; i < N; i++) {
            list[i] = br.readLine();
        }

        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringTokenizer st1 = new StringTokenizer(o1);
                StringTokenizer st2 = new StringTokenizer(o2);
                int num1 = Integer.parseInt(st1.nextToken());
                int num2 = Integer.parseInt(st2.nextToken());
                return Integer.compare(num1, num2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String a : list) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }
}