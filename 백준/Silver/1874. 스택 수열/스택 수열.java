import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int m = 0;

        while (n-- > 0) {
            int i = Integer.parseInt(br.readLine());
            for (int j = m + 1; j <= i; j++) {
                stack.push(j);
                sb.append("+\n");
            }
            if(stack.pop() == i) {
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
            m = m > i ? m : i;
        }
        System.out.println(sb);
    }
}