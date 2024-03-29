import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(br.readLine());
            switch (A) {
                case 0:
                    if (pq.isEmpty()) sb.append(0).append("\n");
                    else sb.append(pq.poll()).append("\n");
                    break;
                default:
                    pq.offer(A);
                    break;
            }

        }
        System.out.println(sb);
    }
}