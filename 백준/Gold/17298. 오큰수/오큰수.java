import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        Arrays.fill(result, -1);
        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int[] n = {i, Integer.parseInt(st.nextToken())};
            while (!stack.isEmpty() && stack.peek()[1] < n[1]) {
                result[stack.pop()[0]] = n[1];
            }
            stack.push(n);
        }

        Arrays.stream(result).forEach(r -> sb.append(r).append(" "));

        System.out.println(sb);
    }
}