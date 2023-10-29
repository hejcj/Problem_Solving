import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        Stack<int[]> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        if(N == 1) System.out.println(0);
        if(N == 2) System.out.println(1);

        while (N-- > 0) {
            int[] n = {Integer.parseInt(br.readLine()), 1};

            while (!stack.isEmpty() && stack.peek()[0] <= n[0]) {
                if(stack.peek()[0] == n[0]) {
                    n[1] += stack.peek()[1];
                }
                result += stack.pop()[1];
            }
            if(!stack.isEmpty()) result ++;
            stack.push(n);
        }

        System.out.println(result);
    }
}