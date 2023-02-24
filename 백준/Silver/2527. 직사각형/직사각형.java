import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] x = new int[4];
            int[] y = new int[4];

            for (int j = 0; j < 4; j++) {
                x[j] = Integer.parseInt(st.nextToken());
                y[j] = Integer.parseInt(st.nextToken());
            }

            if (x[0] > x[3] || x[1] < x[2] || y[0] > y[3] || y[1] < y[2]) {
                System.out.println('d');
            } else if ( (x[1] == x[2] && y[1] == y[2]) || (x[1] == x[2] && y[0] == y[3])
                    || (x[0] == x[3] && y[0] == y[3]) || (x[0] == x[3] && y[1] == y[2])) {
                System.out.println('c');
            } else if (x[1] == x[2] || y[1] == y[2] || x[0] == x[3] || y[0] == y[3]) {
                System.out.println('b');
            } else System.out.println('a');


        }
    }
}