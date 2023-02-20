import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new LinkedList<>();

            int[] imp = new int[10];

            for (int j = 0; j < N; j++) {
                int d = Integer.parseInt(st2.nextToken());
                imp[d]++;
                queue.offer(d);
            }

            int cnt = 0;
            int index = M;
            while (!queue.isEmpty()) {
                int max = 1;
                for (int j = 9; j >=1; j--) {
                    if (imp[j] > 0) {
                        max = j;
                        break;
                    }
                }

                if (queue.peek() == max) {
                    imp[max]--;
                    queue.poll();
                    cnt++;
                    if (index == 0) {
                        System.out.println(cnt);
                        break;
                    } else {
                        index--;
                    }
                } else {
                    queue.offer(queue.poll());
                    if (index == 0) {
                        index = queue.size() - 1;
                    } else {
                        index--;
                    }
                }

            }
        }
    }
}
