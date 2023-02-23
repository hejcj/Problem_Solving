import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        int T = 10;
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(sc.nextLine());
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < 8; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            int cnt = 1;
            while (true) {
                int poll = queue.poll();
                poll-= cnt;
                cnt = cnt % 5 + 1;
                if (poll <= 0) {
                    queue.offer(0);
                    break;
                } 
                queue.offer(poll);

            }
            System.out.printf("#%d ", N);
            while (!queue.isEmpty()) {
                System.out.printf("%d ", queue.poll());
            }
            System.out.println();
        }
    }
}