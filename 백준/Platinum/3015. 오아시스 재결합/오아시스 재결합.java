import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static class Node {
        long is_same;
        long num;

        public Node(long is_same, long num) {
            this.is_same = is_same;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Node> stack = new Stack<>();
        long result = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            long cnt = 0;
            long is_same = 1;
            // 2,0
            // 스택이 비어있거나, stack.peek() 이 자신 보다 클때까지
            // 하나의 숫자를 만날 때마다 가진 숫자 +1
            // 작으면 총 결과 숫자에 이전 숫자가 가진 값을 더해주고, 스택에서 제외
            // 같으면
            while (!stack.isEmpty() && stack.peek().num <= num) {

                if (stack.peek().num == num) {
                    is_same += stack.peek().is_same;
                }
                cnt+=stack.pop().is_same;
            }
            if (!stack.isEmpty()) {
                cnt++;}

            stack.push(new Node(is_same, num));
            result += cnt;
        }
        System.out.println(result);
    }
}
