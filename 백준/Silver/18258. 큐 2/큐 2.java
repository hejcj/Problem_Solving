import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Queue {
        int[] arr;
        int front;
        int back;

        public Queue() {
            int front = 0;
            int back = 0;
            this.arr = new int[2000001];
        }
        public void push(int n) {
            arr[back++] = n;
        }
        public int pop() {
            if(empty() == 1) return -1;
            return arr[front++];
        }

        public int empty() {
            if(size() == 0) return 1;
            return 0;
        }

        public int size() {
            return back-front;
        }
        public int front() {
            if(empty() == 1) return -1;
            return arr[front];
        }

        public int back() {
            if(empty() == 1) return -1;
            return arr[back-1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue();
        int data = 0;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(st.hasMoreTokens()) {
                data = Integer.parseInt(st.nextToken());
            }
            switch (cmd) {
                case "push" :
                    queue.push(data);
                    break;
                case "pop" :
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty" :
                    sb.append(queue.empty()).append("\n");
                    break;
                case "front" :
                    sb.append(queue.front()).append("\n");
                    break;
                case "back" :
                    sb.append(queue.back()).append("\n");
                    break;
                default:
                    break;
            }

        }
        System.out.println(sb);
    }
}