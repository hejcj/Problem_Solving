import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static long reverse(String s) {
        int l = s.length();
        boolean isZ = false;
        StringBuilder sb = new StringBuilder();

        for (int i = l - 1; i >= 0; i--) {
            if(s.charAt(i) != '0') isZ = true;
            if(isZ) sb.append(s.charAt(i));
        }

        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        int cnt = 0;
        while (cnt < N) {
            if(st.hasMoreTokens()) {
                pq.offer(reverse(st.nextToken()));
                cnt++;
            } else {
                st = new StringTokenizer(br.readLine());
            }
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }
}