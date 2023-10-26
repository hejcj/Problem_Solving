import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int data;
        int index;

        public Node(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
        // 하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하느이 탑에서만 수신이 가능하다.

        // 각각의 탑에서 발사한 레이저 신호를 어느탑에서 수신하는지를 알아내는 프로그램을 작성하라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Node> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek().data < n) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                sb.append(stack.peek().index).append(" ");
            } else {
                sb.append("0 ");
            }
            stack.push(new Node(n,i));
        }
        System.out.println(sb);
    }
}