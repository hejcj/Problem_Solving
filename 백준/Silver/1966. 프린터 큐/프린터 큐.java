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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());


            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new LinkedList<>();

            int[] imp = new int[10];
            int max = 0;
            for (int j = 0; j < N; j++) {
                int d = Integer.parseInt(st2.nextToken());
                max = Math.max(d, max);
                imp[d]++;
                queue.offer(d);
            }

            int cnt = 0;
            int index = M;
            while (!queue.isEmpty()) {

                if (queue.peek() == max) {
                    imp[max]--;
                    queue.poll();
                    cnt++;
                    if (index == 0) {
                        sb.append(cnt).append("\n");
                        break;
                    } else {
                        index--;
                    }
                    for (int j = max; j >=1; j--) {
                        if (imp[j] > 0) {
                            max = j;
                            break;
                        }
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
        System.out.println(sb);
    }
}
