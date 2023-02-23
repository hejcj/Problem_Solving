import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[] value = new int[6];
        int[] key = new int[6];
        int[] d = new int[5];
        int[] dv = new int[5];

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            key[i] = k;
            value[i] = v;
            d[key[i]]++;
            dv[key[i]] += value[i];
        }

        boolean is_first1 = false;
        boolean is_first2 = false;


        int n = 0;
        int m = 0;
        if (d[2] == 2 && d[3] == 2) {

            for (int i = 0; i < 6; i++) {
                if (key[i] == 2 && key[(i + 1) % 6] == 3 && key[(i + 2) % 6] == 2) {
                    n = value[(i + 1) % 6];
                    m = value[(i + 2) % 6];
                }
            }
        } else if (d[1] == 2 && d[3] == 2) {
            // 첫번째 1 두번째 3

            for (int i = 0; i < 6; i++) {
                if (key[i] == 3 && key[(i + 1) % 6] == 1 && key[(i + 2) % 6] == 3) {
                    n = value[(i + 1) % 6];
                    m = value[(i + 2) % 6];
                }
            }

        } else if (d[4] == 2 && d[1] == 2) {
            // 두번째 1 첫번째 4
            for (int i = 0; i < 6; i++) {
                if (key[i] == 1 && key[(i + 1) % 6] == 4 && key[(i + 2) % 6] == 1) {
                    n = value[(i + 1) % 6];
                    m = value[(i + 2) % 6];
                }
            }
        } else {
                //첫번째 2 두번째 4
            for (int i = 0; i < 6; i++) {
                if (key[i] == 4 && key[(i + 1) % 6] == 2 && key[(i + 2) % 6] == 4) {
                    n = value[(i + 1) % 6];
                    m = value[(i + 2) % 6];
                }
            }
        }
        System.out.println((dv[1]*dv[3] - n*m) * K);
        /*
1 60
3 20
1 100
4 50
2 160
3 30
         */

    }
}