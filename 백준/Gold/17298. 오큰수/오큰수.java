import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 오큰수는 오른쪽에 있으면서 큰 수중에서 가장 왼쪽에 있는 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        Arrays.fill(result, -1);
        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek()[1] < n) {
                result[stack.pop()[0]] = n;
            }
            stack.push(new int[] {i, n});
        }

        for (int r : result) {
            sb.append(r).append(" ");
        }
        System.out.println(sb);
    }
}