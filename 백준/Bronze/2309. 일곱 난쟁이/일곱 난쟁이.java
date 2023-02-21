import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 일곱 난쟁이의 키의 합이 100
        int[] small = new int[9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] p = new int[101];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            small[i] = Integer.parseInt(br.readLine());
            sum += small[i];
            p[small[i]]++;
        }
        int idx = 0;
        for (int i = 1; i < p.length; i++) {
            if (p[i] > 0) {
                small[idx++] = i;
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (i != j) {
                    if (sum - (small[i] + small[j]) == 100) {

                        StringBuilder sb = new StringBuilder();
                        for (int k = 0; k < small.length; k++) {
                            if (k != i && k != j) {
                                sb.append(small[k]).append("\n");
                            }
                        }
                        System.out.println(sb);
                        return;
                    }
                }
            }
        }
    }
}