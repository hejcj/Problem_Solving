import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 조표 개수
    static int N;

    // 프라이어티 큐
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    // 좌표 출력 배열
    static int[] result;

    static class Node implements Comparable<Node> {
        int num;
        int idx;

        public Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }


        @Override
        public int compareTo(Node o) {
            return this.num-o.num;
        }
    }
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        result = new int[N];
        // 입력 받으면서 pq에 삽입 & 인덱스 기억시키기 위해서 배열에 삽입
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(new Node(Integer.parseInt(st.nextToken()), i));
        }
        int temp = Integer.MAX_VALUE;
        int idx = -1;

        while (!pq.isEmpty()) {
            // 최소값 빼내기
            // 중복처리를 위해 이전에 뽑았던것과 같으면 continue;
            Node poll = pq.poll();
            if(poll.num != temp) idx++;
            temp = poll.num;
            result[poll.idx] = idx;


        }
        // 출력
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}