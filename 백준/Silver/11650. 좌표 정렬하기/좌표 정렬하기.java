import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[][] nums = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {

                int com = Integer.compare(p1[0], p2[0]);
                if (com == 0) {

                    return Integer.compare(p1[1], p2[1]);
                }
                return com;
            }
        });
        for (int[] a : nums) {
            sb.append(a[0]).append(" ").append(a[1]).append("\n");
        }
        System.out.println(sb);
    }
}
