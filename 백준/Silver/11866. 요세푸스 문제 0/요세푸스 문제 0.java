import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr = new int[10000000];
    static int front = 1;
    static int back = 1;
    static void push(int x) {
        arr[back++] = x;
    }

    static int pop() {
        return arr[front++];
    }

    static int size() {
        return back - front;
    }


    public static void main(String[] args) throws IOException {
        // 요세푸스 문제 0
        // 원형 큐
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= N; i++) {
            push(i);
        }

        sb.append("<");
        while (size() > 1) {
            for (int i = 0; i < K-1; i++) {
                push(pop());
            }
            sb.append(pop()).append(", ");
        }

        sb.append(pop()).append(">");
        System.out.println(sb);
    }
}