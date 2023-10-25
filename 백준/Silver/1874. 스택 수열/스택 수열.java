import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다.
        // 스택을 이용해 그 수열을 만들 수 있는지 , 있다면 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int m = 0;

        while (n-- > 0) {
            int i = Integer.parseInt(br.readLine());
            if (!stack.isEmpty() && stack.peek() > i) {
                System.out.println("NO");
                return;
            } else if (!stack.isEmpty() && stack.peek() == i) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                for (int j = m + 1; j <= i; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            }
            m = m > i ? m : i;
        }
        System.out.println(sb);
    }
}