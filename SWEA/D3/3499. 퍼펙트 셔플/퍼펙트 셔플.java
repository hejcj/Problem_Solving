import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(sc.nextLine());
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            String[] card = new String[N];
            for (int j = 0; j < N; j++) {
                card[j] = st.nextToken();
            }
            Queue<String> queue = new LinkedList<>();
            for (int j = 0; j < (N+1) / 2; j++) {
                queue.offer(card[j]);
                if(queue.size() == N) break;
                queue.offer(card[(N + 1) / 2 + j]);
            }
            System.out.printf("#%d ", i);
            for (String s : queue) {
                System.out.printf("%s ", s);
            }
            System.out.printf("\n");
        }
    }
}