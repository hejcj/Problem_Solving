import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // heap 프라이어티 큐로 구현
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(br.readLine());

            switch (A) {
                case 0:
                    if (pq.isEmpty()) {
                        sb.append("0").append("\n");
                    } else {
                        sb.append(pq.poll()).append("\n");
                    }
                    break;
                default:
                    pq.offer(A);
                    break;
            }
        }
        System.out.println(sb);

    }
}